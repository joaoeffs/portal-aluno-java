package com.joaoeffs.portalalunojava.core.domain.turmadisciplina.usecase;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface RegistrarTurmaDisciplinaUseCase {

    UUID handle(RegistrarTurmaDisciplina command);

    @Value
    @Builder
    class RegistrarTurmaDisciplina {

        UUID turma;

        UUID disciplina;
    }
}
