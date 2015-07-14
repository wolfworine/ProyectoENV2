package pe.gmp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public Connection Conectarse(){
		Connection cn=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_proyPE","root","mysql");
			
		}catch(Exception e){
			System.out.println("Error de conexion:" +e.getMessage());
			
		}
		
		return cn;
	}

}
