package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livro;
import com.example.demo.repositories.LivroRepository;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro getLivro(Integer idLivro) {
        Optional<Livro> livro = livroRepository.findById(idLivro);
        livro.isEmpty();
        return livro.get();
    }

    public Livro salvar(Livro livro) {

        if (livroRepository.existsByTitulo(livro.getTitulo())) {
            throw new RuntimeException("Já existe um livro com o nome " + livro.getTitulo()) ;
        } else {
        return livroRepository.save(livro);
        }
    }

    public Livro atualizar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void remover(Integer idLivro) {
        livroRepository.deleteById(idLivro);
    }
   
    public List<Livro> getLivrosPorCategoria(Integer idCategoria){
        return livroRepository.getLivrosPorCategoria(idCategoria);
    }
    public List<Livro> getLivrosPorAutor(Integer idAutor){
        return livroRepository.getLivrosPorAutor(idAutor);
    }
}
