

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


public class ModificaAttDAO {

	
    
    
public static boolean modificaatt ( int comblivdis, String fasciaor ,String giornoset , String spazio , String prendisp ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT * FROM gestioneturno WHERE gestioneturno.giornosettimana='"+giornoset+"' AND gestioneturno.fasciaoraria='"+fasciaor+"' AND gestioneturno.spazio='"+spazio+"' ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "L'evento che si svolge il \""+giornoset+"\" nella fascia oraria \""+fasciaor+"\" nello spazio "+spazio+" è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         
         st.executeUpdate("UPDATE `gestioneturno` SET `fasciaoraria`='"+fasciaor+"',`giornosettimana`='"+giornoset+"',`spazio`='"+spazio+"',`prenotazionidisponibili`='"+prendisp+"' WHERE combinazionelivdis='"+comblivdis+"' ");
            
         JOptionPane.showMessageDialog(FrameModificaEv.frame,"L'evento che si svolge il \""+giornoset+"\" nella fascia oraria \""+fasciaor+"\" nello spazio "+spazio+" è stato modificato correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaEv.frame, ex);
}
return false;
}





     
}






     





