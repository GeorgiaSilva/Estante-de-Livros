package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.entities.Livro;
import com.example.demo.services.LivroService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    //consultar lvro
    @GetMapping("/{idLivro}")
    @Secured(value = { "ADMIN", "USER" })
    public Livro getLivro(@PathVariable Integer idLivro) throws JsonProcessingException {
        Livro livro = livroService.getLivro(idLivro);
        return livro;
    }

    //adinionar livro no db
    @PostMapping
    @Secured(value = { "ADMIN"})
    public void cadastrarLivro(@RequestBody Livro livro){
        livroService.salvar(livro);
    }

    //atualizar livro no db
    @PutMapping
    @Secured(value = { "ADMIN"})
    public void atualizar(@RequestBody Livro livro){
        livroService.atualizar(livro);
    }

    //deletar livro do db
    @DeleteMapping("/{idLivro}")
    @Secured(value = { "ADMIN" })
    public void remover(@PathVariable Integer idLivro){
        livroService.remover(idLivro);
    }

    // pegar lista de livro por categoria
    @GetMapping("/categoria/{idCategoria}")
    @Secured(value = { "ADMIN", "USER" })
    public List<Livro> getLivrosPorCategoria(@PathVariable Integer idCategoria) {
        List<Livro> livros = livroService.getLivrosPorCategoria(idCategoria);
        return livros;
    }
    
    // pegar lista de livro por autor
    @GetMapping("/autor/{idAutor}")
    @Secured(value = { "ADMIN", "USER" })
    public List<Livro> getLivrosPorAutor(@PathVariable Integer idAutor) {
        List<Livro> livros = livroService.getLivrosPorAutor(idAutor);
        return livros;
    }
}
