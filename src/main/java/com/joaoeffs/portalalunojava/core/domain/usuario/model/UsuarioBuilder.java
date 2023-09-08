package com.joaoeffs.portalalunojava.core.domain.usuario.model;

import java.util.UUID;

public class UsuarioBuilder {

    protected UUID id;

    protected String login;

    protected String senha;

    public UsuarioBuilder login(String login) {
        this.login = login;
        return this;
    }

    public UsuarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario build() {

        id = UUID.randomUUID();

        return new Usuario(this);
    }
}