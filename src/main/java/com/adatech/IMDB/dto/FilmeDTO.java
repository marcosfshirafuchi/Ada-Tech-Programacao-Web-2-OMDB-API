package com.adatech.IMDB.dto;

public class FilmeDTO {
    private String Title;
    private String Year;


    //coonstrutor
    public FilmeDTO(String title, String year) {
        Title = title;
        Year = year;
    }
    // get e set
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

}

