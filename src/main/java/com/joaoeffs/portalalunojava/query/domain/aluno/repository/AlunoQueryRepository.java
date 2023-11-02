package com.joaoeffs.portalalunojava.query.domain.aluno.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.aluno.model.AlunoQuery;
import com.joaoeffs.portalalunojava.query.domain.aluno.projection.ListagemAluno;

public interface AlunoQueryRepository extends Repository<AlunoQuery, UUID>, JpaSpecificationExecutor<AlunoQuery> {

    List<ListagemAluno> findAllProjectBy();
}
