CREATE TABLE estoque (
  codigo_est INT NOT NULL AUTO_INCREMENT,
  codigo_prod INT NOT NULL,
  quant_est INT NOT NULL,
  PRIMARY KEY (codigo_est),
  INDEX FK_EstoqueProdutos_idx (codigo_prod),
  CONSTRAINT FK_EstoqueProdutos FOREIGN KEY (codigo_prod) REFERENCES produtos (codigo_prod) ON DELETE NO ACTION ON UPDATE NO ACTION
 );