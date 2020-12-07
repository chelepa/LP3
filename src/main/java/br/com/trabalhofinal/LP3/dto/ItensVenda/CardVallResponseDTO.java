package br.com.trabalhofinal.LP3.dto.ItensVenda;

import javax.validation.constraints.DecimalMin;

public class CardVallResponseDTO {
	
	private Integer idproduto;

	private String nomeProduto;
	
	private Integer quantidade;
	
	@DecimalMin("0.00")
	private Double preco;
	
	@DecimalMin("0.00")
	private Double precounitario;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Double getPrecounitario() {
		return precounitario;
	}

	public void setPrecounitario(Double precounitario) {
		this.precounitario = precounitario;
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
