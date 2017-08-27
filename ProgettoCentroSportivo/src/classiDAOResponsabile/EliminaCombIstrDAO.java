

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

	
    
    
public static boolean eliminacombis ( String nomeis,String cognomeis,String disc,String liv ){
	 
	
	
	
	Connection con = DbConnection.db;
	Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs,rs2;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
    	 st2=con2.createStatement();
         rs= st.executeQuery("SELECT DISTINCT combinazionelivdis FROM disciplinedisponibili where disciplinedisponibili.disciplina='"+disc+"' and disciplinedisponibili.livello='"+liv+"'"); 
         rs2= st2.executeQuery("SELECT DISTINCT matricolaistruttore from istruttore inner join elencoutenti on elencoutenti.idutente=istruttore.idutente where elencoutenti.nome='"+nomeis+"' and elencoutenti.cognome='"+cognomeis+"'"); 
        
        if((rs.next())&&(rs2.next())){
        	
        int comb= rs.getInt("combinazionelivdis"); 
        int comb2=rs2.getInt("matricolaistruttore");
        st2.executeUpdate("DELETE  FROM istruttoridisponibiliperdisciplina WHERE  istruttoridisponibiliperdisciplina.combinazionelivdis='"+comb+"' and istruttoridisponibiliperdisciplina.istruttore='"+comb2+"' ");
      	JOptionPane.showMessageDialog(FrameGestione.frame,"La combinazione  è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;  
        }
        else{
        JOptionPane.showMessageDialog(null, "La combinazione selezionata non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        }
        
           
         
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}





     
}






     





