package com.joaoeffs.portalalunojava.query.domain.notas.model;

import java.util.UUID;

import org.hibernate.annotations.Immutable;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model.AlunoDisciplinaQuery;

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
@Table(name = "notas")
public class NotasQuery {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "n1")
    private String n1;

    @Column(name = "n2")
    private String n2;

    @Column(name = "n3")
    private String n3;

    @ManyToOne
    @JoinColumn(name = "aluno_disciplina_id")
    private AlunoDisciplinaQuery alunoDisciplina;
}
