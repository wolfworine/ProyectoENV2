package pe.gmp.service;

import java.util.List;

import pe.gmp.jpa.CategoriaJPA;

public interface CategoriaService {

	//todos los datos de un Categoria es un bean Categoria.
	public abstract CategoriaJPA BuscarCategoria(CategoriaJPA objcat) throws Exception;
	
	public abstract String GrabaCategoria(CategoriaJPA objcat) throws Exception;
	
	public abstract String ModificaCategoria(CategoriaJPA objcat) throws Exception;
	
	public abstract String EliminaCategoria(CategoriaJPA objcat) throws Exception;
	
	public abstract List<CategoriaJPA> ListaCategoria() throws Exception;
	
	
	
}
