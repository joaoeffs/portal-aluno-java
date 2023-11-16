package com.joaoeffs.portalalunojava.core.domain.aluno.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.UserDetails;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Aluno;

public interface AlunoDomainRepository extends Repository<Aluno, UUID> {

    void save(Aluno aluno);

    UserDetails findByEmail(String email);

}
