package com.joaoeffs.portalalunojava.core.domain.alunodisciplina.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.model.AlunoDisciplina;

public interface AlunoDisciplinaDomainRepository extends Repository<AlunoDisciplina, UUID> {

    void save(AlunoDisciplina alunoDisciplina);

    @Query()
    void deleteById(UUID id);
}
