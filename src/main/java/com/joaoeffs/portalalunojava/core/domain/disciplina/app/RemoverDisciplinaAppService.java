package com.joaoeffs.portalalunojava.core.domain.disciplina.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RemoverDisciplinaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
@Transactional
public class RemoverDisciplinaAppService implements RemoverDisciplinaUseCase {

    private final DisciplinaDomainRepository repository;

    @Override
    public void handle(RemoverDisciplina command) {

        repository.deleteById(command.getId());
    }
}
