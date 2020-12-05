package br.com.trabalhofinal.LP3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.trabalhofinal.LP3.dto.clientes.ClientesDTO;
import br.com.trabalhofinal.LP3.services.ClientesService;

@Controller
public class ClientesController {
	
	@Autowired
	private ClientesService service;

    @RequestMapping(value="/Clientes", method=RequestMethod.GET)
    public ModelAndView getAllClientes(){
        ModelAndView mv = new ModelAndView("clientes/ListarClientes");
        List<ClientesDTO>  listClientes = service.getAllClientes();
        System.out.println(listClientes.get(0).getCPFCli());
        mv.addObject("clientes", listClientes);
        return mv;
    }
}
