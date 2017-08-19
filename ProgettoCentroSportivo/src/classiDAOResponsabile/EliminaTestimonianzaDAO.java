

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


public class EliminaTestimonianzaDAO {

	
    
    
public static boolean eliminatest ( String commento,String data ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT codicetestimonianza FROM testimonianza WHERE testimonianza.commento='"+commento+"' and testimonianza.dataazione='"+data+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La testimonianza contenente il commento "+commento+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        Integer discip= rs.getInt("codicetestimonianza"); 
        st.executeUpdate("DELETE  FROM testimonianza WHERE codicetestimonianza='"+discip+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La disciplina contenente il commento "+commento+" è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}





     
}






     





