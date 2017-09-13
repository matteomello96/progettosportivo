package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import visteadmin.FrameDettagliDaAccResp;
import visteadmin.FrameDettagliMod;
import visteadmin.FrameEventiResp;


public class GestioneIscrizioniEventiDAO {
	
	public static void Uccidiev(int iddet,int codiceturno,int tesserato){
		
		   Connection con = DbConnection.db;
		   Statement st;
		
		   
		   try {
	            
	            st= con.createStatement();
	            
	      st.executeUpdate("DELETE FROM iscrizioniperturnoevento WHERE codisc='"+iddet+"' ");  
	      st.executeUpdate("DELETE FROM iscrizioneevento WHERE codiceiscrizioneevento='"+iddet+"'");
	            
	  	  st.executeUpdate("UPDATE gestioneturnoevento SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'+1 WHERE codiceturnoevento='"+codiceturno+"'"); 
	  	
	  
	    JOptionPane.showMessageDialog(FrameEventiResp.frame, "Ordine Cancellato"," ",JOptionPane.INFORMATION_MESSAGE);
		        	
		        	
		        	
						
	            	
	            	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
	}

	
	
	
	  
		           	
	            
	           
	            
	       
	
	
	
	
	
	public static void ConfermaIscrizioneEv(int idordine,int tesserato,int codiceturno){
		 Connection con = DbConnection.db;
		   Statement st;
		   ResultSet rs;
			int conf;
		   
		   try {
	            
	            st= con.createStatement();
	            rs=st.executeQuery("select confermato from iscrizioneevento where codiceiscrizioneevento='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("confermato");
	            
	            if(conf==0)
	            {
	      st.executeUpdate("UPDATE iscrizioneevento set confermato=1  WHERE codiceiscrizioneevento='"+idordine+"'");
	      st.executeUpdate("INSERT INTO iscrizioniperturnoevento (codiceturnoevento,tesserato,codisc) VALUES('"+codiceturno+"','"+tesserato+"','"+idordine+"')");
	  		st.executeUpdate("UPDATE gestioneturnoevento SET prenotazionidisponibili='"+GetInfoDB.getprenotazioniev(codiceturno)+"'-1 WHERE codiceturnoevento='"+codiceturno+"'");
	  	      JOptionPane.showMessageDialog(FrameEventiResp.frame, "Ordine accettato");
	      
	            }
	      
	            else
	            {
	            	
	            	JOptionPane.showMessageDialog(FrameEventiResp.frame, "Ordine già accettato");
	            }
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, ex);
	        }
		
		
		
	}
	

	public static void ConfermaModEv(int idordine,int tesserato,int codiceturno){
		 Connection con = DbConnection.db;
		   Statement st;
		   ResultSet rs;
			int conf;
		   
		   try {
	            
	            st= con.createStatement();
	            rs=st.executeQuery("select modificato from iscrizioneevento where codiceiscrizioneevento='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("modificato");
	            
	            if(conf==1)
	            {
	      st.executeUpdate("UPDATE iscrizioneevento set confermato=1,modificato=0  WHERE codiceiscrizioneevento='"+idordine+"'");
	      st.executeUpdate("INSERT INTO iscrizioniperturnoevento (codiceturnoevento,tesserato,codisc) VALUES('"+codiceturno+"','"+tesserato+"','"+idordine+"')");
	  		st.executeUpdate("UPDATE gestioneturnoevento SET prenotazionidisponibili='"+GetInfoDB.getprenotazioniev(codiceturno)+"'-1 WHERE codiceturnoevento='"+codiceturno+"'");
	  	      JOptionPane.showMessageDialog(FrameEventiResp.frame, "Modifica accettata");
	      
	            }
	      
	            else
	            {
	            	
	            	JOptionPane.showMessageDialog(FrameEventiResp.frame, "Modifica già accettata");
	            }
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(FrameEventiResp.frame, ex);
	        }
		
		
		
		
	}
	
	public static void AnnullaConfEv(int idordine,int tesserato,int codiceturno){
		 Connection con = DbConnection.db;
		   Statement st;
		   ResultSet rs;
			int conf;
		   
		   try {
	            
	            st= con.createStatement();
	            rs=st.executeQuery("select confermato from iscrizioneevento where codiceiscrizioneevento='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("confermato");
	            
	            if(conf==1)
	            {
	      st.executeUpdate("UPDATE iscrizioneevento set confermato=0  WHERE codiceiscrizioneevento='"+idordine+"'");
	      st.executeUpdate("DELETE FROM iscrizioniperturnoevento WHERE codisc='"+idordine+"'");
	  		st.executeUpdate("UPDATE gestioneturnoevento SET prenotazionidisponibili='"+GetInfoDB.getprenotazioniev(codiceturno)+"'+1 WHERE codiceturnoevento='"+codiceturno+"'");
	  	      JOptionPane.showMessageDialog(FrameEventiResp.frame, "Conferma annullata");
	      
	            }
	      
	            else
	            {
	            	
	            	JOptionPane.showMessageDialog(FrameEventiResp.frame, "Conferma già annullata");
	            }
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(FrameEventiResp.frame, ex);
	        }
		
		
		
		
	}	
	
	
	
	
	
}
