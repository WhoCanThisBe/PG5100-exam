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
public class MovieServiceTest extends ServiceTestBase {

    @Autowired
    private MovieService ms;

    private Long createMovie() {
        return ms.createMovie(
                "movie title",
                "director foo",
                1995
        );
    }


    @Test
    public void create_movie_test() {

        Long movieId = createMovie();

        assertNotNull(movieId);
        assertEquals(1, ms.getMoviesList().size());

    }

    @Test
    public void delete_a_movie_test(){
        Long movieId = createMovie();
        assertEquals(1,ms.getMoviesList().size());
        ms.deleteMovie(movieId);
        assertEquals(0,ms.getMoviesList().size());




//
//
//        Long mockId = movieId + 1;
//
//        //should fail when there is no created with that id;
//        ms.deleteMovie(mockId);


    }



}