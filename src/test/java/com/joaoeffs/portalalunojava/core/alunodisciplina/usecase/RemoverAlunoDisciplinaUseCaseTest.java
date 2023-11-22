package com.joaoeffs.portalalunojava.core.alunodisciplina.usecase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.model.AlunoDisciplina;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.repository.AlunoDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
class RemoverAlunoDisciplinaUseCaseTest {

    @Autowired
    private AlunoDisciplinaDomainRepository repository;

    @Autowired
    private DisciplinaDomainRepository disciplinaRepository;

    @Autowired
    private UsuarioDomainRepository usuarioDomainRepository;

    @Autowired
    MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    private AlunoDisciplina alunoDisciplina;

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

        UUID disciplinaId = disciplina.getId();
        UUID alunoId = usuario.getId();

        alunoDisciplina = AlunoDisciplina.builder()
            .disciplina(disciplinaId)
            .aluno(alunoId)
            .build();
    }

    @Test
    void caminhoFeliz() throws Exception {

        UUID id = alunoDisciplina.getId();

        mock.perform(delete("/api/alunodisciplina/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
    }
}