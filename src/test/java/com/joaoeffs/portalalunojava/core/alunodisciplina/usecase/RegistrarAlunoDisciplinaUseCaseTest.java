package com.joaoeffs.portalalunojava.core.alunodisciplina.usecase;

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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoeffs.portalalunojava.core.domain.aluno.model.Usuario;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.UsuarioDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.repository.AlunoDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.usecase.RegistrarAlunoDisciplinaUseCase.RegistrarAlunoDisciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
public class RegistrarAlunoDisciplinaUseCaseTest {

    private final String URL = "/api/alunodisciplina";

    @Autowired
    private DisciplinaDomainRepository disciplinaRepository;

    @Autowired
    private UsuarioDomainRepository usuarioDomainRepository;

    @Autowired
    private AlunoDisciplinaDomainRepository repository;

    @Autowired
    private MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    private Disciplina disciplina;

    private Usuario usuario;

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

    }

    @Test
    public void caminhoFeliz() throws Exception {

        UUID disciplinaId = disciplina.getId();
        UUID alunoId = usuario.getId();

        RegistrarAlunoDisciplina command = RegistrarAlunoDisciplina.builder()
            .disciplina(disciplinaId)
            .aluno(alunoId)
            .build();

        String alunoDisciplina = mapper.writeValueAsString(command);

        mock.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(alunoDisciplina))
            .andExpect(status().isCreated())
            .andReturn();
    }
}