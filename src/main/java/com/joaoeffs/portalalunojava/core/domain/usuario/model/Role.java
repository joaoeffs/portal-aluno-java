package com.joaoeffs.portalalunojava.core.domain.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    ADMINISTRADOR,
    PROFESSOR,
    ALUNO
}
