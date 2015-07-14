package pe.gmp.jpa;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@NamedQuery(name="UsuarioJPA.findAll", query="SELECT u FROM UsuarioJPA u")
@Table(name="usuario")
public class UsuarioJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usernom;

	private String correo;

	private String nombre;

	private String userpwd;	
	

	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="nivel")
	private NivelJPA nivelBean;

	public UsuarioJPA() {
	}

	public String getUsernom() {
		return this.usernom;
	}

	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public NivelJPA getNivelBean() {
		return this.nivelBean;
	}

	public void setNivelBean(NivelJPA nivelBean) {
		this.nivelBean = nivelBean;
	}

}