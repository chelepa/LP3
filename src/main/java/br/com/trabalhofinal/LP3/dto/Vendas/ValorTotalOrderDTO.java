package br.com.trabalhofinal.LP3.dto.Vendas;

import javax.validation.constraints.DecimalMin;

public class ValorTotalOrderDTO {

	@DecimalMin("0.00")
	private Double valortotalOrder;
	
	public Double getValortotalOrder() {
		return valortotalOrder;
	}

	public void setValortotalOrder(Double valortotalOrder) {
		this.valortotalOrder = valortotalOrder;
	}
}
