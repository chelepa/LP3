package br.com.trabalhofinal.LP3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ItensVenda")
public class ItensVendaEntities {
	
	@Id
	@GeneratedValue
	@Column(name = "CodigoIV")
	private Integer CodigoIV;
	
	@Column(name = "CodigoProd")
	private Integer CodigoProd;
	
	@Column(name = "QuantidadeIV")
	private Integer QuantidadeIV;

	@Column(name = "ValorTotalIV")
	private Double ValorTotalIV;
	
	@Column(name = "CodigoVenda")
	private Integer CodigoVenda;

	public Integer getCodigoIV() {
		return CodigoIV;
	}

	public void setCodigoIV(Integer codigoIV) {
		CodigoIV = codigoIV;
	}

	public Integer getCodigoProd() {
		return CodigoProd;
	}

	public void setCodigoProd(Integer codigoProd) {
		CodigoProd = codigoProd;
	}

	public Integer getQuantidadeIV() {
		return QuantidadeIV;
	}

	public void setQuantidadeIV(Integer quantidadeIV) {
		QuantidadeIV = quantidadeIV;
	}

	public Double getValorTotalIV() {
		return ValorTotalIV;
	}

	public void setValorTotalIV(Double valorTotalIV) {
		ValorTotalIV = valorTotalIV;
	}

	public Integer getCodigoVenda() {
		return CodigoVenda;
	}

	public void setCodigoVenda(Integer codigoVenda) {
		CodigoVenda = codigoVenda;
	}
	
}
