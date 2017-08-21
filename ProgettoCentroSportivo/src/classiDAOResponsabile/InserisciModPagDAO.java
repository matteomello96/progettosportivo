

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameInserisciModPag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class InserisciModPagDAO {

	
    
    
public static boolean inserimentomodpag ( String modp ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT modalitapagamento.Nomemodalita  FROM modalitapagamento WHERE modalitapagamento.Nomemodalita   ='"+modp+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La modalità di pagamento "+modp+" è già stata creata, inserirne un altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO  `modalitapagamento`(modalitapagamento.Nomemodalita ) VALUES ('"+modp+"') ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameInserisciModPag.frame,"La modalità di pagamento  \""+modp+"\" è stata inserita  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciModPag.frame, ex);
}
return false;
}





     
}






     





