package com.joaoeffs.portalalunojava.core.api.turmadisciplina;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.usecase.RegistrarTurmaDisciplinaUseCase;
import com.joaoeffs.portalalunojava.core.domain.turmadisciplina.usecase.RegistrarTurmaDisciplinaUseCase.RegistrarTurmaDisciplina;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/turma-disciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "turma-disciplina-controller")
public class TurmaDisciplinaController {

    private final RegistrarTurmaDisciplinaUseCase registrarTurmaDisciplinaUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarTurma(@RequestBody RegistrarTurmaDisciplina command) {
        UUID id = registrarTurmaDisciplinaUseCase.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }
}
