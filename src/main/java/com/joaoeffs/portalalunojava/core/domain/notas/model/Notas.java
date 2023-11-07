package com.joaoeffs.portalalunojava.core.domain.notas.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@NoArgsConstructor(access = PROTECTED, force = true)
@AllArgsConstructor(access = PRIVATE)

@Entity(name = "Notas")
@Table(name = "notas")
public class Notas {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "n1")
    private BigDecimal n1;

    @Column(name = "n2")
    private BigDecimal n2;

    @Column(name = "n3")
    private BigDecimal n3;

    @Column(name = "aluno_disciplina_id")
    private UUID alunoDisciplina;

    public static NotasBuilder builder() {
        return new NotasBuilder();
    }

    public Notas(NotasBuilder builder) {
        id = builder.id;
        n1 = builder.n1;
        n2 = BigDecimal.ZERO;
        n3 = BigDecimal.ZERO;
        alunoDisciplina = builder.alunoDisciplina;
    }

    public NotasBuilderUpdate alterar() {
        return new NotasBuilderUpdate(id, form -> {
            n1 = form.n1;
            n2 = form.n2;
            n3 = form.n3;
        });
    }
}
