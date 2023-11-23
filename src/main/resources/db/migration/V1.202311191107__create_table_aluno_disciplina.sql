CREATE TABLE aluno_disciplina (

    id                   UUID          NOT NULL,

    aluno_id             UUID          NOT NULL,
    disciplina_id        UUID          NOT NULL,

    CONSTRAINT aluno_disciplina_pk
        PRIMARY KEY (id)
);

ALTER TABLE aluno_disciplina ADD CONSTRAINT aluno_disciplina_aluno_fk FOREIGN KEY (aluno_id) REFERENCES usuario(id);
ALTER TABLE aluno_disciplina ADD CONSTRAINT aluno_disciplina_disciplina_fk FOREIGN KEY (disciplina_id) REFERENCES disciplina(id);
