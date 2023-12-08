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

import com.example.demo.entities.Avaliacao;
import com.example.demo.services.AvaliacaoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    @Autowired
    AvaliacaoService avaliacaoService;

    @GetMapping("/{idAvaliacao}")
    @Secured(value = { "ADMIN", "USER" })
    public Avaliacao getAvaliacao(@PathVariable Integer idAvaliacao) throws JsonProcessingException {
        Avaliacao avaliacao = avaliacaoService.getAvaliacao(idAvaliacao);
        return avaliacao;
    }
    @PostMapping
    public void cadastrarAvaliacao(@RequestBody Avaliacao avaliacao){
        avaliacaoService.salvar(avaliacao);
    }
    @PutMapping
    public void atualizar(@RequestBody Avaliacao avaliacao){
        avaliacaoService.atualizar(avaliacao);
    }
    @DeleteMapping("/{idAvaliacao}")
    public void remover(@PathVariable Integer idAvaliacao){
        avaliacaoService.remover(idAvaliacao);
    }
    @GetMapping("/livro/{idLivro}")
    public List<Avaliacao> getAvaliacaoPorLivro(@PathVariable Integer idLivro){
        List<Avaliacao> avaliacoes = avaliacaoService.getAvaliacaoPorLivro(idLivro);
        return avaliacoes;
    }
}
