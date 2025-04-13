package com.adatech.IMDB.client;

import com.adatech.IMDB.vo.FilmeOMDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdbFilmes", url = "http://www.omdbapi.com/")
public interface FilmeClientOMDBFeign {

    @GetMapping
    FilmeOMDB getFilme(
            @RequestParam("t") String tema,
            @RequestParam("apiKey") String key
    );
}