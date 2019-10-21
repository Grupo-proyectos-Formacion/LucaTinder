package com.grupo2.lucatinder.dao;

import java.util.List;
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
		Query query = entityManager.createNativeQuery("SELECT * FROM usuario WHERE nombre_usuario = ?", Usuario.class);
		query.setParameter(1,nombreUsuario);
		@SuppressWarnings("unchecked")
		Usuario usuario = (Usuario) query.getSingleResult();
 		return usuario;
	}
}

