package classiDAOResponsabile;


import java.awt.Desktop;
import java.io.File;

import java.io.IOException;

import java.sql.Connection;


import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;



public class downloaddao {
	
    public static File f=null;
	public static void scarica(String a2){
		Connection con = DbConnection.db;

		/*Statement st;

		ResultSet rs;


		String ris = null;*/

		//try {
		    
		   // st = con.createStatement();
		  
		    //rs = st.executeQuery("select certificatomed from iscrizioneevento  where codiceiscrizioneevento='"+a2+"' "); 
		   // rs.next();	               
		   // ris=rs.getString("certificatomed");    
		    try {
		    	Desktop desktop = null;
		    	if (Desktop.isDesktopSupported()) {
		    	desktop = Desktop.getDesktop();
		    	}
		    	//java.nio.file.Path path =Paths.get(a2);
				 f= new File(a2);
		    	
		    	
		    	
                
		    	desktop.open(f);
		    	} catch (IOException ioe) {
		    	ioe.printStackTrace();
		    	} catch (IllegalArgumentException n){
		    	JOptionPane.showMessageDialog(null,"Il file non esiste!","errore", JOptionPane.WARNING_MESSAGE);
		    	return;
		    	}

		//} 

		//catch (SQLException ex) {
			
		//}
			
		
		}
	
	}






