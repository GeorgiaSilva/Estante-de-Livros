package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categoria;
import com.example.demo.repositories.CategoriaRepository;
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria getCategoria(Integer idCategoria) {
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        categoria.isEmpty();
        return categoria.get();
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void remover(Integer idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }

    

   
   
}
