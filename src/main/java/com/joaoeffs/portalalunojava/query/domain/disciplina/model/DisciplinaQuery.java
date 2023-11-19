package com.joaoeffs.portalalunojava.query.domain.disciplina.model;

import java.util.UUID;

import org.hibernate.annotations.Immutable;

import com.joaoeffs.portalalunojava.query.domain.usuario.model.UsuarioQuery;

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
@Table(name = "disciplina")
public class DisciplinaQuery {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private UsuarioQuery professor;

}
