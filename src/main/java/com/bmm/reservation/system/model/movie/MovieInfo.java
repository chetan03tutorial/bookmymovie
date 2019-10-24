package com.bmm.reservation.system.model.movie;

import javax.persistence.*;

@Entity
@Table(name = "CATALOG_METADATA")
public class MovieInfo {

    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    @Column(name="MOVIE_ID")
    private int id;

    @Column(name="MOVIE_NAME")
    private String name;

    @Column(name = "DIRECTED_BY")
    private String director;

    @Column(name="RELEASED_DATE")
    private String releaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
