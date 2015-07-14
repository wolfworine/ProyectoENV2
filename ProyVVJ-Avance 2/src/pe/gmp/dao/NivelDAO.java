package pe.gmp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gmp.jpa.NivelJPA;
import pe.gmp.service.NivelService;

public class NivelDAO implements NivelService{
	
	EntityManagerFactory emf;	
	EntityManager em;
	
	public void Open(){
		emf=Persistence.createEntityManagerFactory("ProyEv1");
		em=emf.createEntityManager();	
	}
	
	public void Close(){
		em.close();
		emf.close();		
	}	
	

	@Override
	public List<NivelJPA> listadonivel() throws Exception {
		List<NivelJPA> lista= null;
		Open();
		try {
			Query q=em.createQuery("Select n from NivelJPA n");
			lista=q.getResultList();
			
		} catch (Exception e) {
		System.out.println("Error Dao: "+e.getMessage());
		}
		Close();
		return lista;
	}

	

}
