package consultorioJat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Medico {
	
	int matricula;
	String nombre;
	String apellido;
	String especialidad;
	
	public Medico(int matricula, String nombre, String apellido, String especialidad) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
	}
	
	public void altaMedico() {
		
		String sql = "INSERT INTO medico (medMat,medNom,medApe,medEsp) values ('"+this.matricula+"','"+this.nombre+"','"+this.apellido+"','"+this.especialidad+"')";
        Connection con=null;
        
            try{        
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
            	Statement st = con.createStatement();
            	st.executeUpdate(sql);
		        System.out.println("Medico agregado correctamente");
            } catch(Exception e) {
			       System.out.println(e.getMessage());
			    }
	}
	
	public static void listadoMedico() {
        Connection con=null;
        
            try{        
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
            	Statement st = con.createStatement();
            	ResultSet rs = st.executeQuery("SELECT * FROM medico");
            	System.out.println("Matricula - Nombre - Apellido - Especialidad");
            	System.out.println("---------------------------------------------");
            	while(rs.next())
            		System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getString(4));
            	            	
            } catch(Exception e) {
			       System.out.println(e.getMessage());
			    }
	}
	
	public static void bajaMedico(int matricula) {
		String sql = "DELETE FROM medico where medMat = '"+matricula+"'";
		Connection con=null;
		try{        
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
        	Statement st = con.createStatement();        	
        	if (st.getUpdateCount() > 0) {
        		st.executeUpdate(sql);
        		System.out.println("Medico dado de baja correctamente"); 
        	} else {
        		System.out.println("No existe la matricula"); 
        	}              	
        	            	
        } catch(Exception e) {
		       System.out.println(e.getMessage());
		    }
	}
}
