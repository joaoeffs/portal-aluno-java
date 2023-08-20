CREATE TABLE usuario (
    id          uuid               PRIMARY KEY UNIQUE NOT NULL,
    login       VARCHAR(64)        UNIQUE NOT NULL,
    senha       VARCHAR(64)        NOT NULL,
    role        VARCHAR(64)
);