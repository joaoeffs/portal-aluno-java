package com.joaoeffs.portalalunojava.core.notas.usecase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.UsuarioDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.model.AlunoDisciplina;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.repository.AlunoDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.RegistrarNotasUseCase.RegistrarNotas;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
class RegistrarNotasUseCaseTest {

    private final String URL = "/api/notas";

    @Autowired
    private DisciplinaDomainRepository disciplinaRepository;

    @Autowired
    private UsuarioDomainRepository usuarioDomainRepository;

    @Autowired
    private AlunoDisciplinaDomainRepository alunoDisciplinaRepository;

    @Autowired
    private MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    private Disciplina disciplina;

    private Usuario usuario;

    private AlunoDisciplina alunoDisciplina;

    @BeforeEach
    public void before() {

        disciplina = Disciplina.builder()
            .nome("Ciência de Dados")
            .codigo("CIENDD-2023")
            .build();

        disciplinaRepository.save(disciplina);

        usuario = Usuario.builder()
            .nome("João")
            .sobrenome("Effting")
            .dataNascimento(LocalDate.of(1999, 07, 16))
            .matricula("16071999")
            .email("teste@teste.com")
            .senha("1234")
            .build();

        usuarioDomainRepository.save(usuario);

        alunoDisciplina = AlunoDisciplina.builder()
            .aluno(usuario.getId())
            .disciplina(disciplina.getId())
            .build();

        alunoDisciplinaRepository.save(alunoDisciplina);
    }

    @Test
    void caminhoFeliz() throws Exception {

        RegistrarNotas command = RegistrarNotas.builder()
            .n1(BigDecimal.valueOf(10))
            .n2(BigDecimal.ZERO)
            .n3(BigDecimal.ZERO)
            .alunoDisciplina(alunoDisciplina.getId())
            .build();

        String notas = mapper.writeValueAsString(command);

        mock.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(notas))
            .andExpect(status().isCreated())
            .andReturn();
    }
}