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

import com.grupo2.lucatinder.dao.DaoGenerico;
import com.grupo2.lucatinder.model.Usuario;

@Service
@Transactional
@Component("servicioUsuario")
public class ServicioUsuario implements ServiceGenerico<Usuario>{
	
	@Autowired
	@Qualifier("daoUsuario")
	private DaoGenerico<Usuario> daoUsuario;

	@Override
	public void crear(Usuario objeto) {
		daoUsuario.save(objeto);
		
	}

	@Override
	public List<Usuario> listar() {
		return daoUsuario.findAll();
	}
	
	

}
