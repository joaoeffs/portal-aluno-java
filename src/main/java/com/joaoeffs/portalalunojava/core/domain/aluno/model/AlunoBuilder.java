package com.joaoeffs.portalalunojava.core.domain.aluno.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joaoeffs.portalalunojava.infra.role.Role;

public class AlunoBuilder {

    protected UUID id;

    protected String nome;

    protected String sobrenome;

    protected LocalDate dataNascimento;

    protected String email;

    protected String senha;

    protected String matricula;

    protected Role role;

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
        String encryptedPassword = new BCryptPasswordEncoder().encode(senha);
        this.senha = encryptedPassword;
        return this;
    }

    public AlunoBuilder matricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public AlunoBuilder role(Role role) {
        this.role = role;
        return this;
    }

    public Aluno build() {

        id = UUID.randomUUID();

        return new Aluno(this);
    }
}
