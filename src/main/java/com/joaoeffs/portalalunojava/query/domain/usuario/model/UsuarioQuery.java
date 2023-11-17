package com.joaoeffs.portalalunojava.query.domain.usuario.model;

import java.util.UUID;

import com.joaoeffs.portalalunojava.infra.role.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuario")
public class UsuarioQuery {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "matricula")
    private String matricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
