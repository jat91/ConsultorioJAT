package consultorioJat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consultorio {
	
	public static Connection con = null;
	
	// Menus
	
	public static void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		boolean opMenu = false;
		do {
			try {		
			
	        System.out.print("1 - Medicos\n");
	        System.out.print("2 - Pacientes\n");
	        System.out.print("3 - Historias Clinicas\n");
	        System.out.print("4 - Salir\n");
	        int opcion = sc.nextInt();
	        
	        switch (opcion) {
	        case 1:
				Consultorio.menuMedicos();
				break;
				
			case 2:
				Consultorio.menuPacientes();
				break;
			case 3:
				Consultorio.menuHc();
				break;
			case 4:
				System.out.println("Gracias por usar el sistema");
				Consultorio.cerrarConexion();
				opMenu = true;
				System.exit(0);
				break;
			default:
				System.out.println("Debe ingresar un numero del menu");
				break;
	        }
		} catch (InputMismatchException ex) {
			System.out.println("Debe ingresar un numero del menu");
			sc.next();
		}
		}while (!opMenu);
	}
	
	public static void menuMedicos() {
		Scanner sc = new Scanner(System.in);
		boolean opMenuMed = false;
		do {
			
			try {
				
		        System.out.print("1 - Alta\n");
		        System.out.print("2 - Baja\n");
		        System.out.print("3 - Listado\n");
		        System.out.print("4 - Volver al menu principal\n");
		        int opcion = sc.nextInt();
		        
		        switch (opcion) {
		        case 1:
		        	try {
		        		//Alta medico
		        		System.out.println("Ingrese la matricula del medico: ");
			            int medMat  = sc.nextInt();
			            System.out.println("Ingrese el nombre del medico: ");
			            String medNom = sc.next();
			            System.out.println("Ingrese el apellido del medico: ");
			            String medApe = sc.next();
			            System.out.println("Ingrese la especialidad del medico: ");
			            String medEsp = sc.next();
			            
			            Medico medico = new Medico(medMat, medNom, medApe, medEsp);
			            
			            medico.altaMedico();
			            
		        	} catch (Exception ex) {
		        		System.out.println(ex.getMessage());
		        	}
		        	break;
		        case 2:
		        	try {
		        		//baja medico
		        		System.out.println("Ingrese la matricula del medico que quiera dar de baja\n");
		        		Medico.listadoMedico();
			            int medMat  = sc.nextInt();
			            Medico.bajaMedico(medMat);
			            			            
		        	} catch (Exception ex) {
		        		System.out.println(ex.getMessage());
		        	}
		        	break;
		        case 3:
		        	//listado medicos
		        	Medico.listadoMedico();
		        	break;
		        case 4:
		        	Consultorio.menuPrincipal();
		        	opMenuMed = true;
		        	break;
		        }
			} catch (InputMismatchException ex) {
				System.out.println("Debe ingresar un numero del menu");
				sc.next();
			}
		} while(!opMenuMed);
	}
	
	public static void menuPacientes() {
		Scanner sc = new Scanner(System.in);
		boolean opMenuPac = false;
		do {
			
			try {
				
		        System.out.print("1 - Alta\n");
		        System.out.print("2 - Baja\n");
		        System.out.print("3 - Listado\n");
		        System.out.print("4 - Volver al menu principal\n");
		        int opcion = sc.nextInt();
		        
		        switch (opcion) {
		        case 1:
		        	try {
		        		//Alta paciente
		        		System.out.println("Ingrese el DNI del paciente: ");
			            int pacDni  = sc.nextInt();
			            System.out.println("Ingrese el nombre del paciente: ");
			            String pacNom = sc.next();
			            System.out.println("Ingrese el apellido del paciente: ");
			            String pacApe = sc.next();
			            
			            Paciente paciente = new Paciente(pacDni, pacNom, pacApe);
			            
			            paciente.altaPaciente();
			            
		        	} catch (Exception ex) {
		        		System.out.println(ex.getMessage());
		        	}
		        	break;
		        case 2:
		        	try {
		        		//BAJA PACIENTE
		        		System.out.println("Ingrese el DNI del paciente que quiera dar de baja\n");
		        		Paciente.listadoPaciente();
			            int pacDni  = sc.nextInt();
			            Paciente.bajaPaciente(pacDni);
			            			            
		        	} catch (Exception ex) {
		        		System.out.println(ex.getMessage());
		        	}
		        	break;
		        case 3:
		        	//LISTADO PACIENTES
		        	Paciente.listadoPaciente();
		        	break;
		        case 4:
		        	Consultorio.menuPrincipal();
		        	opMenuPac = true;
		        	break;
		        }
			} catch (InputMismatchException ex) {
				System.out.println("Debe ingresar un numero del menu");
				sc.next();
			}
		} while(!opMenuPac);
	}
	
	public static void menuHc() {
		Scanner sc = new Scanner(System.in);
		boolean opMenuHc = false;
		do {
			
			try {
				
		        System.out.print("1 - Alta\n");
		        System.out.print("2 - Listado\n");
		        System.out.print("3 - Volver al menu principal\n");
		        int opcion = sc.nextInt();
		        
		        switch (opcion) {
		        case 1:
		        	try {
		        		//Alta HC
		        		System.out.println("Ingrese el numero de HC: ");
			            int hcNum  = sc.nextInt();
			            sc.reset();
			            System.out.println("Ingrese fecha yyyy-m-dd: ");          
			            String hcFecIng = sc.next();
			            sc.reset();
			            System.out.println("Ingrese el dni del paciente: ");
			            int hcPacDni  = sc.nextInt();
			            sc.reset();
			            System.out.println("Ingrese la matricula del medico: ");
			            int hcMedMat  = sc.nextInt();
			            sc.reset();
			            System.out.println("Ingrese el diagnostico: ");
			            String hcDiag = sc.next();
			            sc.reset();
			            System.out.println("Ingrese el tratamiento: ");
			            String hcTrat = sc.next();
			            sc.reset();
			            
			            HistoriaClinica hc = new HistoriaClinica(hcNum, hcFecIng, hcPacDni,hcMedMat,hcDiag,hcTrat);
			            
			            hc.altaHc();
			            
		        	} catch (Exception ex) {
		        		System.out.println(ex.getMessage());
		        	}
		        	break;
		        case 2:
		        	//LISTADO HC
		        	HistoriaClinica.listadoHc();
		        	break;
		        case 3:
		        	Consultorio.menuPrincipal();
		        	opMenuHc = true;
		        	break;
		        }
			} catch (InputMismatchException ex) {
				System.out.println("Debe ingresar un numero del menu");
				sc.next();
			}
		} while(!opMenuHc);
	}
	
	
	// Conexiones
	
	public static void hacerConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultoriojat?autoReconnect=true&useSSL=false","root","joaquin2023");
			System.out.print("BIENVENIDO AL CONSULTORIO JAT\n");
		} catch (SQLException ex) {
            System.out.println("Error al conectarse al sistema. Ponganse en contacto con IT");
            System.exit(0);
        } catch (Exception e) {
        	System.out.println("Error al conectarse al sistema. Ponganse en contacto con IT");
        	System.exit(0);
        }
	}
	
	public static void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException ex) {
            System.out.println("Error al cerrar el sistema. Ponganse en contacto con IT");
            System.exit(0);
        } catch (Exception e) {
        	System.out.println("Error al cerrar el sistema. Ponganse en contacto con IT");
        	System.exit(0);
        }
	}
	
	// Main

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Hago conexión
		Consultorio.hacerConexion();	
		
		//Menu principal
		Consultorio.menuPrincipal();
		

	}

}
