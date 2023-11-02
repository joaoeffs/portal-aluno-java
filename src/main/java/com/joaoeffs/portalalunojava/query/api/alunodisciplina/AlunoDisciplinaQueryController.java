package com.joaoeffs.portalalunojava.query.api.alunodisciplina;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.app.AlunoDisciplinaQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model.AlunoDisciplinaQuery;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/alunodisciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "aluno-disciplina-query-controller")
public class AlunoDisciplinaQueryController {

    private final AlunoDisciplinaQueryAppService alunoDisciplinaQueryAppService;

    @GetMapping("/{disciplinaId}")
    public List<AlunoDisciplinaQuery> listarByDisciplina(@PathVariable UUID disciplinaId) {
        return alunoDisciplinaQueryAppService.findByDisciplina(disciplinaId);
    }
}
