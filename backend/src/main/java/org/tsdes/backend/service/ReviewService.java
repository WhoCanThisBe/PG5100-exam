package org.tsdes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tsdes.backend.entity.Movie;
import org.tsdes.backend.entity.Review;
import org.tsdes.backend.entity.User;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;

@Service
@Transactional
public class ReviewService {
    @Autowired
    private EntityManager em;

    public Long createReview(Long targetmovieid,String reviewtext, String author, Integer rating){
        Review review = new Review();
        Movie targetMovie = em.find(Movie.class, targetmovieid);
        User userAuthor = em.find(User.class, author);

        if(targetMovie == null){
            throw new IllegalArgumentException("targeted movie " + targetmovieid + " does not exist.");
        }

        if(userAuthor == null){
            throw new IllegalArgumentException("Username " + targetmovieid + " does not exist.");
        }

        review.setReviewText(reviewtext);
        review.setTargetMovie(targetMovie);
        review.setAuthor(userAuthor);
        review.setRating(rating);
        review.setReviewDate(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));


        em.persist(review);

        return review.getId();
    }
    public Review getReview(@NotNull long id){return em.find(Review.class,id);}

}
