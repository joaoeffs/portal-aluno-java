package com.joaoeffs.portalalunojava.query.domain.notas.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.notas.model.NotasQuery;
import com.joaoeffs.portalalunojava.query.domain.notas.projection.ListagemNotas;

public interface NotasQueryRepository extends Repository<NotasQuery, UUID> {

    Optional<ListagemNotas> findById(UUID id);

    List<NotasQuery> findByAlunoDisciplinaDisciplinaId(UUID disciplinaId);
}
