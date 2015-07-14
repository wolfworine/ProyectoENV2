package pe.gmp.service;

import java.util.List;

import pe.gmp.factory.DAOFactory;
import pe.gmp.jpa.OfertaJPA;

public class OfertaImpl implements OfertaService{

	DAOFactory factory=DAOFactory.getFactory(1);
	
	OfertaService dao=factory.getOfertaService();

	@Override
	public String GrabaOferta(OfertaJPA objOferta) throws Exception {
		return dao.GrabaOferta(objOferta);
	}

	@Override
	public String ModificaOferta(OfertaJPA objOferta) throws Exception {
		return dao.ModificaOferta(objOferta);
	}

	@Override
	public String EliminaOferta(OfertaJPA objOferta) throws Exception {
		return dao.EliminaOferta(objOferta);
	}

	@Override
	public OfertaJPA BuscarOferta(OfertaJPA objOferta) throws Exception {
		return dao.BuscarOferta(objOferta);
	}

	@Override
	public List<OfertaJPA> ListaOferta() throws Exception {
		return dao.ListaOferta();
	}
	


}
