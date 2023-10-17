CREATE TABLE aluno (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    sobrenome	         VARCHAR(32)   NOT NULL,
    data_nascimento	     TIMESTAMP     NOT NULL,
    email                VARCHAR(64)   UNIQUE NOT NULL,
    senha                VARCHAR(16)   NOT NULL,
    matricula            VARCHAR(20)   NOT NULL,

    CONSTRAINT aluno_pk
        PRIMARY KEY (id)
);
