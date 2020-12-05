package br.com.trabalhofinal.LP3.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.CidadesDTO;
import br.com.trabalhofinal.LP3.dto.ClientesDTO;
import br.com.trabalhofinal.LP3.dto.ClientesResponse;
import br.com.trabalhofinal.LP3.entities.CidadesEntities;
import br.com.trabalhofinal.LP3.entities.ClientesEntities;
import br.com.trabalhofinal.LP3.repositories.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository repository;
	
	@Autowired
	private CidadesService cidadesService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ClientesResponse> getAllClientes() {
		
		List<ClientesEntities> list = repository.findAll();
		
		List<ClientesResponse> listClientes = populateCidade(list);
		
		return listClientes;
	}
	
	public void deletarClientes(Integer id) {
		repository.deleteById(id);
	}
	
	public ClientesDTO getClientbyId(Integer id) {
		Optional<ClientesEntities> cliente = repository.findById(id);
		
		ClientesDTO response = modelMapper.map(cliente.get(), ClientesDTO.class);
		
		return response;
	}
	
	public ClientesDTO create(ClientesDTO clientes) {
		ClientesEntities clientesEntities = modelMapper.map(clientes, ClientesEntities.class);
		
		repository.save(clientesEntities);
		
		ClientesDTO response = modelMapper.map(clientesEntities, ClientesDTO.class);
		
		return response;
	}
	
	public ClientesDTO atualizar(ClientesDTO request) {
		ClientesEntities cliente = modelMapper.map(request, ClientesEntities.class);
		
		repository.save(cliente);
		
		ClientesDTO Dto = modelMapper.map(cliente, ClientesDTO.class);
		
		return Dto;
	}
	
	public List<ClientesResponse> populateCidade(List<ClientesEntities> list) {
		List<ClientesResponse> listresponse = new ArrayList<>();
		ClientesResponse cliente = new ClientesResponse();
		for (ClientesEntities clientesEntities : list) {
			cliente.setCodigoCid(nomeCidade(clientesEntities.getCodigoCid()));
			cliente.setCodigoCli(clientesEntities.getCodigoCli());
			cliente.setCPFCli(clientesEntities.getCPFCli());
			cliente.setDataNCli(clientesEntities.getDataNCli());
			cliente.setEmailCli(clientesEntities.getEmailCli());
			cliente.setEnderecoCli(clientesEntities.getEnderecoCli());
			cliente.setNomeCli(clientesEntities.getNomeCli());
			cliente.setTelefoneCli(clientesEntities.getTelefoneCli());
			listresponse.add(cliente);
		}
		return listresponse;
	}
	
	public String nomeCidade(Integer id) {
		CidadesDTO cidades = cidadesService.getCidadeId(id);
		return cidades.getNome();
	}
}