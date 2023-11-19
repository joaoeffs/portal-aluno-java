package com.joaoeffs.portalalunojava.core.domain.aluno.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.UsuarioDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.RegistrarUsuarioUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarUsuarioAppService implements RegistrarUsuarioUseCase {

    private final UsuarioDomainRepository repository;

    @Override
    public UUID handle(RegistrarUsuario command) {

        var usuario = Usuario.builder()
            .nome(command.getNome())
            .sobrenome(command.getSobrenome())
            .dataNascimento(command.getDataNascimento())
            .email(command.getEmail())
            .senha(command.getSenha())
            .matricula(command.getMatricula())
            .role(command.getRole())
            .build();

        repository.save(usuario);

        return usuario.getId();
    }
}
