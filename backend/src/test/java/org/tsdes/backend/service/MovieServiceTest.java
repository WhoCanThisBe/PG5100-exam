package org.tsdes.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MovieServiceTest extends ServiceTestBase {

    @Autowired
    private MovieService ms;

    private Long createMovie() {
        return ms.createMovie(
                "movie title",
                "director foo",
                Date.valueOf("1977-05-25")
        );
    }


    @Test
    public void create_movie_test() {

        Long movieId = createMovie();
        String title = "movie title";
        assertEquals(title,ms.getMovie(movieId).getTitle());
        assertEquals(1, ms.getMoviesList().size());

    }

    @Test
    public void delete_a_movie_test(){
        Long movieId = createMovie();
        assertEquals(1,ms.getMoviesList().size());
        ms.deleteMovie(movieId);
        assertEquals(0,ms.getMoviesList().size());
    }

}