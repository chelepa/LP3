package br.com.trabalhofinal.LP3.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trabalhofinal.LP3.dto.Estoque.EstoqueDTO;
import br.com.trabalhofinal.LP3.dto.Estoque.EstoqueResponseDTO;
import br.com.trabalhofinal.LP3.dto.Fornecedores.FornecedoresResponseDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosResponseDTO;
import br.com.trabalhofinal.LP3.services.EstoqueService;
import br.com.trabalhofinal.LP3.services.ProdutosService;

@Controller
public class EstoqueController {

	@Autowired
	private EstoqueService service;
	
	@Autowired
	private ProdutosService prdService;
	
    @RequestMapping(value="/Estoque", method=RequestMethod.GET)
    public ModelAndView getAllProdutos(){
        ModelAndView mv = new ModelAndView("estoque/ListarEstoque");
        List<EstoqueResponseDTO>  estoque = service.findAllEstoque();
        mv.addObject("estoques", estoque);
        return mv;
    }
    
	@RequestMapping(value="/Estoque/editar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("estoque/EditarEstoque");
	    EstoqueDTO estoque = service.findEstoqueByID(Id);
	    model.addAttribute("estoque", estoque);
	    ProdutosDTO prd = prdService.getProdutosbyId(estoque.getProduto());
	    model.addAttribute("produtos", prd);
		return mv;
	 }
	
	@RequestMapping(value="/Estoque/editar", method= RequestMethod.POST)
	public String salvarAlteracao(@Valid EstoqueDTO request, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Estoque/EditarEstoque";
		}
		service.update(request);
		return "redirect:/Estoque";
	}
	
}
