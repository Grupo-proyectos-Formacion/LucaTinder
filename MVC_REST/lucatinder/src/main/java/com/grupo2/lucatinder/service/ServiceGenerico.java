/**
 * @author Julian Bautista
 * Intefaz servicio generico, usada para extender de ella los demaás 
 * servicios especificos
 * solo métodos comunes a todos los servicios
 */
package com.grupo2.lucatinder.service;

import java.util.List;

public interface ServiceGenerico<T> {

	public T crear(T objeto);
	public List<T> listar();
	public List<T> pedirPosiblesMatches(T objeto);
	public T getById(int id); 
}
