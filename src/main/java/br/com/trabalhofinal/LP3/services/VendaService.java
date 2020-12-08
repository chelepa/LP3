package br.com.trabalhofinal.LP3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.LP3.dto.Vendas.VendaRequestDTO;
import br.com.trabalhofinal.LP3.dto.Vendas.VendaResponseDTO;
import br.com.trabalhofinal.LP3.entities.VendaEntities;
import br.com.trabalhofinal.LP3.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ItensVendaService ItensService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FuncionariosService funcService;
	
	@Autowired
	private ClientesService cliService;
	
	public VendaRequestDTO create(VendaRequestDTO card) {
		
		VendaEntities entities = modelMapper.map(card, VendaEntities.class);
		
		VendaEntities responseEntities = repository.save(entities);
		
		VendaRequestDTO response = modelMapper.map(responseEntities, VendaRequestDTO.class);
		
		ItensService.createItensVenda(responseEntities.getCodigoVenda());
		
		return response;
	}
	
	public List<VendaResponseDTO> getAllVendas() {
		
		List<VendaEntities> responseEntities = repository.findAll();
		
		List<VendaResponseDTO> response = populateNomesClientesFornecedores(responseEntities);
		
		return response;
	}
	
	public VendaResponseDTO getVendasById(Integer id) {
		Optional<VendaEntities> responseEntities = repository.findById(id);
		VendaResponseDTO response = new VendaResponseDTO();
		response.setCodigoVenda(responseEntities.get().getCodigoVenda());
		response.setCodigoFunc(getNomeFunc(responseEntities.get().getCodigoFunc()));
		response.setCodigoCli(getNomeCli(responseEntities.get().getCodigoCli()));
		response.setDataVenda(responseEntities.get().getDataVenda());
		response.setValorTotalVenda(responseEntities.get().getValorTotalVenda());
		return response;
	}
	
	public void deleteVendas(Integer Id) {
		ItensService.deleteitensProductid(Id);
		repository.deleteById(Id);
	}

	private List<VendaResponseDTO> populateNomesClientesFornecedores(List<VendaEntities> responseEntities) {
		List<VendaResponseDTO> list = new ArrayList<VendaResponseDTO>();
		for (VendaEntities vendaResponseDTO : responseEntities) {
			VendaResponseDTO response = new VendaResponseDTO();
			response.setCodigoCli(getNomeCli(vendaResponseDTO.getCodigoCli()));
			response.setCodigoFunc(getNomeFunc(vendaResponseDTO.getCodigoFunc()));
			response.setCodigoVenda(vendaResponseDTO.getCodigoVenda());
			response.setDataVenda(vendaResponseDTO.getDataVenda());
			response.setValorTotalVenda(vendaResponseDTO.getValorTotalVenda());
			list.add(response);
		}
		return list;
	}

	private String getNomeFunc(Integer codigoFunc) {
		return funcService.getFuncionariosbyId(codigoFunc).getNomeFunc();
	}

	private String getNomeCli(Integer codigoCli) {
		return cliService.getClientbyId(codigoCli).getNomeCli();
	}
}
