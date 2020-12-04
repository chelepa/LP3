package br.com.trabalhofinal.LP3.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class VendaEntities {

	@Id
	@Column(name = "CodigoVenda")
	private Integer CodigoVenda;
	
	@Column(name = "CodigoFunc")
	private Integer CodigoFunc;
	
	@Column(name = "CodigoCli")
	private Integer CodigoCli;

	@Column(name = "DataVenda")
	private Date DataVenda;
	
	@Column(name = "ValorTotalVenda")
	private Double ValorTotalVenda;

	public Integer getCodigoVenda() {
		return CodigoVenda;
	}

	public void setCodigoVenda(Integer codigoVenda) {
		CodigoVenda = codigoVenda;
	}

	public Integer getCodigoFunc() {
		return CodigoFunc;
	}

	public void setCodigoFunc(Integer codigoFunc) {
		CodigoFunc = codigoFunc;
	}

	public Integer getCodigoCli() {
		return CodigoCli;
	}

	public void setCodigoCli(Integer codigoCli) {
		CodigoCli = codigoCli;
	}

	public Date getDataVenda() {
		return DataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		DataVenda = dataVenda;
	}

	public Double getValorTotalVenda() {
		return ValorTotalVenda;
	}

	public void setValorTotalVenda(Double valorTotalVenda) {
		ValorTotalVenda = valorTotalVenda;
	}
}
