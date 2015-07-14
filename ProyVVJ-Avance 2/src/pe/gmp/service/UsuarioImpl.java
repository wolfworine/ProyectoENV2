package pe.gmp.service;

import java.util.List;

import pe.gmp.factory.DAOFactory;
import pe.gmp.jpa.UsuarioJPA;

public class UsuarioImpl implements UsuarioService{

	DAOFactory factory=DAOFactory.getFactory(1);
	
	UsuarioService dao=factory.getUsuarioService();
	
	@Override
	public UsuarioJPA BuscarUsuario(UsuarioJPA objusu) throws Exception {
		return dao.BuscarUsuario(objusu);
	}

	@Override
	public String GrabaUsuario(UsuarioJPA objusu) throws Exception {
		return dao.GrabaUsuario(objusu);
	}

	@Override
	public String ModificaUsuario(UsuarioJPA objusu) throws Exception {
		return dao.ModificaUsuario(objusu);
	}

	@Override
	public String EliminaUsuario(UsuarioJPA objusu) throws Exception {
		return dao.EliminaUsuario(objusu);
	}

	@Override
	public List<UsuarioJPA> ListaUsuario() throws Exception {
		return dao.ListaUsuario();
	}

}
