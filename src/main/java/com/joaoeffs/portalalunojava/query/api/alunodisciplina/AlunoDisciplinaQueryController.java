package com.joaoeffs.portalalunojava.query.api.alunodisciplina;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.app.AlunoDisciplinaQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model.AlunoDisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.projection.ListagemAlunoDisciplina;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.projection.ListagemNotasAlunos;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.repository.AlunoDisciplinaQueryRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/alunodisciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "aluno-disciplina-query-controller")
public class AlunoDisciplinaQueryController {

    private final AlunoDisciplinaQueryAppService alunoDisciplinaQueryAppService;
    private final AlunoDisciplinaQueryRepository repository;


    @GetMapping("/{disciplinaId}")
    public List<AlunoDisciplinaQuery> listarByDisciplina(@PathVariable UUID disciplinaId) {
        return alunoDisciplinaQueryAppService.findByDisciplina(disciplinaId);
    }

    @GetMapping("/{disciplinaId}/listar-notas")
    public List<ListagemNotasAlunos> listarNotas(@PathVariable UUID disciplinaId) {
        return repository.listarNotasByDisciplina(disciplinaId);
    }

    @GetMapping("/{id}/aluno")
    public Optional<ListagemAlunoDisciplina> findById(@PathVariable UUID id) {
        return repository.findById(id);
    }
}
