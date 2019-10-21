package com.grupo2.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.grupo2.lucatinder.model.Preferencia;
import com.grupo2.lucatinder.model.Usuario;

/**
* Clase DaoUsuario implementa DaoGenerico
* 
*
* @author Daniel
*
*/
@Repository
@Component("daoPreferencia")
public interface DaoPreferencia  extends JpaRepository <Preferencia,Integer >, DaoCategoriaCustom{

}
