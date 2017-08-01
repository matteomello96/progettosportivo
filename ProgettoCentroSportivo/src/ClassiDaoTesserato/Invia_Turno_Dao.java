package ClassiDaoTesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import VisteUtenteGenerico.FrameCambia;
import view_tesserato.FrameTesserato;
import view_tesserato.FrameTurno;


public class Invia_Turno_Dao {

	
	
	public static void Invia(String disciplina,String livello, String giorno, String orario){
		
		
		
		Connection con = DbConnection.db;
		  
	        Connection con2 = DbConnection.db;
	        Statement st2,st;
	      
	        try {
	            
	        
	            st2 = con2.createStatement();
	            st = con.createStatement(); 
	        	st2.executeUpdate("UPDATE detiscr SET giorno = '"+giorno+"' WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"'");
	        	st.executeUpdate("UPDATE detiscr SET orario = '"+orario+"' WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"'"); 
	        	JOptionPane.showMessageDialog(FrameTurno.frame, "Giorno e orario inseriti"," ",JOptionPane.INFORMATION_MESSAGE);
	        	
				FrameTesserato.frame.setEnabled(true);
				FrameTurno.frame.dispose();
	        	
	         }
	           
	        
	 
	        
	        catch (SQLException ex) {
	           
	        }
		
	}

}


