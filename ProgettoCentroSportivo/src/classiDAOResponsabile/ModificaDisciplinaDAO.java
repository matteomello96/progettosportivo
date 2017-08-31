

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
import visteadmin.FrameModificaDisciplina;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
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


public class ModificaDisciplinaDAO {

	
 public static boolean successo = false;  
    
@SuppressWarnings("resource")
public static boolean modificadisc (String pathprecimg, String exdisc,String dis ,String desc,String cal,String pathim,String nomefile,String pathprec){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
     
    
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
        
        rs= st.executeQuery("SELECT disciplina.nomedisciplina FROM disciplina WHERE nomedisciplina  ='"+dis+"' and descrizione= '"+desc+"' and calendario = '"+cal+"' and immagine= '"+pathim+"'; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+dis+" è già esistente, inserirne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        	
        if (pathprec.equals(pathprecimg))
     { 
    	 pathim=pathprec;
     }
    
     else 
     {
        
        try {
       
        
        
        FileChannel fc1= new FileOutputStream(pathprec).getChannel();
        fc1.close();
        
        java.nio.file.Path pathprec3 =Paths.get(pathprec);
        
        
       	
        java.nio.file.Path pathprec2 =Paths.get(pathprecimg);
        
        java.nio.file.Path pathim3 =Paths.get(pathim);
        File f2 = pathim3.toFile();
        
        Files.copy(pathprec2,pathim3,StandardCopyOption.REPLACE_EXISTING);
        
        File f3 = pathprec3.toFile();
        
        
        
        }
        catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
          } catch (IOException e) {
			// TODO Auto-generated catch block
        	  JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
		}
     }
        st2.executeUpdate("UPDATE  `disciplina`SET nomedisciplina='"+dis+"',descrizione='"+desc+"',calendario='"+cal+"',immagine='"+pathim+"' where nomedisciplina='"+exdisc+"' ");
            
       JOptionPane.showMessageDialog(FrameModificaDisciplina.frame,"La disciplina  \""+dis+"\"  è stata modificata  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
          
     }}
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaDisciplina.frame, ex);
}
return false;

	





     
}}






     





