package pe.gmp.service;

import java.util.List;

import pe.gmp.jpa.NivelJPA;

public interface NivelService {
	
	public abstract List<NivelJPA> listadonivel() throws Exception;
	

}
