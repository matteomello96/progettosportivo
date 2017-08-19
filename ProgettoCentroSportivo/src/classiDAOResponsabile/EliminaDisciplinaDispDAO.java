

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


public class EliminaDisciplinaDispDAO {

	
    
    
public static boolean eliminadisciplinadisp ( String disciplina,String livello ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT combinazionelivdis FROM disciplinedisponibili WHERE disciplinedisponibili.livello='"+livello+"' and disciplinedisponibili.disciplina='"+disciplina+"' "); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La combinazione data dalla "+disciplina+" a cui è associato il livello "+livello+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        int comb= rs.getInt("combinazionelivdis"); 
        st.executeUpdate("DELETE  FROM disciplinedisponibili WHERE disciplinedisponibili.combinazionelivdis='"+comb+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La combinazione data dalla "+disciplina+" a cui è associato il livello "+livello+" è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}





     
}






     





