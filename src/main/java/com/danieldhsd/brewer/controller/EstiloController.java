package com.danieldhsd.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.danieldhsd.brewer.model.Estilo;
import com.danieldhsd.brewer.service.CadastroEstiloService;

@Controller
public class EstiloController {
	
	@Autowired
	private CadastroEstiloService cadastroEstiloService;

	@RequestMapping(path = "/estilos/novo")
	public ModelAndView novo(Estilo estilo) {
		return new ModelAndView("estilo/CadastroEstilo");
	}
	
	@RequestMapping(path = "/estilos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(estilo);
		}
		
		cadastroEstiloService.salvar(estilo);
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso");
		return new ModelAndView("redirect:/estilos/novo");
	}
}
