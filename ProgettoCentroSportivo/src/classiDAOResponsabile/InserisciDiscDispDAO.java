

package classiDAOResponsabile;
import DBInterfaccia.DbConnection ;
import Model.Utente;
import VisteIstruttore.FrameInserisciEv;
import VisteIstruttore.FrameIstruttore;
import VisteIstruttore.FrameModificaEv;
import VisteUtenteGenerico.FrameRegistrazione;
import visteadmin.FrameInserisciDiscDisp;
import visteadmin.FrameInserisciLiv;
import visteadmin.FrameInserisciModPag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;


public class InserisciDiscDispDAO {

	
    
    
public static boolean inserimentodiscdisp ( String dis ,String liv,String costomen){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT disciplinedisponibili.disciplina,disciplinedisponibili.livello FROM disciplinedisponibili WHERE livello  ='"+liv+"' and disciplina  ='"+dis+"'; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+dis+" cui è associato il livello "+liv+" è già stata creata, inserirne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO  `disciplinedisponibili`(disciplina,livello,costomensile) VALUES ('"+dis+"','"+liv+"','"+costomen+"') ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameInserisciDiscDisp.frame,"La disciplina  \""+dis+"\" cui è associato il livello "+liv+" è stata inserita  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciDiscDisp.frame, ex);
}
return false;
}





     
}






     





