package com.joaoeffs.portalalunojava.query.api.disciplina;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.disciplina.app.DisciplinaQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.disciplina.model.DisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.disciplina.projection.ListagemDisciplina;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/disciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "disciplina-query-controller")
public class DisciplinaQueryController {

    private final DisciplinaQueryAppService disciplinaQueryAppService;

    @GetMapping
    public List<ListagemDisciplina> listar() {
        return disciplinaQueryAppService.listar();
    }

    @GetMapping("/{id}")
    public Optional<DisciplinaQuery> findById(@PathVariable UUID id) {
        return disciplinaQueryAppService.findById(id);
    }
}
