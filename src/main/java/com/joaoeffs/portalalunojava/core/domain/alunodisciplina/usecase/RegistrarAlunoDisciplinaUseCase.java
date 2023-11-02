package com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface RegistrarAlunoDisciplinaUseCase {

    UUID handle(RegistrarAlunoDisciplina command);

    @Value
    @Builder
    class RegistrarAlunoDisciplina {

        UUID aluno;

        UUID disciplina;
    }
}
