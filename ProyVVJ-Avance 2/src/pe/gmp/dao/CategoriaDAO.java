package pe.gmp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gmp.jpa.CategoriaJPA;
import pe.gmp.jpa.UsuarioJPA;

import pe.gmp.service.CategoriaService;

public class CategoriaDAO implements CategoriaService{

		EntityManagerFactory emf;
		EntityManager em;
		CategoriaJPA obj=null;
	
		
		public void Open(){
			emf=Persistence.createEntityManagerFactory("ProyEv1");
			em=emf.createEntityManager();	
		}
		public void Close(){
			em.close();
			emf.close();		
		}	
		

	
		@Override
		public CategoriaJPA BuscarCategoria(CategoriaJPA objcat)
				throws Exception {
					
			Open();	
			try {
				//Buscamos con JPA
//				obj.setUsernom(objusu.getUsernom());
//				obj.setUserpwd(objusu.getUserpwd());
//				
//				obj=em.find(UsuarioJPA.class, obj);	
				
				obj=em.find(CategoriaJPA.class, objcat.getCat_id());	
			} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			}finally{
				Close();			
			}
			return obj;
		}
		
		
		@Override
		public String GrabaCategoria(CategoriaJPA objcat) throws Exception {
			String msg="";
			try {
				Open();
				em.getTransaction().begin();
				//metodo para grabar con em: persist
				em.persist(objcat);
				
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
		public String ModificaCategoria(CategoriaJPA objcat) throws Exception {
			String msg="";
			try {
				Open();
				em.getTransaction().begin();
				//metodo para modificar con em: merge
				em.merge(objcat);
				
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
		public String EliminaCategoria(CategoriaJPA objcat) throws Exception {
			String msg="";
			try {
				Open();
				em.getTransaction().begin();
				//metodo para eliminar con em: remove
				//pero se necesita buscar primero.
				UsuarioJPA obj=null;
				obj=em.find(UsuarioJPA.class, objcat.getCat_id());
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
		public List<CategoriaJPA> ListaCategoria() throws Exception {
			List<CategoriaJPA> lista = null;
			Open();
			try{
				Query c=em.createQuery("SELECT u FROM CategoriaJPA u");
				lista=c.getResultList();
			} catch(Exception e){
				System.out.println("Error Dao :" + e.getMessage());
			}
		Close();
		return lista;
		
		}

}
