package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.ItensVenda.CardItensResponse;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardRequestDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardResponseDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.ItensVendaDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.entities.ItensVendaEntities;
import br.com.trabalhofinal.LP3.repositories.ItensVendaRepository;

@Service
public class ItensVendaService {
	
	@Autowired
	private ProdutosService prdService;
	
	@Autowired
	private ItensVendaRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	List<CardResponseDTO> listCard = new ArrayList<CardResponseDTO>();
	
	public void createItensVenda(Integer idvenda) {
		
		for (CardResponseDTO cardResponseDTO : listCard) {
			ItensVendaDTO itensVenda = new ItensVendaDTO();
			itensVenda.setCodigoProd(cardResponseDTO.getIdproduto());
			itensVenda.setCodigoVenda(idvenda);
			itensVenda.setQuantidadeIV(cardResponseDTO.getQuantidade());
			itensVenda.setValorTotalIV(cardResponseDTO.getPreco());
			
			ItensVendaEntities entities = modelMapper.map(itensVenda, ItensVendaEntities.class);
			
			repository.save(entities);
			
		}
	}
	
	public CardItensResponse getItensCart() {
		CardItensResponse response = new CardItensResponse();
		response.setValorOrder(CalcularValorOrder());
		response.setCardItens(listCard);
		return response;
	}
	
	public void deleteItemList(Integer Id) {
		listCard.removeIf(item -> item.getIdproduto().equals(Id));
	}
	
	public Double CalcularValorOrder() {
		Double valor = (double) 0;
		for (CardResponseDTO cardResponseDTO : listCard) {
			valor = valor + cardResponseDTO.getPreco();
		}
		return valor;
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
