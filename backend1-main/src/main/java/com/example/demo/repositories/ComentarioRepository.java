package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Comentario;


public interface ComentarioRepository extends JpaRepository<Comentario,Integer>{
    List<Comentario> getComentariosPorLeitura(Integer idLeitura);
    boolean existsByConteudo(String conteudo);
}
