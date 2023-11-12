package com.joaoeffs.portalalunojava.core.aluno;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.AlunoDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.aluno.usecase.RegistrarAlunoUseCase.RegistrarAluno;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
public class RegistrarAlunoUseCaseTest {

    private final String URL = "/api/aluno";

    @Autowired
    private AlunoDomainRepository alunoRepository;

    @Autowired
    private MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    RegistrarAluno command;

    @BeforeEach
    void before() {

        command = RegistrarAluno.builder()
            .nome("João")
            .sobrenome("Effting")
            .dataNascimento(LocalDate.of(1999, 07, 16))
            .matricula("16071999")
            .email("joaoefftings@gmail.com")
            .senha("1234")
            .build();
    }

    @Test
    void caminhoFeliz() throws Exception {

        String aluno = mapper.writeValueAsString(command);

        mock.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(aluno))
            .andExpect(status().isCreated())
            .andReturn();
    }
}