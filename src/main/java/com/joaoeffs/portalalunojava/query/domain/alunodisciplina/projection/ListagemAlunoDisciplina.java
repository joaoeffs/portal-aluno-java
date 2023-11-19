package com.joaoeffs.portalalunojava.query.domain.alunodisciplina.projection;

import java.util.UUID;

public interface ListagemAlunoDisciplina {

    UUID getId();

    Usuario getUsuario();

    interface Usuario {

        UUID getId();

        String getNome();

        String getSobrenome();

        String getMatricula();
    }
}
