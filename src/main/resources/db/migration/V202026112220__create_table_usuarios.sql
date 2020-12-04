CREATE TABLE usuarios (
  CodigoUser INT NOT NULL AUTO_INCREMENT,
  NomeUser VARCHAR(20) NOT NULL,
  SenhaUser VARCHAR(20) NOT NULL,
  CodFunc INT NOT NULL,
  NivelAcessoUser VARCHAR(45) NOT NULL,
  PRIMARY KEY (CodigoUser),
  INDEX FK_UsuariosFuncionarios_idx (CodFunc),
  CONSTRAINT FK_UsuariosFuncionarios
    FOREIGN KEY (CodFunc)
    REFERENCES funcionarios (CodigoFunc)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
 );