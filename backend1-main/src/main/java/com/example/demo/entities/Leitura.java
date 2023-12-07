package com.example.demo.entities;


import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter

public class Leitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Livro id_livro;
    
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Usuario id_usuario;

    @Temporal(TemporalType.DATE)
    private LocalDate data_inicio;

    @Temporal(TemporalType.DATE)
    private Date data_final;
    
    @PrePersist void prePersist(){
        data_inicio= LocalDate.now();
    }
}
