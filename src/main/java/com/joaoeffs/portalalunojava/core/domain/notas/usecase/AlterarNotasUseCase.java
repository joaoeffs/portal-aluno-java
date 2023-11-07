package com.joaoeffs.portalalunojava.core.domain.notas.usecase;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

public interface AlterarNotasUseCase {

    UUID handle(AlterarNotas command);

    @Value
    @Builder
    class AlterarNotas {

        UUID id;

        BigDecimal n1;

        BigDecimal n2;

        BigDecimal n3;

        public AlterarNotas from(UUID id) {
            return AlterarNotas.builder()
                .id(id)
                .n1(n1)
                .n2(n2)
                .n3(n3)
                .build();
        }
    }
}
