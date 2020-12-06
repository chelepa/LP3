package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.Cidades.CidadesDTO;
import br.com.trabalhofinal.LP3.dto.Funcionarios.FuncionariosDTO;
import br.com.trabalhofinal.LP3.dto.Funcionarios.FuncionariosResponseDTO;
import br.com.trabalhofinal.LP3.entities.FuncionariosEntities;
import br.com.trabalhofinal.LP3.repositories.FuncionariosRepository;

@Service
public class FuncionariosService {
	
	@Autowired
	private FuncionariosRepository repository;
	
	@Autowired
	private CidadesService cidadesService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<FuncionariosResponseDTO> getAllFuncionarios() {
		
		List<FuncionariosEntities> list = repository.findAll();
		
		List<FuncionariosResponseDTO> listClientes = populateCidade(list);
		
		return listClientes;
	}
	
	public void deletarFuncionarios(Integer id) {
		repository.deleteById(id);
	}
	
	public FuncionariosDTO getFuncionariosbyId(Integer id) {
		Optional<FuncionariosEntities> funcionarios = repository.findById(id);
		
		FuncionariosDTO response = modelMapper.map(funcionarios.get(), FuncionariosDTO.class);
		
		return response;
	}
	
	public FuncionariosDTO create(FuncionariosDTO funcionarios) {
		FuncionariosEntities funcionariosEntities = modelMapper.map(funcionarios, FuncionariosEntities.class);
		
		repository.save(funcionariosEntities);
		
		FuncionariosDTO response = modelMapper.map(funcionariosEntities, FuncionariosDTO.class);
		
		return response;
	}
	
	public FuncionariosDTO atualizar(FuncionariosDTO funcionarios) {
		FuncionariosEntities funcionariosEntities = modelMapper.map(funcionarios, FuncionariosEntities.class);
		
		repository.save(funcionariosEntities);
		
		FuncionariosDTO response = modelMapper.map(funcionariosEntities, FuncionariosDTO.class);
		
		return response;
	}
	
	private List<FuncionariosResponseDTO> populateCidade(List<FuncionariosEntities> list) {
		List<FuncionariosResponseDTO> listresponse = new ArrayList<>();
		for (FuncionariosEntities funcionariosEntities : list) {
			FuncionariosResponseDTO funcionario = new FuncionariosResponseDTO();
			funcionario.setCodigoCid(nomeCidade(funcionariosEntities.getCodigoCid()));
			funcionario.setCodigoFunc(funcionariosEntities.getCodigoFunc());
			funcionario.setCPFFunc(funcionariosEntities.getCPFFunc());
			funcionario.setDataNFunc(funcionariosEntities.getDataNFunc());
			funcionario.setEmailFunc(funcionariosEntities.getEmailFunc());
			funcionario.setEnderecoFunc(funcionariosEntities.getEnderecoFunc());
			funcionario.setNomeFunc(funcionariosEntities.getNomeFunc());
			funcionario.setSalarioFunc(funcionariosEntities.getSalarioFunc());
			funcionario.setTelefoneFunc(funcionariosEntities.getTelefoneFunc());
			listresponse.add(funcionario);
		}
		return listresponse;
	}
	
	private String nomeCidade(Integer id) {
		CidadesDTO cidades = cidadesService.getCidadeId(id);
		return cidades.getNome();
	}

}
