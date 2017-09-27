package classiDAOResponsabile;


import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;



public class downloaddao {
	
    public static File f=null;
	public static void scarica(int a2){
		Connection con = DbConnection.db;

		Statement st;

		ResultSet rs;


		String ris = null;

		try {
		    
		    st = con.createStatement();
		  
		    rs = st.executeQuery("select certificatomed from iscrizioneevento  where codiceiscrizioneevento='"+a2+"' "); 
		    rs.next();	               
		     
		    try {
		    	Desktop desktop = null;
		    	if (Desktop.isDesktopSupported()) {
		    	desktop = Desktop.getDesktop();
		    	}
		    	//java.nio.file.Path path =Paths.get(a2);
		    	byte[] img = rs.getBytes("certificatomed");
				 f= new File("certificato.pdf");
		    	
				 try ( FileOutputStream outputStream = new FileOutputStream(f); ) {

				        outputStream.write(img);  //write the bytes and your done. 

				    } catch (Exception e) {
				        e.printStackTrace();
				    }

				

		    	
                
		    	desktop.open(f);
		    	} catch (IOException ioe) {
		    	ioe.printStackTrace();
		    	} catch (IllegalArgumentException n){
		    	JOptionPane.showMessageDialog(null,"Il file non esiste!","errore", JOptionPane.WARNING_MESSAGE);
		    	return;
		    	}

		} 

		catch (SQLException ex) {
			
		}
			
		
		}
	
	}






