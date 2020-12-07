package br.com.trabalhofinal.LP3.dto.Vendas;

import java.time.LocalDate;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

public class VendaDTO {

	private Integer CodigoVenda;
	
	private Integer CodigoFunc;
	
	private Integer CodigoCli;

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
