package com.joaoeffs.portalalunojava.core.domain.turmadisciplina.model;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "turma_disciplina")
public class TurmaDisciplina {

    @Id
    @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "uuid"))
    private UUID id;

    @Column(name = "turma_id")
    private UUID turma;

    @Column(name = "disciplina_id")
    private UUID disciplina;

    public static TurmaDisciplinaBuilder builder() {
        return new TurmaDisciplinaBuilder();
    }

    TurmaDisciplina(TurmaDisciplinaBuilder builder) {
        this.id = requireNonNull(builder.id);
        this.turma = builder.turma;
        this.disciplina = builder.disciplina;
    }
}
