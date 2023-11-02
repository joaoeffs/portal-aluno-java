package com.joaoeffs.portalalunojava.core.domain.alunodisciplina.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.model.AlunoDisciplina;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.repository.AlunoDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase.RegistrarAlunoDisciplinaUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarAlunoDisciplinaAppService implements RegistrarAlunoDisciplinaUseCase {

    private final AlunoDisciplinaDomainRepository repository;

    @Override
    public UUID handle(RegistrarAlunoDisciplina command) {

        var alunoDisciplina = AlunoDisciplina.builder()
            .aluno(command.getAluno())
            .disciplina(command.getDisciplina())
            .build();

        repository.save(alunoDisciplina);
        return alunoDisciplina.getId();
    }
}
