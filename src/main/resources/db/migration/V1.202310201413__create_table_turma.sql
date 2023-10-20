CREATE TABLE turma (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    nome_abreviado	     VARCHAR(16)   NOT NULL,
    ano_letivo           TIMESTAMP     NOT NULL,

    CONSTRAINT turma_pk
        PRIMARY KEY (id)
);
