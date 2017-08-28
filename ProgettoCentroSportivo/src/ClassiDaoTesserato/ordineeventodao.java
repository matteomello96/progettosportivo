package ClassiDaoTesserato;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import view_tesserato.sendeventframe;
import visteadmin.FrameInserisciDisciplina;

public class ordineeventodao {
	
	
	
	
	
	 public static void insdetiscr(String modalita,String certificato,String pathprec,int evento,int costo){	
	        
	        Connection con = DbConnection.db;
	        Statement st;
	        
	       
	        
	        try {
	        	st = con.createStatement();

	        	 
//JOptionPane.showMessageDialog(sendeventframe.frame, " \""+modalita+"\" \\o \""+certificato+"\","+evento+" "+GetInfoDB.getidTess(Utente.getUsername())+" "," ",JOptionPane.INFORMATION_MESSAGE);	
			
	        st.executeUpdate("INSERT INTO iscrizioneevento (codiceiscrizioneevento,evento,modalitapagamento,costotot,confermato,annullato,tesserato,certificatomed) "
	        		+ "VALUES (NULL,'"+evento+"','"+modalita+"','"+costo+"','0','0','"+GetInfoDB.getidTess(Utente.getUsername())+"','"+certificato+"')"); 
	        try {
	            java.nio.file.Path pathprec2 =Paths.get(pathprec);
	            java.nio.file.Path pathim3 =Paths.get(certificato);
	            Files.copy(pathprec2,pathim3,StandardCopyOption.REPLACE_EXISTING);
	            }
	            catch (FileNotFoundException e) {
	            	JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
	              } catch (IOException e) {
	    			// TODO Auto-generated catch block
	            	  JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
	    		}
	        
	        JOptionPane.showMessageDialog(sendeventframe.frame, "Eventi Aggiunti!!");
	      } catch (SQLException ex) {
	        	
	    	  JOptionPane.showMessageDialog(sendeventframe.frame, "Eventi non Aggiunti!!");
	        }
	    }

}
