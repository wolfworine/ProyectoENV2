package pe.gmp.service;

import java.util.List;

import pe.gmp.jpa.OfertaJPA;

public interface OfertaService {
	
public abstract OfertaJPA BuscarOferta(OfertaJPA objOferta) throws Exception;
	
	public abstract String GrabaOferta(OfertaJPA objOferta) throws Exception;
	
	public abstract String ModificaOferta(OfertaJPA objOferta) throws Exception;
	
	public abstract String EliminaOferta(OfertaJPA objOferta) throws Exception;
	
	public abstract List<OfertaJPA> ListaOferta() throws Exception;
	 
}
