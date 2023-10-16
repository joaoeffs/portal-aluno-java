package com.joaoeffs.portalalunojava.core.domain.disciplina.usecase;

import java.util.UUID;

import lombok.Value;

public interface RemoverDisciplinaUseCase {

    void handle(RemoverDisciplina command);

    @Value(staticConstructor = "from")
    class RemoverDisciplina {

        UUID id;
    }
}
