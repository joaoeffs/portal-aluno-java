package com.joaoeffs.portalalunojava.query.domain.disciplina.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.joaoeffs.portalalunojava.query.domain.disciplina.model.DisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.disciplina.projection.ListagemDisciplina;

public interface DisciplinaQueryRepository extends Repository<DisciplinaQuery, UUID> {

    @Query("SELECT d FROM DisciplinaQuery d WHERE d.professor.id = :professorId")
    List<DisciplinaQuery> findByProfessorId(@Param("professorId") UUID professorId);

    Optional<ListagemDisciplina> findById(UUID id);
}
