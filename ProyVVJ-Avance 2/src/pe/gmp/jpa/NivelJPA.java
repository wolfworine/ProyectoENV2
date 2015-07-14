package pe.gmp.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the nivel database table.
 * 
 */
@NamedQuery(name="NivelJPA.findAll", query="SELECT n FROM NivelJPA n")
@Entity
@Table(name="nivel")
public class NivelJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nivelid;

	private String niveldes;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="nivelBean")
	private Set<UsuarioJPA> usuarios;

	public NivelJPA() {
	}

	public String getNivelid() {
		return this.nivelid;
	}

	public void setNivelid(String nivelid) {
		this.nivelid = nivelid;
	}

	public String getNiveldes() {
		return this.niveldes;
	}

	public void setNiveldes(String niveldes) {
		this.niveldes = niveldes;
	}

	public Set<UsuarioJPA> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<UsuarioJPA> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioJPA addUsuario(UsuarioJPA usuario) {
		getUsuarios().add(usuario);
		usuario.setNivelBean(this);

		return usuario;
	}

	public UsuarioJPA removeUsuario(UsuarioJPA usuario) {
		getUsuarios().remove(usuario);
		usuario.setNivelBean(null);

		return usuario;
	}

}