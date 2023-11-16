package com.joaoeffs.portalalunojava.core.api.disciplina;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.AlterarDisciplinaUseCase;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.AlterarDisciplinaUseCase.AlterarDisciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RegistrarDisciplinaUseCase;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RegistrarDisciplinaUseCase.RegistrarDisciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RemoverDisciplinaUseCase;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RemoverDisciplinaUseCase.RemoverDisciplina;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/disciplina", produces = APPLICATION_JSON_VALUE)
@Tag(name = "disciplina-controller")
public class DisciplinaController {

    private final RegistrarDisciplinaUseCase registrarDisciplinaService;
    private final AlterarDisciplinaUseCase alterarDisciplinaUseCase;
    private final RemoverDisciplinaUseCase removerDisciplinaUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarDisciplina(@RequestBody RegistrarDisciplina command) {
        var id = registrarDisciplinaService.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }

    @PutMapping("/{id}")
    public void alterarDisciplina(@PathVariable UUID id, @RequestBody AlterarDisciplina command) {
        alterarDisciplinaUseCase.handle(command.from(id));
    }

    @DeleteMapping("/{id}")
    public void removerDisciplina(@PathVariable UUID id) {
        removerDisciplinaUseCase.handle(RemoverDisciplina.from(id));
    }
}
