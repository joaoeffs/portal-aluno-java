package com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase;

import java.util.UUID;

import lombok.Value;

public interface RemoverAlunoDisciplinaUseCase {

    void handle(RemoverAlunoDisciplina command);

    @Value(staticConstructor = "from")
    class RemoverAlunoDisciplina {

        UUID id;
    }
}
