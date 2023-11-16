package com.joaoeffs.portalalunojava.core.domain.aluno.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Aluno;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.AlunoDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.RegistrarAlunoUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarAlunoAppService implements RegistrarAlunoUseCase {

    private final AlunoDomainRepository repository;

    @Override
    public UUID handle(RegistrarAluno command) {

        Aluno aluno = Aluno.builder()
            .nome(command.getNome())
            .sobrenome(command.getSobrenome())
            .dataNascimento(command.getDataNascimento())
            .email(command.getEmail())
            .senha(command.getSenha())
            .matricula(command.getMatricula())
            .role(command.getRole())
            .build();

        repository.save(aluno);

        return aluno.getId();
    }
}
