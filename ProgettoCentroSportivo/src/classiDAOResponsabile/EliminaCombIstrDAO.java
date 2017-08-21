

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


public class EliminaCombIstrDAO {

	
    
    
public static boolean eliminacombis ( int istruttore,int comblivdis ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT combinazioneistrdis FROM istruttoridisponibiliperdisciplina WHERE istruttoridisponibiliperdisciplina.istruttore='"+istruttore+"' and istruttoridisponibiliperdisciplina.combinazionelivdis='"+comblivdis+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La combinazione a cui sono associati i codici istruttore "+istruttore+" e combinazione livello disciplina "+comblivdis+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        int comb= rs.getInt("combinazioneistrdis"); 
        st.executeUpdate("DELETE  FROM istruttoridisponibiliperdisciplina WHERE  istruttoridisponibiliperdisciplina.combinazioneistrdis='"+comb+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La combinazione a cui sono associati i codici istruttore "+istruttore+" e combinazione livello disciplina "+comblivdis+" è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}





     
}






     





