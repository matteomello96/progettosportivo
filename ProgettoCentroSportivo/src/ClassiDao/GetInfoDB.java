package ClassiDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBInterfaccia.DbConnection;



public class GetInfoDB {
	 public static int getidTess(String nomeutente){

	      
	        
	        Connection con = DbConnection.db;
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	        int ris=1;
	        
	        try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT tesserato.Matricolatesserato FROM tesserato,elencoutenti WHERE elencoutenti.nomeutente='"+nomeutente+"' AND elencoutenti.idutente=tesserato.idutente"); 
	          
	                rs.next();
	                ris=rs.getInt("Matricolatesserato");
	                		
	            return ris; 
	        } catch (SQLException ex) {
	        
	        }
	        return ris;

	}
}
