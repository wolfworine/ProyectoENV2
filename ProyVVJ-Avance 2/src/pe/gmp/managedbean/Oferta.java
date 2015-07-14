package pe.gmp.managedbean;



import java.util.Date;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import pe.gmp.jpa.OfertaJPA;
import pe.gmp.service.OfertaImpl;

public class Oferta {
	private String of_id;
	private String of_descripcion;
	private Date of_fechaini;
	private Date of_fechafin;

	private String mensaje;
	private int estado;

	
	DataModel<OfertaJPA> ofertamodel;
	
	private OfertaImpl ofertai = new OfertaImpl();
	
	
	public void Eliminar(ActionEvent e) throws Exception {
		// Creo el objeto usuario
		OfertaJPA objOferta = new OfertaJPA();
		
		//Obtenemos el atributo oid del face
		String oid;
		oid =e.getComponent().getAttributes().get("oid").toString();

		//seteamos el objOferta
		objOferta.setOf_id(oid);
		
		//eliminamos el objOferta
		mensaje=ofertai.EliminaOferta(objOferta);
		
		System.out.println("Mensaje: "+mensaje);
	}

	
	public void Buscar(ActionEvent e) throws Exception {
		// Creo el objeto Oferta
		OfertaJPA objOferta = new OfertaJPA();
		
		//Obtenemos el atributo otit del face
		String oid;
		oid =e.getComponent().getAttributes().get("oid").toString();

		objOferta.setOf_id(oid);

		// Vuelvo a usar el mismo objeto para chancarlo y enviar otra vez un obj
		// usuario.
		objOferta = ofertai.BuscarOferta(objOferta);
		if (objOferta != null) {
			setOf_descripcion(objOferta.getOf_descripcion());
			setOf_fechaini(objOferta.getOf_fechaini());
			setOf_fechafin(objOferta.getOf_fechafin());
		}
	}

	public void Grabar(ActionEvent e) throws Exception {

		// Obtenemos por face los campos llenamos en nuevo.xhtml
		OfertaJPA objOferta = new OfertaJPA();
		objOferta.setOf_descripcion(getOf_descripcion());
		objOferta.setOf_fechaini(getOf_fechaini());
		objOferta.setOf_fechafin(getOf_fechafin());
		System.out.println("Mensaje: "+mensaje);
		
		if(getEstado()==1)	{
			mensaje=ofertai.ModificaOferta(objOferta);
			if(mensaje != null){
				System.out.println("Se concretó");
			}else{
				System.out.println("No se concretó");
				
			}
		}
		
		else {mensaje=ofertai.GrabaOferta(objOferta);
		if(mensaje != null){
			System.out.println("Se concretó");
		}else{
			System.out.println("No se concretó");
			
		}
		}
		
		System.out.println("Mensaje: "+mensaje);

	}

	
	public String Volver() throws Exception {
		String volver = "";
		volver = "volver";
		return volver;
	}
	
	// por defecto retorna vacío.. hay que llenarlo con el dao y castearlo como
	// ListDataodel
	public DataModel<OfertaJPA> getOfertamodel() throws Exception {
		ofertamodel = new ListDataModel<OfertaJPA>(ofertai.ListaOferta());
		return ofertamodel;
	}

	public void setOfertamodel(DataModel<OfertaJPA> ofertamodel) {
		this.ofertamodel = ofertamodel;
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

	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
}
