package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.Estoque.EstoqueDTO;
import br.com.trabalhofinal.LP3.dto.Estoque.EstoqueResponseDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.entities.EstoqueEntities;
import br.com.trabalhofinal.LP3.repositories.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repository;
	
	@Autowired ProdutosService prodService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EstoqueDTO create(EstoqueDTO request) {
		EstoqueEntities response = modelMapper.map(request, EstoqueEntities.class);
		
		repository.save(response);
		
		EstoqueDTO Dto = modelMapper.map(response, EstoqueDTO.class);
		
		return Dto;
		
	}
	
	public EstoqueDTO update(EstoqueDTO request) {
		EstoqueEntities response = modelMapper.map(request, EstoqueEntities.class);
		
		repository.save(response);
		
		EstoqueDTO Dto = modelMapper.map(response, EstoqueDTO.class);
		
		return Dto;
		
	}
	
	public void deletarEstoque(Integer id) {
		repository.deleteById(id);
	}
	
	public List<EstoqueResponseDTO> findAllEstoque() {
		
		List<EstoqueEntities> response = repository.findAll();
		
		List<EstoqueResponseDTO> listEstoque = populateProduto(response);
		
		return listEstoque;
	}
	
	public EstoqueDTO findEstoqueByID(Integer id) {
		
		Optional<EstoqueEntities> response = repository.findById(id);
		
		EstoqueDTO Dto = modelMapper.map(response.get(), EstoqueDTO.class);
		
		return Dto;
	}
	
	public EstoqueEntities getFindByEstoqueByProdutoId(Integer id) {
		EstoqueEntities estoque = repository.findByProduto(id);
		return estoque;
	}
	
	public void deleteEstoqueByProdutoId(Integer id) {
		EstoqueEntities estoque = repository.findByProduto(id);
		repository.deleteById(estoque.getCodigo());
	}

	private List<EstoqueResponseDTO> populateProduto(List<EstoqueEntities> response) {
		List<EstoqueResponseDTO> listresponse = new ArrayList<>();
		for (EstoqueEntities entities : response) {
			EstoqueResponseDTO dto = new EstoqueResponseDTO();
			dto.setCodigo(entities.getCodigo());
			dto.setQuantidade(entities.getQuantidade());
			dto.setProduto(buscaNomeProduto(entities.getProduto()));
			listresponse.add(dto);
		}
		return listresponse;
	}

	private String buscaNomeProduto(Integer produto) {
		ProdutosDTO response = prodService.getProdutosbyId(produto);
		return response.getNome();
	}
	
}
