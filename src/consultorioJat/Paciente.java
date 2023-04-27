package consultorioJat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Paciente {
	
	int dni;
	String nombre;
	String apellido;
	
	public Paciente(int dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public void altaPaciente() {
			
			String sql = "INSERT INTO paciente (pacDni,pacNom,pacApe) values ('"+this.dni+"','"+this.nombre+"','"+this.apellido+"')";
	        Connection con=null;
	        
	            try{        
	            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
	            	Statement st = con.createStatement();
	            	st.executeUpdate(sql);
			        System.out.println("Paciente agregado correctamente");
	            } catch(Exception e) {
				       System.out.println(e.getMessage());
				    }
	}
	
	public static void listadoPaciente() {
        Connection con=null;
        
            try{        
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
            	Statement st = con.createStatement();
            	ResultSet rs = st.executeQuery("SELECT * FROM paciente");
            	System.out.println("DNI - Nombre - Apellido");
            	System.out.println("---------------------------------------------");
            	while(rs.next())
            		System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3));
            	            	
            } catch(Exception e) {
			       System.out.println(e.getMessage());
			    }
	}
	
	public static void bajaPaciente(int dni) {
		String sql = "DELETE FROM paciente where pacDni = '"+dni+"'";
		Connection con=null;
		try{        
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
        	Statement st = con.createStatement();        	
        	if (st.getUpdateCount() > 0) {
        		st.executeUpdate(sql);
        		System.out.println("Paciente dado de baja correctamente"); 
        	} else {
        		System.out.println("No existe el dni"); 
        	}              	
        	            	
        } catch(Exception e) {
		       System.out.println(e.getMessage());
		    }
	}
	
}
