package com.joaoeffs.portalalunojava.core.disciplina.usecase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.usecase.AlterarDisciplinaUseCase.AlterarDisciplina;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
class AlterarDisciplinaUseCaseTest {

    @Autowired
    private DisciplinaDomainRepository repository;

    @Autowired
    MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    private Disciplina disciplina;

    @BeforeEach
    public void setup() {
        disciplina = Disciplina.builder()
            .nome("Ciência de Dados")
            .codigo("CIENDD-2023")
            .build();

        repository.save(disciplina);
    }

    @Test
    void caminhoFeliz() throws Exception {

        UUID id = disciplina.getId();

        AlterarDisciplina command = AlterarDisciplina.builder()
            .nome("Inteligência Artificial")
            .codigo("INTART-2023")
            .build();

        String alterarDisciplinaJson = mapper.writeValueAsString(command);

        mock.perform(put("/api/disciplina/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(alterarDisciplinaJson))
            .andExpect(status().isOk())
            .andReturn();
    }

}
