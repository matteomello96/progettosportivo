

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameInserisciIstrDisp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class InserisciCombIstrDAO {

	
    
    


public static boolean inseriscicombis ( String nomeis,String cognomeis,String disc,String liv ){
	 
	
	
	
	Connection con = DbConnection.db;
	Connection con2 = DbConnection.db;
	Connection con3 = DbConnection.db;
	Connection con4 = DbConnection.db;
    Statement st,st2,st3,st4;
    ResultSet rs,rs2,rs3;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
    	 st2 =con2.createStatement();
    	 st3 =con3.createStatement();
    	 st4 =con4.createStatement();
         rs= st.executeQuery("SELECT DISTINCT combinazionelivdis FROM disciplinedisponibili where disciplinedisponibili.disciplina='"+disc+"' and disciplinedisponibili.livello='"+liv+"'"); 
         rs2= st2.executeQuery("SELECT DISTINCT matricolaistruttore from istruttore inner join elencoutenti on elencoutenti.idutente=istruttore.idutente where elencoutenti.nome='"+nomeis+"' and elencoutenti.cognome='"+cognomeis+"'"); 
          if((rs.next())&&rs2.next())
          {
         int comb= rs.getInt("combinazionelivdis"); 
         int comb2=rs2.getInt("matricolaistruttore");
         rs3=st3.executeQuery("SELECT DISTINCT combinazioneistrdis from istruttoridisponibiliperdisciplina where istruttore='"+comb2+"' and combinazionelivdis= '"+comb+"' ");
          if(rs3.next())
        		{
        	JOptionPane.showMessageDialog(null, "La combinazione selezionata esiste già"," ",JOptionPane.WARNING_MESSAGE);
        
         }
        else{
        
        st3.executeUpdate("INSERT INTO istruttoridisponibiliperdisciplina(istruttore,combinazionelivdis) VALUES ('"+comb2+"','"+comb+"') ");
      	JOptionPane.showMessageDialog(FrameInserisciIstrDisp.frame,"La combinazione  è stata inserita correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;  
        
        }
        
           
         
            }
     }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciIstrDisp.frame, ex);
}
return false;
}





     
}






     





