package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Comentario;

import com.example.demo.repositories.ComentarioRepository;
@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario getComentario(Integer idComentario) {
        Optional<Comentario> comentario = comentarioRepository.findById(idComentario);
        comentario.isEmpty();
        return comentario.get();
    }

    public Comentario salvar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario atualizar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public void remover(Integer idComentario) {
        comentarioRepository.deleteById(idComentario);
    }

    public List<Comentario> getComentariosPorLeitura(Integer idLeitura){
        return comentarioRepository.getComentariosPorLeitura(idLeitura);
    }

    

   
   
}
