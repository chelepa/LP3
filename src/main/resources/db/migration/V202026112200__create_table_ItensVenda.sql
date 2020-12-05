CREATE TABLE itens_venda (
  codigo_iv INT NOT NULL AUTO_INCREMENT,
  codigo_prod INT NOT NULL,
  quantidade_iv INT NOT NULL,
  valor_total_iv DECIMAL(8,2) NOT NULL,
  codigo_venda INT NOT NULL,
  PRIMARY KEY (`codigo_iv`),
  INDEX FK_ItensVendaProdutos_idx (codigo_prod),
  INDEX FK_ItensVendaVenda_idx (codigo_venda),
  CONSTRAINT FK_ItensVendaProdutos
    FOREIGN KEY (codigo_prod)
    REFERENCES produtos (codigo_prod)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_ItensVendaVenda
    FOREIGN KEY (codigo_venda)
    REFERENCES venda (codigo_venda)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
 );