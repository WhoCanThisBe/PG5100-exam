package org.tsdes.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue(generator = "movie_id_sequence")
    private Long id;

    @NotBlank
    @Size(min=1, max = 128)
    private String title;

    @NotNull
    @Size(min=1, max = 128)
    private String director;
    private String devopsTest;


    @NotNull
    private Date yearOfRelease;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Date yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }


}
