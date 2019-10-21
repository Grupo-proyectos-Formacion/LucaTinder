package com.grupo2.lucatinder.control;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServiceGenerico;


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
	private ServiceGenerico<Usuario> service;
	/**
	 * Crea un Usuario 
	 * 
	 * @return
	 *         <ul>
	 *         <li>ResponseEntity.created(location).build();</li>
	 *         </ul>
	 */
	@PostMapping
	ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		Usuario result = service.crear(usuario);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getIdUsuario())
				.toUri();
		return ResponseEntity.created(location).build();		
	}
		 
	@GetMapping("/listar/usuarios/rest")
	public List<Usuario> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/posiblesMatches/rest/{id}")
	public List<Usuario> pedirPosiblesMatches(@PathVariable int id){
		return service.pedirPosiblesMatches(service.getById(id));
	}
	
	@PostMapping("/tratarResultadoMatch/{match}")
	public void tratarResultadoMatch(@PathVariable boolean match) {
		service.tratarResultadoMatch(match);
	}
	
	
	
}