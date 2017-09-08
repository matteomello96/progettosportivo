package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;




import DBInterfaccia.DbConnection;


public class GestioneIscrizioniDAO {
	
	
	public static void Uccidi_isc(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	            
	            
	      st.executeUpdate("DELETE FROM detiscr WHERE idiscrizione='"+idordine+"'");
	      st.executeUpdate("DELETE FROM iscrizionedisciplina WHERE codiceiscrizionedisciplina='"+idordine+"'");
	      
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}
	public static void ConfermaIscrizione(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("UPDATE iscrizionedisciplina set confermato=1  WHERE codiceiscrizionedisciplina='"+idordine+"'");
 
	      
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}
	
	public static void AccettaModifiche(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("UPDATE iscrizionedisciplina SET modificato=0 WHERE codiceiscrizionedisciplina='"+idordine+"'");
 
	      
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}
	
	public static void AnnullaRichiesta(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("UPDATE iscrizionedisciplina SET annullato WHERE codiceiscrizionedisciplina='"+idordine+"' WHERE codiceiscrizionedisciplina='"+idordine+"'");
 
	      
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}
}
