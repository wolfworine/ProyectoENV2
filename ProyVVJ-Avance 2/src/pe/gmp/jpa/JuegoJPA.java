package pe.gmp.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="JuegoJPA.findAll", query="SELECT u FROM JuegoJPA u")
@Table(name="tb_videojuegos")
public class JuegoJPA implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String vj_id;
	private String vj_titulo;
	private String vj_descripcion;
	private int  vj_stock;
	private double vj_precio;
	private double vj_precio_descuento;
	
	//asociar el otro bean categoria
	@ManyToOne
	@JoinColumn(name="of_id")
	private OfertaJPA oferta;
	
	public JuegoJPA() {
	}
	
	public String getVj_id() {
		return vj_id;
	}

	public void setVj_id(String vj_id) {
		this.vj_id = vj_id;
	}

	public String getVj_titulo() {
		return vj_titulo;
	}

	public void setVj_titulo(String vj_titulo) {
		this.vj_titulo = vj_titulo;
	}

	public String getVj_descripcion() {
		return vj_descripcion;
	}

	public void setVj_descripcion(String vj_descripcion) {
		this.vj_descripcion = vj_descripcion;
	}

	public int getVj_stock() {
		return vj_stock;
	}

	public void setVj_stock(int vj_stock) {
		this.vj_stock = vj_stock;
	}

	public double getVj_precio() {
		return vj_precio;
	}

	public void setVj_precio(double vj_precio) {
		this.vj_precio = vj_precio;
	}

	public double getVj_precio_descuento() {
		return vj_precio_descuento;
	}

	public void setVj_precio_descuento(double vj_precio_descuento) {
		this.vj_precio_descuento = vj_precio_descuento;
	}

	public OfertaJPA getOferta() {
		return oferta;
	}

	public void setOferta(OfertaJPA oferta) {
		this.oferta = oferta;
	}
}
