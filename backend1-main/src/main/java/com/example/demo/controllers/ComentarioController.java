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

import com.example.demo.entities.Comentario;
import com.example.demo.services.ComentarioService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    ComentarioService comentarioService;

    @GetMapping("/{idComentario}")
    @Secured(value = { "ADMIN", "USER" })
    public Comentario getComentario(@PathVariable Integer idComentario) throws JsonProcessingException {
        Comentario comentario = comentarioService.getComentario(idComentario);
        return comentario;
    }
    @PostMapping
    @Secured(value = { "ADMIN" })
    public void cadastrarComentario(@RequestBody Comentario comentario){
        comentarioService.salvar(comentario);
    }
    @PutMapping
    @Secured(value = { "ADMIN" })
    public void atualizar(@RequestBody Comentario comentario){
        comentarioService.atualizar(comentario);
    }
    @DeleteMapping("/{idComentario}")
    @Secured(value = { "ADMIN" })
    public void remover(@PathVariable Integer idComentario){
        comentarioService.remover(idComentario);
    }

    @GetMapping("/leitura/{idleitura}")
    @Secured(value = { "ADMIN", "USER" })
    public List<Comentario> getComentarioPorLeitura(@PathVariable Integer idLeitura){
        List<Comentario> comentarios  = comentarioService.getComentariosPorLeitura(idLeitura);
        return comentarios;
    }
}
