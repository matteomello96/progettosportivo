package ClassiDaoTesserato;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import view_tesserato.FrameVisTest;


public class ModificaCommDao {
	public static void Mod_Comm(String commento,String disciplina,String livello){
		
		 Connection con = DbConnection.db;
	       
	        Statement st;
	        
 try {
	            
	            st = con.createStatement();
	           JOptionPane.showMessageDialog(FrameVisTest.frame, " '"+commento+"' ,'"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"','"+GetInfoDB.getidTess(Utente.getUsername())+"' "," ",JOptionPane.INFORMATION_MESSAGE);
	            
	        
	     st.executeUpdate("UPDATE testimonianza SET Commento='"+commento+"' WHERE testimonianza.CodiceTestimonianza='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and Tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");
	     JOptionPane.showMessageDialog(FrameVisTest.frame, "Commento Modificato"," ",JOptionPane.INFORMATION_MESSAGE);
	 	FrameVisTest.frame.dispose();
		new FrameVisTest();     
	            
	        } catch (SQLException ex) {
	           
	        }
	}
	}
