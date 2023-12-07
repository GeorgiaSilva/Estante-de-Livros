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

@NamedQuery(name = "Comentario.getComentariosPorLeitura", query = "SELECT t FROM Comentario t WHERE t.id_leitura.id=:idLeitura")

@Entity
@Getter @Setter
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Leitura id_leitura;
    
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Usuario id_usuario;

    @Column(nullable = false)
    private Integer pagina;

    @Column(nullable = false)
    private String conteudo;
}
