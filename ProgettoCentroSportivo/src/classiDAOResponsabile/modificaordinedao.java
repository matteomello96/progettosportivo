package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import visteadmin.FrameOrdini;
import visteadmin.FrameElencoUtenti;
import visteadmin.framedettagli;

public class modificaordinedao {
	
	public static void modifica(int idiscrizione,int tesserato,int codiceturno){
		
		Connection con =DbConnection.db;
		
		Statement st;
		  ResultSet rs;
		int conf,ann;
		
		
		try{
			st= con.createStatement();	
		
			
			
			 rs=st.executeQuery("select confermato from detiscr where iddet='"+idiscrizione+"'");
        	 rs.next();
             conf=rs.getInt("confermato");
            
             rs=st.executeQuery("select annullato from detiscr where iddet='"+idiscrizione+"'");
        	 rs.next();
             ann=rs.getInt("annullato");
             //JOptionPane.showMessageDialog(framedettagli.frame, "'"+idiscrizione+"','"+conf+"','"+ann+"',");
             
             if(conf==0 && ann==1){
			st.executeUpdate("UPDATE detiscr SET confermato=1 WHERE iddet='"+idiscrizione+"'");
			st.executeUpdate("UPDATE detiscr SET annullato=0 WHERE iddet='"+idiscrizione+"'");
		st.executeUpdate("INSERT iscrizioniperturno (Codiceturnotesserato,codiceturno,tesserato)"+
			"VALUES(NULL,'"+codiceturno+"','"+tesserato+"')");
		st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'-1 WHERE codiceturno='"+codiceturno+"'");
	      JOptionPane.showMessageDialog(framedettagli.frame, "Modifica accettata");
	
             }
             
             else{
            	 
            	 st.executeUpdate("UPDATE detiscr SET confermato=0 WHERE iddet='"+idiscrizione+"'");
     			st.executeUpdate("UPDATE detiscr SET annullato=1 WHERE iddet='"+idiscrizione+"'");
     			st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+tesserato+"' and codiceturno='"+codiceturno+"' ");
     			st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'+1 WHERE codiceturno='"+codiceturno+"'");
     	   JOptionPane.showMessageDialog(framedettagli.frame, "Modifica negata");	 
             
             }
	
	


				
			}
			
			catch(SQLException ex){
				
				
			}
	}

}
