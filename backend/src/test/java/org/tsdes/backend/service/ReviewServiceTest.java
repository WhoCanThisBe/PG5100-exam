package org.tsdes.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.tsdes.backend.entity.Movie;
import org.tsdes.backend.entity.Review;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ReviewServiceTest extends ResetService{


    @Autowired
    private UserService us;

    @Autowired
    private MovieService ms;

    @Autowired
    private ReviewService rs;

    private String createUserAuthor() {
        String userName = "fooUser";
        us.createUser(
                userName,
                "testpassword",
                "fooName",
                "fooSurname","foo@mail.com");
        return userName;
    }

    private Long createMovies(String titles){
        return ms.createMovie(
                titles,
                "fooDirector",
                1995
        );
    }

    private Long createReview(String userName, Long movieId, int rating) {
        return rs.createReview(
                movieId,
                "some awesome review",
                userName,
                rating
        );
    }



    @Test
    public void creating_review_to_a_movie_with_star_rating(){

        String userName = createUserAuthor();
        String title = "movieTest";
        Long movieId = createMovies(title);

        Long reviewId = createReview(userName, movieId, 4);

        String reviewText = rs.getReview(reviewId).getTargetMovie().getTitle();
        int star =  rs.getReview(reviewId).getRating();

        assertEquals(4,star);
        assertEquals(title,reviewText);

        //check if time stamp works
        assertEquals((new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())), rs.getReview(reviewId).getReviewDate());

    }


    @Test
    public void check_review_list_return_and_review_text_rating(){

        String userName = createUserAuthor();
        String title = "movieTest";
        Long movieId = createMovies(title);
        Movie movie = ms.getMovie(movieId);
        //Should expect nothing since there is no review created
        assertEquals(0, rs.getReviewListMovie(movie).size());

        createReview(userName, movieId, 4);
        createReview(userName, movieId, 2);

        assertEquals(2, rs.getReviewListMovie(movie).size());

        List<Review> reviewList = rs.getReviewListMovie(movie);

        //check if returned rating value of the first created review
        assertEquals(4, reviewList.get(0).getRating());

        //check the text the returned review text match
        assertEquals("some awesome review", reviewList.get(0).getReviewText());
    }

    @Test
    public void averge_rating_test(){
        String userName = createUserAuthor();
        String title = "movieTest";
        Long movieId = createMovies(title);
        Movie movie = ms.getMovie(movieId);

        // should return 0 when no reviews has been added
        assertEquals(0, rs.getAverageRating(movie));

        createReview(userName, movieId, 4);
        createReview(userName, movieId, 2);

        int average = (int) rs.getAverageRating(movie);
        //returned average should return 3
        assertEquals(3,average);

    }


}