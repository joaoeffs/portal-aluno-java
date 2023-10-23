package com.joaoeffs.portalalunojava.query.domain.turmadisciplina.app;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.query.domain.turmadisciplina.model.TurmaDisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.turmadisciplina.repository.TurmaDisciplinaQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TurmaDisciplinaQueryAppService {

    private final TurmaDisciplinaQueryRepository repository;

    public List<TurmaDisciplinaQuery> findByTurma(UUID turma) {
        return repository.findByTurma(turma);
    }
}
