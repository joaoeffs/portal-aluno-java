package com.joaoeffs.portalalunojava.core.domain.professor.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.professor.model.Professor;
import com.joaoeffs.portalalunojava.core.domain.professor.repository.ProfessorDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.professor.usecase.RegistrarProfessorUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarProfessorAppService implements RegistrarProfessorUseCase {

    private final ProfessorDomainRepository repository;

    @Override
    public UUID handle(RegistrarProfessor command) {

        Professor usuario = Professor.builder()
            .nome(command.getNome())
            .sobrenome(command.getSobrenome())
            .dataNascimento(command.getDataNascimento())
            .email(command.getEmail())
            .senha(command.getSenha())
            .build();

        repository.save(usuario);

        return usuario.getId();
    }
}