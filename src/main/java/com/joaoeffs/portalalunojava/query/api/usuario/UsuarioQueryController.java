package com.joaoeffs.portalalunojava.query.api.usuario;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.usuario.app.UsuarioQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.usuario.model.UsuarioQuery;
import com.joaoeffs.portalalunojava.query.domain.usuario.projection.ListagemAluno;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/usuario", produces = APPLICATION_JSON_VALUE)
@Tag(name = "usuario-query-controller")
public class UsuarioQueryController {

    private final UsuarioQueryAppService usuarioQueryAppService;

    @GetMapping
    public List<UsuarioQuery> listar() {
        return usuarioQueryAppService.listar();
    }
}
