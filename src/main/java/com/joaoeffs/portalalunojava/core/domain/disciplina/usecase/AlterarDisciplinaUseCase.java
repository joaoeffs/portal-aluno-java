package com.joaoeffs.portalalunojava.core.domain.disciplina.usecase;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface AlterarDisciplinaUseCase {

    UUID handle(AlterarDisciplina command);

    @Value(staticConstructor = "of")
    @Builder
    class AlterarDisciplina {

        UUID id;

        String nome;

        String codigo;

        public AlterarDisciplina from(UUID id) {
            return AlterarDisciplina.builder()
                .id(id)
                .nome(nome)
                .codigo(codigo)
                .build();
        }
    }
}
