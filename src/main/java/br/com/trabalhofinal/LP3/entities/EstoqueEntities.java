package br.com.trabalhofinal.LP3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class EstoqueEntities {

	@Id
	@GeneratedValue
	@Column(name = "CodigoEst")
	private Integer codigo;
	
	@Column(name = "CodigoProd")
	private Integer produto;
	
	@Column(name = "QuantEst")
	private Integer quantidade;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
