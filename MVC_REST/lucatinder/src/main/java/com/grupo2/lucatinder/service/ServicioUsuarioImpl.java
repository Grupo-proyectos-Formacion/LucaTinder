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
import java.util.Set;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.grupo2.lucatinder.dao.DaoUsuario;
import com.grupo2.lucatinder.dao.DaoUsuarioFake;
import com.grupo2.lucatinder.model.Usuario;

@Service
@Transactional
@Component("servicioUsuario")
public class ServicioUsuarioImpl implements ServicioUsuario{
	
	@Autowired
	private DaoUsuario daoUsuario;

	@Override
	public Usuario crear(Usuario objeto) {
		return daoUsuario.save(objeto);
	}
	
	@Override
	public Set<Usuario> pedirMatchesConfirmados(Usuario usuario) {
		return daoUsuario.pedirMatchesConfirmados(usuario);
	}

	@Override
	public List<Usuario> listar() {
		return daoUsuario.findAll();
	}

	@Override
	public Usuario modificarUsuario(Usuario objeto) {
		return daoUsuario.save(objeto);
	}
	
	public void eliminarUsuario(int id) {
		daoUsuario.deleteById(id);
	}
	
	public List<Usuario> pedirPosiblesMatches(int id) {
		return daoUsuario.pedirPosiblesMatches(daoUsuario.getOne(id));
	}
	
	
	public void tratarResultadoMatch(boolean posibleMatch,Usuario usuarioPrimero, Usuario usuarioSegundo) {
		daoUsuario.tratarResultadoMatch(posibleMatch, usuarioPrimero, usuarioSegundo);	
	}

	@Override
	public Usuario getById(int id) {
		return daoUsuario.getOne(id);
	}

	@Override
	public List<Usuario> pedirPosiblesMatches(Usuario usuario) {
		return daoUsuario.pedirPosiblesMatches(usuario);
	}

	@Override
	public void poblar() {
		List<Usuario> usuarios = this.listar();
		if(usuarios.size()<20) {
			usuarios = DaoUsuarioFake.listaUsuario();
			for (Usuario usuario : usuarios) {
				daoUsuario.save(usuario);
			}
		}
		else System.out.println("La base de datos tiene suficientes usuarios");
		
	}

	@Override
	public Usuario getByName(String nombreUsuario) {
		
		return daoUsuario.getByName(nombreUsuario);
	}

	@Override
	public void eliminar(int id) {
		daoUsuario.deleteById(id);
	}

	@Override
	public List<Usuario> pedirMatchesConfirmados(Usuario usuario) {
		return daoUsuario.pedirMatchesConfirmados(usuario);
	}

	
}
