

package ClassiDAOIstruttore;
import DBInterfaccia.DbConnection ;


import visteIstruttore.FrameModificaEv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;




public class ModificaEventoDAO {

	
    
    
public static boolean modificaevento ( String evento,String nuovoevento,String descr , String costo , String infopag, String tipoev , String biscert , String fasciaor ,String giornoset , String spazio , String prendisp ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT * FROM gestioneturnoevento WHERE gestioneturnoevento.giornosettimana='"+giornoset+"' AND gestioneturnoevento.fasciaoraria='"+fasciaor+"' AND gestioneturnoevento.spazio='"+spazio+"' ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "L'evento che si svolge il \""+giornoset+"\" nella fascia oraria \""+fasciaor+"\" nello spazio "+spazio+" è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("UPDATE  `evento` SET  `nomeevento`= '"+nuovoevento+"' ,  `descrizione`='"+descr+"',`infopagamento`='"+infopag+"',`costoevento`='"+costo+"',`tipoevento`='"+tipoev+"', `bisognocertificato`='"+biscert+"' where nomeevento='"+evento+"'  ");
         rs=st.executeQuery("SELECT codiceevento FROM evento WHERE evento.nomeevento='"+nuovoevento+"'");
         
         rs.next();
         int codevento= rs.getInt("codiceevento");
         st2.executeUpdate("UPDATE `gestioneturnoevento` SET `fasciaoraria`='"+fasciaor+"',`giornosettimana`='"+giornoset+"',`spazio`='"+spazio+"',`prenotazionidisponibili`='"+prendisp+"' WHERE evento='"+codevento+"' ");
            
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






     





