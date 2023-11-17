package com.joaoeffs.portalalunojava.core.domain.aluno.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joaoeffs.portalalunojava.infra.role.Role;

public class UsuarioBuilder {

    protected UUID id;

    protected String nome;

    protected String sobrenome;

    protected LocalDate dataNascimento;

    protected String email;

    protected String senha;

    protected String matricula;

    protected Role role;

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

    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder senha(String senha) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(senha);
        this.senha = encryptedPassword;
        return this;
    }

    public UsuarioBuilder matricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public UsuarioBuilder role(Role role) {
        this.role = role;
        return this;
    }

    public Usuario build() {

        id = UUID.randomUUID();

        return new Usuario(this);
    }
}
