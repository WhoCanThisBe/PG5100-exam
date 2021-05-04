package org.tsdes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tsdes.backend.entity.Movie;
import org.tsdes.backend.entity.Review;
import org.tsdes.backend.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

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
        review.setReviewDate(Timestamp.valueOf(LocalDateTime.now()));


        em.persist(review);

        return review.getId();
    }
    public Review getReview(@NotNull long id){return em.find(Review.class,id);}

    public List<Review> getReviewListMovie(Movie targetmovieid){

        Query query = em.createQuery(
                "select r from Review r where r.targetMovie = ?1", Review.class);
        query.setParameter(1,targetmovieid);

        return query.getResultList();
    }


    public double getAverageRating(Movie targetmovieid){
        Query query = em.createQuery(
                "select avg(r.rating) from Review r where r.targetMovie = ?1");
        query.setParameter(1, targetmovieid);

        Double res = (Double) query.getSingleResult();
        if(res == null){
            return 0.0;}
        return res;
    }

//    public List<Review> getAllReviews(){
//        TypedQuery<Review> query = em.createQuery("select r from Review r", Review.class);
//        return query.getResultList();
//    }



}
