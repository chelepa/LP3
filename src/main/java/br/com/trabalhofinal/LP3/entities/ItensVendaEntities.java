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
	@Column(name = "codigo_iv")
	private Integer CodigoIV;
	
	@Column(name = "codigo_prod")
	private Integer CodigoProd;
	
	@Column(name = "quantidade_iv")
	private Integer QuantidadeIV;

	@Column(name = "valor_total_iv")
	private Double ValorTotalIV;
	
	@Column(name = "codigo_venda")
	private Integer codigoVenda;

	public Integer getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Integer codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

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
	
}
