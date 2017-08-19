

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameModificaModPag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class ModificaModPagDAO {

	
    
    
public static boolean modificamodpag ( String modp,String nuovamodp ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT modalitapagamento.Nomemodalita  FROM modalitapagamento WHERE modalitapagamento.Nomemodalita   ='"+nuovamodp+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La modalità di pagamento "+nuovamodp+" è già stata creata, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("UPDATE modalitapagamento SET  modalitapagamento.Nomemodalita  = '"+nuovamodp+"'  where modalitapagamento.Nomemodalita   ='"+modp+"'  ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaModPag.frame,"La modalità di pagamento precedente \""+modp+"\" è stata cambiata in \""+nuovamodp+"\"  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaModPag.frame, ex);
}
return false;
}





     
}






     





