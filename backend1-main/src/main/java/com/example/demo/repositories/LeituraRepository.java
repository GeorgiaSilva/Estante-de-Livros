package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Leitura;
import com.example.demo.entities.Livro;
import com.example.demo.entities.Usuario;

public interface LeituraRepository extends JpaRepository<Leitura,Integer>{
    List<Leitura> getLeiturasPorUsuario(Integer idUsuario);
    boolean existsByLivro(Livro livro);
    boolean existsByUsuario(Usuario usuario);

}
