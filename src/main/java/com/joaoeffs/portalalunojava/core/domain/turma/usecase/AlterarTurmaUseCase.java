package com.joaoeffs.portalalunojava.core.domain.turma.usecase;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface AlterarTurmaUseCase {

    UUID handle(AlterarTurma command);

    @Value(staticConstructor = "of")
    @Builder
    class AlterarTurma {

        UUID id;

        String nome;

        String nomeAbreviado;

        String anoLetivo;

        public AlterarTurma from(UUID id) {
            return AlterarTurma.builder()
                .id(id)
                .nome(nome)
                .nomeAbreviado(nomeAbreviado)
                .anoLetivo(anoLetivo)
                .build();
        }
    }
}
