package org.tsdes.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.annotation.RequestScope;
import org.tsdes.backend.entity.Movie;
import org.tsdes.backend.entity.Review;
import org.tsdes.backend.service.MovieService;
import org.tsdes.backend.service.ReviewService;
import org.tsdes.backend.service.UserService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScope
public class MovieController {


    @Autowired
    private MovieService ms;

    @Autowired
    private ReviewService rs;

    @Autowired
    private UserService us;


    //gets all reviews to all movies


    /**
     * Primarily adapted from https://github.com/arcuri82/testing_security_development_enterprise_systems/
     */
    private String getUserName(){
        String userName = "";
        try {
            userName = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        } catch (ClassCastException e) {
            //ignore
        }
        return userName;
    }


    public List<Movie> getAllMovies(){
        return ms.getMoviesList();
    }



    //  https://medium.com/javarevisited/stream-tolist-and-other-converter-methods-ive-wanted-since-java-2-c620500cb7ab
    public List<MovieView> getAllMoviesWithReview() {
        return getAllMovies()
                .stream()
                .map(m -> new MovieView(m, rs.getAverageRating(m)))
                        .collect(Collectors.toList());

    }


    public class MovieView{
        public Movie movie;
        public double avgRating;


        public MovieView(Movie movie, double avgRating) {
            this.movie = movie;
            this.avgRating = avgRating;
        }

        public Movie getMovie() {
            return movie;
        }

        public double getAvgRating() {
            return avgRating;
        }
    }
















}
