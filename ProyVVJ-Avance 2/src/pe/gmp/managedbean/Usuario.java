package pe.gmp.managedbean;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import pe.gmp.jpa.NivelJPA;
import pe.gmp.jpa.UsuarioJPA;
import pe.gmp.jpa.UsuarioJPA;
import pe.gmp.service.UsuarioImpl;

//@ManagedBean(name="usuario")
public class Usuario {

	private String usernom, userpwd, nombre, correo, nivel;

	private int estado;
	
	private String mensaje;

	
	

	// Es como si fuera un arrayList
	DataModel<UsuarioJPA> usuariosmodel;

	private UsuarioImpl usuarioi = new UsuarioImpl();

	public void Eliminar(ActionEvent e) throws Exception {
		// Creo el objeto usuario
		UsuarioJPA objusu = new UsuarioJPA();
		
		//Obtenemos el atributo unom del face
		String unom;
		unom = e.getComponent().getAttributes().get("unom").toString();

		//seteamos el objusu
		objusu.setUsernom(unom);
		
		//eliminamos el objusu
		mensaje=usuarioi.EliminaUsuario(objusu);
		
		System.out.println("Mensaje: "+mensaje);
	}

	
	public void Buscar(ActionEvent e) throws Exception {
		// Creo el objeto usuario
		UsuarioJPA objusu = new UsuarioJPA();
		
		//Obtenemos el atributo unom del face
		String unom;
		unom = e.getComponent().getAttributes().get("unom").toString();

		objusu.setUsernom(unom);

		// Vuelvo a usar el mismo objeto para chancarlo y enviar otra vez un obj
		// usuario.
		objusu = usuarioi.BuscarUsuario(objusu);
		if (objusu != null) {
			setUsernom(objusu.getUsernom());
			setUserpwd(objusu.getUserpwd());
			setNombre(objusu.getNombre());
			setCorreo(objusu.getCorreo());
			setNivel(objusu.getNivelBean().getNivelid());
//			setNivel(objusu.getNivel());
			
			//El buscar es para modificar, seteamos el estado...
			setEstado(1);
		}
	}

	public void Grabar(ActionEvent e) throws Exception {

		// Obtenemos por face los campos llenamos en nuevo.xhtml
		UsuarioJPA objusu = new UsuarioJPA();
		objusu.setUsernom(getUsernom());
		objusu.setUserpwd(getUserpwd());
		objusu.setNombre(getNombre());
		objusu.setCorreo(getCorreo());

		
		NivelJPA objn=new NivelJPA();
		objn.setNivelid(getNivel());
		objusu.setNivelBean(objn);
//		objusu.setNivel(getNivel());
		
		
		if(getEstado()==1)	{
			mensaje=usuarioi.ModificaUsuario(objusu);
			if(mensaje != null){
				System.out.println("Se concretó");
			}else{
				System.out.println("No se concretó");
				
			}
		}
		
		else {mensaje=usuarioi.GrabaUsuario(objusu);
		if(mensaje != null){
			System.out.println("Se concretó");
		}else{
			System.out.println("No se concretó");
			
		}
		}
		
		System.out.println("Mensaje: "+mensaje);

	}

	public String Validar() throws Exception {
		
		String vista = "error";

		UsuarioJPA obj = new UsuarioJPA();
		obj.setUsernom(getUsernom());
		obj.setUserpwd(getUserpwd());
		obj = usuarioi.BuscarUsuario(obj);

		if (obj != null) {
			setNombre(obj.getNombre());
			setCorreo(obj.getCorreo());

			vista = "success";
		}

		// if(getUsernom().equals("cibertec")&&getUserpwd().equals("123"))
		// {
		// vista="success";
		//
		// setNombre("Juan Perez");
		// setCorreo("jperez@gmail.com");
		//
		// }
		return vista;

	}
	
	public String Volver() throws Exception {
		String volver = "";
		volver = "volver";
		return volver;
	}

	// por defecto retorna vacío.. hay que llenarlo con el dao y castearlo como
	// ListDataodel
	public DataModel<UsuarioJPA> getUsuariosmodel() throws Exception {
		usuariosmodel = new ListDataModel<UsuarioJPA>(usuarioi.ListaUsuario());
		return usuariosmodel;
	}

	public void setUsuariosmodel(DataModel<UsuarioJPA> usuariosmodel) {
		this.usuariosmodel = usuariosmodel;
	}

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
