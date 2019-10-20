package com.grupo2.lucatinder.service;

import java.util.List;

import com.grupo2.lucatinder.model.Usuario;

public interface ServicioUsuario extends ServicioGenerico<Usuario> {
	public List<Usuario> pedirPosiblesMatches(int id);
	public void tratarResultadoMatch(boolean posibleMatch, Usuario usuarioPrimero, Usuario usuarioSegundo);
	List<Usuario> pedirPosiblesMatches(Usuario usuario);
}
