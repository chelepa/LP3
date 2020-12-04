package br.com.trabalhofinal.LP3.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.CidadesDTO;
import br.com.trabalhofinal.LP3.entities.CidadesEntities;
import br.com.trabalhofinal.LP3.repositories.CidadesRepository;

@Service
public class CidadesService {
	
	@Autowired
	private CidadesRepository cidadesRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CidadesEntities create(CidadesDTO request) {
		
		CidadesEntities cidadesEntities = modelMapper.map(request, CidadesEntities.class);

		cidadesRepository.save(cidadesEntities);
		
		return cidadesEntities;
	}
	
	public CidadesDTO atualizarCidade(CidadesDTO request) {
		CidadesEntities cidade = modelMapper.map(request, CidadesEntities.class);
		
		cidadesRepository.save(cidade);
		
		CidadesDTO Dto = modelMapper.map(cidade, CidadesDTO.class);
		
		return Dto;
	}
	
	public List<CidadesEntities> getAllCidades() {
		return cidadesRepository.findAll();
	}
	
	public void DeletarCidade(Integer Id) {
		cidadesRepository.deleteById(Id);
	}
	
	public CidadesDTO getCidadeId(Integer Id) {
		
		Optional<CidadesEntities> cidadesEntities = cidadesRepository.findById(Id);
		
		CidadesDTO cidades = modelMapper.map(cidadesEntities.get(), CidadesDTO.class);
		
		return cidades;
	}

}
