package com.joaoeffs.portalalunojava.core.domain.disciplina.usecase;

import java.util.UUID;

import lombok.Value;

import jakarta.validation.constraints.NotNull;

public interface RegistrarDisciplinaUseCase {

    UUID handle(RegistrarDisciplina command);

    @Value(staticConstructor = "of")
    class RegistrarDisciplina {

        @NotNull
        String nome;

        String codigo;

        UUID usuario;
    }
}
