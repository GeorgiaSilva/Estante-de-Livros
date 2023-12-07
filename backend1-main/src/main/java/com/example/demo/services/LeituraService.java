package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Leitura;

import com.example.demo.repositories.LeituraRepository;

@Service
public class LeituraService {
    @Autowired
    private LeituraRepository leituraRepository;

    public Leitura getLeitura(Integer idLeitura) {
        Optional<Leitura> leitura = leituraRepository.findById(idLeitura);
        leitura.isEmpty();
        return leitura.get();
    }

    public Leitura salvar(Leitura leitura) {
        return leituraRepository.save(leitura);
    }

    public Leitura atualizar(Leitura leitura) {
        return leituraRepository.save(leitura);
    }

    public void remover(Integer idLeitura) {
        leituraRepository.deleteById(idLeitura);
    }

    public List<Leitura> getLeiturasPorUsuario(Integer idUsuario){
        return leituraRepository.getLeiturasPorUsuario(idUsuario);
    }
   

}
