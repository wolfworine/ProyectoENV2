package pe.gmp.service;

import java.util.List;

import pe.gmp.jpa.UsuarioJPA;

public interface UsuarioService {
	
	//todos los datos de un usuario es un bean Usuario.
	public abstract UsuarioJPA BuscarUsuario(UsuarioJPA objusu) throws Exception;
	
	public abstract String GrabaUsuario(UsuarioJPA objusu) throws Exception;
	
	public abstract String ModificaUsuario(UsuarioJPA objusu) throws Exception;
	
	public abstract String EliminaUsuario(UsuarioJPA objusu) throws Exception;
	
	public abstract List<UsuarioJPA> ListaUsuario() throws Exception;
	
	
	

}
