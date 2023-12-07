package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Livro id_livro;
    
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Usuario id_usuario;

    @Column(nullable = false)
    private Integer pagina;

    @Column(nullable = false)
    private String conteudo;
}
