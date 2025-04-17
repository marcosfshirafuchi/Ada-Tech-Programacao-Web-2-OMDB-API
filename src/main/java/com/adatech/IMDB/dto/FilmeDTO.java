package com.adatech.IMDB.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class FilmeDTO {
    @JsonProperty("Title")
    @NotBlank(message = "O título não pode ser nulo ou em branco.")
    private String title;

    @JsonProperty("Year")
    @NotBlank(message = "O ano de lançamento não pode ser nulo ou em branco.")
    private String year;

    // Construtor
    public FilmeDTO(String title, String year) {
        this.title = title;
        this.year = year;
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}

