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
import view_tesserato.FrameDiscAttive;
import view_tesserato.FrameTesserato;
import view_tesserato.FrameTurno;


public class Invia_Turno_Dao {
public static String oldday;
public static String oldhours;
	
	
	public static void Invia(String disciplina,String livello, String giorno, String orario){
		
		
		
		Connection con = DbConnection.db;
	    Connection con2 = DbConnection.db;
	    Connection con3 = DbConnection.db;
	    Connection con4 = DbConnection.db;
	    Connection con5 = DbConnection.db;
	        Statement st2,st,st3,st4,st5;
	      
	        try {
	     oldday= (String) FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 2) ;      
	     oldhours= (String) FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 3) ;
	    st2 = con2.createStatement();
	    st = con.createStatement(); 
	    st3 = con3.createStatement();
	    st4 = con4.createStatement();
	    st5 = con5.createStatement();
	    st2.executeUpdate("UPDATE detiscr SET giorno = '"+giorno+"' WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");
	    st.executeUpdate("UPDATE detiscr SET orario = '"+orario+"' WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'"); 
	    st3.executeUpdate("UPDATE detiscr SET confermato=0 WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");
	    st4.executeUpdate("UPDATE detiscr SET annullato=1  WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");
	    st5.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and codiceturno='"+GetInfoDB.getcodiceturno(disciplina, livello, oldday, oldhours)+"' ");
	        	

	        	
	         }
	           
	        
	 
	        
	        catch (SQLException ex) {
	           
	        }
		
	}

}


