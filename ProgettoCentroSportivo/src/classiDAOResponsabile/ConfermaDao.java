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
	        Connection con3 = DbConnection.db;
	        Connection con4 = DbConnection.db;
	        
	        Statement st,st2,st3,st4;
	   
	        ResultSet rs,rs1;
	        
	         int conf,ann;
	        try {
	            
	            st= con.createStatement();
	            st2 = con2.createStatement();
	            st3 = con3.createStatement();
	            st4 = con4.createStatement();
	            
	            rs=st2.executeQuery("select confermato from iscrizionedisciplina where codiceiscrizionedisciplina='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("confermato");
	            
	             rs1=st2.executeQuery("select annullato from iscrizionedisciplina where codiceiscrizionedisciplina='"+idordine+"'");
	        	 rs1.next();
	             ann=rs1.getInt("annullato");
	            
//   JOptionPane.showMessageDialog(null, "Il nome utente \""+conf+"\" e\\o l'email \""+ann+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
	            
	       
	            if(conf==1 && ann==0){
	                       	
	            	st2.executeUpdate("UPDATE iscrizionedisciplina SET confermato=0 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        	st.executeUpdate("UPDATE iscrizionedisciplina SET annullato=1 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        	st3.executeUpdate("UPDATE detiscr SET confermato=0 WHERE  detiscr.giorno!='null' and detiscr.orario!='null' and detiscr.idiscrizione='"+idordine+"'");
		        	st4.executeUpdate("UPDATE detiscr SET annullato=1 WHERE  detiscr.giorno!='null' and detiscr.orario!='null' and detiscr.idiscrizione='"+idordine+"'");
		        	
		        	
		        	JOptionPane.showMessageDialog(FrameCambia.frame, "Ordine Annullato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        	
		        	
						
	            	
	            	
	            	
	            	
	            }
	            else{
		        	st2.executeUpdate("UPDATE iscrizionedisciplina SET confermato=1 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        	st.executeUpdate("UPDATE iscrizionedisciplina SET annullato=0 WHERE iscrizionedisciplina.codiceiscrizionedisciplina='"+idordine+"'");
		        	st3.executeUpdate("UPDATE detiscr SET confermato=1 WHERE detiscr.giorno!='null' and detiscr.orario!='null' and detiscr.idiscrizione='"+idordine+"'");
		        	st4.executeUpdate("UPDATE detiscr SET annullato=0 WHERE detiscr.giorno!='null' and detiscr.orario!='null' and detiscr.idiscrizione='"+idordine+"'");
		        	
		        	JOptionPane.showMessageDialog(FrameCambia.frame, "Ordine Confermato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        		
				   	
					
		        	
		            }
	         
	       
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
	}

	
}


