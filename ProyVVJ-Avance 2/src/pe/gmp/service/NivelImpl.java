package pe.gmp.service;

import java.util.List;

import pe.gmp.factory.DAOFactory;
import pe.gmp.jpa.NivelJPA;

public class NivelImpl implements NivelService {
	
	DAOFactory factory=DAOFactory.getFactory(1);
	NivelService dao=factory.getNivelService();

	@Override
	public List<NivelJPA> listadonivel() throws Exception {
		return dao.listadonivel();
	}

}
