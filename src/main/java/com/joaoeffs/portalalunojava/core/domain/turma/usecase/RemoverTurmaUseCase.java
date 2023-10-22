package com.joaoeffs.portalalunojava.core.domain.turma.usecase;

import java.util.UUID;

import lombok.Value;

public interface RemoverTurmaUseCase {

    void handle(RemoverTurma command);

    @Value(staticConstructor = "from")
    class RemoverTurma {

        UUID id;
    }
}
