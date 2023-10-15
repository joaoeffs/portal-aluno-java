package com.joaoeffs.portalalunojava.core.domain.disciplina.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.AlterarDisciplinaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class AlterarDisciplinaAppService implements AlterarDisciplinaUseCase {

    private final DisciplinaDomainRepository repository;

    @Override
    public UUID handle(AlterarDisciplina command) {

        Disciplina disciplina = repository.findById(command.getId());

        disciplina.alterar()
            .nome(command.getNome())
            .codigo(command.getCodigo())
            .apply();

        repository.save(disciplina);

        return disciplina.getId();
    }
}
