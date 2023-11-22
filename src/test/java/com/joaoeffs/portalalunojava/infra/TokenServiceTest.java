package com.joaoeffs.portalalunojava.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.infra.security.TokenService;

@SpringBootTest
public class TokenServiceTest {

    @Autowired
    TokenService tokenService;

    @Test
    public void geraToken() {
        Usuario user = new Usuario();
        user.setEmail("test@example.com");

        String token = tokenService.generateToken(user);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    public void validaToken() {
        Usuario user = new Usuario();
        user.setEmail("test@example.com");

        String token = tokenService.generateToken(user);
        String validatedEmail = tokenService.validateToken(token);

        assertEquals("test@example.com", validatedEmail);
    }

    @Test
    public void deveValidaToken() {
        String invalidToken = "abc123";

        String result = tokenService.validateToken(invalidToken);

        assertTrue(result.isEmpty());
    }
}
