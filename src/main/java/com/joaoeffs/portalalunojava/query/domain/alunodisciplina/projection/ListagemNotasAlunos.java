package com.joaoeffs.portalalunojava.query.domain.alunodisciplina.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface ListagemNotasAlunos {

    UUID getId();

    UUID getNotaId();

    BigDecimal getN1();

    BigDecimal getN2();

    BigDecimal getN3();

    BigDecimal getMedia();

    String getSituacao();

    UUID getAlunoId();

    String getNome();

    String getSobrenome();

    String getMatricula();

    String getNomeDisciplina();

    String getCodigoDisciplina();

}