package com.grupo2.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucatinder.model.Usuario;

/**
* Clase DaoUsuario implementa DaoGenerico
* 
*
* @author 
*
*/

public interface DaoUsuario extends JpaRepository <Usuario,Integer >  {

}
