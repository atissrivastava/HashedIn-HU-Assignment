package com.hashedin.milestone2.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "show_db")
@NoArgsConstructor
public class Show {
    @Id
    @Column(name = "show_id", length = 10)
    private String show_id;

    @Column(name = "show_type", length = 20)
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "director", columnDefinition = "text")
    private String director;

    @Column(name = "casting", columnDefinition = "text")
    private String cast;

    @Column(name = "country", columnDefinition = "text")
    private String country;

    @Column(name = "date_added", length = 20)
    private Date date_added;

    @Column(name = "release_year", length = 20)
    private String release_year;

    @Column(name = "rating", length = 20)
    private String rating;

    @Column(name = "duration", length = 20)
    private String duration;

    @Column(name = "listed_in", columnDefinition = "text")
    private String listed_in;

    @Column(name = "description", columnDefinition = "text")
    private String description;


    public Show(String show_id, String type, String title, String director, String cast, String country, Date date_added, String release_year, String rating, String duration, String listed_in, String description) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.listed_in = listed_in;
        this.description = description;
    }

    public String getShow_id() {
        return show_id;
    }

    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateAdded() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListedIn() {
        return listed_in;
    }

    public void setListedIn(String listed_in) {
        this.listed_in = listed_in;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Show{" + "show_id='" + show_id + '\'' + ", type='" + type + '\'' + ", title='" + title + '\'' + ", director=" + director + ", cast=" + cast + ", country=" + country + ", date_added=" + date_added + ", release_year='" + release_year + '\'' + ", rating='" + rating + '\'' + ", duration='" + duration + '\'' + ", listed_in=" + listed_in + ", description='" + description + '\'' + '}' + "\n";
    }

}