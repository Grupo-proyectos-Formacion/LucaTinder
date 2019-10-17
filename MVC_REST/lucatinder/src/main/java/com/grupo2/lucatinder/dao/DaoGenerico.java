package com.grupo2.lucatinder.dao;
/**
* Intefaz DaoGenerica
* 
*
* @author 
*
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucatinder.model.Usuario;


public interface DaoGenerico<T> extends JpaRepository <T,Integer > {

}
