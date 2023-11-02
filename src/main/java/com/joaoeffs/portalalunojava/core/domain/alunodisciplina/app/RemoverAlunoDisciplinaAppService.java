package com.joaoeffs.portalalunojava.core.domain.alunodisciplina.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.repository.AlunoDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase.RemoverAlunoDisciplinaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
@Transactional
public class RemoverAlunoDisciplinaAppService implements RemoverAlunoDisciplinaUseCase {

    private final AlunoDisciplinaDomainRepository repository;

    @Override
    public void handle(RemoverAlunoDisciplina command) {

        repository.deleteById(command.getId());
    }
}
