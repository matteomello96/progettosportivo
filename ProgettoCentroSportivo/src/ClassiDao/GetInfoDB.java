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
		           
		            rs = st.executeQuery("select iscrizionedisciplina.codiceiscrizionedisciplina from iscrizionedisciplina WHERE iscrizionedisciplina.dataazione='"+num+"'"); 
		           
		                rs.next();
		                ris=rs.getInt("codiceiscrizionedisciplina");
		                		
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
	    
	    
 public static int getcombinazionelivdis(String disciplina,String livello){

	      
	        
	        Connection con = DbConnection.db;
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	        int ris=1;
	        
	        try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT Combinazionelivdis FROM disciplinedisponibili where Disciplina='"+disciplina+"' and Livello='"+livello+"'"); 
	          
	                rs.next();
	                ris=rs.getInt("combinazionelivdis");
	                		
	            return ris; 
	        } catch (SQLException ex) {
	        
	        }
	        return ris;

	}
	    
 public static int getidIstr(String username){

     
     
     Connection con = DbConnection.db;
     
     Statement st;
     
     ResultSet rs;
     

     int ris=1;
     
     try {
         
         st = con.createStatement();
        
         rs = st.executeQuery("SELECT istruttore.matricolaistruttore FROM istruttore,elencoutenti WHERE elencoutenti.username='"+username+"' AND elencoutenti.idutente=istruttore.idutente"); 
       
             rs.next();
             ris=rs.getInt("matricolaistruttore");
             		
         return ris; 
     } catch (SQLException ex) {
     
     }
     return ris;

}
 
 
/*public static int getidcomm(String username,String codice){

     
     
     Connection con = DbConnection.db;
     
     Statement st;
     
     ResultSet rs;
     

     int ris=1;
     
     try {
         
         st = con.createStatement();
        
         rs = st.executeQuery("SELECT CodiceTestimonianza FROM testimonianza WHERE Tesserato='"+username+"'and CodiceTestimonianza='"+codice+"' "); 
       
             rs.next();
             ris=rs.getInt("CodiceTestimonianza");
             		
         return ris; 
     } catch (SQLException ex) {
     
     }
     return ris;

}*/
 
 
 

	    
}
