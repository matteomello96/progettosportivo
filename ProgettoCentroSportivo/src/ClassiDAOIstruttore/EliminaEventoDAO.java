

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


public class EliminaEventoDAO {

	
    
    
public static boolean eliminaevento ( String evento ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         rs=st.executeQuery("SELECT codiceevento FROM evento WHERE evento.nomeevento='"+evento+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "L'evento "+evento+" non è  stato eliminato"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        int codevento= rs.getInt("codiceevento"); 
        st.executeUpdate("DELETE  FROM gestioneturnoevento WHERE  gestioneturnoevento.evento='"+codevento+"' ");
        
         
         st2.executeUpdate("DELETE from evento  WHERE codiceevento='"+codevento+"' ");
            
         JOptionPane.showMessageDialog(FrameIstruttore.frame,"L'evento "+evento+" è stato eliminato correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameIstruttore.frame, ex);
}
return false;
}





     
}






     





