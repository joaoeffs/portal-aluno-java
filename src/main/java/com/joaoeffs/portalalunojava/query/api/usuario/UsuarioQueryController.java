package com.joaoeffs.portalalunojava.query.api.usuario;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.infra.role.Role;
import com.joaoeffs.portalalunojava.query.domain.usuario.model.UsuarioQuery;
import com.joaoeffs.portalalunojava.query.domain.usuario.repository.UsuarioQueryRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/usuario", produces = APPLICATION_JSON_VALUE)
@Tag(name = "usuario-query-controller")
public class UsuarioQueryController {
    private final UsuarioQueryRepository repository;

    @GetMapping
    public List<UsuarioQuery> listar() {
        return repository.findByRole(Role.valueOf(Role.ALUNO.toString()));
    }
}
