package pe.gmp.service;

import java.util.List;

import pe.gmp.factory.DAOFactory;
import pe.gmp.jpa.CategoriaJPA;

public class CategoriaImpl implements CategoriaService{

	DAOFactory factory=DAOFactory.getFactory(1);

	CategoriaService dao = factory.getCategoriaService();
	
	@Override
	public CategoriaJPA BuscarCategoria(CategoriaJPA objcat) throws Exception {
		return dao.BuscarCategoria(objcat);
		
	}

	@Override
	public String GrabaCategoria(CategoriaJPA objcat) throws Exception {
		return dao.GrabaCategoria(objcat);
	}

	@Override
	public String ModificaCategoria(CategoriaJPA objcat) throws Exception {
		return dao.ModificaCategoria(objcat);
	}

	@Override
	public String EliminaCategoria(CategoriaJPA objcat) throws Exception {
		return dao.EliminaCategoria(objcat);
	}

	@Override
	public List<CategoriaJPA> ListaCategoria() throws Exception {
		return dao.ListaCategoria();
	}
	
}
