package br.com.trabalhofinal.LP3.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class ProdutosEntities {
	
	@Id
	@GeneratedValue
	@Column(name = "CodigoProd")
	private Integer codigo;
	
	@Column(name = "NomeProd")
	private String nome;
	
	@Column(name = "PrecoUnitProd")
	private Double PrecoUnitProd;

	@Column(name = "DataFabricProd")
	private Date DataFabricProd;
	
	@Column(name = "CategoriaProd")
	private String CategoriaProd;
	
	@Column(name = "CodigoFor")
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
