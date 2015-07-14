package pe.gmp.jpa;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@NamedQuery(name="CategoriaJPA.findAll", query="SELECT u FROM CategoriaJPA u")
@Table(name="tb_categorias")
public class CategoriaJPA implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	private String cat_id;
	private String cat_descripcion;
	
	/*
	@OneToMany(mappedBy="videojuegosBean")
	private Set<VideojuegosJPA> videojuegos;*/
	
	public CategoriaJPA(){}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_descripcion() {
		return cat_descripcion;
	}

	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}
	
	
	//Obtencion seteo y todo eso de videojuegos
	
/*	public Set<VideojuegosJPA> getVideojuegos() {
		return this.videojuegos;
	}

	public void setVideojuegos(Set<VideojuegosJPA> videojuegos) {
		this.videojuegos =	videojuegos;
	}

	public VideojuegosJPA addViedeojuegos(VideojuegosJPA videojuegos) {
		getVideojuegos().add(videojuegos);
		videojuegos.setNivelBean(this);

		return videojuegos;
	}

	public VideojuegosJPA removeVideojuegos(UsuarioJPA videojuegos) {
		getVideojuegos().remove(videojuegos);
		videojuegos.setNivelBean(null);

		return videojuegos;
	}*/
	
	
}
