package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import visteadmin.FrameDettagliDaAccResp;
import visteadmin.FrameDettagliMod;
import visteadmin.FrameOrdini;


public class GestioneIscrizioniDAO {
	
	
	public static void Uccidi_isc(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	            
	            
	      st.executeUpdate("DELETE FROM detiscr WHERE idiscrizione='"+idordine+"'");
	      st.executeUpdate("DELETE FROM iscrizionedisciplina WHERE codiceiscrizionedisciplina='"+idordine+"'");
	      st.executeUpdate("DELETE FROM iscrizioniperturno WHERE iddet='"+idordine+"'");
	      JOptionPane.showMessageDialog(FrameOrdini.frame, "Ordine eliminato");
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}
	public static void ConfermaIscrizione(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("UPDATE iscrizionedisciplina set confermato=1  WHERE codiceiscrizionedisciplina='"+idordine+"'");
 
	      JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, "Ordine confermato");
	      
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}
	
	public static void AccettaModifiche(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	      st.executeUpdate("UPDATE iscrizionedisciplina SET modificato=0,confermato=1 WHERE codiceiscrizionedisciplina='"+idordine+"'");
 
	      
	      
	      JOptionPane.showMessageDialog(FrameDettagliMod.frame, "Ordine modificato");
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	           
	        }
		
		
		
	}
	
	
}
