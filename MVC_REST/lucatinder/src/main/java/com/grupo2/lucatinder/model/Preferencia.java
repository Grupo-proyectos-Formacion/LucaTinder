package com.grupo2.lucatinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preferencia")

public class Preferencia {


	
	@Id
	@GeneratedValue
	@Column(name="id_preferencia")
	private int idPreferencia;
	@Column(name="nomre_preferencia")
	private String nombrePreferencia;
	@Column(name="descripcion_preferencia")
	private String descripcionPreferencia;
	@Column(name="familia_preferencia")
	private String familiaPreferencia;
	
	public Preferencia() {
		super();
	}

	public Preferencia(int idPreferencia, String nombrePreferencia, String descripcionPreferencia,
			String familiaPreferencia) {
		super();
		this.idPreferencia = idPreferencia;
		this.nombrePreferencia = nombrePreferencia;
		this.descripcionPreferencia = descripcionPreferencia;
		this.familiaPreferencia = familiaPreferencia;
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

	
	public String getFamiliaPreferencia() {
		return familiaPreferencia;
	}

	public void setFamiliaPreferencia(String familiaPreferencia) {
		this.familiaPreferencia = familiaPreferencia;
	}
	
	
	@Override
	public String toString() {
		return "Preferencia [idPreferencia=" + idPreferencia + ", nombrePreferencia=" + nombrePreferencia
				+ ", descripcionPreferencia=" + descripcionPreferencia + ", familiaPreferencia=" + familiaPreferencia
				+ "]";
	}

	
}
