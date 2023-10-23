package com.joaoeffs.portalalunojava.query.domain.turmadisciplina.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.turmadisciplina.model.TurmaDisciplinaQuery;

public interface TurmaDisciplinaQueryRepository extends Repository<TurmaDisciplinaQuery, UUID> {

    @Query(value = "SELECT * FROM turma_disciplina WHERE turma_id = ?1", nativeQuery = true)
    List<TurmaDisciplinaQuery> findByTurma(UUID turmaId);
}
