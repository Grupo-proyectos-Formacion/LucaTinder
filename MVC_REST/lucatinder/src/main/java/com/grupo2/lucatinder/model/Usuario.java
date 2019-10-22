/**
 * @author Julian Bautista
 * Clase Usuario
 * Mapeada a la tabla usuario de la base de datos
 */
package com.grupo2.lucatinder.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	

	@Id
	@GeneratedValue
    @Column(name = "id_usuario")
	private int idUsuario;
	
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
	
	@Column(name="imagen_usuario")
	private String imagenUsuario;
	
	/*@OneToMany
	(fetch= FetchType.EAGER,   cascade = CascadeType.ALL)
	@JoinTable(name="usuario_preferencia", joinColumns={@JoinColumn(name ="id_usuario", referencedColumnName ="id_usuario")},
	inverseJoinColumns={@JoinColumn(name ="id_preferencia", referencedColumnName ="id_preferencia")})*/
	@OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Preferencia> preferenciaUsuario;
	
	
	
	public Usuario(){
		super();
		/*if(this.sexoUsuario) {
			this.imagenUsuario = "https://randomuser.me/api/portraits/women/"+this.idUsuario+".jpg";
			} else this.imagenUsuario = "https://randomuser.me/api/portraits/men/"+this.idUsuario+".jpg";*/
		
	}
	
	public Usuario(String nombreUsuario, String descripcionUsuario, int edadUsuario,String ciudadUsuario, Boolean sexoUsuario) {
		
		this.nombreUsuario = nombreUsuario;
		this.descripcionUsuario = descripcionUsuario;
		this.edadUsuario = edadUsuario;
		this.ciudadUsuario = ciudadUsuario;
		this.sexoUsuario = sexoUsuario;
	}
	
public Usuario(String nombreUsuario, String descripcionUsuario, int edadUsuario,String ciudadUsuario, Boolean sexoUsuario ,String imagenUsuario) {
		
		this.nombreUsuario = nombreUsuario;
		this.descripcionUsuario = descripcionUsuario;
		this.edadUsuario = edadUsuario;
		this.ciudadUsuario = ciudadUsuario;
		this.sexoUsuario = sexoUsuario;
		this.imagenUsuario = imagenUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getImagenUsuario() {
		return imagenUsuario;
	}

	public void setImagenUsuario(String imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}
	
	public List<Preferencia> getPreferenciaUsuario() {
		return preferenciaUsuario;
	}

	public void setPreferenciaUsuario(List<Preferencia> preferenciaUsuario) {
		this.preferenciaUsuario = preferenciaUsuario;
	}

	public void addPreferenciaUsuario(Preferencia preferencia) {
		this.preferenciaUsuario.add(preferencia);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", descripcionUsuario="
				+ descripcionUsuario + ", edadUsuario=" + edadUsuario + ", ciudadUsuario=" + ciudadUsuario
				+ ", sexoUsuario=" + sexoUsuario + "]\n";
	}

	
	
	
	
	
}
