package com.joaoeffs.portalalunojava.core.domain.usuario.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.usuario.model.Usuario;
import com.joaoeffs.portalalunojava.core.domain.usuario.repository.UsuarioDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.usuario.usecase.RegistrarUsuarioUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarUsuarioAppService implements RegistrarUsuarioUseCase {

    private final UsuarioDomainRepository repository;

    @Override
    public UUID handle(RegistrarUsuario command) {

        Usuario usuario = Usuario.builder()
            .nome(command.getNome())
            .sobrenome(command.getNome())
            .dataNascimento(command.getDataNascimento())
            .matricula(command.getMatricula())
            .email(command.getEmail())
            .login(command.getLogin())
            .senha(command.getSenha())
            .role(command.getRole())
            .build();

        repository.save(usuario);

        return usuario.getId();
    }
}