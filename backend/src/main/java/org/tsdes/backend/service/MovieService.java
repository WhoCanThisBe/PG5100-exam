package org.tsdes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tsdes.backend.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class MovieService {

    @Autowired
    private EntityManager em;


    public Long createMovie(
            @NotNull String title,
            @NotNull String director,
            @NotNull Date year_of_release){

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setYearOfRelease(year_of_release);

        em.persist(movie);

        return movie.getId();
    }


    public void deleteMovie(@NotNull Long id){
        em.remove(em.find(Movie.class, id));
    }


    public List<Movie> getMoviesList(){
        TypedQuery<Movie> query = em.createQuery("select q from Movie q", Movie.class);
        return query.getResultList();
    }

    public Movie getMovie(long id){
        return em.find(Movie.class,id);
    }
}