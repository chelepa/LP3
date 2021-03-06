package br.com.trabalhofinal.LP3.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "venda")
public class VendaEntities {

	@Id
	@GeneratedValue
	@Column(name = "codigo_venda")
	private Integer CodigoVenda;
	
	@Column(name = "codigo_func")
	private Integer CodigoFunc;
	
	@Column(name = "codigo_cli")
	private Integer CodigoCli;

	@Column(name = "data_venda")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate DataVenda;
	
	@Column(name = "valor_total_venda")
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

	public LocalDate getDataVenda() {
		return DataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		DataVenda = dataVenda;
	}

	public Double getValorTotalVenda() {
		return ValorTotalVenda;
	}

	public void setValorTotalVenda(Double valorTotalVenda) {
		ValorTotalVenda = valorTotalVenda;
	}
}
