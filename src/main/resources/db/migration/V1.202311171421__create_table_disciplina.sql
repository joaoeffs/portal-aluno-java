CREATE TABLE disciplina (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    codigo               VARCHAR(16)   NOT NULL,
    professor_id         UUID,

    CONSTRAINT disciplina_pk
        PRIMARY KEY (id)
);

ALTER TABLE disciplina  ADD CONSTRAINT disciplina_professor_fk FOREIGN KEY (professor_id) REFERENCES usuario(id);
