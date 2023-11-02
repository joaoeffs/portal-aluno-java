package com.joaoeffs.portalalunojava.core.domain.alunodisciplina.model;

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
@Table(name = "aluno_disciplina")
public class AlunoDisciplina {

    @Id
    @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "uuid"))
    private UUID id;

    @Column(name = "aluno_id")
    private UUID aluno;

    @Column(name = "disciplina_id")
    private UUID disciplina;

    public static AlunoDisciplinaBuilder builder() {
        return new AlunoDisciplinaBuilder();
    }

    AlunoDisciplina(AlunoDisciplinaBuilder builder) {
        this.id = requireNonNull(builder.id);
        this.aluno = requireNonNull(builder.aluno);
        this.disciplina = requireNonNull(builder.disciplina);
    }
}
