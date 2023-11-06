package com.joaoeffs.portalalunojava.core.domain.notas.usecase;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface RegistrarNotasUseCase {

    UUID handle(RegistrarNotas command);


    @Value
    @Builder
    class RegistrarNotas {

        BigDecimal n1;

        BigDecimal n2;

        BigDecimal n3;

        UUID alunoDisciplina;
    }
}
