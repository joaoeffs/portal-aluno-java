package com.joaoeffs.portalalunojava.query.domain.usuario.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.infra.role.Role;
import com.joaoeffs.portalalunojava.query.domain.usuario.model.UsuarioQuery;
import com.joaoeffs.portalalunojava.query.domain.usuario.projection.ListagemAluno;

public interface UsuarioQueryRepository extends Repository<UsuarioQuery, UUID> {

    List<UsuarioQuery> findByRole(Role role);

}
