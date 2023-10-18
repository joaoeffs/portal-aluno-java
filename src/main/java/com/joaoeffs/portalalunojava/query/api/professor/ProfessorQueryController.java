package com.joaoeffs.portalalunojava.query.api.professor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.query.domain.professor.app.ProfessorQueryAppService;
import com.joaoeffs.portalalunojava.query.domain.professor.projection.ListagemProfessor;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/professor", produces = APPLICATION_JSON_VALUE)
@Tag(name = "professor-query-controller")
public class ProfessorQueryController {

    private final ProfessorQueryAppService professorQueryAppService;

    @GetMapping
    public List<ListagemProfessor> listar() {
        return professorQueryAppService.listar();
    }
}
