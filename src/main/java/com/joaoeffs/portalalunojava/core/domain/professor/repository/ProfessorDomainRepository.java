package com.joaoeffs.portalalunojava.core.domain.professor.repository;

import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.core.domain.professor.model.Professor;

public interface ProfessorDomainRepository extends Repository<Professor, UUID> {

    void save(Professor usuario);
}