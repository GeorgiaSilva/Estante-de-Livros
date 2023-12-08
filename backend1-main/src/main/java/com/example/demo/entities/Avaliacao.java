package com.example.demo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "Avaliacao.getAvaliacaoPorLivro", query = "SELECT t FROM Avaliacao t WHERE t.id_livro.id=:idCLivro")


@Entity
@Getter @Setter
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Livro id_livro;

    @Column(nullable = false)
    private String texto;
    
    
}
