package com.grupo2.lucatinder.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.grupo2.lucatinder.model.Preferencia;
import com.grupo2.lucatinder.service.ServicioPreferencia;

@Controller
public class ControlPreferencia{
	
	@Autowired
	private ServicioPreferencia service;
	
	@GetMapping("/crear/preferencia")
	public String crear(Model model){
		model.addAttribute("preferencia", new Preferencia());
		return "preferencias/crearPreferencia";
	}
	
	@PostMapping("/crear/preferencia")
	public String tratarCreacionPreferencia(@ModelAttribute Preferencia preferencia,Model model){
		System.out.println(preferencia);
		model.addAttribute("preferencia", service.crear(preferencia));
		return "preferencias/crearPreferencia";
	}

}
