package com.joaoeffs.portalalunojava.core.domain.usuario.model;

import java.time.LocalDate;
import java.util.UUID;

import com.joaoeffs.portalalunojava.core.domain.usuario.model.Role.Role;

public class UsuarioBuilder {

    protected UUID id;

    protected String nome;

    protected String sobrenome;

    protected LocalDate dataNascimento;

    protected String matricula;

    protected String email;

    protected String login;

    protected String senha;

    protected Role roles;

    public UsuarioBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioBuilder sobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public UsuarioBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public UsuarioBuilder matricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }


    public UsuarioBuilder login(String login) {
        this.login = login;
        return this;
    }

    public UsuarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioBuilder roles(Role roles) {
        this.roles = roles;
        return this;
    }

    public Usuario build() {

        id = UUID.randomUUID();

        return new Usuario(this);
    }
}