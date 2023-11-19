package com.joaoeffs.portalalunojava.query.domain.usuario.projection;

import java.util.UUID;

public interface ListagemAluno {

    UUID getId();

    String getNome();

    String getSobrenome();

    String getRole();
}
