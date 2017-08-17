package ClassiDaoTesserato;


import java.io.File;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import view_tesserato.sendeventframe;

public class ordineeventodao {
	
	
	
	
	
	 public static void insdetiscr(String modalita,File certificato,int evento,int costo){	
	        
	        Connection con = DbConnection.db;
	        Statement st;
	        
	       
	        
	        try {
	        	st = con.createStatement();

	        	 
JOptionPane.showMessageDialog(sendeventframe.frame, " \""+modalita+"\" \\o \""+certificato+"\","+evento+" "+GetInfoDB.getidTess(Utente.getUsername())+" "," ",JOptionPane.INFORMATION_MESSAGE);	
			
	        st.executeUpdate("INSERT INTO iscrizioneevento (codiceiscrizioneevento,evento,modalitapagamento,costotot,confermato,annullato,tesserato,certificatomed) "
	        		+ "VALUES (NULL,'"+evento+"','"+modalita+"','"+costo+"','0','0','"+GetInfoDB.getidTess(Utente.getUsername())+"','"+certificato+"')"); 
	        JOptionPane.showMessageDialog(sendeventframe.frame, "Eventi Aggiunti!!");
	      } catch (SQLException ex) {
	        	
	    	  JOptionPane.showMessageDialog(sendeventframe.frame, "Eventi non Aggiunti!!");
	        }
	    }

}
