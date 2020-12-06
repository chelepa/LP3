package br.com.trabalhofinal.LP3.dto.Produtos;

import java.util.Date;

public class ProdutosDTO {
	
	private Integer codigo;
	
	private String nome;
	
	private Double PrecoUnitProd;

	private Date DataFabricProd;
	
	private String CategoriaProd;
	
	private Integer CodigoFor;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoUnitProd() {
		return PrecoUnitProd;
	}

	public void setPrecoUnitProd(Double precoUnitProd) {
		PrecoUnitProd = precoUnitProd;
	}

	public Date getDataFabricProd() {
		return DataFabricProd;
	}

	public void setDataFabricProd(Date dataFabricProd) {
		DataFabricProd = dataFabricProd;
	}

	public String getCategoriaProd() {
		return CategoriaProd;
	}

	public void setCategoriaProd(String categoriaProd) {
		CategoriaProd = categoriaProd;
	}

	public Integer getCodigoFor() {
		return CodigoFor;
	}

	public void setCodigoFor(Integer codigoFor) {
		CodigoFor = codigoFor;
	}
}
