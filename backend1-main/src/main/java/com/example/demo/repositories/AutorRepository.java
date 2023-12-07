package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor,Integer>{
    
}
