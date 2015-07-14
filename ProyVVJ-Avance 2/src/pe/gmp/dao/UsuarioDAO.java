package pe.gmp.dao;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gmp.jpa.UsuarioJPA;
import pe.gmp.service.UsuarioService;
//import pe.gmp.util.Conexion;

public class UsuarioDAO implements UsuarioService{
	
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
	public UsuarioJPA BuscarUsuario(UsuarioJPA objusu) throws Exception {
		UsuarioJPA obj=null;		
		Open();	
		try {
			//Buscamos con JPA
//			obj.setUsernom(objusu.getUsernom());
//			obj.setUserpwd(objusu.getUserpwd());
//			
//			obj=em.find(UsuarioJPA.class, obj);	
			
			obj=em.find(UsuarioJPA.class, objusu.getUsernom());	
		} catch (Exception e) {
		System.out.println("Error: "+e.getMessage());
		}finally{
			Close();			
		}
		return obj;
		
	}

	@Override
	public String GrabaUsuario(UsuarioJPA objusu) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para grabar con em: persist
			em.persist(objusu);
			
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
	public String ModificaUsuario(UsuarioJPA objusu) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para modificar con em: merge
			em.merge(objusu);
			
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
	public String EliminaUsuario(UsuarioJPA objusu) throws Exception {
		String msg="";
		try {
			Open();
			em.getTransaction().begin();
			//metodo para eliminar con em: remove
			//pero se necesita buscar primero.
			UsuarioJPA obj=null;
			obj=em.find(UsuarioJPA.class, objusu.getUsernom());
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
	public List<UsuarioJPA> ListaUsuario() throws Exception {
		List<UsuarioJPA> lista= null;
		Open();
		try {
			Query q=em.createQuery("Select u from UsuarioJPA u");
			lista=q.getResultList();
			
		} catch (Exception e) {
		System.out.println("Error Dao: "+e.getMessage());
		}
		Close();
		return lista;
	}
	
//	Sin persistencia!!!!
//	@Override
//	public UsuarioJPA BuscarUsuario(UsuarioJPA objusu) {
//		UsuarioJPA obj=null;
//		
//		Conexion conex=new Conexion();
//		
//		try {
//			
//			PreparedStatement cmd;
//			cmd=conex.Conectarse().prepareStatement("select * from usuario where usernom=?");
//			cmd.setString(1,objusu.getUsernom());	
//			ResultSet rs= cmd.executeQuery();
//			
//			if(rs.next()){
//				obj=new UsuarioJPA();
//				obj.setNombre(rs.getString("usernom"));
//				obj.setCorreo(rs.getString("correo"));				
//			}
//			
//		} catch (Exception e) {
//			System.out.println("Error Dao: "+e.getMessage());
//		}
//		
//		return obj;
//	}

	
	
}
