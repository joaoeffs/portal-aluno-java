package com.joaoeffs.portalalunojava.query.domain.professor.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.query.domain.professor.projection.ListagemProfessor;
import com.joaoeffs.portalalunojava.query.domain.professor.repository.ProfessorQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ProfessorQueryAppService {

    private final ProfessorQueryRepository repository;

    public List<ListagemProfessor> listar() {
        return repository.findAllProjectBy();
    }
}
