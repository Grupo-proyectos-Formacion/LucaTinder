package com.grupo2.lucatinder.model;

public class Interaccion {
	private String idUsuarioPrimero;
	private int idUsuarioPrimeroInt;
	private String idUsuarioSegundo;
	private int idUsuarioSegundoInt;
	private String resultadoInteraccion;
	
	
	public Interaccion() {
		super();
	}
	
	public Interaccion(int idUsuarioPrimero, int idUsuarioSegundo) {
		this.idUsuarioPrimeroInt = idUsuarioPrimero;
		this.idUsuarioSegundoInt =idUsuarioSegundo;
		this.idUsuarioPrimero= idUsuarioPrimero+"";
		this.idUsuarioSegundo= idUsuarioSegundo+"";
		
		this.toString();
		
	}
	
	
	public String getIdUsuarioPrimero() {
		return idUsuarioPrimero;
	}
	public void setIdUsuarioPrimero(String idUsuarioPrimero) {
		this.idUsuarioPrimero = idUsuarioPrimero;
		this.idUsuarioPrimeroInt = Integer.parseInt(idUsuarioPrimero);
	}
	public int getIdUsuarioPrimeroInt() {
		return idUsuarioPrimeroInt;
	}
	public void setIdUsuarioPrimeroInt(int idUsuarioPrimeroInt) {
		this.idUsuarioPrimeroInt = idUsuarioPrimeroInt;
		this.idUsuarioPrimero = idUsuarioPrimeroInt+"";
	}
	public String getIdUsuarioSegundo() {
		return idUsuarioSegundo;
	}
	public void setIdUsuarioSegundo(String idUsuarioSegundo) {
		this.idUsuarioSegundo = idUsuarioSegundo;
		this.idUsuarioSegundoInt = Integer.parseInt(idUsuarioSegundo);
	}
	public int getIdUsuarioSegundoInt() {
		return idUsuarioSegundoInt;
	}
	public void setIdUsuarioSegundoInt(int idUsuarioSegundoInt) {
		this.idUsuarioSegundoInt = idUsuarioSegundoInt;
		this.idUsuarioSegundo = idUsuarioSegundo+"";
	}
	public String getResultadoInteraccion() {
		return resultadoInteraccion;
	}
	public void setResultadoInteraccion(String resultadoInteraccion) {
		this.resultadoInteraccion = resultadoInteraccion;
	}
	public Boolean getResultadoInteraccionBool() {
		if(this.resultadoInteraccion.equals("true")) {
			return true;
		} else return false;
	}
	@Override
	public String toString() {
		return "Interaccion [idUsuarioPrimero=" + idUsuarioPrimero + ", idUsuarioPrimeroInt=" + idUsuarioPrimeroInt
				+ ", idUsuarioSegundo=" + idUsuarioSegundo + ", idUsuarioSegundoInt=" + idUsuarioSegundoInt
				+ ", resultadoInteraccion=" + resultadoInteraccion + "]";
	}
	
	
	
}
