package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Leitura;

public interface LeituraRepository extends JpaRepository<Leitura,Integer>{
    List<Leitura> getLeiturasPorUsuario(Integer idUsuario);
}
