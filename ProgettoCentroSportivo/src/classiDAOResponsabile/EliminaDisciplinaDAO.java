

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


public class EliminaDisciplinaDAO {

	
    
    
public static boolean eliminadisciplina ( String disciplina ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT nomedisciplina FROM disciplina WHERE disciplina.nomedisciplina='"+disciplina+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+disciplina+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        String discip= rs.getString("nomedisciplina"); 
        st.executeUpdate("DELETE  FROM disciplina WHERE  disciplina.nomedisciplina='"+disciplina+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La disciplina "+disciplina+" è stata eliminato correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}





     
}






     





