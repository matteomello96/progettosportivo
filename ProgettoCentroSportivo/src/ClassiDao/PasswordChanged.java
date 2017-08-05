package ClassiDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import Model.Utente;
import VisteUtenteGenerico.FrameCambia;
import view_tesserato.FrameTesserato;
import visteadmin.FrameResponsabile;
public class PasswordChanged {
	
	
	
	public static void changed(String vecchiapass ,String Nuovapass){
		
		  Connection con = DbConnection.db;
	       
	        Statement st;
	        
	        ResultSet rs;
	        try {
	            
	            st = con.createStatement();
	           
	            
	          rs=st.executeQuery("SELECT elencoutenti.idutente FROM elencoutenti WHERE elencoutenti.username='"+Utente.getUsername()+"' AND elencoutenti.password='"+vecchiapass+"'");
	            
	         if(rs.next()){
	        	st.executeUpdate("UPDATE elencoutenti SET password = '"+Nuovapass+"' WHERE elencoutenti.username='"+Utente.getUsername()+"'");
	        	JOptionPane.showMessageDialog(FrameCambia.frame, "Password cambiata"," ",JOptionPane.INFORMATION_MESSAGE);
	        if(FrameTesserato.frame!=null)
	        FrameTesserato.frame.setEnabled(true);
			   if(FrameResponsabile.frame!=null)
			    		FrameResponsabile.frame.setEnabled(true);
			    	//if(CapFrame.frame!=null)
			    	//	CapFrame.frame.setEnabled(true);
			    	//if(AdminFrame.frame!=null)
			    		//AdminFrame.frame.setEnabled(true);
				FrameCambia.frame.setVisible(false);
				FrameCambia.frame.dispose();
	        	
	         }
	           
	          else
	        	  {
	        	  
	        	  JOptionPane.showMessageDialog(FrameCambia.frame, "Vecchia password non valida, riprovare."," ",JOptionPane.WARNING_MESSAGE);
	        	  
	        	  }
	       
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
	}

}
