

package ClassiDAOIstruttore;
import DBInterfaccia.DbConnection ;

import VisteUtenteGenerico.FrameModificaDati;

import visteIstruttore.FrameModificaAtt;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;




public class ModificaDatiDAO {

	
    
    
public static boolean modificadati ( String citta, String via ,String numciv , String telefono , String mail,String user ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT * FROM elencoutenti WHERE citta='"+citta+"' AND via='"+via+"' AND numerocivico='"+numciv+"'  AND  telefono='"+telefono+"' AND mail='"+mail+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "L'utente con  dati già modificati  è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         
         st.executeUpdate("UPDATE `elencoutenti` SET `citta`='"+citta+"',`via`='"+via+"',`numerocivico`='"+numciv+"',`telefono`='"+telefono+"',`mail`='"+mail+"',`modificato`= 1 WHERE username='"+user+"' ");
            
         JOptionPane.showMessageDialog(FrameModificaAtt.frame,"L'utente è stato modificato correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaDati.frame, ex);
}
return false;
}





     
}






     





