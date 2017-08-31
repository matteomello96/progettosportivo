 

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import javafx.scene.shape.Path;
import visteadmin.FrameInserisciDiscDisp;
import visteadmin.FrameInserisciDisciplina;
import visteadmin.FrameInserisciLiv;
import visteadmin.FrameInserisciModPag;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import ClassiDao.GetInfoDB;


public class InserisciDisciplinaDAO {

	
    
    
@SuppressWarnings("resource")
public static boolean inserimentodisc ( String dis ,String desc,String cal,String pathim,String nomefile,String pathprec){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    URL pathnuovo;
    URL pathpreced;
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT disciplina.nomedisciplina FROM disciplina WHERE nomedisciplina  ='"+dis+"' ; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+dis+" è già stata creata, inserirne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        
        
         st2.executeUpdate("INSERT INTO  `disciplina`(nomedisciplina,descrizione,calendario,immagine) VALUES ('"+dis+"','"+desc+"','"+cal+"','"+pathim+"') ");
        try {
        java.nio.file.Path pathprec2 =Paths.get(pathprec);
        java.nio.file.Path pathim3 =Paths.get(pathim);
        Files.copy(pathprec2,pathim3,StandardCopyOption.REPLACE_EXISTING);
        
        
        
        }
        catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
          } catch (IOException e) {
			// TODO Auto-generated catch block
        	  JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
		}
        
        
         
            
       JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame,"La disciplina  \""+dis+"\"  è stata inserita  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
          
     }}
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, ex);
}
return false;

	





     
}}






     





