package ClassiDaoTesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;

import view_tesserato.FrameDiscAttive;



public class Invia_Turno_Dao {
public static String oldday;
public static String oldhours;
public static int conf;	
	
	public static void Invia(String disciplina,String livello, String giorno, String orario){
		
		
		
		Connection con = DbConnection.db;
		
	        Statement st;
	        ResultSet rs;
	      
	        try {
	        	
	        	
	     oldday= (String) FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 2) ;      
	     oldhours= (String) FrameDiscAttive.table_1.getValueAt(FrameDiscAttive.table_1.getSelectedRow(), 3) ;
	 
	    st = con.createStatement(); 
	  
	    
	    rs=st.executeQuery("select confermato from detiscr where iddet='"+GetInfoDB.getiddet2(disciplina, livello, GetInfoDB.getidTess(Utente.getUsername()))+"'");
   	 rs.next();
       conf=rs.getInt("confermato");
   //    JOptionPane.showMessageDialog(FrameInserisciTurno.frame, "'"+conf+"'");
       
       
       
	    st.executeUpdate("UPDATE detiscr SET giorno = '"+giorno+"' WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");
	    st.executeUpdate("UPDATE detiscr SET orario = '"+orario+"' WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'"); 
	    st.executeUpdate("UPDATE detiscr SET confermato=0 WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");
	  st.executeUpdate("UPDATE detiscr SET modificato=0  WHERE detiscr.combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and detiscr.tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"'");
	 
	  
	  
	  /*if(conf==1){
	   st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and codiceturno='"+GetInfoDB.getcodiceturno2(disciplina, livello, oldday, oldhours)+"' ");
	   st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(GetInfoDB.getcodiceturno2(disciplina, livello, oldday, oldhours))+"'+1 WHERE codiceturno='"+GetInfoDB.getcodiceturno2(disciplina, livello, oldday, oldhours)+"'");  	
	  }*/
	        	
	         }
	           
	         
	 
	        
	        catch (SQLException ex) {
	           
	        }
		
	}

}


