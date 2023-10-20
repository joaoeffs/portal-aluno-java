package com.joaoeffs.portalalunojava.core.domain.turmadisciplina.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.model.TurmaDisciplina;
import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.repository.TurmaDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.usecase.RegistrarTurmaDisciplinaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarTurmaDisciplinaAppService implements RegistrarTurmaDisciplinaUseCase {

    private final TurmaDisciplinaDomainRepository repository;

    @Override
    public UUID handle(RegistrarTurmaDisciplina command) {

        TurmaDisciplina turmaDisciplina = TurmaDisciplina.builder()
            .turma(command.getTurma())
            .disciplina(command.getDisciplina())
            .build();

        repository.save(turmaDisciplina);

        return turmaDisciplina.getId();
    }
}
