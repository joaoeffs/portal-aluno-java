package com.joaoeffs.portalalunojava.query.domain.turma.app;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.query.domain.turma.projection.ListagemTurma;
import com.joaoeffs.portalalunojava.query.domain.turma.repository.TurmaQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TurmaQueryAppService {

    private final TurmaQueryRepository repository;

    public List<ListagemTurma> listar() {
        return repository.findAllProjectBy();
    }

    public Optional<ListagemTurma> findById(UUID id) {
        return repository.findById(id);
    }
}
