package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.Estoque.EstoqueDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardItensResponse;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardRequestDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardResponseDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardVallResponseDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.ItensVendaDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.entities.EstoqueEntities;
import br.com.trabalhofinal.LP3.entities.ItensVendaEntities;
import br.com.trabalhofinal.LP3.repositories.ItensVendaRepository;

@Service
public class ItensVendaService {
	
	@Autowired
	private ProdutosService prdService;
	
	@Autowired
	private EstoqueService estoqueService;
	
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
			
			atualizarEstoque(entities);
		}
		listCard.removeAll(listCard);
	}
	
	private void atualizarEstoque(ItensVendaEntities entities) {
		EstoqueEntities estoque = estoqueService.getFindByEstoqueByProdutoId(entities.getCodigoProd());
		Integer QuantEstoque = estoque.getQuantidade() - entities.getQuantidadeIV();
		estoque.setQuantidade(QuantEstoque);
		EstoqueDTO Dto = modelMapper.map(estoque, EstoqueDTO.class);
		estoqueService.update(Dto);
	}

	public List<ItensVendaEntities> getItensFromOrder(Integer Id) {
		return repository.findByCodigoVenda(Id);
	}
	
	public List<CardVallResponseDTO> getItensOrderValor(Integer Id) {
		List<CardVallResponseDTO> list = new ArrayList<CardVallResponseDTO>();
		List<ItensVendaEntities> listItens = getItensFromOrder(Id);
				
		for (ItensVendaEntities itensVendaEntities : listItens) {
			ProdutosDTO produt = prdService.getProdutosbyId(itensVendaEntities.getCodigoProd());
			CardVallResponseDTO response = new CardVallResponseDTO();
			response.setIdproduto(itensVendaEntities.getCodigoProd());
			response.setNomeProduto(produt.getNome());
			response.setPreco(itensVendaEntities.getValorTotalIV());
			response.setPrecounitario(produt.getPrecoUnitProd());
			response.setQuantidade(itensVendaEntities.getQuantidadeIV());
			list.add(response);
		}
		
		return list;
	}
	
	public void deleteitensProductid(Integer Id) {
		List<ItensVendaEntities> list = getItensFromOrder(Id);
		for (ItensVendaEntities itensVendaEntities : list) {
			repository.deleteById(itensVendaEntities.getCodigoIV());
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
