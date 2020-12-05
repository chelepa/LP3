CREATE TABLE clientes (
  codigo_cli INT NOT NULL AUTO_INCREMENT,
  nome_cli VARCHAR(100) NOT NULL,
  endereco_cli VARCHAR(255) NOT NULL,
  codigo_cid INT NOT NULL,
  email_cli VARCHAR(45) NOT NULL,
  data_nasc_cli date NOT NULL,
  telefone_cli VARCHAR(15) NOT NULL,
  cpf_cli VARCHAR(14) NOT NULL,
  PRIMARY KEY (codigo_cli),
  INDEX FL_CodigoCid_idx (codigo_cid) VISIBLE,
  CONSTRAINT FK_CodigoCid FOREIGN KEY (codigo_cid) REFERENCES cidades (codigo_cid) ON DELETE NO ACTION ON UPDATE NO ACTION
);