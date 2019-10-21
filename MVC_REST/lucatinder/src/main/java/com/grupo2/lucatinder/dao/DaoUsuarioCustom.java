package com.grupo2.lucatinder.dao;

import java.util.List;
import java.util.Set;

import com.grupo2.lucatinder.model.Usuario;

public interface DaoUsuarioCustom {
	
	List<Usuario> pedirPosiblesMatches(Usuario user);
	void tratarResultadoMatch(Boolean match, Usuario usuarioPrimero, Usuario usuarioSegundo);
	Usuario getByName(String nombreUsuario); 
	Set<Usuario> pedirMatchesConfirmados(Usuario usuario);

}
