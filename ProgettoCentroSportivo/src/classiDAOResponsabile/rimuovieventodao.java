package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;




import DBInterfaccia.DbConnection;


public class rimuovieventodao {
	
	
	public static void uccudievento(Object ideven){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("DELETE FROM iscrizioneevento WHERE codiceiscrizioneevento='"+ideven+"'");
  
	      
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}

}
