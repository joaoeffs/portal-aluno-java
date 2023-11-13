package com.joaoeffs.portalalunojava.core.notas;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
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
import com.joaoeffs.portalalunojava.core.domain.aluno.model.Aluno;
import com.joaoeffs.portalalunojava.core.domain.aluno.repository.AlunoDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.model.AlunoDisciplina;
import com.joaoeffs.portalalunojava.core.domain.alunodisciplina.repository.AlunoDisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.disciplina.model.Disciplina;
import com.joaoeffs.portalalunojava.core.domain.disciplina.repository.DisciplinaDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.notas.model.Notas;
import com.joaoeffs.portalalunojava.core.domain.notas.repository.NotasDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.AlterarNotasUseCase;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.AlterarNotasUseCase.AlterarNotas;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
public class AlterarNotasUseCaseTest {

    @Autowired
    private NotasDomainRepository repository;

    @Autowired
    private DisciplinaDomainRepository disciplinaRepository;

    @Autowired
    private AlunoDomainRepository alunoRepository;

    @Autowired
    private AlunoDisciplinaDomainRepository alunoDisciplinaRepository;

    @Autowired
    MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    private Notas notas;

    private Disciplina disciplina;

    private Aluno aluno;

    private AlunoDisciplina alunoDisciplina;

    @BeforeEach
    public void setup() {

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

        alunoDisciplina = AlunoDisciplina.builder()
            .aluno(aluno.getId())
            .disciplina(disciplina.getId())
            .build();

        alunoDisciplinaRepository.save(alunoDisciplina);

        notas = Notas.builder()
            .n1(BigDecimal.valueOf(10))
            .n2(BigDecimal.ZERO)
            .n3(BigDecimal.ZERO)
            .alunoDisciplina(alunoDisciplina.getId())
            .build();

        repository.save(notas);
    }

    @Test
    public void caminhoFeliz() throws Exception {

        UUID id = notas.getId();

        AlterarNotas command = AlterarNotas.builder()
            .n2(BigDecimal.valueOf(7))
            .n3(BigDecimal.valueOf(5))
            .build();

        String notas = mapper.writeValueAsString(command);

        mock.perform(put("/api/notas/{id}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(notas))
            .andExpect(status().isOk())
            .andReturn();
    }
}
