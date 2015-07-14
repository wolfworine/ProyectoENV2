package pe.gmp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gmp.jpa.OfertaJPA;
import pe.gmp.service.OfertaService;

public class OfertaDAO implements OfertaService {

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
	public OfertaJPA BuscarOferta(OfertaJPA objOferta) throws Exception {
		OfertaJPA obj=null;		
		Open();	
		try {
			//Buscamos con JPA			
			obj=em.find(OfertaJPA.class, objOferta.getOf_id());	
		} catch (Exception e) {
		System.out.println("Error: "+e.getMessage());
		}finally{
			Close();			
		}
		return obj;
	}

	@Override
	public String GrabaOferta(OfertaJPA objOferta) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para grabar con em: persist
			em.persist(objOferta);
			
			em.getTransaction().commit();
			msg="Se grabó con éxito!";
			
		} catch (Exception e) {
			System.out.println("Error Dao: "+e.getMessage());
			msg="Error Dao: "+e.getMessage();
			em.getTransaction().rollback();
		
		}finally{
			Close();
		}
		return msg;
	}

	@Override
	public String ModificaOferta(OfertaJPA objOferta) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para modificar con em: merge
			em.merge(objOferta);
			
			em.getTransaction().commit();
			msg="Se modificó con éxito!";
			
		} catch (Exception e) {
			System.out.println("Error Dao: "+e.getMessage());
			msg="Error Dao: "+e.getMessage();
			em.getTransaction().rollback();
		
		}finally{
			Close();
		}
		return msg;
	}

	@Override
	public String EliminaOferta(OfertaJPA objOferta) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para eliminar con em: remove
			//pero se necesita buscar primero.
			OfertaJPA obj=null;
			obj=em.find(OfertaJPA.class, objOferta.getOf_id());
			if(obj!=null) em.remove(obj);
			
			em.getTransaction().commit();
			msg="Se eliminó con éxito!";
			
		} catch (Exception e) {
			System.out.println("Error Dao: "+e.getMessage());
			msg="Error Dao: "+e.getMessage();
			em.getTransaction().rollback();
		
		}finally{
			Close();
		}
		return msg;
	}

	@Override
	public List<OfertaJPA> ListaOferta() throws Exception {
		List<OfertaJPA> lista= null;
		Open();
		try {
			Query q=em.createQuery("Select u from OfertaJPA u");
			lista=q.getResultList();
			
		} catch (Exception e) {
		System.out.println("Error Dao: "+e.getMessage());
		}
		Close();
		return lista;
	}

}
