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
import br.com.trabalhofinal.LP3.dto.Fornecedores.FornecedoresResponseDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosResponseDTO;
import br.com.trabalhofinal.LP3.services.FornecedoresService;
import br.com.trabalhofinal.LP3.services.ProdutosService;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutosService service;
	
	@Autowired
	private FornecedoresService fornecedoresService;
	
    @RequestMapping(value="/Produtos", method=RequestMethod.GET)
    public ModelAndView getAllProdutos(){
        ModelAndView mv = new ModelAndView("produtos/ListarProdutos");
        List<ProdutosResponseDTO>  listprodutos = service.getAllProdutos();
        mv.addObject("produtos", listprodutos);
        return mv;
    }
    
	@GetMapping(value="/Produtos/Cadastro")
	public ModelAndView formCadastro(){
		ModelAndView mv = new ModelAndView("produtos/CadastroProdutos");
		List<FornecedoresResponseDTO> listFornecedores = fornecedoresService.getAllFornecedores();
		mv.addObject("fornecedores", listFornecedores);
		return mv;
	}
	
	@PostMapping(value="/Produtos/Cadastro")
	public String form(@Valid ProdutosDTO produtos, BindingResult result, RedirectAttributes attributes) throws ParseException{		
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Produtos/Cadastro";
		}
		service.create(produtos);
		return "redirect:/Produtos";
	}
	
    @RequestMapping(value="/Produtos/excluir", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Produtos");
		service.deletarProdutos(id);
		return modelAndView;
    }
    
	@RequestMapping(value="/Produtos/editar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("produtos/EditarProdutos");
	    ProdutosDTO produtos = service.getProdutosbyId(Id);
	    model.addAttribute("produtos", produtos);
		List<FornecedoresResponseDTO> listFornecedores = fornecedoresService.getAllFornecedores();
		mv.addObject("fornecedores", listFornecedores);
		return mv;
	 }
	
	@RequestMapping(value="/Produtos/editar", method= RequestMethod.POST)
	public String salvarAlteracao(@Valid ProdutosDTO produtos, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Produtos/editar";
		}
		service.atualizar(produtos);
		return "redirect:/Produtos";
	}
}
