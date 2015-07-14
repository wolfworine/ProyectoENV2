package pe.gmp.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioJPA_old {

	//clave única-primaria: usernom.
	@Id
	private String usernom;
	
	@Column(name="userpwd")	
	private String userpwd;
	
	@Column(name="nombre")	
	private String nombre;
	
	@Column(name="correo")	
	private String correo;
	
	@Column(name="nivel")	
	private String nivel;

	
	public String getUsernom() {
		return usernom;
	}

	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
	
	

}
