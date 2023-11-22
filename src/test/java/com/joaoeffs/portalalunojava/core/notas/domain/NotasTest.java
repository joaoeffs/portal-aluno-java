package com.joaoeffs.portalalunojava.core.notas.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.joaoeffs.portalalunojava.core.domain.notas.model.Notas;
import com.joaoeffs.portalalunojava.core.domain.notas.model.Situacao;

public class NotasTest {

    private Notas notas;

    private UUID id;

    private BigDecimal n1;

    private BigDecimal n2;

    private BigDecimal n3;

    private BigDecimal media;

    private Situacao situacao;

    private UUID alunoDisciplina;

    @BeforeEach
    void setup() {
        id = UUID.randomUUID();
        n1 = BigDecimal.TEN;
        n2 = BigDecimal.TEN;
        n3 = BigDecimal.TEN;
        media = BigDecimal.TEN;
        situacao = Situacao.APROVADO;
        alunoDisciplina = UUID.randomUUID();
        notas = new Notas(id, n1, n2, n3, media, situacao, alunoDisciplina);
    }

    @Test
    void deveRegistrarNotas() {
        assertAll("Verifica se todos os atributos das notas estão corretos",
            () -> assertEquals(id, notas.getId()),
            () -> assertEquals(n1, notas.getN1()),
            () -> assertEquals(n2, notas.getN2()),
            () -> assertEquals(n3, notas.getN3()),
            () -> assertEquals(media, notas.getMedia()),
            () -> assertEquals(situacao, notas.getSituacao()),
            () -> assertEquals(alunoDisciplina, notas.getAlunoDisciplina())
        );
    }

    @Test
    void deveCalcularMediaCorretamente() {
        BigDecimal n1 = BigDecimal.valueOf(7);
        BigDecimal n2 = BigDecimal.valueOf(8);
        BigDecimal n3 = BigDecimal.valueOf(9);
        Notas notas = new Notas(id, n1, n2, n3, null, situacao, alunoDisciplina);

        notas.calcularMedia();

        BigDecimal mediaCalculada = notas.getMedia();

        BigDecimal mediaEsperada = n1.add(n2).add(n3).divide(BigDecimal.valueOf(3), RoundingMode.HALF_UP);

        assertTrue(mediaEsperada.compareTo(mediaCalculada) == 0, "A média calculada não está correta.");
    }


    @Test
    void situacaoEmAndamentoQuandoNotasNaoRegistradas() {
        Notas notas = new Notas(id, null, n2, n3, media, null, alunoDisciplina);
        notas.calcularMedia();
        assertEquals(Situacao.EM_ANDAMENTO, notas.getSituacao(), "A situação deve ser EM_ANDAMENTO quando as notas não estão todas registradas.");
    }

    @Test
    void situacaoAprovadoQuandoMediaIgualOuMaiorQueSeis() {
        BigDecimal n1 = BigDecimal.valueOf(6);
        BigDecimal n2 = BigDecimal.valueOf(6);
        BigDecimal n3 = BigDecimal.valueOf(6);
        Notas notas = new Notas(id, n1, n2, n3, null, null, alunoDisciplina);
        notas.calcularMedia();
        assertEquals(Situacao.APROVADO, notas.getSituacao(), "A situação deve ser APROVADO quando a média é igual ou maior que 6.");
    }

    @Test
    void situacaoReprovadoQuandoMediaMenorQueSeis() {
        BigDecimal n1 = BigDecimal.valueOf(5);
        BigDecimal n2 = BigDecimal.valueOf(5);
        BigDecimal n3 = BigDecimal.valueOf(5);
        Notas notas = new Notas(id, n1, n2, n3, null, null, alunoDisciplina);
        notas.calcularMedia();
        assertEquals(Situacao.REPROVADO, notas.getSituacao(), "A situação deve ser REPROVADO quando a média é menor que 6.");
    }

    @Test
    void situacaoAprovadoQuandoMediaExatamenteSeis() {
        BigDecimal n1 = BigDecimal.valueOf(5);
        BigDecimal n2 = BigDecimal.valueOf(6);
        BigDecimal n3 = BigDecimal.valueOf(7);
        Notas notas = new Notas(id, n1, n2, n3, null, null, alunoDisciplina);
        notas.calcularMedia();
        assertEquals(Situacao.APROVADO, notas.getSituacao(), "A situação deve ser APROVADO quando a média é exatamente 6.");
    }


    @Test
    void situacaoEmAndamentoQuandoUmaNotaNaoRegistrada() {
        Notas notasComN1Nulo = new Notas(id, null, n2, n3, media, null, alunoDisciplina);
        notasComN1Nulo.calcularMedia();
        assertEquals(Situacao.EM_ANDAMENTO, notasComN1Nulo.getSituacao(),
            "A situação deve ser EM_ANDAMENTO quando a nota n1 não está registrada.");

        Notas notasComN2Nulo = new Notas(id, n1, null, n3, media, null, alunoDisciplina);
        notasComN2Nulo.calcularMedia();
        assertEquals(Situacao.EM_ANDAMENTO, notasComN2Nulo.getSituacao(),
            "A situação deve ser EM_ANDAMENTO quando a nota n2 não está registrada.");

        Notas notasComN3Nulo = new Notas(id, n1, n2, null, media, null, alunoDisciplina);
        notasComN3Nulo.calcularMedia();
        assertEquals(Situacao.EM_ANDAMENTO, notasComN3Nulo.getSituacao(),
            "A situação deve ser EM_ANDAMENTO quando a nota n3 não está registrada.");
    }



}
