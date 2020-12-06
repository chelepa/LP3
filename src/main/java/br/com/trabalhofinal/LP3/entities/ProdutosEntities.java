package br.com.trabalhofinal.LP3.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "produtos")
public class ProdutosEntities {
	
	@Id
	@GeneratedValue
	@Column(name = "codigo_prod")
	private Integer codigo;
	
	@Column(name = "nome_prod")
	private String nome;
	
	@Column(name = "preco_unit_prod")
	private Double PrecoUnitProd;

	@Column(name = "data_fabric_prod")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate DataFabricProd;
	
	@Column(name = "categoria_prod")
	private String CategoriaProd;
	
	@Column(name = "codigo_for")
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

	public LocalDate getDataFabricProd() {
		return DataFabricProd;
	}

	public void setDataFabricProd(LocalDate dataFabricProd) {
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
