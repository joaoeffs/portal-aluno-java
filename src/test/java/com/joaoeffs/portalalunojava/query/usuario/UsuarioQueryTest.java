package com.joaoeffs.portalalunojava.query.usuario;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
class UsuarioQueryTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void deveListarAlunos() throws Exception {

        mockMvc.perform(get("/api/usuario"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id", is("11710720-3799-4402-a71f-2efe77b645c3")))
            .andExpect(jsonPath("$[0].nome", is("joao")))
            .andExpect(jsonPath("$[0].sobrenome", is("effting")))
            .andExpect(jsonPath("$[0].matricula", is("16071999")))
            .andExpect(jsonPath("$[0].role", is("ALUNO")));
    }
}
