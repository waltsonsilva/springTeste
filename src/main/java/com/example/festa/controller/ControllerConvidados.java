package com.example.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.festa.model.Convidado;
import com.example.festa.repository.Convidados;

@Controller
public class ControllerConvidados {
	
	@Autowired
	private Convidados convidados;

	@GetMapping("/convidados")
	public ModelAndView listar() {
		ModelAndView modelAndview = new ModelAndView("/ListaConvidados");
		
		modelAndview.addObject("convidados", convidados.findAll());
		modelAndview.addObject(new Convidado());
		return modelAndview;
	}
	
	@PostMapping("/convidados")
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
}
