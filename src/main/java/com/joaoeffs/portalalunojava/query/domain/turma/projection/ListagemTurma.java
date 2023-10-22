package com.joaoeffs.portalalunojava.query.domain.turma.projection;

import java.time.LocalDate;
import java.util.UUID;

public interface ListagemTurma {

    UUID getId();

    String getNome();

    String getNomeAbreviado();

    String getAnoLetivo();
}
