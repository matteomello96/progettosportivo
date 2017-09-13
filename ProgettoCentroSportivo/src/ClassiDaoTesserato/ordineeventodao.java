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
	
	
	
	
	
	 public static void insdetiscr(String modalita,String certificato,String pathprec,int evento,int costo,String tipoevento){	
	        
	        Connection con = DbConnection.db;
	        Statement st;
	        
	       
	        
	        try {
	        	st = con.createStatement();

	        	 
//JOptionPane.showMessageDialog(sendeventframe.frame, " \""+modalita+"\" \\o \""+certificato+"\","+evento+" "+GetInfoDB.getidTess(Utente.getUsername())+" "," ",JOptionPane.INFORMATION_MESSAGE);	
			
	    
	        try {
	        	if((!(pathprec.equals("null"))&&!((certificato.equals("null")))))
	        	{
	            java.nio.file.Path pathprec2 =Paths.get(pathprec);
	            java.nio.file.Path pathim3 =Paths.get(certificato);
	            Files.copy(pathprec2,pathim3,StandardCopyOption.REPLACE_EXISTING);
	        	}
	        	else
	        	{
	        		certificato="null";
	        	}
	            }
	            catch (FileNotFoundException e) {
	            	JOptionPane.showMessageDialog(sendeventframe.frame, e);
	              } catch (IOException e) {
	    			// TODO Auto-generated catch block
	            	  JOptionPane.showMessageDialog(sendeventframe.frame, e);
	    		}
	        st.executeUpdate("INSERT INTO iscrizioneevento (evento,modalitapagamento,costotot,confermato,annullato,modificato,tesserato,certificatomed,tipoevento) "
	        		+ "VALUES ('"+evento+"','"+modalita+"','"+costo+"','0','0','0','"+GetInfoDB.getidTess(Utente.getUsername())+"','"+certificato+"','"+tipoevento+"')"); 
	    	
	        JOptionPane.showMessageDialog(sendeventframe.frame, "Evento Aggiunto !!");
	      } catch (SQLException ex) {
	        
	        }    
	    }

}
