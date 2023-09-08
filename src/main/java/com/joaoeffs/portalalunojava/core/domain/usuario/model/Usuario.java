package com.joaoeffs.portalalunojava.core.domain.usuario.model;

import static java.util.Objects.requireNonNull;

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
@Table(name = "usuario")
public class Usuario {

    @Id
    @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "uuid"))
    private UUID id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    Usuario(UsuarioBuilder builder) {
        this.id = requireNonNull(builder.id);
        this.login = requireNonNull(builder.login);
        this.senha = requireNonNull(builder.senha);
    }
}