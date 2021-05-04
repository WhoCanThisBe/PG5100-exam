package org.tsdes.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.tsdes.backend.entity.Movie;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MovieServiceTest extends ServiceTestBase {

    @Autowired
    private MovieService ms;

    @Autowired
    private UserService us;

    @Autowired
    private ReviewService rs;

    private Long createMovie(String title) {
        return ms.createMovie(
                title,
                "director foo",
                Date.valueOf("1977-05-25")
        );
    }


    @Test
    public void create_movie_test() {

        Long movieId = createMovie("movie title");
        String title = "movie title";
        assertEquals(title,ms.getMovie(movieId).getTitle());
        assertEquals(1, ms.getMoviesList().size());

    }

    @Test
    public void delete_a_movie_test(){
        Long movieId = createMovie("movie title");
        assertEquals(1,ms.getMoviesList().size());
        ms.deleteMovie(movieId);
        assertEquals(0,ms.getMoviesList().size());
    }

    @Test
    public void retrieve_movie_list_sorted_by_average_rating_test(){

        Long movieId1 = createMovie("movie title1");
        Long movieId2 = createMovie("movie title2");

        String userName = "fooUser";

        us.createUser(
                userName,
                "testpassword",
                "fooName",
                "fooSurname",
                "foo@mail.com");

        rs.createReview(
                 ms.getMovie(movieId1).getId(),
                "awesome review",
                userName,
                1);

        rs.createReview(
                 ms.getMovie(movieId2).getId(),
                "awesome review",
                userName,
                2);

        List <Movie> movies = ms.getAvgRatedSortedMoviesList() ;

        //should be second created
        assertEquals("movie title2",movies.get(0).getTitle());

    }

}