package com.joaoeffs.portalalunojava.query.domain.aluno.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.query.domain.aluno.projection.ListagemAluno;
import com.joaoeffs.portalalunojava.query.domain.aluno.repository.AlunoQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AlunoQueryAppService {

    private final AlunoQueryRepository repository;

    public List<ListagemAluno> listar() {
        return repository.findAllProjectBy();
    }
}
