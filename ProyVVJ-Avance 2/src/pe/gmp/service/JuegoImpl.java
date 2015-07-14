package pe.gmp.service;

import java.util.List;

import pe.gmp.factory.DAOFactory;
import pe.gmp.jpa.JuegoJPA;

public class JuegoImpl implements JuegoService {
	
	DAOFactory factory=DAOFactory.getFactory(1);
	
	JuegoService dao=factory.getJuegoService();

	@Override
	public JuegoJPA BuscarJuego(JuegoJPA objJuego) throws Exception {
		return dao.BuscarJuego(objJuego);
	}

	@Override
	public String GrabaJuego(JuegoJPA objJuego) throws Exception {
		return dao.GrabaJuego(objJuego);
	}

	@Override
	public String ModificaJuego(JuegoJPA objJuego) throws Exception {
		return dao.ModificaJuego(objJuego);
	}

	@Override
	public String EliminaJuego(JuegoJPA objJuego) throws Exception {
		return dao.EliminaJuego(objJuego);
	}

	@Override
	public List<JuegoJPA> ListaJuego() throws Exception {
		return dao.ListaJuego();
	}

}
