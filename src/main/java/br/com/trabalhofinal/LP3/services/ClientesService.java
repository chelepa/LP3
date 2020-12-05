package br.com.trabalhofinal.LP3.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.clientes.ClientesDTO;
import br.com.trabalhofinal.LP3.entities.ClientesEntities;
import br.com.trabalhofinal.LP3.repositories.ClientesRepository;

import org.modelmapper.TypeToken;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ClientesDTO> getAllClientes() {
		
		List<ClientesEntities> list = repository.findAll();

		List<ClientesDTO>  listClientes = modelMapper.map(list, new TypeToken<List<ClientesDTO>>(){}.getType());
		
		return listClientes;
	}
	
}
