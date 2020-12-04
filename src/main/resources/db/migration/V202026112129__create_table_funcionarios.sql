CREATE TABLE funcionarios (
  CodigoFunc INT NOT NULL AUTO_INCREMENT,
  NomeFunc VARCHAR(100) NOT NULL,
  EnderecoFunc VARCHAR(255) NOT NULL,
  CodigoCid INT NOT NULL,
  EmailFunc VARCHAR(255) NOT NULL,
  DataNFunc DATE NOT NULL,
  TelefoneFunc VARCHAR(45) NOT NULL,
  CPFFunc VARCHAR(15) NOT NULL,
  SalarioFunc VARCHAR(14) NOT NULL,
  PRIMARY KEY (CodigoFunc),
  INDEX FK_Funcionarios_Cidades_idx (CodigoCid),
  CONSTRAINT FK_Funcionarios_Cidades FOREIGN KEY (CodigoCid) REFERENCES cidades (codigo_cid) ON DELETE NO ACTION ON UPDATE NO ACTION
 );