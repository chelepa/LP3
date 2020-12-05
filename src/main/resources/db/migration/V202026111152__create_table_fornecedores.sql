CREATE TABLE fornecedores (
  codigo_for INT NOT NULL AUTO_INCREMENT,
  nome_for VARCHAR(100) NOT NULL,
  endereco_for VARCHAR(255) NOT NULL,
  codigo_cid INT NOT NULL,
  email_for VARCHAR(255) NOT NULL,
  cnpj_for VARCHAR(18) NOT NULL,
  telefone_for VARCHAR(15) NOT NULL,
  PRIMARY KEY (codigo_for),
  INDEX FK_CodigoCid_idx (codigo_cid) VISIBLE,
  CONSTRAINT FK_CodigoCidForn FOREIGN KEY (codigo_cid) REFERENCES cidades (codigo_cid) ON DELETE NO ACTION ON UPDATE NO ACTION
);