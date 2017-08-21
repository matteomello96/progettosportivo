

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameInserisciLiv;
import visteadmin.FrameInserisciModPag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class InserisciLivelloDAO {

	
    
    
public static boolean inserimentoliv ( String liv ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT livello.NomeLivello FROM livello WHERE livello.NomeLivello  ='"+liv+"'; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il livello  "+liv+" è già stato creato, inserirne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO  `livello`(NomeLivello) VALUES ('"+liv+"') ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameInserisciLiv.frame,"Il livello  \""+liv+"\" è stato inserito  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciLiv.frame, ex);
}
return false;
}





     
}






     





