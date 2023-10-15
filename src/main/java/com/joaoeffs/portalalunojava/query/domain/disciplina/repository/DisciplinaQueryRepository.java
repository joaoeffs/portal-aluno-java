package com.joaoeffs.portalalunojava.query.domain.disciplina.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.disciplina.model.DisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.disciplina.projection.ListagemDisciplina;

public interface DisciplinaQueryRepository extends Repository<DisciplinaQuery, UUID>,
    JpaSpecificationExecutor<DisciplinaQuery> {

    List<ListagemDisciplina> findAllProjectBy();

    Optional<DisciplinaQuery> findById(UUID id);
}
