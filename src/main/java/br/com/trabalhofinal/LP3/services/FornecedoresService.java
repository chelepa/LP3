package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.Cidades.CidadesDTO;
import br.com.trabalhofinal.LP3.dto.Fornecedores.FornecedoresDTO;
import br.com.trabalhofinal.LP3.dto.Fornecedores.FornecedoresResponseDTO;
import br.com.trabalhofinal.LP3.entities.FornecedoresEntities;
import br.com.trabalhofinal.LP3.repositories.FornecedoresRepository;

@Service
public class FornecedoresService {

	@Autowired
	private FornecedoresRepository repository;
	
	@Autowired
	private CidadesService cidadesService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void deletarFuncionarios(Integer id) {
		repository.deleteById(id);
	}
	
	public FornecedoresDTO getFornecedoresbyId(Integer id) {
		Optional<FornecedoresEntities> fornecedores = repository.findById(id);
		
		FornecedoresDTO response = modelMapper.map(fornecedores.get(), FornecedoresDTO.class);
		
		return response;
	}
	
	public FornecedoresDTO create(FornecedoresDTO fornecedores) {
		FornecedoresEntities response = modelMapper.map(fornecedores, FornecedoresEntities.class);
		
		repository.save(response);
		
		FornecedoresDTO dto = modelMapper.map(response, FornecedoresDTO.class);
		
		return dto;
	}
	
	public FornecedoresDTO atualizar(FornecedoresDTO fornecedores) {
		FornecedoresEntities fornecedoresEntities = modelMapper.map(fornecedores, FornecedoresEntities.class);
		
		repository.save(fornecedoresEntities);
		
		FornecedoresDTO response = modelMapper.map(fornecedoresEntities, FornecedoresDTO.class);
		
		return response;
	}
	
	public List<FornecedoresResponseDTO> getAllFornecedores() {
		
		List<FornecedoresEntities> list = repository.findAll();
		
		List<FornecedoresResponseDTO> listClientes = populateCidade(list);
		
		return listClientes;
	}

	private List<FornecedoresResponseDTO> populateCidade(List<FornecedoresEntities> list) {
		List<FornecedoresResponseDTO> listresponse = new ArrayList<>();
		for (FornecedoresEntities entities : list) {
			FornecedoresResponseDTO response = new FornecedoresResponseDTO();
			response.setCNPJFor(entities.getCNPJFor());
			response.setCodigoCid(nomeCidade(entities.getCodigoCid()));
			response.setCodigoFor(entities.getCodigoFor());
			response.setEmailFor(entities.getEmailFor());
			response.setEnderecoFor(entities.getEnderecoFor());
			response.setNomeFor(entities.getNomeFor());
			response.setTelefoneFor(entities.getTelefoneFor());

			listresponse.add(response);
		}
		return listresponse;
	}
	
	private String nomeCidade(Integer id) {
		CidadesDTO cidades = cidadesService.getCidadeId(id);
		return cidades.getNome();
	}
}
