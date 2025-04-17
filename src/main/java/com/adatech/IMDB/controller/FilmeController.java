package com.adatech.IMDB.controller;

import com.adatech.IMDB.converter.FilmeConverter;
import com.adatech.IMDB.dto.FilmeDTO;
import com.adatech.IMDB.model.Filme;
import com.adatech.IMDB.service.FilmeService;
import com.adatech.IMDB.vo.FilmeOMDB;
import com.adatech.IMDB.vo.FilmeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private FilmeConverter filmeConverter;


    @GetMapping
    public ResponseEntity<FilmeOMDB> getFilme(@RequestParam("titulo") String titulo) {
        FilmeOMDB filmeOMDB = filmeService.getInformacoesFilme(titulo);
        return ResponseEntity.status(HttpStatus.OK).body(filmeOMDB);
    }

    @PostMapping
    public ResponseEntity<FilmeVO> saveFilme(@RequestBody FilmeDTO filmeDTO) {
        FilmeVO filmeVO = filmeConverter.converteParaFilmeVO(filmeService.save(filmeDTO));
        addHateoas(filmeVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeVO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeVO> getById(@PathVariable("id") Long id) {

        FilmeVO filmeVO = filmeConverter.converteParaFilmeVO(filmeService.getById(id));
        return ResponseEntity.ok(filmeVO);
    }

    @GetMapping("/listarFilmes")
    public ResponseEntity<List<FilmeVO>> getAllFilmes() {
        List<Filme> filmes = filmeService.getForAll();

        List<FilmeVO> filmesVO = filmes.stream()
                .map(filme -> {
                    var filmeVO = filmeConverter.converteParaFilmeVO(filme);
                    addHateoas(filmeVO);
                    return filmeVO;
                })
                .toList();

        return ResponseEntity.ok(filmesVO);
    }


    private void addHateoas(FilmeVO filmeVO) {
        filmeVO.add(linkTo(methodOn(FilmeController.class).getById(filmeVO.getId()))
                .withSelfRel());
    }
}
