package com.joaoeffs.portalalunojava.query.domain.turmadisciplina.model;

import java.util.UUID;

import org.hibernate.annotations.Immutable;

import com.joaoeffs.portalalunojava.query.domain.disciplina.model.DisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.turma.model.TurmaQuery;

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
@Table(name = "turma_disciplina")
public class TurmaDisciplinaQuery {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaQuery turma;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaQuery disciplina;

}
