

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


public class InserisciAttDAO {

	
    
    
public static boolean registraatt(String disc, String liv , String fasciaor ,String giornoset , String spazio , String prendisp){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    String username=""+Utente.getUsername()+"";
    int matricola = GetInfoDB.getidIstr(username); 
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT * FROM gestioneturno WHERE gestioneturno.giornosettimana='"+giornoset+"' AND gestioneturno.fasciaoraria='"+fasciaor+"' AND gestioneturno.spazio='"+spazio+"' ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "L'attività che si svolge il \""+giornoset+"\" nella fascia oraria \""+fasciaor+"\" nello spazio "+spazio+" è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         rs=st.executeQuery("SELECT combinazionelivdis FROM disciplinedisponibili WHERE disciplinedisponibili.disciplina='"+disc+"' AND disciplinedisponibili.livello='"+liv+"'");
         
         rs.next();
         int comb= rs.getInt("combinazionelivdis");
         st2.executeUpdate("INSERT INTO `gestioneturno` (`fasciaoraria`,`giornosettimana`,`spazio`,`prenotazionidisponibili`,`combinazionelivdis`) VALUES ('"+fasciaor+"','"+giornoset+"','"+spazio+"','"+prendisp+"','"+comb+"')");
            
         JOptionPane.showMessageDialog(FrameInserisciEv.frame,"L'attività che si svolge il \""+giornoset+"\" nella fascia oraria \""+fasciaor+"\" nello spazio "+spazio+" è stato creato correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciEv.frame, ex);
}
return false;
}





     
}






     





