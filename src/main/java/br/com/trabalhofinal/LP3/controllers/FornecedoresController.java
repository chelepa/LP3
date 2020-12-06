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

import br.com.trabalhofinal.LP3.dto.Fornecedores.FornecedoresDTO;
import br.com.trabalhofinal.LP3.dto.Fornecedores.FornecedoresResponseDTO;
import br.com.trabalhofinal.LP3.entities.CidadesEntities;
import br.com.trabalhofinal.LP3.services.CidadesService;
import br.com.trabalhofinal.LP3.services.FornecedoresService;

@Controller
public class FornecedoresController {

	@Autowired
	private FornecedoresService service;
	
	@Autowired
	private CidadesService cidadeService;
	
    @RequestMapping(value="/Fornecedores", method=RequestMethod.GET)
    public ModelAndView getAllClientes(){
        ModelAndView mv = new ModelAndView("Fornecedores/ListarFornecedores");
        List<FornecedoresResponseDTO>  listFornecedores = service.getAllFornecedores();
        mv.addObject("listFornecedores", listFornecedores);
        return mv;
    }
    
	@GetMapping(value="/Fornecedores/Cadastro")
	public ModelAndView formCadastro(){
		ModelAndView mv = new ModelAndView("Fornecedores/CadastroFornecedores");
		List<CidadesEntities> listCidades = cidadeService.getAllCidades();
		mv.addObject("cidades", listCidades);
		return mv;
	}
	
    @RequestMapping(value="/Fornecedores/excluir", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Fornecedores");
		service.deletarFuncionarios(id);
		return modelAndView;
    }
    
	@RequestMapping(value="/Fornecedores/editar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("fornecedores/EditarFornecedores");
	    FornecedoresDTO dto = service.getFornecedoresbyId(Id);
	    model.addAttribute("fornecedores", dto);
	    List<CidadesEntities> listCidades = cidadeService.getAllCidades();
		mv.addObject("cidade", listCidades);
		return mv;
	 }
	
	@PostMapping(value="/Fornecedores/Cadastro")
	public String form(@Valid FornecedoresDTO fornecedores, BindingResult result, RedirectAttributes attributes) throws ParseException{		
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Fornecedores/Cadastro";
		}
		service.create(fornecedores);
		return "redirect:/Fornecedores";
	}
	
	@RequestMapping(value="/Fornecedores/editar", method= RequestMethod.POST)
	public String salvarAlteracao(@Valid FornecedoresDTO fornecedores, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Fornecedores/editar";
		}
		service.atualizar(fornecedores);
		return "redirect:/Fornecedores";
	}
	
}
