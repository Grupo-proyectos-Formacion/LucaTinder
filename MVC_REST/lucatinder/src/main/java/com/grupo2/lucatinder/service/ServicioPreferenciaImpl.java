package com.grupo2.lucatinder.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grupo2.lucatinder.dao.DaoPreferencia;
import com.grupo2.lucatinder.model.Preferencia;

@Service
@Transactional
@Component("servicioPreferencia")
public class ServicioPreferenciaImpl implements ServicioPreferencia {


	@Autowired
	private DaoPreferencia daoPreferencia;

	@Override
	public Preferencia crear(Preferencia objeto) {
		return daoPreferencia.save(objeto);
	}

	@Override
	public List<Preferencia> listar() {
		
		return daoPreferencia.findAll();
	}

	@Override
	public Preferencia getById(int id) {
		daoPreferencia.getOne(id);
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
