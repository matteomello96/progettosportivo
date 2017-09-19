package ClassiDaoTesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;

import view_tesserato.FrameDettagliConfTess;
import view_tesserato.FrameDettagliDaAccTess;
import view_tesserato.FrameDettagliModTess2;

import view_tesserato.FrameInserisciTurno;
import view_tesserato.FrameIscrDisc;
import view_tesserato.FrameModificaTurnoMod;


public class Modifica_Turno_Dao {
public static String oldday;
public static String oldhours;
public static int conf;	
	
	public static void ModificaDaAcc(String disciplina,String livello, String giorno, String orario,int tesserato,int iddet,int codturnoprec){
		
		
		
		Connection con = DbConnection.db;
		
	        Statement st;
	        ResultSet rs;
	      
	        try {
	        	
	        	
	     oldday= (String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 5) ;      
	     oldhours= (String) FrameDettagliDaAccTess.table_2.getValueAt(FrameDettagliDaAccTess.table_2.getSelectedRow(), 6) ;
	 
	    st = con.createStatement(); 
	  
	    
	   
   //    JOptionPane.showMessageDialog(FrameInserisciTurno.frame, "'"+conf+"'");
       
       
       
	    st.executeUpdate("UPDATE detiscr SET giorno = '"+giorno+"',orario = '"+orario+"',confermato=0,modificato=0 WHERE iddet='"+iddet+"'");
	  
	  
	 
	  
	  

	   st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+tesserato+"' and codiceturno='"+codturnoprec+"' ");
	   st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codturnoprec)+"'+1 WHERE codiceturno='"+codturnoprec+"'");  	
	 
	        	
	         }
	           
	         
	 
	        
	        catch (SQLException ex) {
	           
	        }
		
	}
	public static void ModificaDaConf(String disciplina,String livello, String giorno, String orario,int tesserato,int iddet,int codturnoprec){
		
		
		
		Connection con = DbConnection.db;
		
	        Statement st;
	        ResultSet rs;
	        int ris=0;
	        try {
	        	
	        	
	   	     oldday= (String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 5) ;      
	   	     oldhours= (String) FrameDettagliConfTess.table_2.getValueAt(FrameDettagliConfTess.table_2.getSelectedRow(), 6) ;
	   	 
	   	    st = con.createStatement(); 
	   	  
	   	    
	   	   
	      //    
	          
	          
	          
	   	    st.executeUpdate("UPDATE detiscr SET giorno = '"+giorno+"',orario = '"+orario+"',confermato=0,modificato=1 WHERE iddet='"+iddet+"'");
	   	  
	   	  
	   	 
	   	  
	   	  

	   	   st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+tesserato+"' and codiceturno='"+codturnoprec+"' ");
	   	   st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codturnoprec)+"'+1 WHERE codiceturno='"+codturnoprec+"'");  	 	
	   	   	
	   	rs = st.executeQuery("SELECT idiscrizione FROM detiscr WHERE iddet='"+iddet+"' ; "); 
	   	
        rs.next();
        ris=rs.getInt("idiscrizione");
	    JOptionPane.showMessageDialog(FrameInserisciTurno.frame, "'"+ris+"'");    	
        st.executeUpdate("UPDATE iscrizionedisciplina SET confermato=0,modificato=1,annullato=0 WHERE codiceiscrizionedisciplina='"+ris+"'");
        
        
        
        
	         }
	           
	         
	 
	        
	        catch (SQLException ex) {
	           
	        }
		
	}
	
public static void ModificaDaMod(String disciplina,String livello, String giorno, String orario,int tesserato,int iddet,int codturnoprec){
		
		
		
		Connection con = DbConnection.db;
		
	        Statement st;
	        ResultSet rs;
	        int ris=0;
	        try {
	        	
	        	
	   	     oldday= (String) FrameDettagliModTess2.table_2.getValueAt(FrameDettagliModTess2.table_2.getSelectedRow(), 5) ;      
	   	     oldhours= (String) FrameDettagliModTess2.table_2.getValueAt(FrameDettagliModTess2.table_2.getSelectedRow(), 6) ;
	   	 
	   	    st = con.createStatement(); 
	   	  
	   	    
	   	   
	      //    
	          
	          
	          
	   	    st.executeUpdate("UPDATE detiscr SET giorno = '"+giorno+"',orario = '"+orario+"',confermato=0,modificato=1 WHERE iddet='"+iddet+"'");
	   	  
	   	  
	   	 
	   	  
	   	  

	   	   st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+tesserato+"' and codiceturno='"+codturnoprec+"' ");
	   	   st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codturnoprec)+"'+1 WHERE codiceturno='"+codturnoprec+"'");  	 	
	   	   	
	   	rs = st.executeQuery("SELECT idiscrizione FROM detiscr WHERE iddet='"+iddet+"' ; "); 
	   	
        rs.next();
        ris=rs.getInt("idiscrizione");
	    JOptionPane.showMessageDialog(FrameModificaTurnoMod.frame, "'"+ris+"'");    	
        st.executeUpdate("UPDATE iscrizionedisciplina SET confermato=0,modificato=1,annullato=0 WHERE codiceiscrizionedisciplina='"+ris+"'");
        
        
        
        
	         }
	           
	         
	 
	        
	        catch (SQLException ex) {
	           
	        }
		
	}
	
	
	public static void Uccidi_isc(int idordine){
		 Connection con = DbConnection.db;
		   Statement st;
		   
		   
		   try {
	            
	            st= con.createStatement();
	            
	            
	      st.executeUpdate("DELETE FROM detiscr WHERE idiscrizione='"+idordine+"'");
	      st.executeUpdate("DELETE FROM iscrizionedisciplina WHERE codiceiscrizionedisciplina='"+idordine+"'");
	      st.executeUpdate("DELETE FROM iscrizioniperturno WHERE iddet='"+idordine+"'");
	      JOptionPane.showMessageDialog(FrameIscrDisc.frame, "Ordine eliminato");
		   } catch (SQLException ex) {
	           
	        }
		
		
		
	}
}


