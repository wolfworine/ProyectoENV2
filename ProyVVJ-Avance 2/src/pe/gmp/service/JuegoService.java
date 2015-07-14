package pe.gmp.service;

import java.util.List;

import pe.gmp.jpa.JuegoJPA;

public interface JuegoService {
	
public abstract JuegoJPA BuscarJuego(JuegoJPA objJuego) throws Exception;
	
	public abstract String GrabaJuego(JuegoJPA objJuego) throws Exception;
	
	public abstract String ModificaJuego(JuegoJPA objJuego) throws Exception;
	
	public abstract String EliminaJuego(JuegoJPA objJuego) throws Exception;
	
	public abstract List<JuegoJPA> ListaJuego() throws Exception;
}
