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
 * Test
 * 
 * @author Sisa romero
 * 
 * 
 * Pruebas Unitarias
 */

@SpringBootTest
class LucatinderApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@Autowired
	
	private ServicioUsuario servicio;

	@Test
	void contextLoads() {
	}
	
	/**
	 * TestAñadirUsuario
	 * 
	 *
	 * Test para saber si un Usuario se crea correctamente
	 * 
	 * 
	 */	
	@Test
	void TestAñadirUsuario() {
	    
		int inicio=servicio.listar().size();
		
		Usuario user = new Usuario("Maria","Madrid",1,"Soy un prueba unitaria",true);
		servicio.crear(user);
		
		int siguiente=servicio.listar().size();
		
		
		
		assertEquals(inicio, siguiente);
		logger.info("------------------------ Test creación de Usuario");
	}

}
