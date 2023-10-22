package com.joaoeffs.portalalunojava.core.domain.turma.model;

import static java.util.Objects.requireNonNull;

import java.util.UUID;
import java.util.function.Consumer;

import lombok.Getter;

@Getter
public class TurmaBuilderUpdate {

    private final Consumer<TurmaBuilderUpdate> action;

    protected UUID id;

    protected String nome;

    protected String nomeAbreviado;

    protected String anoLetivo;

    TurmaBuilderUpdate(UUID id, Consumer<TurmaBuilderUpdate> action) {
        this.id = requireNonNull(id);
        this.action = requireNonNull(action);
    }

    public TurmaBuilderUpdate id(UUID id) {
        this.id = id;
        return this;
    }

    public TurmaBuilderUpdate nome(String nome) {
        this.nome = nome;
        return this;
    }

    public TurmaBuilderUpdate nomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
        return this;
    }

    public TurmaBuilderUpdate anoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
        return this;
    }

    public void apply() {
        action.accept(this);
    }
}
