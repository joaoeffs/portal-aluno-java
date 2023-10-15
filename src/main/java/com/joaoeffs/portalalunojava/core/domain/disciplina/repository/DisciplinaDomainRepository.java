package com.joaoeffs.portalalunojava.core.domain.disciplina.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;

public interface DisciplinaDomainRepository extends Repository<Disciplina, UUID> {

    void save(Disciplina disciplina);

    Disciplina findById(UUID id);

//    default Disciplina get(UUID id) {
//        return findById(id).orElseThrow(id::null);
//    }
}
