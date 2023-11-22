package com.joaoeffs.portalalunojava.core.usuario.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.infra.role.Role;

class UsuarioTest {

    private Usuario usuario;
    private UUID uuid;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String matricula;
    private LocalDate dataNascimento;
    private Role role;

    @BeforeEach
    void setUp() {
        uuid = UUID.randomUUID();
        nome = "João";
        sobrenome = "Effting";
        email = "joao@gmail.com";
        senha = "1234";
        matricula = "1607199";
        dataNascimento = LocalDate.of(1999, 7, 16);
        role = Role.ADMIN;
        usuario = new Usuario(uuid, nome, sobrenome, dataNascimento, email, senha, matricula, role);
    }

    @Test
    void deveCriarUsuario() {
        assertAll("Verifica se todos os atributos do usuário estão corretos",
            () -> assertEquals(uuid, usuario.getId(), "O UUID não é o esperado"),
            () -> assertEquals(nome, usuario.getNome(), "O nome não é o esperado"),
            () -> assertEquals(sobrenome, usuario.getSobrenome(), "O sobrenome não é o esperado"),
            () -> assertEquals(email, usuario.getEmail(), "O e-mail não é o esperado"),
            () -> assertEquals(senha, usuario.getSenha(), "A senha não é a esperada"),
            () -> assertEquals(matricula, usuario.getMatricula(), "A matrícula não é a esperada"),
            () -> assertEquals(dataNascimento, usuario.getDataNascimento(), "A data de nascimento não é a esperada"),
            () -> assertEquals(role, usuario.getRole(), "O papel não é o esperado")
        );
    }

    @Test
    void roleAdmin() {
        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")),
            "A autoridade de ADMIN não foi encontrada");
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_PROFESSOR")),
            "A autoridade de PROFESSOR não foi encontrada");
    }

    @Test
    void roleProfessor() {
        var professorRole = Role.PROFESSOR;
        Usuario usuarioProfessor = new Usuario(uuid, nome, sobrenome, dataNascimento, email, senha, matricula, professorRole);

        Collection<? extends GrantedAuthority> authoritiesProfessor = usuarioProfessor.getAuthorities();

        assertTrue(authoritiesProfessor.contains(new SimpleGrantedAuthority("ROLE_PROFESSOR")),
            "A autoridade de PROFESSOR não foi encontrada");
        assertTrue(authoritiesProfessor.contains(new SimpleGrantedAuthority("ROLE_ADMIN")),
            "A autoridade de ADMIN não deve estar presente para PROFESSOR");
        assertFalse(authoritiesProfessor.contains(new SimpleGrantedAuthority("ROLE_ALUNO")),
            "A autoridade de ALUNO não deve estar presente para PROFESSOR");
    }

    @Test
    void roleAluno() {
        var alunoRole = Role.ALUNO;
        Usuario usuarioAluno = new Usuario(uuid, nome, sobrenome, dataNascimento, email, senha, matricula, alunoRole);

        Collection<? extends GrantedAuthority> authoritiesAluno = usuarioAluno.getAuthorities();

        assertTrue(authoritiesAluno.contains(new SimpleGrantedAuthority("ROLE_ALUNO")),
            "A autoridade de ALUNO não foi encontrada");
        assertFalse(authoritiesAluno.contains(new SimpleGrantedAuthority("ROLE_ADMIN")),
            "A autoridade de ADMIN não deve estar presente para ALUNO");
        assertFalse(authoritiesAluno.contains(new SimpleGrantedAuthority("ROLE_PROFESSOR")),
            "A autoridade de PROFESSOR não deve estar presente para ALUNO");
    }

    @Test
    void getPassword_ShouldReturnCorrectPassword() {
        assertEquals("1234", usuario.getPassword(), "A senha retornada não é a esperada.");
    }

    @Test
    void getUsername_ShouldReturnCorrectUsername() {
        assertEquals("joao@gmail.com", usuario.getUsername(), "O username (e-mail) retornado não é o esperado.");
    }

    @Test
    void isAccountNonExpired_ShouldReturnTrue() {
        assertEquals(true, usuario.isAccountNonExpired(), "A conta deve estar não expirada.");
    }

    @Test
    void isAccountNonLocked_ShouldReturnTrue() {
        assertEquals(true, usuario.isAccountNonLocked(), "A conta deve estar não bloqueada.");
    }

    @Test
    void isCredentialsNonExpired_ShouldReturnTrue() {
        assertEquals(true, usuario.isCredentialsNonExpired(), "As credenciais devem estar não expiradas.");
    }

    @Test
    void isEnabled_ShouldReturnTrue() {
        assertEquals(true, usuario.isEnabled(), "A conta deve estar habilitada.");
    }

}
