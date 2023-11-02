package com.joaoeffs.portalalunojava.core.api.alunodisciplina;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase.RegistrarAlunoDisciplinaUseCase;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase.RegistrarAlunoDisciplinaUseCase.RegistrarAlunoDisciplina;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase.RemoverAlunoDisciplinaUseCase;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase.RemoverAlunoDisciplinaUseCase.RemoverAlunoDisciplina;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/alunodisciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "aluno-disciplina-controller")
public class AlunoDisciplinaController {

    private final RegistrarAlunoDisciplinaUseCase registrarAlunoDisciplinaUseCase;
    private final RemoverAlunoDisciplinaUseCase removerAlunoDisciplinaUseCase;

    @PostMapping
    public ResponseEntity<Void> registrarAlunoDisciplina(@RequestBody RegistrarAlunoDisciplina command) {

        UUID id = registrarAlunoDisciplinaUseCase.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }

    @DeleteMapping("/{id}")
    public void removerAlunoDisciplina(@PathVariable UUID id) {
        removerAlunoDisciplinaUseCase.handle(RemoverAlunoDisciplina.from(id));
    }

}
