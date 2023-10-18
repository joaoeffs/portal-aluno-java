package com.joaoeffs.portalalunojava.query.domain.disciplina.projection;

import java.util.UUID;

public interface ListagemDisciplina {

    UUID getId();

    String getNome();

    String getCodigo();

    Professor getProfessor();

    interface Professor {

        UUID getId();

        String getNome();

        String getSobrenome();
    }
}
