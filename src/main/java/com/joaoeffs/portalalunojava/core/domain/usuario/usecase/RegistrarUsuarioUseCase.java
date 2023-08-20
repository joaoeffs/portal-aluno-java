package com.joaoeffs.portalalunojava.core.domain.usuario.usecase;

import java.util.UUID;

import com.joaoeffs.portalalunojava.core.domain.usuario.model.Role;

import lombok.Builder;
import lombok.Value;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RegistrarUsuarioUseCase {

    UUID handle(RegistrarUsuario command);

    @Value
    @Builder
    class RegistrarUsuario {

        @Valid
        @NotNull
        String login;

        @Valid
        @NotNull
        String senha;

        @NotNull
        Role role;
    }
}
