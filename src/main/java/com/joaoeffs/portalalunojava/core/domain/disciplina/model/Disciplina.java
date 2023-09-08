package com.joaoeffs.portalalunojava.core.domain.disciplina.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Getter
@NoArgsConstructor(access = PROTECTED, force = true)
@AllArgsConstructor(access = PRIVATE)

@Entity(name = "Disciplina")
@Table(name = "disciplina")
public class Disciplina {

    @EmbeddedId
    @Column(name = "id")
    private final UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo")
    private String codigo;

    @OneToMany
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
