/*package com.grupo2.lucatinder.control;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo2.lucatinder.model.Preferencia;
import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServicioUsuario;

@Controller
public class ControlPreferenciaRest {

	
	@Autowired
	private ServicioUsuario service;
	
	@PostMapping
	ResponseEntity<?> crearPreferencia(@RequestBody Preferencia preferencia){

		Preferencia pref = service.crear(pref);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getIdPreferencia())
				.toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
}
*/