package com.joaoeffs.portalalunojava.core.api.notas;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.notas.usecase.AlterarNotasUseCase;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.AlterarNotasUseCase.AlterarNotas;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.RegistrarNotasUseCase;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.RegistrarNotasUseCase.RegistrarNotas;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "api/notas", produces = APPLICATION_JSON_VALUE)
@Tag(name = "noras-controller")
public class NotasController {

    private final RegistrarNotasUseCase registrarNotasUseCase;
    private final AlterarNotasUseCase alterarNotasUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarNotas(@RequestBody RegistrarNotas command) {
        var id = registrarNotasUseCase.handle(command);

        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }

    @PutMapping("/{id}")
    public void alterarNotas(@PathVariable UUID id, @RequestBody AlterarNotas command) {
        alterarNotasUseCase.handle(command.from(id));
    }

}
