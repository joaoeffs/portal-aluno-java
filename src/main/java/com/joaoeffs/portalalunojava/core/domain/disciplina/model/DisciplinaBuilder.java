package com.joaoeffs.portalalunojava.core.domain.disciplina.model;

import java.util.UUID;

public class DisciplinaBuilder {

    protected UUID id;

    protected String nome;

    protected String codigo;


    public DisciplinaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public DisciplinaBuilder codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public Disciplina build() {
        id = UUID.randomUUID();

        return new Disciplina(this);
    }

}
