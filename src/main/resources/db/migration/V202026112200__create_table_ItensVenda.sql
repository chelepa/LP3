CREATE TABLE ItensVenda (
  CodigoIV INT NOT NULL AUTO_INCREMENT,
  CodigoProd INT NOT NULL,
  QuantidadeIV INT NOT NULL,
  ValorTotalIV DECIMAL(8,2) NOT NULL,
  CodigoVenda INT NOT NULL,
  PRIMARY KEY (`CodigoIV`),
  INDEX FK_ItensVendaProdutos_idx (CodigoProd),
  INDEX FK_ItensVendaVenda_idx (CodigoVenda),
  CONSTRAINT FK_ItensVendaProdutos
    FOREIGN KEY (CodigoProd)
    REFERENCES produtos (CodigoProd)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_ItensVendaVenda
    FOREIGN KEY (CodigoVenda)
    REFERENCES venda (CodigoVenda)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
 );