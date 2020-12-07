CREATE TABLE IF NOT EXISTS venda (
  codigo_venda INT NOT NULL AUTO_INCREMENT,
  codigo_func INT NOT NULL,
  codigo_cli INT NOT NULL,
  data_venda DATE NOT NULL,
  valor_total_venda DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (codigo_venda)
);