package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import Model.Utente;
import VisteUtenteGenerico.FrameCambia;
import view_tesserato.FrameTesserato;
import visteadmin.FrameOrdini;
import visteadmin.FrameResponsabile;

public class ConfermaDao {
	
	
	
	
	public static void Confermaiscrizione(int idordine){
		
		   Connection con = DbConnection.db;
	        Connection con2 = DbConnection.db;
	        Statement st,st2;
	        ResultSet rs;
	        ResultSet rs1;
	         int conf,ann;
	        try {
	            
	            st= con.createStatement();
	            st2 = con2.createStatement();
	       
	            rs=st2.executeQuery("select confermato from ordine where idordine='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("confermato");
	            
	             rs1=st2.executeQuery("select annullato from ordine where idordine='"+idordine+"'");
	        	 rs1.next();
	             ann=rs1.getInt("annullato");
	            
//   JOptionPane.showMessageDialog(null, "Il nome utente \""+conf+"\" e\\o l'email \""+ann+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
	            
	            if(conf==0 && ann==1){
	        	st2.executeUpdate("UPDATE ordine SET confermato=1 WHERE ordine.idordine='"+idordine+"'");
	        	st.executeUpdate("UPDATE ordine SET annullato=0 WHERE ordine.idordine='"+idordine+"'");
	        	JOptionPane.showMessageDialog(FrameCambia.frame, "Ordine Confermato"," ",JOptionPane.INFORMATION_MESSAGE);
	        	
	        		FrameResponsabile.frame.setEnabled(true);
			   	
				FrameOrdini.frame.setVisible(false);
				FrameOrdini.frame.dispose();
	        	
	            }
	            else
	            {
	            	
	            	st2.executeUpdate("UPDATE ordine SET confermato=0 WHERE ordine.idordine='"+idordine+"'");
		        	st.executeUpdate("UPDATE ordine SET annullato=1 WHERE ordine.idordine='"+idordine+"'");
		        	JOptionPane.showMessageDialog(FrameCambia.frame, "Ordine Confermato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        		FrameResponsabile.frame.setEnabled(true);
				   	
					FrameOrdini.frame.setVisible(false);
					FrameOrdini.frame.dispose();	
	            	
	            	
	            	
	            	
	            }
	         
	       
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
	}

	
}


