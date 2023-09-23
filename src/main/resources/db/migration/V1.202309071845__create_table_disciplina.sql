CREATE TABLE disciplina (

    id                   UUID          NOT NULL,

    nome	             VARCHAR(32)   NOT NULL,
    codigo               VARCHAR(16)   NOT NULL,
    usuario_id           UUID          NOT NULL,

    CONSTRAINT disciplina_pk
        PRIMARY KEY (id),

    CONSTRAINT disciplina_usuario_fk
            FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
