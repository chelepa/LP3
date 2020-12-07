package br.com.trabalhofinal.LP3.dto.ItensVenda;

import javax.validation.constraints.DecimalMin;

public class CardResponseDTO {
	
	private Integer idproduto;

	private String nomeProduto;
	
	private Integer quantidade;
	
	@DecimalMin("0.00")
	private Double preco;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}
}
