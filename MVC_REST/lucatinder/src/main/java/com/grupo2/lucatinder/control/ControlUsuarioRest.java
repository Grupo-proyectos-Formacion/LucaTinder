package com.grupo2.lucatinder.control;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServicioUsuario;



/**
 * Clase ControlUsuarioRest
 *
 * Contiene métodos para Usuario
 *
 * @author Sisa,Daniel
 
 */
@RestController
@CrossOrigin(origins = "*")
public class ControlUsuarioRest {


	@Autowired
	private ServicioUsuario service;
	
	private int actualUsuario;
	
	ObjectMapper objectMapper = new ObjectMapper();

	private static final Logger logger = LoggerFactory.getLogger(ControlUsuarioRest.class);
	
	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	class UsuarioNotFoundException extends RuntimeException {

		public UsuarioNotFoundException() {
			super("This user does not exist");
		}
	}
	
	private Usuario usuarioSesion;
	
	/**
	 * Login Usuario  
	 * 
	 * @author Sisa Romero
	 * @return
	 *         <ul>
	 *         <li>Devuelve Usuario</li>
	 *         </ul>
	 */
	@PostMapping("/login/rest")
		public Usuario loginUsuario(@RequestBody String nombre) throws JsonMappingException, JsonProcessingException{
		logger.info("------ Logeando el usuario /REST ---------------");
		logger.info(nombre);
		String json = nombre;
		JsonNode jsonNode = objectMapper.readTree(json);
		String nombre2 = jsonNode.get("nombreUsuario").asText();				
		logger.info(nombre2);	
		Usuario  usuario= service.getByName(nombre2);
		if(usuario != null) {
            this.actualUsuario = usuario.getIdUsuario();
        }
		this.usuarioSesion = usuario;
        return usuario;
		}
	/**
	 * 
	 * Crear Usuario
	 * 
	 */	
	@PostMapping("/crear/usuario/rest")
	ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		System.out.println("--------------------------------------------------");
		System.out.println(usuario);
		Usuario result = service.crear(usuario);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getIdUsuario())
				.toUri();
		logger.info("-- -----Creando Usuario");
		return ResponseEntity.created(location).build();		
	}
		 
	@GetMapping("/get/session")
	public Usuario getSesion(){
		logger.info("--------Listando usuarios en Rest");
		return this.usuarioSesion;
	}
	
	
	@GetMapping("/listar/usuarios/rest")
	public List<Usuario> listar(){
		logger.info("--------Listando usuarios en Rest");
		return service.listar();
	}
	
	@GetMapping("/listar/posiblesMatches/rest/{id}")
	public List<Usuario> pedirPosiblesMatches(@PathVariable int id){
		logger.info("--------Listando posibles Mathes  en Rest -------");
		return service.pedirPosiblesMatches(service.getById(id));
	}	
	
	@GetMapping("/listar/pedirMatchesConfirmados/rest/{id}")
	public Set<Usuario> pedirMatchesConfirmados(@PathVariable int id){
		logger.info("--------Listando  Matches Confirmados  en Rest---------- ");
		return service.pedirMatchesConfirmados(service.getById(id));
	}
	
	
	@PostMapping("/tratarResultadoMatch/{id}")
	public void tratarResultadoMatch(@RequestBody Usuario usuario, @PathVariable int id) {			
		logger.info("--------Tratando resultados en Rest verificar-----------");
		service.tratarResultadoMatch(true,this.usuarioSesion, usuario);
	}
	/**
	 * Eliminar Usuario 
	 */
	@DeleteMapping("/eliminar/usuario/rest/{id}")
    void deleteById(@PathVariable int id){
        this.service.eliminarUsuario(id);
        logger.info("-------Eliminando Usuario en Rest");
        this.usuarioSesion = null;
	} 
	
	@PutMapping("/modificar/usuario")
	public Usuario editUsuario(@RequestBody Usuario usuario) {
		logger.info("-------Modificando Usuario en Rest");
		return service.modificarUsuario(usuario);
	}
	
	
}