CREATE TABLE cidades(
	codigo_cid int NOT NULL AUTO_INCREMENT,
	nome_cid varchar(255) NOT NULL,
    uf_cid varchar(2) NOT NULL,
    cep_cid varchar(9) NOT NULL,
    PRIMARY KEY (codigo_cid)
);