package com.joaoeffs.portalalunojava.core.disciplina.usecase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoeffs.portalalunojava.core.CustomPrincipal;
import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.UsuarioDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RegistrarDisciplinaUseCase.RegistrarDisciplina;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback
public class RegistrarDisciplinaUseCaseTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private UsuarioDomainRepository usuarioRepository;

    private Usuario usuario;
    private RegistrarDisciplina command;

    @BeforeEach
    public void setUp() {

        usuario = Usuario.builder()
            .nome("João")
            .sobrenome("Effting")
            .dataNascimento(LocalDate.of(1999, 7, 16))
            .matricula("16071999")
            .email("joaoefftings@gmail.com")
            .senha("1234")
            .build();

        usuarioRepository.save(usuario);

        command = RegistrarDisciplina.builder()
            .nome("Ciência de Dados")
            .codigo("CIENDA-2023")
            .build();
    }

    @Test
    void caminhoFeliz() throws Exception {

        CustomPrincipal customPrincipal = new CustomPrincipal(UUID.randomUUID());

        Authentication auth = new TestingAuthenticationToken(customPrincipal, null, "ROLE_ADMIN");

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(auth);
        SecurityContextHolder.setContext(securityContext);

        String json = mapper.writeValueAsString(command);

        mockMvc.perform(post("/api/disciplina")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isCreated());
    }
}

