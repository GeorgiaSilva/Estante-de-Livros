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

@NamedQuery(name = "Livro.getLivrosPorCategoria", query = "SELECT t FROM Livro t WHERE t.categoria.id=:idCategoria")


@Entity

@Getter @Setter

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Autor autor;

   
    @Column(nullable = false)
    private String sinopse;

    @Column(nullable = false)
    private Integer qtd_paginas;
}
/*
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Curso curso;
*/