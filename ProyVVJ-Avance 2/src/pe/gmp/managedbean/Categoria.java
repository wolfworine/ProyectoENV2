package pe.gmp.managedbean;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import pe.gmp.jpa.CategoriaJPA;


import pe.gmp.service.CategoriaImpl;


public class Categoria {

	private String cat_id;
	
	private String cat_descripcion;

	private String mensaje;

	private int estado;
	
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

	private CategoriaImpl categoriai = new CategoriaImpl();
	
	DataModel<CategoriaJPA> categoriamodel;
	 
	//public ArrayList<SelectItem> categorias;

	public void Eliminar(ActionEvent e) throws Exception {
		// Creo el objeto usuario
		CategoriaJPA objcat = new CategoriaJPA();

		// Obtenemos el atributo unom del face
		String cdes;
		cdes = e.getComponent().getAttributes().get("cdes").toString();

		// seteamos el objusu
		objcat.setCat_id(cdes);

		// eliminamos el objusu
		mensaje = categoriai.EliminaCategoria(objcat);

		System.out.println("Mensaje: " + mensaje);
	}

	public void Buscar(ActionEvent e) throws Exception {
		// Creo el objeto usuario
		CategoriaJPA objcat = new CategoriaJPA();

		// Obtenemos el atributo unom del face
		String cdes;
		cdes = e.getComponent().getAttributes().get("cdes").toString();

		objcat.setCat_id(cdes);

		// Vuelvo a usar el mismo objeto para chancarlo y enviar otra vez un obj
		// usuario.
		objcat = categoriai.BuscarCategoria(objcat);
		if (objcat != null) {
			setCat_descripcion(objcat.getCat_descripcion());

			// setNivel(objusu.getNivel());

			// El buscar es para modificar, seteamos el estado...
				setEstado(1);
		}
	}

	public void Grabar(ActionEvent e) throws Exception {

		// Obtenemos por face los campos llenamos en nuevo.xhtml
		CategoriaJPA objcat = new CategoriaJPA();
		objcat.setCat_descripcion(getCat_descripcion());
		System.out.println("Mensaje: "+mensaje);

		if (getEstado() == 1) {
			mensaje = categoriai.ModificaCategoria(objcat);
			if (mensaje != null) {
				System.out.println("Se concretó");
			} else {
				System.out.println("No se concretó");

			}
		}

		else {
			mensaje = categoriai.GrabaCategoria(objcat);
			if (mensaje != null) {
				System.out.println("Se concretó");
			} else {
				System.out.println("No se concretó");

			}
		}

		System.out.println("Mensaje: " + mensaje);

	}

	public String Volver() throws Exception {
		String volver = "";
		volver = "volver";
		return volver;
	}

	// Probar este get y set que no estoy seguro :/

/*
	public ArrayList<SelectItem> getCategoriaLista() throws Exception {
		categorias = new ArrayList<SelectItem>();
		for (CategoriaJPA obj : categoriai.ListaCategoria()) {
			categorias.add(new SelectItem(obj.getCatid(), obj.getCatdes()));
		}

		return categorias;
	}

	public void setCategoriaLista(ArrayList<SelectItem> categorias) {
		this.categorias = categorias;
	}
*/
	public DataModel<CategoriaJPA> getCategoriamodel() throws Exception {
		categoriamodel = new ListDataModel<CategoriaJPA>(
				categoriai.ListaCategoria());
		return categoriamodel;
	}

	public void setCategoriamodel(DataModel<CategoriaJPA> categoriamodel) {
		this.categoriamodel = categoriamodel;
	}


}
