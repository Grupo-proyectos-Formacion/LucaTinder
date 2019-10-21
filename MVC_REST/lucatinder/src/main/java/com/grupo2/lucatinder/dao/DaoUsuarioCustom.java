package com.grupo2.lucatinder.dao;

import java.util.List;

import com.grupo2.lucatinder.model.Usuario;

/**
* Clase DaoUsuario implementa DaoGenerico
* 
*
* @author Sisa Romero
* 
*
*/
public interface DaoUsuarioCustom {
	
	List<Usuario> pedirPosiblesMatches(Usuario user);
	void tratarResultadoMatch(Boolean match, Usuario usuarioPrimero, Usuario usuarioSegundo);
	Usuario getByName(String nombreUsuario); 

}
