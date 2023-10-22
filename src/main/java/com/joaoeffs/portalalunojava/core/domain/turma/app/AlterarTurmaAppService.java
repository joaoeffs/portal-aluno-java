package com.joaoeffs.portalalunojava.core.domain.turma.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.turma.model.Turma;
import com.joaoeffs.portalalunojava.core.domain.turma.repository.TurmaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.turma.usecase.AlterarTurmaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class AlterarTurmaAppService implements AlterarTurmaUseCase {

    private final TurmaDomainRepository repository;

    @Override
    public UUID handle(AlterarTurma command) {

        Turma turma = repository.findById(command.getId());

        turma.alterar()
            .nome(command.getNome())
            .nomeAbreviado(command.getNomeAbreviado())
            .anoLetivo(command.getAnoLetivo())
            .apply();

        repository.save(turma);

        return turma.getId();
    }
}
