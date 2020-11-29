-- posweb.curso definition

CREATE TABLE curso (
  id SERIAL NOT NULL ,
  nome varchar(100),
  PRIMARY KEY (id)
);

-- posweb.aluno definition

CREATE TABLE aluno (
  id SERIAL NOT NULL ,
  nome varchar(100) ,
  idCurso INTEGER DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT aluno_idCurso_fkey FOREIGN KEY (idCurso) REFERENCES curso (id)
);

INSERT INTO curso (id, nome) VALUES(1, 'Sistemas de Informação');
INSERT INTO curso (id, nome) VALUES(3, 'Engenharia Civil');
INSERT INTO curso (id, nome) VALUES(4, 'Química');
INSERT INTO curso (id, nome) VALUES(5, 'Eletromecânica');
INSERT INTO curso (id, nome) VALUES(6, 'Engenharia Elétrica');