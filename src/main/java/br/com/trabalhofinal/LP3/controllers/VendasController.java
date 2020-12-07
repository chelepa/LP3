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
import br.com.trabalhofinal.LP3.dto.ItensVenda.CardResponseDTO;
import br.com.trabalhofinal.LP3.dto.Produtos.ProdutosDTO;
import br.com.trabalhofinal.LP3.dto.Vendas.ValorTotalOrderDTO;
import br.com.trabalhofinal.LP3.services.ClientesService;
import br.com.trabalhofinal.LP3.services.FuncionariosService;
import br.com.trabalhofinal.LP3.services.ItensVendaService;
import br.com.trabalhofinal.LP3.services.ProdutosService;


@Controller
public class VendasController {
		
	@Autowired
	private ProdutosService prdService;
	
	@Autowired
	private FuncionariosService FuncService;
	
	@Autowired
	private ClientesService cliService;
	
	@Autowired
	private ItensVendaService itensVendaService;

    @RequestMapping(value="/Vendas", method=RequestMethod.GET)
    public ModelAndView getAllProdutos(){
        ModelAndView mv = new ModelAndView("Venda/ListarVenda");
//        List<ProdutosResponseDTO>  listprodutos = service.getAllProdutos();
//        mv.addObject("produtos", listprodutos);
        return mv;
    }
    
	@GetMapping(value="/Vendas/Cadastro")
	public ModelAndView formCadastro(){
		ModelAndView mv = new ModelAndView("Venda/CriarVenda");
        List<FuncionariosResponseDTO>  funcionarios = FuncService.getAllFuncionarios();
        mv.addObject("funcionarios", funcionarios);
        List<ClientesResponse>  clientes = cliService.getAllClientes();
        mv.addObject("clientes", clientes);
        List<CardResponseDTO> teste = itensVendaService.getItensCart();
        mv.addObject("itensCard", teste);
		return mv;
	}
	
	@PostMapping(value="/Vendas/Cadastro")
	public String form(@Valid ProdutosDTO produtos, BindingResult result, RedirectAttributes attributes) throws ParseException{		
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			System.out.println(msg);
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Produtos/Cadastro";
		}
//		service.create(produtos);
		return "redirect:/Produtos";
	}
	
    @RequestMapping(value="/Vendas/excluir", method= RequestMethod.POST)
    public ModelAndView excluir(@RequestParam("id") Integer id){
    	ModelAndView modelAndView = new ModelAndView("redirect:/Vendas");
//		service.deletarProdutos(id);
		return modelAndView;
    }
    
	@RequestMapping(value="/Vendas/editar", method= RequestMethod.GET)
	public ModelAndView editarCadastro(@RequestParam("id") Integer Id, Model model) {	
	    ModelAndView mv = new ModelAndView("Venda/EditarVenda");
//	    ProdutosDTO produtos = service.getProdutosbyId(Id);
//	    model.addAttribute("produtos", produtos);
//		List<FornecedoresResponseDTO> listFornecedores = fornecedoresService.getAllFornecedores();
//		mv.addObject("fornecedores", listFornecedores);
		return mv;
	 }
	
	@RequestMapping(value="/Vendas/editar", method= RequestMethod.POST)
	public String salvarAlteracao(@Valid ProdutosDTO produtos, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			List<String> msg = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				msg.add(error.getDefaultMessage());
			}
			attributes.addFlashAttribute("mensagem", msg);
			return "redirect:/Venda/EditarVenda";
		}
//		service.atualizar(produtos);
		return "redirect:/Vendas";
	}
}
