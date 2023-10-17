package com.joaoeffs.portalalunojava.core.domain.professor.model;

import java.time.LocalDate;
import java.util.UUID;

public class ProfessorBuilder {

    protected UUID id;

    protected String nome;

    protected String sobrenome;

    protected LocalDate dataNascimento;

    protected String email;

    protected String senha;

    public ProfessorBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProfessorBuilder sobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public ProfessorBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public ProfessorBuilder email(String email) {
        this.email = email;
        return this;
    }

    public ProfessorBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Professor build() {

        id = UUID.randomUUID();

        return new Professor(this);
    }
}