package com.joaoeffs.portalalunojava.core.api.professor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.professor.usecase.RegistrarProfessorUseCase;
import com.joaoeffs.portalalunojava.core.domain.professor.usecase.RegistrarProfessorUseCase.RegistrarProfessor;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/professor", produces = APPLICATION_JSON_VALUE)
@Tag(name = "professor-controller")
public class ProfessorController {

    private final RegistrarProfessorUseCase registrarProfessorUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarProfessor(@RequestBody RegistrarProfessor command) {
        UUID id = registrarProfessorUseCase.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }
}