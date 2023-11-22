package com.joaoeffs.portalalunojava.core.disciplina.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;

class DisciplinaTest {

    private UUID id;

    private String nome;

    private String codigo;

    private UUID professor;

    private Disciplina disciplina;

    @BeforeEach
    void setup() {
        id = UUID.randomUUID();
        nome = "Matemática";
        codigo = "MAT-2023";
        professor = UUID.randomUUID();
        disciplina = new Disciplina(id, nome, codigo, professor);
    }

    @Test
    void deveCriarDisciplina() {
        assertAll("Verifica se todos os atributos da disciplina estão corretos",
            () -> assertEquals(id, disciplina.getId()),
            () -> assertEquals(nome, disciplina.getNome()),
            () -> assertEquals(codigo, disciplina.getCodigo()),
            () -> assertEquals(professor, disciplina.getProfessor())
        );
    }
}
