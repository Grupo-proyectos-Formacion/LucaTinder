package com.grupo2.lucatinder.control;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServicioGenerico;
import com.grupo2.lucatinder.service.ServicioUsuario;



/**
 * Clase ControlUsuarioRest
 *
 * Contiene métodos para Usuario
 *
 * @author Sisa,
 
 */


@RestController
public class ControlUsuarioRest {


	@Autowired
	private ServicioUsuario service;

	private static final Logger logger = LoggerFactory.getLogger(ControlUsuarioRest.class);
	
	/**
	 * Crea un Usuario 
	 * 
	 * @return
	 *         <ul>
	 *         <li>ResponseEntity.created(location).build();</li>
	 *         </ul>
	 */
	
	private Usuario usuarioSesion;
	

	@GetMapping("/login/rest/{name}")
	public Usuario loginUsuario(@PathVariable String nombre){	
		Usuario us= service.getByName(nombre);
		logger.info("-- Logeando el usuario --");
		return us;
	}
		
	
	@PostMapping("/crear/usuario/rest")
	ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		this.usuarioSesion = service.getById(72);
		Usuario result = service.crear(usuario);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getIdUsuario())
				.toUri();
		logger.info("-- Creando Usuario");
		return ResponseEntity.created(location).build();		
	}
		 

	
	@GetMapping("/listar/usuarios/rest")
	public List<Usuario> listar(){
		logger.info("--Listando usuarios");
		return service.listar();
	}
	
	@GetMapping("/listar/posiblesMatches/rest/{id}")
	public List<Usuario> pedirPosiblesMatches(@PathVariable int id){
		return service.pedirPosiblesMatches(service.getById(id));
	}
	
	@PostMapping("/tratarResultadoMatch/{posibleMatch}")
	public void tratarResultadoMatch(@RequestBody Usuario usuario, @PathVariable boolean posibleMatch) {
		service.tratarResultadoMatch(posibleMatch, this.usuarioSesion, usuario);
	}
	
	
	@DeleteMapping("/eliminar/usuario/rest/{id}")
    void deleteById(@PathVariable int id){
        this.service.eliminarUsuario(id);
        logger.info("-- Eliminando Usuario en Rest");
	} 
	
	
	
}