package com.joaoeffs.portalalunojava.query.domain.turma.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.turma.model.TurmaQuery;
import com.joaoeffs.portalalunojava.query.domain.turma.projection.ListagemTurma;

public interface TurmaQueryRepository extends Repository<TurmaQuery, UUID>, JpaSpecificationExecutor<TurmaQuery> {

    List<ListagemTurma> findAllProjectBy();

    Optional<ListagemTurma> findById(UUID id);
}
