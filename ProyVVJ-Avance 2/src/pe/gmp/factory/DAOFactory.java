package pe.gmp.factory;

import pe.gmp.service.CategoriaService;
import pe.gmp.service.JuegoService;
import pe.gmp.service.NivelService;
import pe.gmp.service.OfertaService;
import pe.gmp.service.UsuarioService;

public abstract class DAOFactory {
	
	public static final int mysql=1;
	public static final int jpa=2;
	
	public abstract UsuarioService getUsuarioService();
	public abstract OfertaService getOfertaService();
	public abstract CategoriaService getCategoriaService();
	public abstract JuegoService getJuegoService();
	public abstract NivelService getNivelService();
	
	
	
	public static DAOFactory getFactory(int bd){
		
		switch (bd) {
		case 1:
			return new MysqlDAOFactory();
			
		}
		return null;
		
	}

}
