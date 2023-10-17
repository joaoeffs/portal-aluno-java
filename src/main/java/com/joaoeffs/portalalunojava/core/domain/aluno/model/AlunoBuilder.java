package com.joaoeffs.portalalunojava.core.domain.aluno.model;

import java.time.LocalDate;
import java.util.UUID;

public class AlunoBuilder {

    protected UUID id;

    protected String nome;

    protected String sobrenome;

    protected LocalDate dataNascimento;

    protected String email;

    protected String senha;

    protected String matricula;

    public AlunoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public AlunoBuilder sobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public AlunoBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public AlunoBuilder email(String email) {
        this.email = email;
        return this;
    }

    public AlunoBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public AlunoBuilder matricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public Aluno build() {

        id = UUID.randomUUID();

        return new Aluno(this);
    }
}
