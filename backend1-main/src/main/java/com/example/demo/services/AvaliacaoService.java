package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Avaliacao;
import com.example.demo.repositories.AvaliacaoRepository;
@Service
public class AvaliacaoService {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao getAvaliacao(Integer idAvaliacao) {
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(idAvaliacao);
        avaliacao.isEmpty();
        return avaliacao.get();
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao atualizar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public void remover(Integer idAvaliacao) {
        avaliacaoRepository.deleteById(idAvaliacao);
    }
   
   
}
