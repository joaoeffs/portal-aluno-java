package com.joaoeffs.portalalunojava.query.domain.usuario.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.infra.role.Role;
import com.joaoeffs.portalalunojava.query.domain.usuario.model.UsuarioQuery;
import com.joaoeffs.portalalunojava.query.domain.usuario.projection.ListagemAluno;
import com.joaoeffs.portalalunojava.query.domain.usuario.repository.UsuarioQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UsuarioQueryAppService {

    private final UsuarioQueryRepository repository;

    public List<UsuarioQuery> listar() {
        return repository.findByRole(Role.valueOf(Role.ALUNO.toString()));
    }
}
