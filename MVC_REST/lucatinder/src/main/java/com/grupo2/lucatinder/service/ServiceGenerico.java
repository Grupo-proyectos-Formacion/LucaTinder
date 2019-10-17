/**
 * @author Julian Bautista
 * Intefaz servicio generico, usada para extender de ella los demaás 
 * servicios especificos
 * solo métodos comunes a todos los servicios
 */
package com.grupo2.lucatinder.service;

public interface ServiceGenerico<T> {

	public void crear(T objeto);
}
