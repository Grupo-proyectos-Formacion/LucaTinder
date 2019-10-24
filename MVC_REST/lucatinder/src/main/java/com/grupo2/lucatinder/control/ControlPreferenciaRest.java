package com.grupo2.lucatinder.control;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.lucatinder.model.Preferencia;
import com.grupo2.lucatinder.service.ServicioPreferencia;

@RestController
@CrossOrigin(origins = "*")
public class ControlPreferenciaRest {

	
	@Autowired
	private ServicioPreferencia service;
	
	/*@PostMapping
	ResponseEntity<?> crearPreferencia(@RequestBody Preferencia preferencia){

		Preferencia pref = service.crear(pref);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getIdPreferencia())
				.toUri();
		return ResponseEntity.created(location).build();		
	}*/
	
	@GetMapping("/listar/todas/preferencias/rest")
	public List<Preferencia> listarPreferencias(){
		return service.listar();
	}
	
	
}
