package br.com.trabalhofinal.LP3.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.Estoque.EstoqueDTO;
import br.com.trabalhofinal.LP3.entities.EstoqueEntities;
import br.com.trabalhofinal.LP3.repositories.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EstoqueDTO create(EstoqueDTO request) {
		EstoqueEntities response = modelMapper.map(request, EstoqueEntities.class);
		
		repository.save(response);
		
		EstoqueDTO Dto = modelMapper.map(response, EstoqueDTO.class);
		
		return Dto;
		
	}
	
	public void deletarEstoque(Integer id) {
		repository.deleteById(id);
	}
	
}
