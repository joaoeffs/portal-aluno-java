package com.joaoeffs.portalalunojava.query.domain.disciplina.app;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.query.domain.disciplina.model.DisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.disciplina.projection.ListagemDisciplina;
import com.joaoeffs.portalalunojava.query.domain.disciplina.repository.DisciplinaQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class DisciplinaQueryAppService {

    private final DisciplinaQueryRepository repository;

    public List<DisciplinaQuery> listar(UUID usuario) {
        return repository.findByProfessorId(usuario);
    }

    public Optional<ListagemDisciplina> findById(UUID id) {
        return repository.findById(id);
    }
}
