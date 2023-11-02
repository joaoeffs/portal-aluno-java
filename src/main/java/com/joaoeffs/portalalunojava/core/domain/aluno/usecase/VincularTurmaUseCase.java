package com.joaoeffs.portalalunojava.core.domain.aluno.usecase;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface VincularTurmaUseCase {

    void handle(VincularTurma command);

    @Value
    @Builder
    class VincularTurma {

        UUID id;

        UUID turma;

        public VincularTurma from(UUID id) {
            return VincularTurma.builder()
                .id(id)
                .turma(turma)
                .build();
        }
    }
}
