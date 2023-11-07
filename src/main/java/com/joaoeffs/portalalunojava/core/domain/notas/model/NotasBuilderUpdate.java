package com.joaoeffs.portalalunojava.core.domain.notas.model;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Consumer;

public class NotasBuilderUpdate {

    private final Consumer<NotasBuilderUpdate> action;

    protected UUID id;

    protected BigDecimal n1;

    protected BigDecimal n2;

    protected BigDecimal n3;

    NotasBuilderUpdate(UUID id, Consumer<NotasBuilderUpdate> action) {
        this.id = requireNonNull(id);
        this.action = requireNonNull(action);
    }

    public NotasBuilderUpdate id(UUID id) {
        this.id = id;
        return this;
    }


    public NotasBuilderUpdate n1(BigDecimal n1) {
        this.n1 = n1;
        return this;
    }

    public NotasBuilderUpdate n2(BigDecimal n2) {
        this.n2 = n2;
        return this;
    }

    public NotasBuilderUpdate n3(BigDecimal n3) {
        this.n3 = n3;
        return this;
    }

    public void apply() {
        action.accept(this);
    }
}
