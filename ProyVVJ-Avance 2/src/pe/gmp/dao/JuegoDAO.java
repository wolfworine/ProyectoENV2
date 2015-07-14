package pe.gmp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gmp.jpa.JuegoJPA;
import pe.gmp.service.JuegoService;

public class JuegoDAO implements JuegoService {
	
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
	public JuegoJPA BuscarJuego(JuegoJPA objJuego) throws Exception {
		JuegoJPA obj=null;		
		Open();	
		try {
			//Buscamos con JPA			
			obj=em.find(JuegoJPA.class, objJuego.getVj_id());	
		} catch (Exception e) {
		System.out.println("Error: "+e.getMessage());
		}finally{
			Close();			
		}
		return obj;
	}

	@Override
	public String GrabaJuego(JuegoJPA objJuego) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para grabar con em: persist
			em.persist(objJuego);
			
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
	public String ModificaJuego(JuegoJPA objJuego) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para modificar con em: merge
			em.merge(objJuego);
			
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
	public String EliminaJuego(JuegoJPA objJuego) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para eliminar con em: remove
			//pero se necesita buscar primero.
			JuegoJPA obj=null;
			obj=em.find(JuegoJPA.class, objJuego.getVj_id());
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
	public List<JuegoJPA> ListaJuego() throws Exception {
		List<JuegoJPA> lista= null;
		Open();
		try {
			Query q=em.createQuery("Select u from JuegoJPA u");
			lista=q.getResultList();
			
		} catch (Exception e) {
		System.out.println("Error Dao: "+e.getMessage());
		}
		Close();
		return lista;
	}

}
