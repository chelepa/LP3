CREATE TABLE IF NOT EXISTS venda (
  CodigoVenda INT NOT NULL,
  CodigoFunc INT NOT NULL,
  CodigoCli INT NOT NULL,
  DataVenda DATE NOT NULL,
  ValorTotalVenda DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (CodigoVenda)
);