package proyecto_Mysql.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import proyecto_Mysql.Mysql.Equipo;
import proyecto_Mysql.Mysql.Partido;
import proyecto_Mysql.Mysql.Pronostico;


/**
 *
 * @author Your name
 */
public class Main {
    public static void main(String... param) throws ClassNotFoundException {
    	
    	Connection conectar = null;
    	
    	
    	String sURL = "jdbc:mysql://localhost:3306/trabajo_integrador";
    			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    	
    		try {
    			
    			conectar = DriverManager.getConnection(sURL, "root", "1234g");
    			
    		// JOptionPane.showMessageDialog(null, "Conexión Exitosa");
    		
    		} catch (SQLException ex) {
    			
    			JOptionPane.showMessageDialog(null, "Conexión Fallida");
    		}
    	

    		Statement s=null; 
        	
        	try {
        		
        		s= conectar.createStatement();
        		
        	}
        	
        	catch (SQLException ex) 	{
        		
        		
        	}
        	
        	int val=2;
        			
        	ResultSet rs=null; 
        	       	
        	
        	try {
        		
        		rs=s.executeQuery ("(SELECT * FROM trabajo_integrador.resultado as resultados inner join trabajo_integrador.equipo \r\n"
        				+ "as equipo2 on resultados.cod_equipo1=equipo2.cod_equipo inner join trabajo_integrador.equipo as equipo3\r\n"
        				+ "on ( resultados.cod_equipo2=equipo3.cod_equipo ) ) ;");
        	
        		
        	//	JOptionPane.showMessageDialog(null,"Consulta Realizada");
        	}
        	
        	catch (SQLException ex) {
        		
        		  JOptionPane.showMessageDialog(null,"Consulta fallida");
        		
        		 
        	}

        	//PARTIDO
        	
        	Partido rr=null;
    	 	
    	 	ArrayList<Partido>arrayPartidos = new ArrayList<Partido>();   	 	
    	 	
    	 	Equipo equipo1;
    	 	Equipo equipo2;    	 	
    	 	
    	 	try {
    	 		
    	 		while(rs.next())
      		 
    	 		{
    	 			
    	 		rr=new Partido();	
    	 		equipo1=new Equipo();
    	 		equipo2=new Equipo();
    	 		
    	 		equipo1.setNombre(rs.getString(7));
    	 		equipo2.setNombre(rs.getString(10));
    	 		rr.setequipo1(equipo1);
    	 		rr.setequipo2(equipo2);
    	 		rr.setGol1(rs.getInt(3));
    	 		rr.setGol2(rs.getInt(4));
    	 		arrayPartidos.add(rr);
    	 	
    	 			
    	 //	System.out.println(rs.getString(7)+" "+rs.getInt(3)+" " + rs.getInt(4)+" "+ rs.getString(10)) ;  		    		
    	 		
    	 		} 
    	 		
    	 	} catch (SQLException ex)	{
    	 		
    	 	}
            	
 
   
			
        	ResultSet pr=null; 
        	
        	try {
        		
        	pr=s.executeQuery ("(SELECT * FROM trabajo_integrador.pronostico as pronostico inner join trabajo_integrador.equipo \r\n"
        			+ "as equipo2 on pronostico.cod_equipo1=equipo2.cod_equipo inner join trabajo_integrador.equipo as equipo3\r\n"
        			+ "on ( pronostico.cod_equipo2=equipo3.cod_equipo ) ) ;"); 
        
        		
        		// JOptionPane.showMessageDialog(null,"Consulta Realizada");
        	}
        	
        	catch (SQLException ex) {
        		
        		  JOptionPane.showMessageDialog(null,"Consulta fallida");
        		
        		 
        	}
        	
        
    	 	
    	 	//PRONOSTICO
    	 	
    	 	Pronostico pronostico = null; 
    	 	
    	 	ArrayList<Pronostico> listaPronostico = new ArrayList<Pronostico>(); 
    		
    		//DECLARAMOS
    	 	
    		Equipo unEquipo1Pronostico;
    		Equipo unEquipo2Pronostico;
    	 		
    		
    		try {
    			while (pr.next())
    			{
    				
    			pronostico=new Pronostico();
    			unEquipo1Pronostico=new Equipo();
    			unEquipo2Pronostico=new Equipo();
    			
    			unEquipo1Pronostico.setNombre(pr.getString(8));
    			unEquipo2Pronostico.setNombre(pr.getString(11));
    			pronostico.setEquipo1(unEquipo1Pronostico);
    			pronostico.setEquipo2(unEquipo2Pronostico);
    			pronostico.setGanaEquipo1(pr.getInt(3));
    			pronostico.setEmpate(pr.getInt(4));
    			pronostico.setGanaEquipo2(pr.getInt(5));
    			
    			listaPronostico.add(pronostico);
    			
    			//System.out.println(pr.getString(8)+" "+pr.getInt(3)+" " + pr.getInt(4)+" "+ pr.getInt(5)+" "+ pr.getString(11)) ; 
    	
    			}    			
    	 		
    	 	} catch (SQLException ex)	{
    	 		
    	 	
    	 	}
    		
    		
    		
    		
    		 int puntos = 0 ;
    		
    		
    		for (int i= 0; i < listaPronostico.size(); i++) { 
    			
    		int empate = 0;
    			
    		if (arrayPartidos.get(i).getequipo1().getNombre().equals(listaPronostico.get(i).getEquipo1().getNombre()) && 
    				arrayPartidos.get(i).getequipo2().getNombre().equals(listaPronostico.get(i).getEquipo2().getNombre())) {
    			
    		
    			// VERIFICAR QUE EQUIPO GANA EN CADA RONDA DE LA LISTA PARTIDOS / RESULTADOS. 
    			
    			if (arrayPartidos.get(i).getGol1() > arrayPartidos.get(i).getGol2() && listaPronostico.get(i).getGanaEquipo1() == 1) {
    				
    				JOptionPane.showMessageDialog(null, "Hay un acierto, el equipo ganador es: " + arrayPartidos.get(i).getequipo1().getNombre() );
    				
    				puntos++; 
    			}	
    			else if (arrayPartidos.get(i).getGol1() < arrayPartidos.get(i).getGol2() && listaPronostico.get(i).getGanaEquipo2() == 1) {
    			
    				JOptionPane.showMessageDialog(null, arrayPartidos.get(i).getequipo2().getNombre());
    				
    				puntos++;
    			
    			}
    			
    			else if (arrayPartidos.get(i).getGol1() == arrayPartidos.get(i).getGol2() && listaPronostico.get(i).getEmpate() == 1) {
    				
    				JOptionPane.showMessageDialog(null, "Hay un acierto, " + arrayPartidos.get(i).getequipo1().getNombre() + " y " + arrayPartidos.get(i).getequipo2().getNombre() + " empataron.");
    				puntos++;
    				
    			}
    	
    		
    		}
    		

    		}
    		
    			JOptionPane.showMessageDialog(null, "La cantidad de aciertos es: " + puntos);			
    			
    }
}