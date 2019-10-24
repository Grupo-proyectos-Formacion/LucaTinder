package com.grupo2.lucatinder.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.grupo2.lucatinder.model.Usuario;

public class DaoUsuarioCustomImpl implements DaoUsuarioCustom {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> pedirPosiblesMatches(Usuario usuario) {
		Query query = entityManager.createNativeQuery("SELECT * FROM usuario WHERE sexo_usuario NOT  LIKE ?", Usuario.class);
	    query.setParameter(1, usuario.getSexoUsuario());
	    return query.getResultList();
	}
	
	
	
	@Override
	public void tratarResultadoMatch(Boolean eleccion, Usuario usuarioPrimero, Usuario usuarioSegundo) {
		if(eleccion) {
		Query query = entityManager.createNativeQuery("INSERT INTO contacto (id_tronista, id_pretendiente) VALUES (? , ?)  ");
		query.setParameter(1, usuarioPrimero.getIdUsuario());
		query.setParameter(2, usuarioSegundo.getIdUsuario());
		System.out.println("ENTRANDO EN DAO USUARIO, RESULTADO DE INTERACCION POSITIVA");
		System.out.println(query.toString());
		query.executeUpdate();
		}
		else {
			Query query = entityManager.createNativeQuery("INSERT INTO descarte (id_tronista, id_loser) VALUES (? , ?)  ");
			query.setParameter(1, usuarioPrimero.getIdUsuario());
			query.setParameter(2, usuarioSegundo.getIdUsuario());
			System.out.println("ENTRANDO EN DAO USUARIO, RESULTADO DE INTERACCION NEGATIVA");
			System.out.println(query.toString());
			query.executeUpdate();
			}
		
	}

	@Override
	public Usuario getByName(String nombreUsuario) {
		Query query = entityManager.createNativeQuery("SELECT * FROM usuario WHERE nombre_usuario = ? ORDER BY id_usuario LIMIT 1", Usuario.class);
		query.setParameter(1,nombreUsuario);
		@SuppressWarnings("unchecked")
		Usuario usuario = (Usuario) query.getSingleResult();
 		return usuario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> pedirMatchesConfirmados(Usuario usuario) {
		Query query = entityManager.createNativeQuery("SELECT id_lover_dos FROM lucatinder_grupo2.match WHERE id_lover_uno = ?");
		query.setParameter(1, usuario.getIdUsuario());
		List<Integer> matches = query.getResultList();
		List<Usuario> usuariosSet = new ArrayList<Usuario>();
		for (int idUsuarioMatch : matches) {
			usuariosSet.add(entityManager.find(Usuario.class, idUsuarioMatch));
		}
		return usuariosSet;
		
	}
	
	
}

