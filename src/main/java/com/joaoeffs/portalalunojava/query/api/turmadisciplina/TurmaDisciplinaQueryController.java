package com.joaoeffs.portalalunojava.query.api.turmadisciplina;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.turmadisciplina.app.TurmaDisciplinaQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.turmadisciplina.model.TurmaDisciplinaQuery;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/turmadisciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "turma-disciplina-query-controller")
public class TurmaDisciplinaQueryController {

    private final TurmaDisciplinaQueryAppService turmaDisciplinaQueryAppService;

    @GetMapping("/{turmaId}")
    public List<TurmaDisciplinaQuery> listarByTurma(@PathVariable UUID turmaId) {
        return turmaDisciplinaQueryAppService.findByTurma(turmaId);
    }
}
