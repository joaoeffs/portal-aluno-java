package com.joaoeffs.portalalunojava.core.domain.disciplina.usecase;

import java.util.UUID;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;

import lombok.Builder;
import lombok.Value;

import jakarta.validation.constraints.NotNull;

public interface RegistrarDisciplinaUseCase {

    UUID handle(RegistrarDisciplina command);

    @Value
    @Builder
    class RegistrarDisciplina {

        @NotNull
        String nome;

        String codigo;

        UUID professor;

        public RegistrarDisciplina from(UUID usuario) {
            return RegistrarDisciplina.builder()
                .nome(nome)
                .codigo(codigo)
                .professor(usuario)
                .build();
        }
    }
}
