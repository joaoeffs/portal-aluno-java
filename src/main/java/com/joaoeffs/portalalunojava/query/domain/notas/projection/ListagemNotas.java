package com.joaoeffs.portalalunojava.query.domain.notas.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface ListagemNotas {

    UUID getId();

    BigDecimal getN1();

    BigDecimal getN2();

    BigDecimal getN3();

    UUID getAlunoDisciplina();
}
