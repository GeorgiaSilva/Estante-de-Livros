package com.example.demo.services;


import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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
        if (leituraRepository.existsByLivro(leitura.getLivro()) && leituraRepository.existsByUsuario(leitura.getUsuario()) ) {
            throw new RuntimeException("Já existe uma leitura desse livro ") ;
        } else {
            return leituraRepository.save(leitura);
        }
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
  
 // supondo que você tenha um repositório para a entidade Leitura

    public void concluirLeitura(Integer idLeitura) {
        Optional<Leitura> leituraOptional = leituraRepository.findById(idLeitura);

        if (leituraOptional.isPresent()) {
            Leitura leitura = leituraOptional.get();

            // Verificar se a leitura já foi concluída
            if (leitura.getDataFim() == null) {
                // Concluir a leitura
                leitura.setDataFim(LocalDate.now());

                // Atualizar a entidade no banco de dados
                leituraRepository.save(leitura);
            } else {
                throw new IllegalStateException("A leitura já foi concluída anteriormente.");
            }
        } else {
            throw new NoSuchElementException("Leitura não encontrada com o ID: " + idLeitura);
        }
    }

   

}
