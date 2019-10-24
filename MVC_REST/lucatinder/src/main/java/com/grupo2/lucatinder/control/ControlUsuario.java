package com.grupo2.lucatinder.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo2.lucatinder.model.Preferencia;
import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServicioPreferencia;
import com.grupo2.lucatinder.service.ServicioUsuario;

/**
 * 
 * @author Daniel, Sisa, Julian, Luis
 *
 */


@Controller
public class ControlUsuario {
	
	
	@Autowired
	private ServicioUsuario service;
	
	@Autowired
	private ServicioPreferencia servicePreferencia;
	
	private Usuario usuarioSesion;
	
	@GetMapping("/")
	public String login(Model model){ 
		List<Usuario> usuarios = service.listar();
		if(usuarios.size()<20) {
			service.poblar();
		} else System.out.println("Hay suficientes usuarios en la base de datos");
		
		System.out.println(System.getProperty("file.encoding"));
		
		if(usuarioSesion==null) {
			String usuario="";
			usuarioSesion = new Usuario();
			model.addAttribute("usuario2", usuarioSesion);
			model.addAttribute("usuario",usuario);
			return "usuarios/index";
		}
		else {
			model.addAttribute("usuario", this.usuarioSesion);
			return "usuarios/usuario";
		}
	}
	
	@GetMapping("/login")
	public String tratarLoginGet(Model model){
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String tratarLogin(@RequestParam String usuario, Model model){
		this.usuarioSesion = service.getByName(usuario);
		model.addAttribute("usuario",this.usuarioSesion);
		return "usuarios/usuario";
	}
	
	
	@GetMapping("/crear/usuario")
	public String crear(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuarios/crearUsuario";
	}
	
	@PostMapping("/crear/usuario")
	public String guardar(@ModelAttribute Usuario usuario, Model model){
		//System.out.println(usuario);
		 model.addAttribute("usuario" , service.crear(usuario));
		 this.usuarioSesion = usuario;
		return "/usuarios/usuario";
	}	
	
	@GetMapping("/listar/posiblesMatches/{id}")
	public String pedirPosiblesMatches(@PathVariable int id, Model model) {
		List<Usuario> lista = service.pedirPosiblesMatches(service.getById(id));
		String eleccion ="";
		model.addAttribute("usuarios", lista);
		model.addAttribute("eleccion",eleccion);
		return "usuarios/lista";
	}
	
	@GetMapping("/listar/matches")
	public String listarMatchesConfirmados(Model model) {
		List<Usuario> matches = service.pedirMatchesConfirmados(this.usuarioSesion);
		System.out.println("-------------------IMPRIMIENDO-MATCHES------------------------");
		System.out.println(matches);
		model.addAttribute("usuarios", matches);
		return "usuarios/lista";
	}
	
	
	@GetMapping("/listar/tronista/{id}")
	public String perfilMatch(@PathVariable int id, Model model) {
		Usuario usuario = service.getById(id);
		String eleccion ="";
		model.addAttribute("tronista",usuario);
		model.addAttribute("eleccion",eleccion);
		System.out.println(usuario.getImagenUsuario());
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
		
		return "redirect:/listar/posiblesMatches/"+this.usuarioSesion.getIdUsuario();
	}
	
	
	/* ESTA ES UNA MEJORA DEL METODO DE ARRIBA, PERO AIGUE SIN FUNCIONAR*
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
		
	
		System.out.println(model);
		System.out.println(eleccion + "Esta ha sido la eleccion");
		int idTronistaActual = Integer.parseInt(idTronista);
		
		return "redirect:/listar/tronista/"+(idTronistaActual++);
	}
	 */
	
	@GetMapping("/confirmaEliminaUsuario")
	public String confirmaEliminaUsuario(Model model) {
		model.addAttribute("usuario", this.usuarioSesion);
		return "usuarios/confirmarEliminaUsuario";
	}
	
	@GetMapping("/eliminarUsuario")
	public String eliminarUsuario() {
		System.out.println(this.usuarioSesion.getIdUsuario());
		if(usuarioSesion != null) {
			System.out.println(this.usuarioSesion.getIdUsuario());
			service.eliminar(this.usuarioSesion.getIdUsuario());
			usuarioSesion=null;
		}else {
			System.out.println("vacio");
		}
		return "redirect:/";
	}
	
	@GetMapping("/editar")
	public String editUser(Model model) {
		model.addAttribute("usuario", this.usuarioSesion);
		return "/usuarios/crearUsuario";
	}
	
	@GetMapping("/preferencia")
	public String darPreferencia(Model model) {

		String idPreferencia="";
		model.addAttribute("idPreferencia", idPreferencia);
		model.addAttribute("preferencias", servicePreferencia.listar());
		System.out.println(servicePreferencia.listar());
		return "/usuarios/preferenciaUsuario";
	}
	
	@PostMapping("/preferencia")
	public String tratarDarPreferencia(@RequestParam String idPreferencia,Model model) {
		Preferencia preferencia = servicePreferencia.getById(Integer.parseInt(idPreferencia));
		//this.usuarioSesion.addPreferenciaUsuario(preferencia);
		List<Preferencia> preferencias = null;
		if(usuarioSesion.getPreferenciaUsuario() == null) {
			preferencias = new ArrayList<>();
		} else preferencias = usuarioSesion.getPreferenciaUsuario();
		
		preferencias.add(preferencia);
		this.usuarioSesion.setPreferenciaUsuario(preferencias);
		System.out.println("------  "+usuarioSesion);
		System.out.println("------  "+usuarioSesion.getPreferenciaUsuario());		
		
		service.crear(this.usuarioSesion);
		
		//this.usuarioSesion.setPreferenciaUsuario(preferencias);
		System.out.println("LISTA DE PREFERENCIAS DE USUARIO: "+this.usuarioSesion.getPreferenciaUsuario());
		model.addAttribute("usuario", this.usuarioSesion);
		return "/usuarios/usuario";
		}
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion() {
		this.usuarioSesion = null;
		return "redirect:/";
	}

}
	