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

import com.example.demo.entities.Categoria;
import com.example.demo.services.CategoriaService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/{idCategoria}")
    @Secured(value = { "ADMIN", "USER" })
    public Categoria getCategoria(@PathVariable Integer idCategoria) throws JsonProcessingException {
        Categoria categoria = categoriaService.getCategoria(idCategoria);
        return categoria;
    }
    @PostMapping
    @Secured(value = { "ADMIN" })
    public void cadastrarCategoria(@RequestBody Categoria categoria){
        categoriaService.salvar(categoria);
    }
    @PutMapping
    @Secured(value = { "ADMIN" })
    public void atualizar(@RequestBody Categoria categoria){
        categoriaService.atualizar(categoria);
    }
    @DeleteMapping("/{idCategoria}")
    @Secured(value = { "ADMIN" })
    public void remover(@PathVariable Integer idCategoria){
        categoriaService.remover(idCategoria);
    }
}
