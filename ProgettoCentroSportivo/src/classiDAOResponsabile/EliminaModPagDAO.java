

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


public class EliminaModPagDAO {

	
    
    
public static boolean eliminamodpagam ( String modpag ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT modalitapagamento.Nomemodalita� FROM modalitapagamento WHERE modalitapagamento.Nomemodalita�='"+modpag+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La modalit� di pagamento "+modpag+" non �  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        String discip= rs.getString("modalitapagamento.Nomemodalita�"); 
        st.executeUpdate("DELETE  FROM modalitapagamento WHERE modalitapagamento.Nomemodalita�='"+discip+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La modalit� di pagamento "+modpag+" � stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}





     
}






     





