package com.joaoeffs.portalalunojava.query.domain.professor.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.professor.model.ProfessorQuery;
import com.joaoeffs.portalalunojava.query.domain.professor.projection.ListagemProfessor;

public interface ProfessorQueryRepository extends Repository<ProfessorQuery, UUID>,
    JpaSpecificationExecutor<ProfessorQuery> {

    List<ListagemProfessor> findAllProjectBy();
}
