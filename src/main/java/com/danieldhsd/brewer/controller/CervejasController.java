package com.danieldhsd.brewer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.danieldhsd.brewer.controller.page.PageWrapper;
import com.danieldhsd.brewer.dto.CervejaDTO;
import com.danieldhsd.brewer.enumeration.Origem;
import com.danieldhsd.brewer.enumeration.Sabor;
import com.danieldhsd.brewer.model.Cerveja;
import com.danieldhsd.brewer.repository.Cervejas;
import com.danieldhsd.brewer.repository.Estilos;
import com.danieldhsd.brewer.repository.filter.CervejaFilter;
import com.danieldhsd.brewer.service.CadastroCervejaService;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	@Autowired
	private Cervejas cervejas;
	
	@RequestMapping(path = "/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		
		return mv;
	}
	
	@RequestMapping(path = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(cerveja);
		}
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		cadastroCervejaService.salvar(cerveja);
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult bindingResult, 
			@PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		
		PageWrapper<Cerveja> paginaWrapper = new PageWrapper<>(cervejas.filtrar(cervejaFilter, pageable),
																httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}
	
	@GetMapping("/filtro")
	public @ResponseBody List<CervejaDTO> pesquisar(String skuOuNome) {
		return cervejas.porSkuOuNome(skuOuNome);
	}
}
