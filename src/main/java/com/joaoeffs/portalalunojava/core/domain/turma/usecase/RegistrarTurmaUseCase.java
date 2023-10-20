package com.joaoeffs.portalalunojava.core.domain.turma.usecase;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface RegistrarTurmaUseCase {

    UUID handle(RegistrarTurma command);

    @Value
    @Builder
    class RegistrarTurma {

        String nome;

        String nomeAbreviado;

        LocalDate anoLetivo;
    }

}