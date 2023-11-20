package com.joaoeffs.portalalunojava.core.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.infra.role.Role;

public class UsuarioTest {

    @Test
    void deveCriarUsuario() {
        var uuid = UUID.randomUUID();
        var nome = "João";
        var sobrenome = "Effting";
        var email = "joao@gmail.com";
        var senha = "1234";
        var matricula = "1607199";
        var dataNascimento = LocalDate.of(1999, 07, 16);
        var role = Role.ADMIN;

        Usuario usuario = new Usuario(uuid, nome, sobrenome, dataNascimento, email, senha, matricula, role);

        assertEquals(uuid, usuario.getId());
        assertEquals(nome, usuario.getNome());
        assertEquals(sobrenome, usuario.getSobrenome());
        assertEquals(email, usuario.getEmail());
        assertEquals(senha, usuario.getSenha());
        assertEquals(matricula, usuario.getMatricula());
        assertEquals(dataNascimento, usuario.getDataNascimento());
        assertEquals(role, usuario.getRole());
    }
}
