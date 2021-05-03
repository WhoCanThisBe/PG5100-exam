package org.tsdes.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.tsdes.backend.entity.Movie;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ReviewServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    private String createUserAuthor() {
        String userName = "fooUser";
        userService.createUser(
                userName,
                "testpassword",
                "fooName",
                "fooSurname","foo@mail.com");
        return userName;
    }

    private Long createMovies(String titles){
        return movieService.createMovie(
                titles,
                "fooDirector",
                1995
        );
    }

    private Long createReview(String userName, Long movieId) {
        return reviewService.createReview(
                movieId,
                "some awesome review",
                userName, 4
        );
    }

    @Test
    public void creating_review_to_a_movie_with_star_rating(){

        String userName = createUserAuthor();
        String title = "movieTest";
        Long movieId = createMovies(title);

        Long reviewId = createReview(userName, movieId);

        String reviewText = reviewService.getReview(reviewId).getTargetMovie().getTitle();
        int star =  reviewService.getReview(reviewId).getRating();

        assertEquals(4,star);
        assertEquals(title,reviewText);

    }


    @Test
    public void check_review_list_return_size(){

        String userName = createUserAuthor();
        String title = "movieTest";
        Long movieId = createMovies(title);
        Movie movie = movieService.getMovie(movieId);

        assertEquals(0, reviewService.getReviewListPerMovie(movie).size());
        Long createReview = createReview(userName, movieId);
        assertEquals(1, reviewService.getReviewListPerMovie(movie).size());
    }


}