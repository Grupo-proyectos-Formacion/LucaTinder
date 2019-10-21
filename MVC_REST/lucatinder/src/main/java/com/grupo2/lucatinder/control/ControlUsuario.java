package com.grupo2.lucatinder.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServicioUsuario;

@Controller
public class ControlUsuario {
	
	
	@Autowired
	private ServicioUsuario service;
	

	private Usuario usuarioSesion;
	
	@GetMapping("/")
	public String login(Model model){
		List<Usuario> usuarios = service.listar();
		if(usuarios.size()<20) {
			service.poblar();
		} else System.out.println("Hay suficientes usuarios en la base de datos");
		
		if(usuarioSesion==null) {
			String usuario="";
			model.addAttribute("usuario",usuario);
			return "usuarios/login";
		}
		else {
			model.addAttribute("usuario", this.usuarioSesion);
			return "usuarios/usuario";
		}
	}
	
	@PostMapping("/login")
	public String tratarLogin(@RequestParam String usuario, Model model){
		System.out.println("NOMBRE DEL USUARIO: "+usuario);
		this.usuarioSesion = service.getByName(usuario);
		model.addAttribute("usuario",this.usuarioSesion);
		return "usuarios/usuario";
	}
	
	/*@GetMapping("/")
	public String index(Model model){
		List<Usuario> usuarios = service.listar();
		if(usuarios.size()<20) {
			service.poblar();
		} else System.out.println("Hay suficientes usuarios en la base de datos");
		model.addAttribute("usuario", new Usuario());
		return "usuarios/crearUsuario";
	}*/
	
	//*
	@GetMapping("/crear/usuario")
	public String crear(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuarios/crearUsuario";
	}
	//*
	@PostMapping("/crear/usuario")
	public String guardar(@ModelAttribute Usuario usuario, Model model){
		System.out.println(usuario);
		 model.addAttribute("usuario" , service.crear(usuario));
		return "/usuarios/usuario";
	}	
	//*
	@GetMapping("/listar/posiblesMatches/{id}")
	public String pedirPosiblesMatches(@PathVariable int id, Model model) {
		List<Usuario> lista = service.pedirPosiblesMatches(service.getById(id));
		model.addAttribute("usuarios", lista);
		return "usuarios/lista";
	}
	
	@GetMapping("/listar/tronista/{id}")
	public String perfilMatch(@PathVariable int id, Model model) {
		Usuario usuario = service.getById(id);
		String eleccion ="";
		model.addAttribute("tronista",usuario);
		model.addAttribute("eleccion",eleccion);
		return "usuarios/perfilMatch";
	}
	@PostMapping("/eleccion")
	public String trataResultadoMatch(
			@RequestParam(value = "id", required = false) String idTronista, 
			@RequestParam(value = "eleccion", required = false) String eleccion,
			Model model) {
		
		if(eleccion.equals("match")) { 
			System.out.println("Te mola?, ha. " );
			service.tratarResultadoMatch(true, this.usuarioSesion, service.getById(Integer.parseInt(idTronista)));
			}
		else if(eleccion.equals("rechazo")) { 
			System.out.println("No te mola huh?" ); 
			service.tratarResultadoMatch(false, this.usuarioSesion, service.getById(Integer.parseInt(idTronista)));
			}
		
		//System.out.println(tronista);
		System.out.println(model);
		System.out.println(eleccion + "Esta ha sido la eleccion");
		
		return "redirect:/";
	}
	
}
	