CREATE TABLE funcionarios (
  codigo_func INT NOT NULL AUTO_INCREMENT,
  nome_func VARCHAR(100) NOT NULL,
  endereco_func VARCHAR(255) NOT NULL,
  codigo_cid INT NOT NULL,
  email_func VARCHAR(255) NOT NULL,
  data_nasc_func DATE NOT NULL,
  telefone_func VARCHAR(45) NOT NULL,
  cpf_func VARCHAR(15) NOT NULL,
  salario_func VARCHAR(14) NOT NULL,
  PRIMARY KEY (codigo_func),
  INDEX FK_Funcionarios_Cidades_idx (codigo_cid),
  CONSTRAINT FK_Funcionarios_Cidades FOREIGN KEY (codigo_cid) REFERENCES cidades (codigo_cid) ON DELETE NO ACTION ON UPDATE NO ACTION
 );