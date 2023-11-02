package com.joaoeffs.portalalunojava.query.domain.aluno.projection;

import java.util.UUID;

public interface ListagemAluno {

    UUID getId();

    String getNome();

    String getSobrenome();

    String getMatricula();

    Turma getTurma();

    interface Turma {

        UUID getId();

        String getNome();
    }
}
