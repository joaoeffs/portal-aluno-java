package com.joaoeffs.portalalunojava.core.domain.aluno.usecase;

import java.time.LocalDate;
import java.util.UUID;

import com.joaoeffs.portalalunojava.infra.role.Role;

import lombok.Builder;
import lombok.Value;

public interface RegistrarUsuarioUseCase {

    UUID handle(RegistrarUsuario command);

    @Value
    @Builder
    class RegistrarUsuario {

        String nome;

        String sobrenome;

        LocalDate dataNascimento;

        String email;

        String senha;

        String matricula;

        Role role;
    }
}
