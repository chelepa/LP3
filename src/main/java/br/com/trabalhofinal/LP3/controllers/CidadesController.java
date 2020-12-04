package br.com.trabalhofinal.LP3.controllers;


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

import br.com.trabalhofinal.LP3.dto.CidadesDTO;
import br.com.trabalhofinal.LP3.entities.CidadesEntities;
import br.com.trabalhofinal.LP3.services.CidadesService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CidadesController {
	
	@Autowired
	private CidadesService service;
	
	@GetMapping(value="/Cidade/Cadastro")
	public String formCadastro(){
		return "cidades/CidadesCadastro";
	}
	
	@RequestMapping(value="/Cidade/editar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("cidades/EditarCidades");
		CidadesDTO cidadeModel = service.getCidadeId(Id);
		model.addAttribute("cidade", cidadeModel);
	    return mv;
	 }
	
	@RequestMapping(value="/Cidade/salvarAlteracao", method= RequestMethod.POST)
	public String salvarAlteracao(@Valid CidadesDTO cidade, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Cidade/editar";
		}
		service.atualizarCidade(cidade);
		return "redirect:/Cidades";
	}
	
	@PostMapping(value="/Cidade/Cadastro")
	public String form(@Valid CidadesDTO cidade, BindingResult result, RedirectAttributes attributes){		
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Cidade/Cadastro";
		}
		service.create(cidade);
		return "redirect:/Cidades";
	}
	
    @RequestMapping(value="/Cidades", method=RequestMethod.GET)
    public ModelAndView getCidades(){
        ModelAndView mv = new ModelAndView("cidades/ListarCidades");
        List<CidadesEntities> cidades = service.getAllCidades();
        mv.addObject("cidades", cidades);
        return mv;
    }
    
    @RequestMapping(value="/Cidades/excluir", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Cidades");
		service.DeletarCidade(id);
		return modelAndView;
    }	
}