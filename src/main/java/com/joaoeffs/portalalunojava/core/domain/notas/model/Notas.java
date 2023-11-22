package com.joaoeffs.portalalunojava.core.domain.notas.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor

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

    @Column(name = "media")
    private BigDecimal media;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private Situacao situacao;

    @Column(name = "aluno_disciplina_id")
    private UUID alunoDisciplina;

    public static NotasBuilder builder() {
        return new NotasBuilder();
    }

    public Notas(NotasBuilder builder) {
        id = builder.id;
        n1 = builder.n1;
        alunoDisciplina = builder.alunoDisciplina;
    }

    public NotasBuilderUpdate alterar() {
        return new NotasBuilderUpdate(id, form -> {
            n1 = form.n1;
            n2 = form.n2;
            n3 = form.n3;
        });
    }

    public void calcularMedia() {
        BigDecimal soma = BigDecimal.ZERO;

        soma = soma.add(n1 != null ? n1 : BigDecimal.ZERO);
        soma = soma.add(n2 != null ? n2 : BigDecimal.ZERO);
        soma = soma.add(n3 != null ? n3 : BigDecimal.ZERO);

        this.media = soma.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
        setSituacao();
    }

    private void setSituacao() {
        if (n1 == null || n2 == null || n3 == null) {
            this.situacao = Situacao.EM_ANDAMENTO;
        } else {
            if (this.media.compareTo(BigDecimal.valueOf(6)) >= 0) {
                this.situacao = Situacao.APROVADO;
            } else {
                this.situacao = Situacao.REPROVADO;
            }
        }
    }

}
