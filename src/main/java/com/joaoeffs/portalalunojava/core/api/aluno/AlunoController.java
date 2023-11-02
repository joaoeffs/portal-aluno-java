package com.joaoeffs.portalalunojava.core.api.aluno;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.RegistrarAlunoUseCase;
import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.RegistrarAlunoUseCase.RegistrarAluno;
import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.VincularTurmaUseCase;
import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.VincularTurmaUseCase.VincularTurma;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/aluno", produces = APPLICATION_JSON_VALUE)
@Tag(name = "aluno-controller")
public class AlunoController {

    private final RegistrarAlunoUseCase registrarAlunoUseCase;

    private final VincularTurmaUseCase vincularTurmaUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarAluno(@RequestBody RegistrarAluno command) {
        UUID id = registrarAlunoUseCase.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }

    @PatchMapping("/{id}/vincular-turma")
    public void vincularTurma(@PathVariable UUID id, @RequestBody VincularTurma command) {
        vincularTurmaUseCase.handle(command.from(id));
    }
}
