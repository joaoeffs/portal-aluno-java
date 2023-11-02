package com.joaoeffs.portalalunojava.core.domain.aluno.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.aluno.repository.AlunoDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.VincularTurmaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class VincularTurmaAppService implements VincularTurmaUseCase {

    private final AlunoDomainRepository repository;

    @Override
    public void handle(VincularTurma command) {

        var aluno = repository.findById(command.getId());

        aluno.vincularTurma(command.getTurma());

        repository.save(aluno);
    }
}
