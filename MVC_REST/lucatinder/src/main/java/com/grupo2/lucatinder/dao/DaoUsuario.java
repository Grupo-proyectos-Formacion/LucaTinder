package com.grupo2.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.grupo2.lucatinder.model.Usuario;

/**
* Clase DaoUsuario implementa DaoGenerico
* 
*
* @author 
*
*/
@Component("daoUsuario")
public interface DaoUsuario extends JpaRepository <Usuario,Integer >  {

}
