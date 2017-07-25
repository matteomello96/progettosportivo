package ClassiDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import DBInterfaccia.DbConnection;



public class GetInfoDB {
	 public static int getidTess(String username){

	      
	        
	        Connection con = DbConnection.db;
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	        int ris=1;
	        
	        try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT tesserato.Matricolatesserato FROM tesserato,elencoutenti WHERE elencoutenti.username='"+username+"' AND elencoutenti.idutente=tesserato.idutente"); 
	          
	                rs.next();
	                ris=rs.getInt("Matricolatesserato");
	                		
	            return ris; 
	        } catch (SQLException ex) {
	        
	        }
	        return ris;

	}
	 
	 
	 
	  public static int getlastorder(String num){
	       	 Connection con = DbConnection.db;
		        
		        Statement st;
		        
		        ResultSet rs;
		        
		       
		        int ris=1;
		        
		        try {
		            
		            st = con.createStatement();
		           
		            rs = st.executeQuery("select ordine.idordine from ordine WHERE ordine.datacreazioneordine='"+num+"'"); 
		           
		                rs.next();
		                ris=rs.getInt("idordine");
		                		
		            return ris; 
		        } catch (SQLException ex) {
		           
		        }
		        return ris;
	       }
	  
	    public static String getDate(){
		 	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		 	   new Date();
		 	   Calendar cal = Calendar.getInstance();
		 	  
		 	   String data=dateFormat.format(cal.getTime());
		 	   return data;
		 	}
	    
	    
	    public static String getDateOnly(){
		 	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

		 	   new Date();
		 	   Calendar cal = Calendar.getInstance();
		 	  
		 	   String data=dateFormat.format(cal.getTime());
		 	   return data;
		 	}
	    
	    
	    
}
