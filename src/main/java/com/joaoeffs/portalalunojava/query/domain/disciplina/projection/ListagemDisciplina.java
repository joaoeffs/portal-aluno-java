package com.joaoeffs.portalalunojava.query.domain.disciplina.projection;

import java.util.UUID;

public interface ListagemDisciplina {

    UUID getId();

    String getNome();

    String getCodigo();

    Usuario getUsuario();

    interface Usuario {

        UUID getId();

        String getNome();

        String getSobrenome();

        String getMatricula();
    }
}
