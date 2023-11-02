package com.joaoeffs.portalalunojava.query.domain.aluno.model;

import java.util.UUID;

import org.hibernate.annotations.Immutable;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Immutable
@Entity
@Table(name = "aluno")
public class AlunoQuery {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "matricula")
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaQuery turma;
}
