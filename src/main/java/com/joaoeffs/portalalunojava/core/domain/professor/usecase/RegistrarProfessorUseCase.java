package com.joaoeffs.portalalunojava.core.domain.professor.usecase;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface RegistrarProfessorUseCase {

    UUID handle(RegistrarProfessor command);

    @Value
    @Builder
    class RegistrarProfessor {

        String nome;

        String sobrenome;

        LocalDate dataNascimento;

        String email;

        String senha;
    }
}