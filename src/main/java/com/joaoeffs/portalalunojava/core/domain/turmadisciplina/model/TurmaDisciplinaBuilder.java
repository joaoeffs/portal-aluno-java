package com.joaoeffs.portalalunojava.core.domain.turmadisciplina.model;

import java.util.UUID;

public class TurmaDisciplinaBuilder {

    protected UUID id;

    protected UUID turma;

    protected UUID disciplina;

    public TurmaDisciplinaBuilder turma(UUID turma) {
        this.turma = turma;
        return this;
    }

    public TurmaDisciplinaBuilder disciplina(UUID disciplina) {
        this.disciplina = disciplina;
        return this;
    }

    public TurmaDisciplina build() {

        id = UUID.randomUUID();

        return new TurmaDisciplina(this);
    }
}
