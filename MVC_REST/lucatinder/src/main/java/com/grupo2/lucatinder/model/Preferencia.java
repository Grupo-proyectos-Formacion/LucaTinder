package com.grupo2.lucatinder.model;

public class Preferencia {

	/*
	 * atributos:
	id:int
	nombre: string
	descripcion: string
	familia: string o enum
	 */
	private int idPreferencia;
	private String nombrePreferencia;
	private String descripcionPreferencia;
	private String familia;
	
	public Preferencia() {
		super();
	}

	public Preferencia(int idPreferencia, String nombrePreferencia, String descripcionPreferencia, String familia) {
		super();
		this.idPreferencia = idPreferencia;
		this.nombrePreferencia = nombrePreferencia;
		this.descripcionPreferencia = descripcionPreferencia;
		this.familia = familia;
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

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	@Override
	public String toString() {
		return "Preferencia [idPreferencia=" + idPreferencia + ", nombrePreferencia=" + nombrePreferencia
				+ ", descripcionPreferencia=" + descripcionPreferencia + ", familia=" + familia + "]";
	}
	
	
	
	
	
}
