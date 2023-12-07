package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Autor;
import com.example.demo.services.AutorService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService autorService;

    @GetMapping("/{idAutor}")
    @Secured(value = { "ADMIN", "USER" })
    public Autor getAutor(@PathVariable Integer idAutor) throws JsonProcessingException {
        Autor autor = autorService.getAutor(idAutor);
        return autor;
    }
    @PostMapping
    @Secured(value = { "ADMIN" })
    public void cadastrarAutora(@RequestBody Autor autor){
        autorService.salvar(autor);
    }
    @PutMapping
    @Secured(value = { "ADMIN" })
    public void atualizar(@RequestBody Autor autor){
        autorService.atualizar(autor);
    }
    @DeleteMapping("/{idAutor}")
    @Secured(value = { "ADMIN" })
    public void remover(@PathVariable Integer idAutor){
        autorService.remover(idAutor);
    }
}
