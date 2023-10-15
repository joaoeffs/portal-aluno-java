package com.joaoeffs.portalalunojava.core.domain.disciplina.model;

import static java.util.Objects.requireNonNull;

import java.util.UUID;
import java.util.function.Consumer;

import lombok.Getter;

@Getter
public class DisciplinaBuilderUpdate {

    private final Consumer<DisciplinaBuilderUpdate> action;

    protected UUID id;

    protected String nome;

    protected String codigo;

    DisciplinaBuilderUpdate(UUID id, Consumer<DisciplinaBuilderUpdate> action) {
        this.id = requireNonNull(id);
        this.action = requireNonNull(action);
    }

    public DisciplinaBuilderUpdate id(UUID id) {
        this.id = id;
        return this;
    }

    public DisciplinaBuilderUpdate nome(String nome) {
        this.nome = nome;
        return this;
    }

    public DisciplinaBuilderUpdate codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public void apply() {
        action.accept(this);
    }
}
