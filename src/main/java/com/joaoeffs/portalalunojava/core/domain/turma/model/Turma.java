package com.joaoeffs.portalalunojava.core.domain.turma.model;

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
@Table(name = "turma")
public class Turma {

    @Id
    @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "uuid"))
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nome_abreviado")
    private String nomeAbreviado;

    @Column(name = "ano_letivo")
    private String anoLetivo;

    public static TurmaBuilder builder() {
        return new TurmaBuilder();
    }

    Turma(TurmaBuilder builder) {
        this.id = requireNonNull(builder.id);
        this.nome = builder.nome;
        this.nomeAbreviado = builder.nomeAbreviado;
        this.anoLetivo = builder.anoLetivo;
    }

    public TurmaBuilderUpdate alterar() {
        return new TurmaBuilderUpdate(id, form -> {
            nome = form.nome;
            nomeAbreviado = form.nomeAbreviado;
            anoLetivo = form.anoLetivo;
        });
    }
}
