package com.joaoeffs.portalalunojava.query.api.aluno;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.aluno.app.AlunoQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.aluno.projection.ListagemAluno;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/aluno", produces = APPLICATION_JSON_VALUE)
@Tag(name = "aluno-query-controller")
public class AlunoQueryController {

    private final AlunoQueryAppService alunoQueryAppService;

    @GetMapping
    public List<ListagemAluno> listar() {
        return alunoQueryAppService.listar();
    }
}
