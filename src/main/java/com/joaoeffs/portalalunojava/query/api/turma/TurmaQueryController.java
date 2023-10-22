package com.joaoeffs.portalalunojava.query.api.turma;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.turma.app.TurmaQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.turma.projection.ListagemTurma;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/turma", produces = APPLICATION_JSON_VALUE)
@Tag(name = "turma-query-controller")
public class TurmaQueryController {

    private final TurmaQueryAppService turmaQueryAppService;

    @GetMapping
    public List<ListagemTurma> listar() {
        return turmaQueryAppService.listar();
    }

    @GetMapping("/{id}")
    public Optional<ListagemTurma> findById(@PathVariable UUID id) {
        return turmaQueryAppService.findById(id);
    }
}
