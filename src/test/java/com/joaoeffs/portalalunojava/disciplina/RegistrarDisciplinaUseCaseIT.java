package com.joaoeffs.portalalunojava.disciplina;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.RegistrarDisciplinaUseCase.RegistrarDisciplina;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class RegistrarDisciplinaUseCaseIT {

    private final String URL = "/api/disciplina";

    @Autowired
    private MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    RegistrarDisciplina command;

    @BeforeEach
    void before() {

        command = RegistrarDisciplina.builder()
            .nome("Ciência de Dados")
            .codigo("CIENDA-2023")
            .build();
    }

    @Test
    void caminhoFeliz() throws Exception {

        String disciplina = mapper.writeValueAsString(command);

        mock.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(disciplina))
            .andExpect(status().isCreated())
            .andReturn();
    }
}
