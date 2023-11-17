package com.joaoeffs.portalalunojava.core.domain.disciplina.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RegistrarDisciplinaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarDisciplinaAppService implements RegistrarDisciplinaUseCase {

    private final DisciplinaDomainRepository repository;

    @Override
    public UUID handle(RegistrarDisciplina command) {

        var disciplina = Disciplina.builder()
            .nome(command.getNome())
            .codigo(command.getCodigo())
            .professor(command.getProfessor())
            .build();

        repository.save(disciplina);

        return disciplina.getId();
    }
}
