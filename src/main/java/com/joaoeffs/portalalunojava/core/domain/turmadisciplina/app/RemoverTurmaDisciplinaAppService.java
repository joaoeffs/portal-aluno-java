package com.joaoeffs.portalalunojava.core.domain.turmadisciplina.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.repository.TurmaDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.usecase.RemoverTurmaDisciplinaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
@Transactional
public class RemoverTurmaDisciplinaAppService implements RemoverTurmaDisciplinaUseCase {

    private final TurmaDisciplinaDomainRepository repository;

    @Override
    public void handle(RemoverTurmaDisciplina command) {

        repository.deleteById(command.getId());
    }
}
