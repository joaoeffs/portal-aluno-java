CREATE TABLE usuario (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    sobrenome	         VARCHAR(32)   NOT NULL,
    data_nascimento	     TIMESTAMP     NOT NULL,
    email                VARCHAR(64)   UNIQUE NOT NULL,
    senha                VARCHAR(64)   NOT NULL,
    matricula            VARCHAR(20),
    role                 VARCHAR(10)   NOT NULL,

    CONSTRAINT usuario_pk
        PRIMARY KEY (id)
);
