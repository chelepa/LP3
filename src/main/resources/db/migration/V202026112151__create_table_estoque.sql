CREATE TABLE estoque (
  CodigoEst INT NOT NULL AUTO_INCREMENT,
  CodigoProd INT NOT NULL,
  QuantEst INT NOT NULL,
  PRIMARY KEY (CodigoEst),
  INDEX FK_EstoqueProdutos_idx (CodigoProd),
  CONSTRAINT FK_EstoqueProdutos FOREIGN KEY (CodigoProd) REFERENCES produtos (CodigoProd) ON DELETE NO ACTION ON UPDATE NO ACTION
 );