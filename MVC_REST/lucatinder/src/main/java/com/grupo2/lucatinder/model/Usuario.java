/**
 * @author Julian Bautista
 * Clase Usuario
 * Mapeada a la tabla usuario de la base de datos
 */
package com.grupo2.lucatinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private int id;
	
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	
	@Column(name="descripcion_usuario")
	private String descripcionUsuario;
	
	@Column(name="edad_usuario")
	private int edadUsuario;
	
	@Column(name="ciudad_usuario")
	private String ciudadUsuario;
	
	@Column(name="sexo_usuario")
	private Boolean sexoUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDescripcionUsuario() {
		return descripcionUsuario;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
	}

	public int getEdadUsuario() {
		return edadUsuario;
	}

	public void setEdadUsuario(int edadUsuario) {
		this.edadUsuario = edadUsuario;
	}

	public String getCiudadUsuario() {
		return ciudadUsuario;
	}

	public void setCiudadUsuario(String ciudadUsuario) {
		this.ciudadUsuario = ciudadUsuario;
	}

	public Boolean getSexoUsuario() {
		return sexoUsuario;
	}

	public void setSexoUsuario(Boolean sexoUsuario) {
		this.sexoUsuario = sexoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", descripcionUsuario=" + descripcionUsuario
				+ ", edadUsuario=" + edadUsuario + ", ciudadUsuario=" + ciudadUsuario + ", sexoUsuario=" + sexoUsuario
				+ "]";
	}
	
	
	
	
}
