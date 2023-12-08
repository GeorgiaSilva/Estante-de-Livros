package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Avaliacao;


public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Integer>{
    List<Avaliacao> getAvaliacaoPorLivro(Integer idLivro);
    boolean existsByTexto(String texto);
}
