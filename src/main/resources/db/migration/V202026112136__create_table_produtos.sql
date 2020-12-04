CREATE TABLE produtos (
  CodigoProd INT NOT NULL AUTO_INCREMENT,
  NomeProd VARCHAR(255) NOT NULL,
  PrecoUnitProd DECIMAL(8,2) NOT NULL,
  DataFabricProd DATE NOT NULL,
  CategoriaProd VARCHAR(100) NOT NULL,
  CodigoFor INT NOT NULL,
  PRIMARY KEY (CodigoProd),
  INDEX FK_ProdutosFornecedores_idx (CodigoFor),
  CONSTRAINT FK_ProdutosFornecedores
    FOREIGN KEY (CodigoFor)
    REFERENCES fornecedores (CodigoFor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);