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

    private List <Movie> movies = null;
    private List <Review> reviews = null;


    public List<Movie> getAllMovies(){
        return ms.getMoviesList();
    }

    public String getAvgPerMovie(Movie movie){
        return String.format("%.2f", rs.getAverageRating(movie));
    }

//    public String selectMovie(Movie movie) {
//        selectedMovie = movie;
//        refreshReviews();
//        return "/movie.jsf?faces-redirect=true";
//    }


}
