package consultorioJat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HistoriaClinica {
	
	int hcNum;
	String fecha;
	int hcPacDni;
	int hcMedMat;
	String hcDiag;
	String hcTrat;
	
	public HistoriaClinica(int hcNum, String fecha, int hcPacDni, int hcMedMat, String hcDiag, String hcTrat) {
		this.hcNum = hcNum;
		this.fecha = fecha;
		this.hcPacDni = hcPacDni;
		this.hcMedMat = hcMedMat;
		this.hcDiag = hcDiag;
		this.hcTrat = hcTrat;
	}
	
	public void altaHc() {
		
		String sql = "INSERT INTO historiaclinica (hcNum,hcFecIng,hcPacDNI,hcMedMat,hcDiag,hcTrat) values ('"+this.hcNum+"','"+this.fecha+"','"+this.hcPacDni+"','"+this.hcMedMat+"','"+this.hcDiag+"','"+this.hcTrat+"')";
        Connection con=null;
        
            try{        
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
            	Statement st = con.createStatement();
            	st.executeUpdate(sql);
		        System.out.println("Historia clinica agregado correctamente");
            } catch(Exception e) {
			       System.out.println(e.getMessage());
			    }
	}
	
	public static void listadoHc() {
        Connection con=null;
        
            try{        
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false", "root","joaquin2023");  
            	Statement st = con.createStatement();
            	ResultSet rs = st.executeQuery("SELECT * FROM historiaclinica");
            	System.out.println("Id - Fecha - Paciente - Medico - Diagnostico - Tratamiento");
            	System.out.println("---------------------------------------------");
            	while(rs.next())
            		System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3)+" - "+rs.getInt(4)+" - "+rs.getString(5)+" - "+rs.getString(6));
            	            	
            } catch(Exception e) {
			       System.out.println(e.getMessage());
			    }
	}

}
