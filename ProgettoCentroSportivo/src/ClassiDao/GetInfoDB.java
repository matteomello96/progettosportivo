package ClassiDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import Model.Utente;
import view_tesserato.Confermaordine;
import visteadmin.FrameOrdini;
import visteadmin.framedettagli;




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
	 public static float getcosto(String evento ){
		   
	     Connection con = DbConnection.db;
	 
	     Statement st;
	     
	     ResultSet rs;
	     

	  Float ris = null;
	     
	     try {
	         
	         st = con.createStatement();
	       
	         rs = st.executeQuery("select costoevento from evento where nomeevento='"+evento+"';  "); 
	         rs.next();	               
	         ris=rs.getFloat("costoevento");    
	         return ris;
	     } 
	     
	     catch (SQLException ex) {
	     	
	     }
			
	     return ris;}
	 
	 public static float getcostoatt(String disciplina,String livello ){
		   
	     Connection con = DbConnection.db;
	 
	     Statement st;
	     
	     ResultSet rs;
	     

	  Float ris = null;
	     
	     try {
	         
	         st = con.createStatement();
	       
	         rs = st.executeQuery("select costomensile from disciplinedisponibili where disciplina='"+disciplina+"' and livello ='"+livello+"';  "); 
	         rs.next();	               
	         ris=rs.getFloat("costomensile");    
	         return ris;
	     } 
	     
	     catch (SQLException ex) {
	     	
	     }
			
	     return ris;}
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
	    
	    
 public static int getcombinazionelivdis(String disciplina , String livello){
   
	        Connection con = DbConnection.db;
	    
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	      int ris=-1;
	        
	        try {
	            
	            st = con.createStatement();
	          
	            rs = st.executeQuery("select combinazionelivdis from disciplinedisponibili where Disciplina='"+disciplina+"' and Livello='"+livello+"'  "); 
	            rs.next();	               
	            ris=rs.getInt("combinazionelivdis");    
	            return ris;
	        } 
	        
	        catch (SQLException ex) {
	        	
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
public static int getcodiceturno(String fasciaor,String giornoset, String spazio ){

     
     
     Connection con = DbConnection.db;
     
     Statement st;
     
     ResultSet rs;
     

     int ris=1;
     
     try {
         
         st = con.createStatement();
        
         rs = st.executeQuery("SELECT codiceturno from gestioneturno WHERE fasciaoraria='"+fasciaor+"' AND giornosettimana='"+fasciaor+"' AND spazio='"+spazio+"'"); 
       
             rs.next();
             ris=rs.getInt("codiceturno");
             		
         return ris; 
     } catch (SQLException ex) {
     
     }
     return ris;

}

public static int getcodiceturnoevento(String fasciaor,String giornoset, String spazio ){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=1;
    
    try {
        
        st = con.createStatement();
       
        rs = st.executeQuery("SELECT codiceturnoevento from gestioneturnoevento WHERE fasciaoraria='"+fasciaor+"' AND giornosettimana='"+fasciaor+"' AND spazio='"+spazio+"'"); 
      
            rs.next();
            ris=rs.getInt("codiceturnoevento");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}


 
 
public static int getiddet(String disciplina,String livello,int tesserato){

     
     
     Connection con = DbConnection.db;
     
     Statement st;
     
     ResultSet rs;
     

     int ris=-1;
     
     try {
         
         st = con.createStatement();

       
    //   JOptionPane.showMessageDialog(framedettagli.frame, " '"+a+"','"+disciplina+"','"+livello+"','"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' "," ",JOptionPane.WARNING_MESSAGE);				
         rs = st.executeQuery("SELECT iddet FROM detiscr WHERE tesserato='"+tesserato+"' and combinazionelivdis= '"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"'  "); 
       
             rs.next();
             ris=rs.getInt("iddet");
             		
         return ris; 
     } catch (SQLException ex) {
     
     }
     return ris;

}




public static int getcodiceturno(String disciplina,String livello,String giorno, String orario){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select codiceturno from gestioneturno where fasciaoraria='"+orario+"' and Giornosettimana='"+giorno+"' and Combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"'");
      
            rs.next();
            ris=rs.getInt("codiceturno");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}



public static int getprenotazioni(int codiceturno){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select prenotazionidisponibili from gestioneturno where codiceturno='"+codiceturno+"'");
      
            rs.next();
            ris=rs.getInt("prenotazionidisponibili");
            		
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
