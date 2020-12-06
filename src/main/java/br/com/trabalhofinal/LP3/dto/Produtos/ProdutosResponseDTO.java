package br.com.trabalhofinal.LP3.dto.Produtos;

import java.time.LocalDate;
import java.util.Date;

public class ProdutosResponseDTO {
	
	private Integer codigo;
	
	private String nome;
	
	private String PrecoUnitProd;

	private LocalDate DataFabricProd;
	
	private String CategoriaProd;
	
	private String CodigoFor;

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

	public String getPrecoUnitProd() {
		return PrecoUnitProd;
	}

	public void setPrecoUnitProd(String precoUnitProd) {
		PrecoUnitProd = precoUnitProd;
	}

	public LocalDate getDataFabricProd() {
		return DataFabricProd;
	}

	public void setDataFabricProd(LocalDate localDate) {
		DataFabricProd = localDate;
	}

	public String getCategoriaProd() {
		return CategoriaProd;
	}

	public void setCategoriaProd(String categoriaProd) {
		CategoriaProd = categoriaProd;
	}

	public String getCodigoFor() {
		return CodigoFor;
	}

	public void setCodigoFor(String codigoFor) {
		CodigoFor = codigoFor;
	}
}
