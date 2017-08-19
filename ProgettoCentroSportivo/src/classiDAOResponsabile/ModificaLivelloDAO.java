

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameModificaLiv;
import visteadmin.FrameModificaModPag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class ModificaLivelloDAO {

	
    
    
public static boolean modificaliv ( String liv,String nuovoliv ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT livello.NomeLivello FROM livello WHERE livello.NomeLivello  ='"+nuovoliv+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il livello  "+liv+" è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("UPDATE livello SET  livello.NomeLivello = '"+nuovoliv+"'  where livello.NomeLivello  ='"+liv+"'  ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaLiv.frame,"Il livello precedente \""+liv+"\" è stato cambiato in \""+nuovoliv+"\"  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaLiv.frame, ex);
}
return false;
}





     
}






     





