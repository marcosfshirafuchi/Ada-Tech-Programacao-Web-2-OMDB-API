package com.adatech.IMDB.model;

import jakarta.persistence.*;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String title;
    @Column
    String year;

    //GET E SET
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

