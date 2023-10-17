CREATE TABLE disciplina (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    codigo               VARCHAR(16)   NOT NULL,

    CONSTRAINT disciplina_pk
        PRIMARY KEY (id)
);
