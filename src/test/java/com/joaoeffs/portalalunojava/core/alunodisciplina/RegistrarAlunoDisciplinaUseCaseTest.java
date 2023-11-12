package com.joaoeffs.portalalunojava.core.alunodisciplina;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
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
import com.joaoeffs.portalalunojava.core.domain.aluno.model.Aluno;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.AlunoDomainRepository;
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
    private AlunoDomainRepository alunoRepository;

    @Autowired
    private AlunoDisciplinaDomainRepository repository;

    @Autowired
    private MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    RegistrarAlunoDisciplina command;

    private Disciplina disciplina;

    private Aluno aluno;

    @BeforeEach
    public void before() {

        disciplina = Disciplina.builder()
            .nome("Ciência de Dados")
            .codigo("CIENDD-2023")
            .build();

        disciplinaRepository.save(disciplina);

        aluno = Aluno.builder()
            .nome("João")
            .sobrenome("Effting")
            .dataNascimento(LocalDate.of(1999, 07, 16))
            .matricula("16071999")
            .email("teste@teste.com")
            .senha("1234")
            .build();

        alunoRepository.save(aluno);

    }

    @Test
    public void caminhoFeliz() throws Exception {

        UUID disciplinaId = disciplina.getId();
        UUID alunoId = aluno.getId();

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
