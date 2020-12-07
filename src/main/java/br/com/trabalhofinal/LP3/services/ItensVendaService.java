package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.ItensVenda.CardRequestDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardResponseDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.dto.Vendas.ValorTotalOrderDTO;

@Service
public class ItensVendaService {
	
	@Autowired
	private ProdutosService prdService;
	
	List<CardResponseDTO> listCard = new ArrayList<CardResponseDTO>();
	
	public List<CardResponseDTO> getItensCart() {
		return listCard;
	}
	
	public void deleteItemList(Integer Id) {
		listCard.removeIf(item -> item.getIdproduto().equals(Id));
	}
	
	public List<CardResponseDTO> populateItensVenda(CardRequestDTO request) {
		Boolean createNewItem = true;
			CardResponseDTO card = new CardResponseDTO();
			ProdutosDTO produt = prdService.getProdutosbyId(request.getIdProduto());
			
		for (CardResponseDTO cardResponseDTO : listCard) {
			if (cardResponseDTO.getIdproduto().equals(request.getIdProduto())) {
				cardResponseDTO.setQuantidade(cardResponseDTO.getQuantidade() + request.getQuantidade());
				cardResponseDTO.setPreco(getPrice(cardResponseDTO.getQuantidade(), produt.getPrecoUnitProd()));
				createNewItem = false;
			}
		}
		if (createNewItem) {
			card.setIdproduto(request.getIdProduto());
			card.setNomeProduto(produt.getNome());
			card.setQuantidade(request.getQuantidade());
			card.setPreco(getPrice(request.getQuantidade(), produt.getPrecoUnitProd()));

			listCard.add(card);
		}

		return listCard;
	}

	private Double getPrice(Integer quantidade, Double produtPrice) {
		Double price = produtPrice * quantidade;
		return price;
	}	
}
