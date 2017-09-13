package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import VisteUtenteGenerico.FrameCambia;
import visteadmin.FrameDettagliDaAccResp;

public class Uccidi_iscrizione {
	
	
	
	public static void Uccidi_isc(int iddet,int codiceturno,int tesserato,int conf){
		
		   Connection con = DbConnection.db;
		   Statement st;
		
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("DELETE FROM detiscr WHERE iddet='"+iddet+"'");
	      st.executeUpdate("DELETE FROM iscrizioniperturno WHERE codiceturno='"+codiceturno+"' and tesserato='"+tesserato+"'");      
	      
	      
	      
	      
	    if(conf==1){  
	  	st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'+1 WHERE codiceturno='"+codiceturno+"'"); 
	  	
	    }
	    JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, "Ordine Cancellato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        	
		        	
						
	            	
	            	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
	}

}
