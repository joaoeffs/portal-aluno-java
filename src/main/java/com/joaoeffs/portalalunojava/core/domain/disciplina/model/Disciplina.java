package com.joaoeffs.portalalunojava.core.domain.disciplina.model;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

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

@Entity(name = "Disciplina")
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo")
    private String codigo;

    public static DisciplinaBuilder builder() {
        return new DisciplinaBuilder();
    }

    public Disciplina(DisciplinaBuilder builder) {
        id = requireNonNull(builder.id);
        nome = builder.nome;
        codigo = builder.codigo;
    }

    public DisciplinaBuilderUpdate alterar() {
        return new DisciplinaBuilderUpdate(id, form -> {
            nome = form.nome;
            codigo = form.codigo;
        });
    }
}
