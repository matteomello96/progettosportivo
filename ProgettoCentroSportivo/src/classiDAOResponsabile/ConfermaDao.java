package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;

import VisteUtenteGenerico.FrameCambia;


public class ConfermaDao {
	
	
	
	
	public static void Confermaiscrizione(int idordine){
		
		   Connection con = DbConnection.db;
	        Connection con2 = DbConnection.db;
	     
	        
	        Statement st;
	   
	        ResultSet rs;
	        
	         int conf,ann;
	        try {
	            
	            st= con.createStatement();
	         
	           
	            
	            rs=st.executeQuery("select confermato from iscrizionedisciplina where codiceiscrizionedisciplina='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("confermato");
	            
	             rs=st.executeQuery("select annullato from iscrizionedisciplina where codiceiscrizionedisciplina='"+idordine+"'");
	        	 rs.next();
	             ann=rs.getInt("annullato");
	            
//   JOptionPane.showMessageDialog(null, "Il nome utente \""+conf+"\" e\\o l'email \""+ann+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
	            
	       
	            if(conf==1 && ann==0){
	                       	
	            	st.executeUpdate("UPDATE iscrizionedisciplina SET confermato=0 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        	st.executeUpdate("UPDATE iscrizionedisciplina SET annullato=1 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        
		        	
		        	
		        	JOptionPane.showMessageDialog(FrameCambia.frame, "Ordine Annullato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        	
		        	
						
	            	
	            	
	            	
	            	
	            }
	            else{
		        	st.executeUpdate("UPDATE iscrizionedisciplina SET confermato=1 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        	st.executeUpdate("UPDATE iscrizionedisciplina SET annullato=0 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        
		        	
		        	JOptionPane.showMessageDialog(FrameCambia.frame, "Ordine Confermato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        		
				   	
					
		        	
		            }
	         
	       
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
	}

	
}


