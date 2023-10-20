package com.joaoeffs.portalalunojava.core.domain.turmadisciplina.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.model.TurmaDisciplina;

public interface TurmaDisciplinaDomainRepository extends Repository<TurmaDisciplina, UUID> {

    void save(TurmaDisciplina turmaDisciplina);
}
