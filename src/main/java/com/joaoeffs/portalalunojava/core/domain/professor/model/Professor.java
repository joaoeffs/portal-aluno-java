package com.joaoeffs.portalalunojava.core.domain.professor.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "uuid"))
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public static ProfessorBuilder builder() {
        return new ProfessorBuilder();
    }

    Professor(ProfessorBuilder builder) {
        this.id = requireNonNull(builder.id);
        this.nome = builder.nome;
        this.sobrenome = builder.sobrenome;
        this.dataNascimento = builder.dataNascimento;
        this.email = requireNonNull(builder.email);
        this.senha = requireNonNull(builder.senha);
    }
}