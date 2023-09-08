package com.joaoeffs.portalalunojava.core.api.usuario;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.usuario.usecase.RegistrarUsuarioUseCase;
import com.joaoeffs.portalalunojava.core.domain.usuario.usecase.RegistrarUsuarioUseCase.RegistrarUsuario;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;

import jakarta.annotation.security.RolesAllowed;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/usuario", produces = APPLICATION_JSON_VALUE)
@Tag(name = "usuario-controller")
public class UsuarioController {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarUsuario(@RequestBody RegistrarUsuario command) {
        UUID id = registrarUsuarioUseCase.handle(command);
        return ResponseEntity.created(fromCurrentRequest().path("/").path(id.toString()).build().toUri()).build();
    }
}