package com.joaoeffs.portalalunojava.core.domain.turmadisciplina.usecase;

import java.util.UUID;

import lombok.Value;

public interface RemoverTurmaDisciplinaUseCase {

    void handle(RemoverTurmaDisciplina command);

    @Value(staticConstructor = "from")
    class RemoverTurmaDisciplina {

        UUID id;
    }
}
