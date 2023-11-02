package com.joaoeffs.portalalunojava.core.domain.alunodisciplina.model;

import java.util.UUID;

public class AlunoDisciplinaBuilder {

    protected UUID id;

    protected UUID aluno;

    protected UUID disciplina;

    public AlunoDisciplinaBuilder aluno(UUID aluno) {
        this.aluno = aluno;
        return this;
    }

    public AlunoDisciplinaBuilder disciplina(UUID disciplina) {
        this.disciplina = disciplina;
        return this;
    }

    public AlunoDisciplina build() {

        id = UUID.randomUUID();

        return new AlunoDisciplina(this);
    }
}
