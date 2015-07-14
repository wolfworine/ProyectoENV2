package pe.gmp.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="OfertaJPA.findAll", query="SELECT u FROM OfertaJPA u")
@Table(name="tb_ofertas")
public class OfertaJPA implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String of_id;
	private String of_descripcion;
	private Date of_fechaini;
	private Date of_fechafin;
	
	
	public OfertaJPA() {
	}
		
	public String getOf_id() {
		return of_id;
	}
	
	public void setOf_id(String of_id) {
		this.of_id = of_id;
	}

	public String getOf_descripcion() {
		return of_descripcion;
	}
	public void setOf_descripcion(String of_descripcion) {
		this.of_descripcion = of_descripcion;
	}
	public Date getOf_fechaini() {
		return of_fechaini;
	}
	public void setOf_fechaini(Date of_fechaini) {
		this.of_fechaini = of_fechaini;
	}
	public Date getOf_fechafin() {
		return of_fechafin;
	}
	public void setOf_fechafin(Date of_fechafin) {
		this.of_fechafin = of_fechafin;
	}
	
	
}
