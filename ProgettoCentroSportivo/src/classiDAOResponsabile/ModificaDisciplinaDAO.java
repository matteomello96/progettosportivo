

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
public static boolean modificadisc ( String exdisc,String dis ,String desc,String cal,String pathim,String nomefile,String pathprec){
	 
	
	
	
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
        
        
         st2.executeUpdate("UPDATE  `disciplina`SET nomedisciplina='"+dis+"',descrizione='"+desc+"',calendario='"+cal+"',immagine='"+pathim+"' where nomedisciplina='"+exdisc+"' ");
        try {
         File f1 = new File(pathprec);
         FileInputStream fis1 = new FileInputStream(f1);
         FileChannel channel1=fis1.getChannel();
         FileLock lock1= channel1.tryLock();
         if (lock1==null){ JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame,"non posso lavorare 1"); }
         File f2 = new File(pathim);
         FileInputStream fis2 = new FileInputStream(f2);
         FileChannel channel2=fis2.getChannel();
         FileLock lock2= channel2.tryLock();
         if (lock2==null){ JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame,"non posso lavorare 2"); }
         java.nio.file.Path pathprec2 =Paths.get(pathprec);
        java.nio.file.Path pathim3 =Paths.get(pathim);
        Files.copy(pathprec2,pathim3,StandardCopyOption.REPLACE_EXISTING);
        //
        //successo = f.delete();
        }
        catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
          } catch (IOException e) {
			// TODO Auto-generated catch block
        	  JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
		}
        
        //if(successo){JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame,"Il file con il path "+pathprec+"è stato eliminato correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         //}
            
       JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame,"La disciplina  \""+dis+"\"  è stata modificata  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
          
     }}
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, ex);
}
return false;

	





     
}}






     





