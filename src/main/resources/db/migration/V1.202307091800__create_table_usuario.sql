CREATE TABLE usuario (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    sobrenome	         VARCHAR(32)   NOT NULL,
    data_nascimento	     TIMESTAMP     NOT NULL,
    matricula            VARCHAR(8)    NOT NULL,
    email                VARCHAR(64)   UNIQUE NOT NULL,
    senha                VARCHAR(16)   NOT NULL,
    role                 VARCHAR(16)   NOT NULL,

    CONSTRAINT usuario_pk
        PRIMARY KEY (id)
);
