package com.joaoeffs.portalalunojava.core.api.disciplina;

import static com.joaoeffs.portalalunojava.infra.role.Role.Value.ADMINISTRADOR;
import static com.joaoeffs.portalalunojava.infra.role.Role.Value.PROFESSOR;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RegistrarDisciplinaUseCase;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RegistrarDisciplinaUseCase.RegistrarDisciplina;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import jakarta.annotation.security.RolesAllowed;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/disciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "disciplina-controller")
public class DisciplinaController {

    private final RegistrarDisciplinaUseCase registrarDisciplinaService;

    @RolesAllowed({ ADMINISTRADOR, PROFESSOR })
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarDisciplina(@RequestBody RegistrarDisciplina command) {
        var id = registrarDisciplinaService.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }
}
