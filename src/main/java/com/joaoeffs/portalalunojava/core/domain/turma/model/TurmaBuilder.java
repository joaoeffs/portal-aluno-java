package com.joaoeffs.portalalunojava.core.domain.turma.model;

import java.time.LocalDate;
import java.util.UUID;

public class TurmaBuilder {

    protected UUID id;

    protected String nome;

    protected String nomeAbreviado;

    protected LocalDate anoLetivo;

    public TurmaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public TurmaBuilder nomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
        return this;
    }

    public TurmaBuilder anoLetivo(LocalDate anoLetivo) {
        this.anoLetivo = anoLetivo;
        return this;
    }

    public Turma build() {

        id = UUID.randomUUID();

        return new Turma(this);
    }
}
