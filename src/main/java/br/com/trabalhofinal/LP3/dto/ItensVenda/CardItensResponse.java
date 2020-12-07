package br.com.trabalhofinal.LP3.dto.ItensVenda;

import java.util.List;

import javax.validation.constraints.DecimalMin;

public class CardItensResponse {
	
	@DecimalMin("0.00")
	private Double valorOrder;

	private List<CardResponseDTO> cardItens;

	public Double getValorOrder() {
		return valorOrder;
	}

	public void setValorOrder(Double valorOrder) {
		this.valorOrder = valorOrder;
	}

	public List<CardResponseDTO> getCardItens() {
		return cardItens;
	}

	public void setCardItens(List<CardResponseDTO> cardItens) {
		this.cardItens = cardItens;
	}
}
