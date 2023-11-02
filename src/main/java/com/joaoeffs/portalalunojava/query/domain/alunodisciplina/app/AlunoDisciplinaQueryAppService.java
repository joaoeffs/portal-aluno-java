package com.joaoeffs.portalalunojava.query.domain.alunodisciplina.app;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model.AlunoDisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.repository.AlunoDisciplinaQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AlunoDisciplinaQueryAppService {

    private final AlunoDisciplinaQueryRepository repository;

    public List<AlunoDisciplinaQuery> findByDisciplina(UUID disciplina) {
        return repository.findByDisciplina(disciplina);
    }
}
