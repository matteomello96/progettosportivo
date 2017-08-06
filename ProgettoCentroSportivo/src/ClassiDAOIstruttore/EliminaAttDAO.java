

package ClassiDAOIstruttore;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class EliminaAttDAO {

	
    
    
public static boolean eliminaatt ( int comblivdis ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement();
         
         st.executeUpdate("DELETE  FROM gestioneturno WHERE  gestioneturno.combinazionelivdis='"+comblivdis+"' ");
         
        
        
            
         JOptionPane.showMessageDialog(FrameIstruttore.frame,"L'attività selezionata è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
     
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameIstruttore.frame, ex);
}
return false;
}





     
}






     





