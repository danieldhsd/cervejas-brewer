package com.danieldhsd.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.danieldhsd.brewer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(Cerveja cerveja) {
		System.out.println("SKU: " + cerveja.getSku());
		System.out.println(">>>>>Cadastro<<<<<<");
		return "cerveja/CadastroCerveja";
	}
}
