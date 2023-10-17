package com.joaoeffs.portalalunojava.core.domain.aluno.usecase;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface RegistrarAlunoUseCase {

    UUID handle(RegistrarAluno command);

    @Value
    @Builder
    class RegistrarAluno {

        String nome;

        String sobrenome;

        LocalDate dataNascimento;

        String email;

        String senha;

        String matricula;
    }
}
