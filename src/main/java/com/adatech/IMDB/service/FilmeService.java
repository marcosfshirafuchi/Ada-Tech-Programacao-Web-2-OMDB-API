package com.adatech.IMDB.service;

import com.adatech.IMDB.converter.FilmeConverter;
import com.adatech.IMDB.dto.FilmeDTO;
import com.adatech.IMDB.model.Filme;
import com.adatech.IMDB.repository.FilmeRepository;
import com.adatech.IMDB.vo.FilmeOMDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final FilmeConverter filmeConverter;

    @Value("${url.apiFilmes}")
    private String urlApiFilmes;

    private final String PARAM_API_KEY = "&apikey=158d281a";

    public FilmeService(FilmeRepository filmeRepository, FilmeConverter filmeConverter) {
        this.filmeRepository = filmeRepository;
        this.filmeConverter = filmeConverter;
    }

    public FilmeOMDB getInformacoesFilme(String titulo) {
        RestTemplate restTemplate = new RestTemplate();
        FilmeOMDB filmeOMDB = restTemplate.getForObject(urlApiFilmes + "?t=" + titulo + PARAM_API_KEY, FilmeOMDB.class);

        if (filmeOMDB == null || "False".equalsIgnoreCase(filmeOMDB.getResponse())) {
            throw new IllegalArgumentException("Filme não encontrado na base OMDB.");
        }

        return filmeOMDB;
    }

//    public FilmeOMDB getFilme(String tema) {
//        if (tema == null || tema.isEmpty()) {
//            throw new IllegalArgumentException("O título do filme (tema) não pode ser nulo ou vazio");
//        }
//        return filmeClientFeign.getFilme(tema, apiKey);
//    }


    public Filme save(FilmeDTO filmeDTO) {
        if (filmeDTO == null) {
            throw new IllegalArgumentException("FilmeDTO não pode ser nulo");
        }

        Filme filme = filmeConverter.converteParaFilme(filmeDTO);
        return filmeRepository.save(filme);
    }


    public Filme getById(Long id) {
        Optional<Filme> filme = filmeRepository.findById(id);
        return filme.orElseThrow(() -> new IllegalArgumentException("Filme não encontrado com o ID: " + id));
    }

    public List<Filme> getForAll() {
        List<Filme> filmes = filmeRepository.findAll();
        if (filmes.isEmpty()) {
            throw new IllegalArgumentException("Lista de filmes vazia!");
        }
        return filmes;
    }

}
