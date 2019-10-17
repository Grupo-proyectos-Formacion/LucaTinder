package com.grupo2.lucatinder.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServiceGenerico;

@Controller("/")
public class ControlUsuario {
	
	@Autowired
	private ServiceGenerico<Usuario> service;
	
	@GetMapping("/crear/usuario")
	public String crear(Usuario usuario){
		
		service.crear(usuario);
		
		return "/altaUsuario";
		
	}
	
	
}