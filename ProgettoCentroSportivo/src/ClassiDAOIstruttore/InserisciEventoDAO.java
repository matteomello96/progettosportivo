

package ClassiDAOIstruttore;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteUtenteGenerico.FrameRegistrazione;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class InserisciEventoDAO {

	
    
    
public static boolean registraevento(int comblivdis,String nomeev, String descr , String costo , String infopag, String tipoev , String biscert , String fasciaor ,String giornoset , String spazio , String prendisp){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    String username=""+Utente.getUsername()+"";
    int matricola = GetInfoDB.getidIstr(username); 
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT * FROM gestioneturnoevento WHERE gestioneturnoevento.giornosettimana='"+giornoset+"' AND gestioneturnoevento.fasciaoraria='"+fasciaor+"' AND gestioneturnoevento.spazio='"+spazio+"' ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "L'evento che si svolge il \""+giornoset+"\" nella fascia oraria \""+fasciaor+"\" nello spazio "+spazio+" è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO `evento` ( `combinazionelivdis`,`nomeevento`, `descrizione`, `infopagamento`,`costoevento`,`istruttoredisp`,`tipoevento`, `bisognocertificato`) VALUES ('"+comblivdis+"','"+nomeev+"', '"+descr+"', '"+infopag+"','"+costo+"', '"+matricola+"', '"+tipoev+"', '"+biscert+"')");
         rs=st.executeQuery("SELECT codiceevento FROM evento WHERE evento.nomeevento='"+nomeev+"'");
         
         rs.next();
         int evento= rs.getInt("codiceevento");
         st2.executeUpdate("INSERT INTO `gestioneturnoevento` (`fasciaoraria`,`giornosettimana`,`spazio`,`prenotazionidisponibili`,`evento`) VALUES ('"+fasciaor+"','"+giornoset+"','"+spazio+"','"+prendisp+"','"+evento+"')");
            
         JOptionPane.showMessageDialog(FrameInserisciEv.frame,"L'evento che si svolge il \""+giornoset+"\" nella fascia oraria \""+fasciaor+"\" nello spazio "+spazio+" è stato creato correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciEv.frame, ex);
}
return false;
}





     
}






     





