package ClassiDaoTesserato;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import view_tesserato.sendeventframe;


public class ordineeventodao {
	
	
	
	
	
	 public static void insdetiscr(String modalita,String certificato,int evento,int costo,String tipoevento){	
	        
	        Connection con = DbConnection.db;
	        Statement st;
	        Statement st2;
	        
	        ResultSet rs;
	        

	        int ris=1;
	       
	        
	        try {
	        	st = con.createStatement();

	        	 
	        	
			
	    
	        if((!((certificato.equals("null")))))
			{
				 st.executeUpdate("INSERT INTO iscrizioneevento (evento,modalitapagamento,costotot,confermato,annullato,modificato,tesserato,tipoevento) "
			    		+ "VALUES ('"+evento+"','"+modalita+"','"+costo+"','0','0','0','"+GetInfoDB.getidTess(Utente.getUsername())+"','"+tipoevento+"')"); 
				 rs = st.executeQuery("SELECT codiceiscrizioneevento FROM iscrizioneevento WHERE evento='"+evento+"' AND costotot='"+costo+"' AND tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and tipoevento='"+tipoevento+"'"); 
			       
	             rs.next();
	             ris=rs.getInt("codiceiscrizioneevento");
	             JOptionPane.showMessageDialog(sendeventframe.frame, ris);
	         
				 InputStream is = new FileInputStream(new File(certificato));
		            
		            PreparedStatement ps = con.prepareStatement("UPDATE iscrizioneevento set certificatomed=? where codiceiscrizioneevento='"+ris+"'");
		            ps.setBlob(1,is);
		            ps.executeUpdate();
		            JOptionPane.showMessageDialog(sendeventframe.frame, "Evento Aggiunto !!");
			}
			else
			{
				st.executeUpdate("INSERT INTO iscrizioneevento (evento,modalitapagamento,costotot,confermato,annullato,modificato,tesserato,tipoevento,certificatomed) "
			    		+ "VALUES ('"+evento+"','"+modalita+"','"+costo+"','0','0','0','"+GetInfoDB.getidTess(Utente.getUsername())+"','"+tipoevento+"',NULL)");
				JOptionPane.showMessageDialog(sendeventframe.frame, "Evento Aggiunto !!");
			}
	        
	      } catch (SQLException ex) {
	        
	        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	    }

}
