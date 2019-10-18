/**
 * @author Julian Bautista
 * 
 * Servicio especifico de usuario implementa el servicio Generico
 * 
 * 
 * 
 */
package com.grupo2.lucatinder.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.grupo2.lucatinder.dao.DaoUsuario;
import com.grupo2.lucatinder.dao.DaoUsuarioCustomImpl;
import com.grupo2.lucatinder.model.Usuario;

@Service
@Transactional
@Component("servicioUsuario")
public class ServicioUsuario implements ServiceGenerico<Usuario>{
	
	@Autowired
	private DaoUsuario daoUsuario;

	@Override
	public Usuario crear(Usuario objeto) {
		return daoUsuario.save(objeto);
	}

	@Override
	public List<Usuario> listar() {
		return daoUsuario.findAll();
	}

	@Override
	public Usuario getById(int id) {
		return daoUsuario.getOne(id);
	}
	
	public void tratarResultadoMatch(boolean match, Usuario usuario) {
		daoUsuario.tratarResultadoMatch(match, usuario);
		
	}
	
	public List<Usuario> pedirPosiblesMatches(Usuario usuario) {
		return daoUsuario.pedirPosiblesMatches(usuario);
	}
	

}
