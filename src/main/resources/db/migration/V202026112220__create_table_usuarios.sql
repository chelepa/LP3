CREATE TABLE usuarios (
  codigo_user INT NOT NULL AUTO_INCREMENT,
  nome_user VARCHAR(20) NOT NULL,
  senha_user VARCHAR(20) NOT NULL,
  codigo_func INT NOT NULL,
  nivel_acesso_user VARCHAR(45) NOT NULL,
  PRIMARY KEY (codigo_user),
  INDEX FK_UsuariosFuncionarios_idx (codigo_func),
  CONSTRAINT FK_UsuariosFuncionarios
    FOREIGN KEY (codigo_func)
    REFERENCES funcionarios (codigo_func)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
 );