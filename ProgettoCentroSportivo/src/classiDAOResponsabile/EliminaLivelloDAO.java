

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameGestione;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class EliminaLivelloDAO {

	
    
    
public static boolean eliminalivello ( String livello ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT nomelivello FROM livello WHERE livello.nomelivello='"+livello+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "Il livello "+livello+" non è  stato eliminato"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        String discip= rs.getString("nomelivello"); 
        st.executeUpdate("DELETE  FROM livello WHERE livello.nomelivello='"+discip+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"Il livello "+livello+" è stato eliminato correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}





     
}






     





