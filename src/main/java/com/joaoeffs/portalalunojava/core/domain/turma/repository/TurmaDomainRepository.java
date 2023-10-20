package com.joaoeffs.portalalunojava.core.domain.turma.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.core.domain.turma.model.Turma;

public interface TurmaDomainRepository extends Repository<Turma, UUID> {

    void save(Turma turma);
}