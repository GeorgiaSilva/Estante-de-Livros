package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Autor;
import com.example.demo.repositories.AutorRepository;
@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor getAutor(Integer idAutor) {
        Optional<Autor> autor = autorRepository.findById(idAutor);
        autor.isEmpty();
        return autor.get();
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor atualizar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void remover(Integer idAutor) {
        autorRepository.deleteById(idAutor);
    }
   
   
}
