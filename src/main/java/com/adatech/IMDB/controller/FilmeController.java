package com.adatech.IMDB.controller;

import com.adatech.IMDB.converter.FilmeConverter;
import com.adatech.IMDB.dto.FilmeDTO;
import com.adatech.IMDB.service.FilmeService;
import com.adatech.IMDB.vo.FilmeOMDB;
import com.adatech.IMDB.vo.FilmeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
        try {
            FilmeOMDB filmeOMDB = filmeService.getInformacoesFilme(titulo);
            return ResponseEntity.status(HttpStatus.OK).body(filmeOMDB);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // ou uma resposta customizada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<FilmeVO> saveFilme(@RequestBody FilmeDTO filmeDTO) {
        try {
            FilmeVO filmeVO = filmeConverter.converteParaFilmeVO(filmeService.save(filmeDTO));
            addHateoas(filmeVO);
            return ResponseEntity.status(HttpStatus.CREATED).body(filmeVO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeVO> getById(@PathVariable("id") Long id) {
        try {
            FilmeVO filmeVO = filmeConverter.converteParaFilmeVO(filmeService.getById(id));
            return ResponseEntity.ok(filmeVO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listarFilmes")
    public ResponseEntity<List<FilmeVO>> getAllFilmes() {
        try {
            var filmes = filmeService.getForAll();

            if (filmes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            FilmeVO filmesVO = (FilmeVO) filmes.stream()
                    .map(filme -> {
                        var filmeVO = filmeConverter.converteParaFilmeVO(filme);
                        addHateoas(filmeVO);
                        return filmeVO;
                    })
                    .toList();

            return ResponseEntity.ok(Collections.singletonList(filmesVO));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    private void addHateoas(FilmeVO filmeVO) {
        filmeVO.add(linkTo(methodOn(FilmeController.class).getById(filmeVO.getId()))
                .withSelfRel());
    }
}

