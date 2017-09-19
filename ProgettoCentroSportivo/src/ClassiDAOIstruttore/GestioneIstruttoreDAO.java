

package ClassiDAOIstruttore;
import DBInterfaccia.DbConnection ;

import visteIstruttore.FrameAttIstr;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;



public class GestioneIstruttoreDAO {

	
    
    
public static boolean eliminaatt ( int comblivdis ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement();
         
         st.executeUpdate("DELETE  FROM gestioneturno WHERE  gestioneturno.combinazionelivdis='"+comblivdis+"' ");
         
        
        
            
         JOptionPane.showMessageDialog(FrameAttIstr.frame,"L'attività selezionata è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         
        
        
         
         return true;
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameAttIstr.frame, ex);
}
return false;
}


   


     
}






     





