package br.com.trabalhofinal.LP3.dto.Vendas;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

public class VendaResponseDTO {

	private Integer CodigoVenda;
	
	private String CodigoFunc;
	
	private String CodigoCli;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate DataVenda;
	
	@DecimalMin("0.00")
	private Double ValorTotalVenda;

	public Integer getCodigoVenda() {
		return CodigoVenda;
	}

	public void setCodigoVenda(Integer codigoVenda) {
		CodigoVenda = codigoVenda;
	}

	public String getCodigoFunc() {
		return CodigoFunc;
	}

	public void setCodigoFunc(String codigoFunc) {
		CodigoFunc = codigoFunc;
	}

	public String getCodigoCli() {
		return CodigoCli;
	}

	public void setCodigoCli(String codigoCli) {
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
