package com.grupo2.lucatinder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.grupo2.lucatinder.model.Usuario;

/**
* Clase DaoUsuario implementa DaoGenerico
* 
*
* @author Sisa Romero
*
*/

@Repository
@Component("daoUsuario")
public interface DaoUsuario extends JpaRepository <Usuario,Integer >  {
	
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
}
