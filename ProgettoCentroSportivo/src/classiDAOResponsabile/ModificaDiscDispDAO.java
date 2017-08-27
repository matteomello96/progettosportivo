

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameModificaDiscDisp;
import visteadmin.FrameModificaLiv;
import visteadmin.FrameModificaModPag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class ModificaDiscDispDAO {

	
    
    
public static boolean modificadiscdisp ( String disc,String liv,float f,String nuovocm){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs,rs2;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT disciplinedisponibili.combinazionelivdis FROM disciplinedisponibili WHERE livello  ='"+liv+"' and disciplina  ='"+disc+"' and costomensile='"+nuovocm+"'");
        
        if(rs.next()){
      	  JOptionPane.showMessageDialog(null, "La disciplina disponibile "+disc+" cui è associato il livello  "+liv+" con il costo mensile "+nuovocm+"  e  è già stata creata, sceglierne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        }
        else{
            
         st2.executeUpdate("UPDATE disciplinedisponibili SET  costomensile='"+nuovocm+"'   WHERE livello  ='"+liv+"' and disciplina  ='"+disc+"' and costomensile  ='"+f+"' ;");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaDiscDisp.frame,"La combinazione  è stata cambiata  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaDiscDisp.frame, ex);
}
return false;
}





     
}






     





