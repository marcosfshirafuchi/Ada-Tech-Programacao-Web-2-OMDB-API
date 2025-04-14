package com.adatech.IMDB.dto;

public class FilmeDTO {
    private String title;
    private String year;


    //coonstrutor
    public FilmeDTO(String title, String year) {
        title = title;
        year = year;
    }
    // get e set
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

}

