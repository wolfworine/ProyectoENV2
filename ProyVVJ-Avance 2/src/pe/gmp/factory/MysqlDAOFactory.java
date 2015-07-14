package pe.gmp.factory;

import pe.gmp.dao.CategoriaDAO;
import pe.gmp.dao.JuegoDAO;
import pe.gmp.dao.NivelDAO;
import pe.gmp.dao.OfertaDAO;
import pe.gmp.dao.UsuarioDAO;
import pe.gmp.service.CategoriaService;
import pe.gmp.service.JuegoService;
import pe.gmp.service.NivelService;
import pe.gmp.service.OfertaService;
import pe.gmp.service.UsuarioService;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public UsuarioService getUsuarioService() {
		return new UsuarioDAO();
	}

	@Override
	public NivelService getNivelService() {
		return new NivelDAO();
	}

	@Override
	public OfertaService getOfertaService() {
		return new OfertaDAO();
	}

	@Override
	public JuegoService getJuegoService() {
		return new JuegoDAO();
	}

	@Override
	public CategoriaService getCategoriaService() {
		return new CategoriaDAO();
	}

	
}
