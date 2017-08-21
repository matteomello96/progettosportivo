package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;


import visteadmin.frameeventi;


public class confeven {
	
	
	
	
	public static void conf(Object ideven){
		
		   Connection con = DbConnection.db;
	      
	     
	        
	        Statement st;
	   
	        ResultSet rs;
	        
	         int conf,ann;
	        try {
	        
	          
	            st= con.createStatement();
	         
	          //  JOptionPane.showMessageDialog(frameeventi.frame, "Il nome utente \""+ideven+"\" e\\o l'email \""+ideven+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				    
	            
	            rs=st.executeQuery("select confermato from iscrizioneevento where codiceiscrizioneevento='"+ideven+"'");
	        	 rs.next();
	             conf=rs.getInt("confermato");
	            
	             rs=st.executeQuery("select annullato from iscrizioneevento where codiceiscrizioneevento='"+ideven+"'");
	        	 rs.next();
	             ann=rs.getInt("annullato");
	            
   //JOptionPane.showMessageDialog(frameeventi.frame, "Il nome utente \""+conf+"\" e\\o l'email \""+ann+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
	            
	       
	            if(conf==1 && ann==0){
	                       	
	            	st.executeUpdate("UPDATE iscrizioneevento SET confermato=0 WHERE iscrizioneevento.codiceiscrizioneevento='"+ideven+"'");
		        	st.executeUpdate("UPDATE iscrizioneevento SET annullato=1 WHERE iscrizioneevento.codiceiscrizioneevento='"+ideven+"'");
		        
		        	
		        	
		        	JOptionPane.showMessageDialog(frameeventi.frame, "Iscrizione Annullato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        	
		        	
						
	            	
	            	
	            	
	            	
	            }
	            else{
		        	st.executeUpdate("UPDATE iscrizioneevento SET confermato=1 WHERE iscrizioneevento.codiceiscrizioneevento='"+ideven+"'");
		        	st.executeUpdate("UPDATE iscrizioneevento SET annullato=0 WHERE iscrizioneevento.codiceiscrizioneevento='"+ideven+"'");
		        
		        	
		        	JOptionPane.showMessageDialog(frameeventi.frame, "Iscrizione Confermata"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        		
				   	
					
		        	
		            }
	         
	       
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
	}

	
}


