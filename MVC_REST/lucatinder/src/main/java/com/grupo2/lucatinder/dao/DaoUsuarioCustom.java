package com.grupo2.lucatinder.dao;

import java.util.List;

import com.grupo2.lucatinder.model.Usuario;

public interface DaoUsuarioCustom {
	
	List<Usuario> pedirPosiblesMatches(Usuario user);
	void tratarResultadoMatch(Boolean match, Usuario usuario);

}
