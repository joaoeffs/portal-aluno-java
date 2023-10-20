package com.joaoeffs.portalalunojava.core.api.turma;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.turma.usecase.RegistrarTurmaUseCase;
import com.joaoeffs.portalalunojava.core.domain.turma.usecase.RegistrarTurmaUseCase.RegistrarTurma;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/turma", produces = APPLICATION_JSON_VALUE)
@Tag(name = "turma-controller")
public class TurmaController {

    private final RegistrarTurmaUseCase registrarTurmaUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarTurma(@RequestBody RegistrarTurma command) {
        UUID id = registrarTurmaUseCase.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }
}
