package com.grupo2.lucatinder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preferencia")
public class Preferencia {


	
	@Id
	@GeneratedValue
	@Column(name="id_preferencia")
	private int idPreferencia;
	@Column(name="nombre_preferencia")
	private String nombrePreferencia;
	@Column(name="descripcion_preferencia")
	private String descripcionPreferencia;
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreferencia")
    private List<Usuario> usuarioPreferenciaList;*/

	
	public Preferencia() {
		super();
	}

	public Preferencia(int idPreferencia, String nombrePreferencia, String descripcionPreferencia,
			String familiaPreferencia) {
		super();
		this.idPreferencia = idPreferencia;
		this.nombrePreferencia = nombrePreferencia;
		this.descripcionPreferencia = descripcionPreferencia;

	}

	public int getIdPreferencia() {
		return idPreferencia;
	}

	public void setIdPreferencia(int idPreferencia) {
		this.idPreferencia = idPreferencia;
	}

	public String getNombrePreferencia() {
		return nombrePreferencia;
	}

	public void setNombrePreferencia(String nombrePreferencia) {
		this.nombrePreferencia = nombrePreferencia;
	}

	public String getDescripcionPreferencia() {
		return descripcionPreferencia;
	}

	public void setDescripcionPreferencia(String descripcionPreferencia) {
		this.descripcionPreferencia = descripcionPreferencia;
	}

	@Override
	public String toString() {
		return "Preferencia [idPreferencia=" + idPreferencia + ", nombrePreferencia=" + nombrePreferencia
				+ ", descripcionPreferencia=" + descripcionPreferencia + "]";
	}

	

	


	
}
