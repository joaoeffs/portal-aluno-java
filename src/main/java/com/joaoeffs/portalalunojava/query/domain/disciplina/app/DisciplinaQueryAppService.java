package com.joaoeffs.portalalunojava.query.domain.disciplina.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.query.domain.disciplina.projection.ListagemDisciplina;
import com.joaoeffs.portalalunojava.query.domain.disciplina.repository.DisciplinaQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class DisciplinaQueryAppService {

    private final DisciplinaQueryRepository repository;

    public List<ListagemDisciplina> listar() {
        return repository.findAllProjectBy();
    }
}
