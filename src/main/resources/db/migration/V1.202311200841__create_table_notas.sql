CREATE TABLE notas (

    id                      UUID          NOT NULL,

    n1	                    NUMERIC(16, 2),
    n2	                    NUMERIC(16, 2),
    n3	                    NUMERIC(16, 2),
    media	                NUMERIC(16, 2),
    situacao                VARCHAR(16),

    aluno_disciplina_id     UUID,

    CONSTRAINT notas_pk
        PRIMARY KEY (id)
);

ALTER TABLE notas ADD CONSTRAINT notas_aluno_disciplina_fk FOREIGN KEY (aluno_disciplina_id) REFERENCES aluno_disciplina(id);
