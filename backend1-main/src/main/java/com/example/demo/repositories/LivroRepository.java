package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro,Integer>{
    List<Livro> getLivrosPorCategoria(Integer idCategoria);
    List<Livro> getLivrosPorAutor(Integer idAutor);
}
