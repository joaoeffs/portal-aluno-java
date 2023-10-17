CREATE TABLE professor (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    sobrenome	         VARCHAR(32)   NOT NULL,
    data_nascimento	     TIMESTAMP     NOT NULL,
    email                VARCHAR(64)   UNIQUE NOT NULL,
    senha                VARCHAR(16)   NOT NULL,

    CONSTRAINT professor_pk
        PRIMARY KEY (id)
);
