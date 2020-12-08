package br.com.trabalhofinal.LP3.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trabalhofinal.LP3.dto.Clientes.ClientesResponse;
import br.com.trabalhofinal.LP3.dto.Funcionarios.FuncionariosResponseDTO;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardItensResponse;
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardVallResponseDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosResponseDTO;
import br.com.trabalhofinal.LP3.dto.Vendas.VendaDTO;
import br.com.trabalhofinal.LP3.dto.Vendas.VendaRequestDTO;
import br.com.trabalhofinal.LP3.dto.Vendas.VendaResponseDTO;
import br.com.trabalhofinal.LP3.entities.VendaEntities;
import br.com.trabalhofinal.LP3.services.ClientesService;
import br.com.trabalhofinal.LP3.services.FuncionariosService;
import br.com.trabalhofinal.LP3.services.ItensVendaService;
import br.com.trabalhofinal.LP3.services.ProdutosService;
import br.com.trabalhofinal.LP3.services.VendaService;


@Controller
public class VendasController {
	
	@Autowired
	private FuncionariosService FuncService;
	
	@Autowired
	private ClientesService cliService;
	
	@Autowired
	private ItensVendaService itensVendaService;
	
	@Autowired
	private VendaService service;

    @RequestMapping(value="/Vendas", method=RequestMethod.GET)
    public ModelAndView getAllProdutos(){
        ModelAndView mv = new ModelAndView("Venda/ListarVenda");
        List<VendaResponseDTO>  listVendas = service.getAllVendas();
        mv.addObject("vendas", listVendas);
        return mv;
    }
    
	@GetMapping(value="/Vendas/Cadastro")
	public ModelAndView formCadastro(){
		ModelAndView mv = new ModelAndView("Venda/CriarVenda");
        List<FuncionariosResponseDTO>  funcionarios = FuncService.getAllFuncionarios();
        mv.addObject("funcionarios", funcionarios);
        List<ClientesResponse>  clientes = cliService.getAllClientes();
        mv.addObject("clientes", clientes);
        CardItensResponse teste = itensVendaService.getItensCart();
        mv.addObject("itensCard", teste.getCardItens());
        mv.addObject("valorOrder", teste.getValorOrder());
		return mv;
	}
	
	@PostMapping(value="/Vendas/Cadastro")
	public String form(@Valid VendaRequestDTO card, BindingResult result, RedirectAttributes attributes) throws ParseException{		
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Vendas/Cadastro";
		}
		service.create(card);
		return "redirect:/Vendas";
	}
	
    @RequestMapping(value="/Vendas/excluir", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Vendas");
		service.deleteVendas(id);
		return modelAndView;
    }
    
	@RequestMapping(value="/Vendas/Visualizar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("Venda/EditarVenda");
	    VendaResponseDTO vendas = service.getVendasById(Id);
	    model.addAttribute("vendas", vendas);
	    List<CardVallResponseDTO> teste = itensVendaService.getItensOrderValor(Id);
		mv.addObject("listitensorder", teste);
		return mv;
	 }
}
