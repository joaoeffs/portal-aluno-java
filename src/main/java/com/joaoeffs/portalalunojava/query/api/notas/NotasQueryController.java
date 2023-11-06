package com.joaoeffs.portalalunojava.query.api.notas;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.notas.model.NotasQuery;
import com.joaoeffs.portalalunojava.query.domain.notas.repository.NotasQueryRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/notas", produces = APPLICATION_JSON_VALUE)
@Tag(name = "notas-query-controller")
public class NotasQueryController {

    private final NotasQueryRepository repository;

    @GetMapping("/{disciplinaId}")
    public List<NotasQuery> listar(@PathVariable UUID disciplinaId) {
        return repository.findByAlunoDisciplinaDisciplinaId(disciplinaId);
    }
}
