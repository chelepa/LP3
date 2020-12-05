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

import br.com.trabalhofinal.LP3.dto.CidadesDTO;
import br.com.trabalhofinal.LP3.dto.ClientesDTO;
import br.com.trabalhofinal.LP3.dto.ClientesResponse;
import br.com.trabalhofinal.LP3.entities.CidadesEntities;
import br.com.trabalhofinal.LP3.services.CidadesService;
import br.com.trabalhofinal.LP3.services.ClientesService;

@Controller
public class ClientesController {
	
	@Autowired
	private ClientesService service;
	
	@Autowired
	private CidadesService cidadeService;

    @RequestMapping(value="/Clientes", method=RequestMethod.GET)
    public ModelAndView getAllClientes(){
        ModelAndView mv = new ModelAndView("clientes/ListarClientes");
        List<ClientesResponse>  listClientes = service.getAllClientes();
        mv.addObject("clientes", listClientes);
        return mv;
    }
    
	@GetMapping(value="/Clientes/Cadastro")
	public ModelAndView formCadastro(){
		ModelAndView mv = new ModelAndView("clientes/CadastroClientes");
		List<CidadesEntities> listCidades = cidadeService.getAllCidades();
		mv.addObject("cidades", listCidades);
		return mv;
	}
	
	@PostMapping(value="/Clientes/Cadastro")
	public String form(@Valid ClientesDTO clientes, BindingResult result, RedirectAttributes attributes) throws ParseException{		
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Clientes/Cadastro";
		}
		service.create(clientes);
		return "redirect:/Clientes";
	}
	
    @RequestMapping(value="/Clientes/excluir", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Clientes");
		service.deletarClientes(id);
		return modelAndView;
    }
    
	@RequestMapping(value="/Clientes/editar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("Clientes/EditarClientes");
	    ClientesDTO cliente = service.getClientbyId(Id);
	    model.addAttribute("cliente", cliente);
	    List<CidadesEntities> listCidades = cidadeService.getAllCidades();
		mv.addObject("cidade", listCidades);
		return mv;
	 }
	
	@RequestMapping(value="/Clientes/editar", method= RequestMethod.POST)
	public String salvarAlteracao(@Valid ClientesDTO clientes, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Clientes/editar";
		}
		service.atualizar(clientes);
		return "redirect:/Clientes";
	}
}
