package com.joaoeffs.portalalunojava.query.domain.notas.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.notas.model.NotasQuery;

public interface NotasQueryRepository extends Repository<NotasQuery, UUID> {

    List<NotasQuery> findByAlunoDisciplinaDisciplinaId(UUID disciplinaId);
}
