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

import com.example.demo.entities.Leitura;
import com.example.demo.services.LeituraService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/leitura")
public class LeituraController {
    @Autowired
    LeituraService leituraService;

    //consultar eitura
    @GetMapping("/{idLeitura}")
    @Secured(value = { "ADMIN", "USER" })
    public Leitura getLeitura(@PathVariable Integer idLeitura) throws JsonProcessingException {
        Leitura leitura = leituraService.getLeitura(idLeitura);
        return leitura;
    }

    //adinionar leitura no db
    @PostMapping
    @Secured(value = { "ADMIN"})
    public void cadastrarLeitura(@RequestBody Leitura leitura){
        leituraService.salvar(leitura);
    }

    //atualizar leitura no db
    @PutMapping
    @Secured(value = { "ADMIN"})
    public void atualizar(@RequestBody Leitura leitura){
        leituraService.atualizar(leitura);
    }

    //deletar livro do db
    @DeleteMapping("/{idLeitura}")
    @Secured(value = { "ADMIN" })
    public void remover(@PathVariable Integer idLeitura){
        leituraService.remover(idLeitura);
    }

    // pegar lista de livro por categoria
    @GetMapping("/usuario/{idUsuario}")
    @Secured(value = { "ADMIN", "USER" })
    public List<Leitura> getLieiturasPorUsuario(@PathVariable Integer idUsuario) {
        List<Leitura> leituras = leituraService.getLeiturasPorUsuario(idUsuario);
        return leituras;
    }
    
    
}