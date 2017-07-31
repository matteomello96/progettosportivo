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
	         
	            
	           String ObjButtons[] = {"        Sì        ","      No      "};
		        int PromptResult = JOptionPane.showOptionDialog(FrameVisTest.frame,"Sei sicuro di voler modificare la testimonianza. ","Testimonianza modificata",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION){
	             st.executeUpdate("UPDATE testimonianza SET testimonianza.Commento='"+commento+"' WHERE testimonianza.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and Tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");  
		        }
	 	FrameVisTest.frame.dispose();
		new FrameVisTest();     
		         
	        } 
 
 catch (SQLException ex) {
	           
	        } 
 
 
	}
	}
