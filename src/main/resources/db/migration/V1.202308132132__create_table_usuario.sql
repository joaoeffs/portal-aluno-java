CREATE TABLE usuario (
    id          uuid        PRIMARY KEY UNIQUE NOT NULL,
    login       text        UNIQUE NOT NULL,
    senha       text        NOT NULL,
    role        text        NOT NULL
);