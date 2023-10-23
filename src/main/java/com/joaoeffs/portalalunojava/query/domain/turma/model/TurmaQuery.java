package com.joaoeffs.portalalunojava.query.domain.turma.model;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@Table(name = "turma")
public class TurmaQuery {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nome_abreviado")
    private String nomeAbreviado;

    @Column(name = "ano_letivo")
    private String anoLetivo;
}
