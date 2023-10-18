ALTER TABLE disciplina ADD professor_id UUID NULL;

ALTER TABLE disciplina  ADD CONSTRAINT disciplina_professor_fk FOREIGN KEY (professor_id) REFERENCES professor(id);
