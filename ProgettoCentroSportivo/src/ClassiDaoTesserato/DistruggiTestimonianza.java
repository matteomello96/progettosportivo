package ClassiDaoTesserato;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import view_tesserato.FrameVisTest;


public class DistruggiTestimonianza {

 




    
    public static void EliminaTest(String disciplina,String livello){


    
        
        Connection con = DbConnection.db;;
        Statement st;
        
        
        
        
        try {
            
            st = con.createStatement();
            
            
            JOptionPane.showMessageDialog(FrameVisTest.frame," '"+GetInfoDB.getcombinazionelivdis(disciplina,livello)+"''"+disciplina+"','"+livello+"'","",JOptionPane.WARNING_MESSAGE);
            String ObjButtons[] = {"        Sì        ","      No      "};
	        int PromptResult = JOptionPane.showOptionDialog(FrameVisTest.frame,"Sei sicuro di voler cancellare la testimonianza. Non potrai più recuperarla!!!","Cancellazione Testimonianza",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
	        if(PromptResult==JOptionPane.YES_OPTION)
	        {
	        	st.executeUpdate("DELETE FROM testimonianza WHERE testimonianza.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina,livello)+"' and testimonianza.Tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");  	
	        }
	        
            
         
           
       
            
       
           
            
        } catch (SQLException ex) {
        	
        }

    }}
    
    
    
    