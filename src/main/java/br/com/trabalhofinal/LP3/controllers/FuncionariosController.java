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

import br.com.trabalhofinal.LP3.dto.Clientes.ClientesDTO;
import br.com.trabalhofinal.LP3.dto.Funcionarios.FuncionariosDTO;
import br.com.trabalhofinal.LP3.dto.Funcionarios.FuncionariosResponseDTO;
import br.com.trabalhofinal.LP3.entities.CidadesEntities;
import br.com.trabalhofinal.LP3.services.CidadesService;
import br.com.trabalhofinal.LP3.services.FuncionariosService;

@Controller
public class FuncionariosController {

	@Autowired
	private FuncionariosService service;
	
	@Autowired
	private CidadesService cidadeService;
	
    @RequestMapping(value="/Funcionarios", method=RequestMethod.GET)
    public ModelAndView getAllFuncionarios(){
        ModelAndView mv = new ModelAndView("funcionarios/ListarFuncionarios");
        List<FuncionariosResponseDTO>  listClientes = service.getAllFuncionarios();
        mv.addObject("funcionarios", listClientes);
        return mv;
    }
    
	@GetMapping(value="/Funcionarios/Cadastro")
	public ModelAndView formCadastro(){
		ModelAndView mv = new ModelAndView("funcionarios/CadastroFuncionarios");
		List<CidadesEntities> listCidades = cidadeService.getAllCidades();
		mv.addObject("cidades", listCidades);
		return mv;
	}
	
	@PostMapping(value="/Funcionarios/Cadastro")
	public String form(@Valid FuncionariosDTO funcionarios, BindingResult result, RedirectAttributes attributes) throws ParseException{		
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Funcionarios/Cadastro";
		}
		service.create(funcionarios);
		return "redirect:/Funcionarios";
	}
	
    @RequestMapping(value="/Funcionarios/excluir", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Funcionarios");
		service.deletarFuncionarios(id);
		return modelAndView;
    }
    
	@RequestMapping(value="/Funcionarios/editar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("Funcionarios/EditarFuncionario");
	    FuncionariosDTO funcionario = service.getFuncionariosbyId(Id);
	    model.addAttribute("funcionario", funcionario);
	    List<CidadesEntities> listCidades = cidadeService.getAllCidades();
		mv.addObject("cidade", listCidades);
		return mv;
	 }
	
	@RequestMapping(value="/Funcionarios/editar", method= RequestMethod.POST)
	public String salvarAlteracao(@Valid FuncionariosDTO funcionarios, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Funcionarios/editar";
		}
		service.atualizar(funcionarios);
		return "redirect:/Funcionarios";
	}
}
