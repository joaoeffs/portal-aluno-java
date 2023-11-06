package com.joaoeffs.portalalunojava.core.domain.notas.model;

import java.math.BigDecimal;
import java.util.UUID;

public class NotasBuilder {

    protected UUID id;

    protected BigDecimal n1;

    protected BigDecimal n2;

    protected BigDecimal n3;

    protected UUID alunoDisciplina;

    public NotasBuilder n1(BigDecimal n1) {
        this.n1 = n1;
        return this;
    }

    public NotasBuilder n2(BigDecimal n2) {
        this.n2 = n2;
        return this;
    }

    public NotasBuilder n3(BigDecimal n3) {
        this.n3 = n3;
        return this;
    }

    public NotasBuilder alunoDisciplina(UUID alunoDisciplina) {
        this.alunoDisciplina = alunoDisciplina;
        return this;
    }

    public Notas build() {
        id = UUID.randomUUID();

        return new Notas(this);
    }
}
