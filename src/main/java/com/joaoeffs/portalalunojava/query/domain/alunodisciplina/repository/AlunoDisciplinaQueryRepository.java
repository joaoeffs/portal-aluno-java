package com.joaoeffs.portalalunojava.query.domain.alunodisciplina.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model.AlunoDisciplinaQuery;

public interface AlunoDisciplinaQueryRepository extends Repository<AlunoDisciplinaQuery, UUID> {

    @Query(value = "SELECT * FROM aluno_disciplina WHERE disciplina_id = ?1", nativeQuery = true)
    List<AlunoDisciplinaQuery> findByDisciplina(UUID disciplinaId);
}
