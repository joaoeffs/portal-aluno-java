package com.joaoeffs.portalalunojava.core.domain.usuario.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.core.domain.usuario.model.Usuario;

public interface UsuarioDomainRepository extends Repository<Usuario, UUID> {

    void save(Usuario usuario);
}
