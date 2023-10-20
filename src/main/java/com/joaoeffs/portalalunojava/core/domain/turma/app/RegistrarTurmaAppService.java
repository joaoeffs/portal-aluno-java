package com.joaoeffs.portalalunojava.core.domain.turma.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.turma.model.Turma;
import com.joaoeffs.portalalunojava.core.domain.turma.repository.TurmaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.turma.usecase.RegistrarTurmaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarTurmaAppService implements RegistrarTurmaUseCase {

    private final TurmaDomainRepository repository;

    @Override
    public UUID handle(RegistrarTurma command) {

        Turma turma = Turma.builder()
            .nome(command.getNome())
            .nomeAbreviado(command.getNomeAbreviado())
            .anoLetivo(command.getAnoLetivo())
            .build();

        repository.save(turma);

        return turma.getId();
    }
}
