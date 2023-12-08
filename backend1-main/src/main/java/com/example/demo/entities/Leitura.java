package com.example.demo.entities;



import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "Leitura.getLeiturasPorUsuario", query = "SELECT t FROM Leitura t WHERE t.usuario.id=:idUsuario")

@Entity
@Getter @Setter

public class Leitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Livro livro;
    
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private LocalDate DataInicio;
    
    @Temporal(TemporalType.DATE)
    private LocalDate DataFim;

    @PrePersist void prePersist(){
        DataInicio = LocalDate.now();
    }
    @PreUpdate
    void PreUpdate(){
        DataFim = LocalDate.now();
        if (DataFim != null && DataInicio == null) {
            // Se a leitura está sendo concluída, mas a data de início ainda não está definida, mantenha a data de início
            DataInicio = LocalDate.now();
        }
    }

}
