package com.joaoeffs.portalalunojava.core.domain.notas.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.core.domain.notas.model.Notas;

public interface NotasDomainRepository extends Repository<Notas, UUID> {

    void save(Notas notas);

    Notas findById(UUID id);
}
