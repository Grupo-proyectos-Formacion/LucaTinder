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
	public void tratarResultadoMatch(Boolean eleccion, Usuario usuario) {
		if(eleccion) {
		Query query = entityManager.createNativeQuery("INSERT INTO contacto (id_pretendiente, id_tronistra) VALUES (? , ?)  ", "resultado");
		query.setParameter(1, usuario.getIdUsuario());
		query.setParameter(2, usuario.getIdUsuario());
		}
		else {
			Query query = entityManager.createNativeQuery("INSERT INTO descarte (id_tronista, id_loser) VALUES (? , ?)  ", "resultado");
			query.setParameter(1, usuario.getIdUsuario());
			query.setParameter(2, usuario.getIdUsuario());
			}
		
		
	}
}

