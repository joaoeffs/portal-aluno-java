package com.joaoeffs.portalalunojava.core.domain.turma.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.turma.repository.TurmaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.turma.usecase.RemoverTurmaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
@Transactional
public class RemoverTurmaAppService implements RemoverTurmaUseCase {

    private final TurmaDomainRepository repository;

    @Override
    public void handle(RemoverTurma command) {

        repository.deleteById(command.getId());
    }
}
