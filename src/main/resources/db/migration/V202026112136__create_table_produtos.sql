CREATE TABLE produtos (
  codigo_prod INT NOT NULL AUTO_INCREMENT,
  nome_prod VARCHAR(255) NOT NULL,
  preco_unit_prod DECIMAL(8,2) NOT NULL,
  data_fabric_prod DATE NOT NULL,
  categoria_prod VARCHAR(100) NOT NULL,
  codigo_for INT NOT NULL,
  PRIMARY KEY (codigo_prod),
  INDEX FK_ProdutosFornecedores_idx (codigo_for),
  CONSTRAINT FK_ProdutosFornecedores
    FOREIGN KEY (codigo_for)
    REFERENCES fornecedores (codigo_for)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);