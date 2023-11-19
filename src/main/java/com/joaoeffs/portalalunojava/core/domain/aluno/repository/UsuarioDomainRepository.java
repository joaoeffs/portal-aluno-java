package com.joaoeffs.portalalunojava.core.domain.aluno.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.UserDetails;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;

public interface UsuarioDomainRepository extends Repository<Usuario, UUID> {

    void save(Usuario usuario);

    UserDetails findByEmail(String email);

}
