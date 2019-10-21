package com.grupo2.lucatinder.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo2.lucatinder.dao.DaoPreferencia;
import com.grupo2.lucatinder.model.Preferencia;
import com.grupo2.lucatinder.service.ServicioPreferencia;
import com.grupo2.lucatinder.service.ServicioUsuarioImpl;

public class ControlPreferencia {


	
	@Autowired
	private ServicioPreferencia service;
	
	@Autowired
	private DaoPreferencia daoPreferencia;
	
	@Autowired
	 private ServicioUsuarioImpl serviceImpl;
	
	
	
	@GetMapping("/crear/preferencia")
	public String crear(Model model){
		model.addAttribute("preferencia", new Preferencia());
		return "usuarios/crearPreferencia";
	}
	
	@PostMapping("/crear/preferencia")
	public String tratarCreacionPreferencia(@ModelAttribute Preferencia preferencia,Model model){
		model.addAttribute("preferencia", service.crear(preferencia));
		return "usuarios/crearPreferencia";
	}
}
