package com.joaoeffs.portalalunojava.core.api.authentication;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.core.domain.aluno.model.AuthenticationDTO;
import com.joaoeffs.portalalunojava.core.domain.aluno.model.LoginResponseDTO;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.UsuarioDomainRepository;
import com.joaoeffs.portalalunojava.infra.security.TokenService;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/auth", produces = APPLICATION_JSON_VALUE)
@Tag(name = "authentication-controller")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    private UsuarioDomainRepository usuarioRepository;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmail(data.email());

        String role = String.valueOf(usuarioOptional.map(Usuario::getRole).orElse(null));

        return ResponseEntity.ok(new LoginResponseDTO(token, role));
    }
}
