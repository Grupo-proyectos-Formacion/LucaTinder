/**
 * @author Julian Bautista
 * 
 * Servicio especifico de usuario implementa el servicio Generico
 * 
 * 
 * 
 */
package com.grupo2.lucatinder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
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

	public List<Usuario> pedirPosiblesMatches(Usuario usuario) {
		return daoUsuario.pedirPosiblesMatches(usuario);
	}

	@Override
	public Usuario getById(int id) {
		return daoUsuario.getOne(id);
	}
	
	public void tratarResultadoMatch(boolean match) {
		daoUsuario.tratarResultadoMatch(match);
		
	}
	
	
 public List<Usuario> listaUsuario() {
	     
		 ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		 
		 Locale locale= new Locale("es");
		 Faker faker = new Faker(locale);
		
		
			
			 for (int i=0; i<20;i++) {
				  				 
				 String nombre= faker.name().firstName();
				 int edad= faker.number().numberBetween(18, 80);
				 String ciudad= faker.address().cityName();
				 String descripcion= faker.friends().quote();
				 boolean sexo = new Random().nextBoolean();
				 
				 new Usuario(nombre,descripcion,edad,ciudad,sexo);	 
				 listaUsuario.add(new Usuario(nombre,descripcion,edad,ciudad,sexo));
				 
				 
			 
			 }
			return listaUsuario;
			 
	 }
	
	
}
