package pe.gmp.managedbean;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import pe.gmp.jpa.JuegoJPA;
import pe.gmp.service.JuegoImpl;

public class Juego {
	
	private String vj_id;
	private String vj_titulo;
	private String vj_descripcion;
	private int  vj_stock;
	private double vj_precio;
	private double vj_precio_descuento;

		
	private int estado;
		
	private String mensaje;
	
	private List<JuegoJPA> filteredGames;
	
	// Es como si fuera un arrayList
	DataModel<JuegoJPA> juegomodel;
	private JuegoImpl juegoi = new JuegoImpl();
	
	public void Eliminar(ActionEvent e) throws Exception {
		// Creo el objeto usuario
		JuegoJPA objJuego = new JuegoJPA();
		
		//Obtenemos el atributo oid del face
		String jid;
		jid =e.getComponent().getAttributes().get("jid").toString();

		//seteamos el objOferta
		objJuego.setVj_id(jid);
		
		//eliminamos el objOferta
		mensaje=juegoi.EliminaJuego(objJuego);
		
		System.out.println("Mensaje: "+mensaje);
	}

	//falta los ultimos 2 atributos
	public void Buscar(ActionEvent e) throws Exception {
		// Creo el objeto Oferta
		JuegoJPA objJuego = new JuegoJPA();
		
		//Obtenemos el atributo otit del face
		String jid;
		jid =e.getComponent().getAttributes().get("jid").toString();

		objJuego.setVj_id(jid);

		// Vuelvo a usar el mismo objeto para chancarlo y enviar otra vez un obj
		// usuario.
		objJuego = juegoi.BuscarJuego(objJuego);
		if (objJuego != null) {
			setVj_titulo(objJuego.getVj_titulo());
			setVj_descripcion(objJuego.getVj_descripcion());
			setVj_stock(objJuego.getVj_stock());
			setVj_precio(objJuego.getVj_precio());
			setVj_precio_descuento(objJuego.getVj_precio_descuento());
		}
	}

	//falta los ultimos 2 atributos
	public void Grabar(ActionEvent e) throws Exception {

		// Obtenemos por face los campos llenamos en nuevo.xhtml
		JuegoJPA objJuego = new JuegoJPA();
		objJuego.setVj_titulo(getVj_titulo());
		objJuego.setVj_descripcion(getVj_descripcion());
		objJuego.setVj_stock(getVj_stock());
		objJuego.setVj_precio(getVj_precio());
		objJuego.setVj_precio_descuento(getVj_precio_descuento());
		System.out.println("Mensaje: "+mensaje);
		
		if(getEstado()==1)	{
			mensaje=juegoi.ModificaJuego(objJuego);
			if(mensaje != null){
				System.out.println("Se concretó");
			}else{
				System.out.println("No se concretó");
				
			}
		}
		
		else {mensaje=juegoi.GrabaJuego(objJuego);
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
	public DataModel<JuegoJPA> getJuegomodel() throws Exception {
		juegomodel = new ListDataModel<JuegoJPA>(juegoi.ListaJuego());
		return juegomodel;
	}


	public void setJuegomodel(DataModel<JuegoJPA> juegomodel) {
		this.juegomodel = juegomodel;
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

	public List<JuegoJPA> getFilteredGames() {
		return filteredGames;
	}

	public void setFilteredGames(List<JuegoJPA> filteredGames) {
		this.filteredGames = filteredGames;
	}	
}
