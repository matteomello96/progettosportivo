package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;




import DBInterfaccia.DbConnection;


public class rimuoviordinedao {
	
	
	public static void Uccidi_isc(Object idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("DELETE FROM iscrizionedisciplina WHERE codiceiscrizionedisciplina='"+idordine+"'");
  
	      
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}

}
