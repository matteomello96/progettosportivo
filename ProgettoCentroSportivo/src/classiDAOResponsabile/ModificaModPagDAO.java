

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;

import visteadmin.FrameModificaModPag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;




public class ModificaModPagDAO {

	
    
    
public static boolean modificamodpag ( String modp,String nuovamodp ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT modalitapagamento.Nomemodalita� FROM modalitapagamento WHERE modalitapagamento.Nomemodalita�  ='"+nuovamodp+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La modalit� di pagamento "+nuovamodp+" � gi� stata creata, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("UPDATE modalitapagamento SET  modalitapagamento.Nomemodalita� = '"+nuovamodp+"'  where modalitapagamento.Nomemodalita�  ='"+modp+"'  ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaModPag.frame,"La modalit� di pagamento precedente \""+modp+"\" � stata cambiata in \""+nuovamodp+"\"  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaModPag.frame, ex);
}
return false;
}





     
}






     





