package com.grupo2.lucatinder.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServiceGenerico;

@Controller
public class ControlUsuario {
	
	@Autowired
	private ServiceGenerico<Usuario> service;
	
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuarios/crearUsuario";
	}
	
	@GetMapping("/crear/usuario")
	public String crear(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuarios/crearUsuario";
	}
	
	@PostMapping("/crear/usuario")
	public String guardar(@ModelAttribute Usuario usuario, Model model){
		System.out.println(usuario);
		 model.addAttribute("usuario" , service.crear(usuario));
		return "/usuarios/usuario";
	}
	
	@GetMapping("/listar/usuarios")
	public String listar(Model model) {
		List<Usuario> lista = service.listar();
		model.addAttribute("usuarios", lista);
		return "/index";
	}
	
	@GetMapping("/listar/posiblesMatches/{id}")
	public String pedirPosiblesMatches(@PathVariable int id, Model model) {
		List<Usuario> lista = service.pedirPosiblesMatches(service.getById(id));
		model.addAttribute("usuarios", lista);
		return "usuarios/lista";
	}
	
	@GetMapping("/listar/tronista/{id}")
	public String perfilMatch(@PathVariable int id, Model model) {
		Usuario usuario = service.getById(id);
		model.addAttribute("usuario", usuario);
		int elec=1;
		model.addAttribute("resultado", elec);
		return "usuarios/perfilMatch";
	}
	
	@PostMapping("/eleccion")
	public void trataResultadoMatch(@ModelAttribute int resultado,@ModelAttribute Usuario tronista) {
		if(resultado!=0) { System.out.println("Le has dado like a "+ tronista.getNombreUsuario());}
		else { System.out.println("No te gusta "+ tronista.getNombreUsuario()); }
	}
	
}
	