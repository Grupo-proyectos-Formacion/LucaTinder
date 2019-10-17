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
}

