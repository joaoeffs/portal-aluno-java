package com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model;

import java.util.UUID;

import org.hibernate.annotations.Immutable;

import com.joaoeffs.portalalunojava.query.domain.aluno.model.AlunoQuery;
import com.joaoeffs.portalalunojava.query.domain.disciplina.model.DisciplinaQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Immutable
@Entity
@Table(name = "aluno_disciplina")
public class AlunoDisciplinaQuery {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoQuery aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaQuery disciplina;
}
