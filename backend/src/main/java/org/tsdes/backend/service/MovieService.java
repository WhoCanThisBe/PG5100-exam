package org.tsdes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tsdes.backend.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieService {

    @Autowired
    private EntityManager em;

    @Autowired
    private ReviewService rs;

    public Long createMovie(
            String title,
            String director,
            Date year_of_release){

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setYearOfRelease(year_of_release);

        em.persist(movie);

        return movie.getId();
    }


    public void deleteMovie(Long id){
        Movie movie = em.find(Movie.class, id);
        if(movie == null){
            throw new IllegalArgumentException("movieId " + id + " does not exist.");
        }
        em.remove(em.find(Movie.class, id));
    }

    public List<Movie> getMoviesList(){
        TypedQuery<Movie> query = em.createQuery("select q from Movie q", Movie.class);
        return query.getResultList();
    }

    public List <Movie> getAvgRatedSortedMoviesList() {
        List <Movie> query = em.createQuery("select q FROM Movie q", Movie.class).getResultList();
        return query.stream()
                .sorted(Comparator.comparing(m -> rs.getAverageRating((Movie) m))
                        .reversed())
                .collect(Collectors.toList());
    }


    public Movie getMovie(long id){
        return em.find(Movie.class,id);
    }
}