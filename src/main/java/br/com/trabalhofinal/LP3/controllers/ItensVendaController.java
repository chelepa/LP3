package br.com.trabalhofinal.LP3.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trabalhofinal.LP3.dto.ItensVenda.CardRequestDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosResponseDTO;
import br.com.trabalhofinal.LP3.services.ItensVendaService;
import br.com.trabalhofinal.LP3.services.ProdutosService;

@Controller
public class ItensVendaController {
	
	@Autowired
	private ProdutosService prdService;
	
	@Autowired
	private ItensVendaService itensVendaService;

	@GetMapping(value="/Vendas/Card")
	public ModelAndView formCadastroCard(){
		ModelAndView mv = new ModelAndView("ItensVenda/AdionarProdutos");
		List<ProdutosResponseDTO> listprodutos = prdService.getAllProdutos();
		mv.addObject("produtos", listprodutos);
		return mv;
	}
	
	@PostMapping(value="/Vendas/Card")
	public String forCarrinho(@Valid CardRequestDTO card, BindingResult result, RedirectAttributes attributes) throws ParseException{		
		itensVendaService.populateItensVenda(card);
		return "redirect:/Vendas/Cadastro";
	}
	
    @RequestMapping(value="/Vendas/ExcluiItemId", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Vendas/Cadastro");
    	itensVendaService.deleteItemList(id);
		return modelAndView;
    }
}
