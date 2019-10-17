package com.grupo2.lucatinder.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServiceGenerico;

@Controller("/")
public class ControlUsuario {
	
	@Autowired
	private ServiceGenerico<Usuario> service;
	
	@GetMapping("/crear/usuario")
	public String crear(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuarios/crearUsuario";
		
	}
	
	@PostMapping("/crear/usuario")
	public String guardar(@ModelAttribute Usuario usuario){
		System.out.println(usuario);
		service.crear(usuario);
		return "/altaUsuario";
		
	}
	
	
}