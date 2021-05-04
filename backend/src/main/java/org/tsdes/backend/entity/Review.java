package org.tsdes.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "REVIEWS")
public class Review {

    @Id
    @GeneratedValue (generator = "review_id_sequence")
    private Long id;

    @ManyToOne
    @NotNull
    private Movie targetMovie;

    private String reviewText;

    @Min(1)
    @Max(5)
    private int rating;

//https://stackoverflow.com/questions/23068676/how-to-get-current-timestamp-in-string-format-in-java-yyyy-mm-dd-hh-mm-ss
    private Timestamp reviewDate;

    @ManyToOne
    @NotNull
    private User author;

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getTargetMovie() {
        return targetMovie;
    }

    public void setTargetMovie(Movie targetMovie) {
        this.targetMovie = targetMovie;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
