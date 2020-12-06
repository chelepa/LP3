package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.Fornecedores.FornecedoresDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosResponseDTO;
import br.com.trabalhofinal.LP3.entities.ProdutosEntities;
import br.com.trabalhofinal.LP3.repositories.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired FornecedoresService fornecedor;
	
	public List<ProdutosResponseDTO> getAllProdutos() {
		
		List<ProdutosEntities> list = repository.findAll();
		
		List<ProdutosResponseDTO> listProdutos = populateFornecedor(list);
		
		return listProdutos;
	}
	
	public void deletarProdutos(Integer id) {
		// tem que deletar o estoque do produto tambem
		repository.deleteById(id);
	}
	
	public ProdutosDTO getProdutosbyId(Integer id) {
		Optional<ProdutosEntities> produtos = repository.findById(id);
		
		ProdutosDTO response = modelMapper.map(produtos.get(), ProdutosDTO.class);
		
		return response;
	}
	
	public ProdutosDTO create(ProdutosDTO produtos) {
		ProdutosEntities entities = modelMapper.map(produtos, ProdutosEntities.class);
		
		repository.save(entities);
		
		ProdutosDTO response = modelMapper.map(entities, ProdutosDTO.class);
		
		return response;
	}
	
	public ProdutosDTO atualizar(ProdutosDTO produtos) {
		
		ProdutosEntities entities = modelMapper.map(produtos, ProdutosEntities.class);
		
		repository.save(entities);
		
		ProdutosDTO response = modelMapper.map(entities, ProdutosDTO.class);
		
		return response;
	}

	private List<ProdutosResponseDTO> populateFornecedor(List<ProdutosEntities> list) {
		List<ProdutosResponseDTO> listresponse = new ArrayList<>();
		for (ProdutosEntities entities : list) {
			ProdutosResponseDTO dto = new ProdutosResponseDTO();
			dto.setCategoriaProd(entities.getCategoriaProd());
			dto.setCodigo(entities.getCodigo());
			dto.setCodigoFor(populateNomeFornecedor(entities.getCodigoFor()));
			dto.setDataFabricProd(entities.getDataFabricProd());
			dto.setNome(entities.getNome());
			dto.setPrecoUnitProd(entities.getPrecoUnitProd());
			listresponse.add(dto);
		}
		return null;
	}

	private String populateNomeFornecedor(Integer codigoFor) {
		FornecedoresDTO fornecedores = fornecedor.getFornecedoresbyId(codigoFor);
		return fornecedores.getNomeFor();
	}
	
	
}
