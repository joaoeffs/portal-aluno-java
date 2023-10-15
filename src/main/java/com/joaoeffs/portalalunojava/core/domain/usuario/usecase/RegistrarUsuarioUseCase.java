package com.joaoeffs.portalalunojava.core.domain.usuario.usecase;

import java.time.LocalDate;
import java.util.UUID;

import com.joaoeffs.portalalunojava.core.domain.usuario.model.Role.Role;

import lombok.Builder;
import lombok.Value;

public interface RegistrarUsuarioUseCase {

    UUID handle(RegistrarUsuario command);

    @Value
    @Builder
    class RegistrarUsuario {

        String nome;

        String sobrebome;

        LocalDate dataNascimento;

        String matricula;

        String email;

        String login;

        String senha;

        Role roles;
    }
}