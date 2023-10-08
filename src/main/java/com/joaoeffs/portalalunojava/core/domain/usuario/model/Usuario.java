package com.joaoeffs.portalalunojava.core.domain.usuario.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.UUID;

import com.joaoeffs.portalalunojava.core.domain.usuario.model.Role.Role;

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
@Table(name = "usuario")
public class Usuario {

    @Id
    @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "uuid"))
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "role")
    private Role roles;

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    Usuario(UsuarioBuilder builder) {
        this.id = requireNonNull(builder.id);
        this.nome = builder.nome;
        this.sobrenome = builder.sobrenome;
        this.dataNascimento = builder.dataNascimento;
        this.matricula = builder.matricula;
        this.email = builder.email;
        this.login = requireNonNull(builder.login);
        this.senha = requireNonNull(builder.senha);
        this.roles = builder.roles;
    }
}