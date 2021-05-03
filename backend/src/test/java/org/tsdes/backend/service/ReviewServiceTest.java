package org.tsdes.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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


    @Test
    public void creating_review_to_a_movie(){

        String userName = createUserAuthor();

        String movieTitle = "movieTest";

        Long movieId = movieService.createMovie(
                movieTitle,
                "fooDirector",
                1995
                );


        Long reviewId = reviewService.createReview(
                movieId,
                "some awesome review",
                userName,4
                );

        String reviewText = reviewService.getReview(reviewId).getTargetMovie().getTitle();

        assertEquals(movieTitle,reviewText);
    }

}