package com.joaoeffs.portalalunojava.query.domain.notas.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface ListagemNotas {

    UUID getId();

    UUID getNotaId();

    BigDecimal getN1();

    BigDecimal getN2();

    BigDecimal getN3();

    UUID getAlunoId();

    String getNome();

    String getSobrenome();

    String getMatricula();
}
