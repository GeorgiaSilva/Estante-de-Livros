package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Integer>{
    
}
