package com.grupo2.lucatinder;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServicioUsuario;

/**
 * 
 * @author Daniel Fernandez 
 *
 */

@SpringBootTest
class LucatinderTest2 {
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@Autowired
	
	private ServicioUsuario servicio;

	@Test
	void contextLoads() {
	}
	
	
	/**
	 * 
	 * Test para comprobar si se elimina un usuario
	 */	
	@Test
	void testBorrarUsuario() {
	    
		int id=servicio.listar().size();
		
		servicio.eliminarUsuario(id);
		
		
		logger.info("------------------------ Test borrado de Usuario");
	}

}
