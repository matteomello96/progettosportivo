package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import visteadmin.framedettagli;


public class GestioneDetIscrizioniDAO {
	
	
	public static void AnnullaDetIsc(int idordine,int tesserato,int codiceturno){
		 Connection con = DbConnection.db;
		   Statement st;
		   ResultSet rs;
				int conf;
		   
		   
	            
			   
			   try {
		            
		            st= con.createStatement();
		            rs=st.executeQuery("select confermato from detiscr where iddet='"+idordine+"'");
		        	 rs.next();
		             conf=rs.getInt("confermato");
		            
		            if(conf==1)
		            {
	            
	            st.executeUpdate("UPDATE detiscr set confermato=0  WHERE iddet='"+idordine+"'");
	     
	      st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+tesserato+"' and codiceturno='"+codiceturno+"' ");
			st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'+1 WHERE codiceturno='"+codiceturno+"'");
	   JOptionPane.showMessageDialog(framedettagli.frame, "Conferma annullata");
	   
	      
		            }
		      
		            else
		            {
		            	
		            	JOptionPane.showMessageDialog(framedettagli.frame, "Parte di ordine già annullata");
		            }
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(framedettagli.frame, ex);
	        }
		
		
		
	}
	public static void ConfermaDetIscrizione(int idordine,int tesserato,int codiceturno){
		 Connection con = DbConnection.db;
		   Statement st;
		   ResultSet rs;
			int conf;
		   
		   try {
	            
	            st= con.createStatement();
	            rs=st.executeQuery("select confermato from detiscr where iddet='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("confermato");
	            
	            if(conf==0)
	            {
	      st.executeUpdate("UPDATE detiscr set confermato=1  WHERE iddet='"+idordine+"'");
	      st.executeUpdate("INSERT iscrizioniperturno (codiceturno,tesserato) VALUES('"+codiceturno+"','"+tesserato+"')");
	  		st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'-1 WHERE codiceturno='"+codiceturno+"'");
	  	      JOptionPane.showMessageDialog(framedettagli.frame, "Parte di ordine accettata");
	      
	            }
	      
	            else
	            {
	            	
	            	JOptionPane.showMessageDialog(framedettagli.frame, "Parte di ordine già accettata");
	            }
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(framedettagli.frame, ex);
	        }
		
		
		
	}
	

	public static void ConfermaDetMod(int idordine,int tesserato,int codiceturno){
		 Connection con = DbConnection.db;
		   Statement st;
		   ResultSet rs;
			int conf;
		   
		   try {
	            
	            st= con.createStatement();
	            rs=st.executeQuery("select modificato from detiscr where iddet='"+idordine+"'");
	        	 rs.next();
	             conf=rs.getInt("modificato");
	            
	            if(conf==1)
	            {
	      st.executeUpdate("UPDATE detiscr set confermato=1,modificato=0  WHERE iddet='"+idordine+"'");
	      st.executeUpdate("INSERT iscrizioniperturno (codiceturno,tesserato) VALUES('"+codiceturno+"','"+tesserato+"')");
	  		st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'-1 WHERE codiceturno='"+codiceturno+"'");
	  	      JOptionPane.showMessageDialog(framedettagli.frame, "Modifica accettata");
	      
	            }
	      
	            else
	            {
	            	
	            	JOptionPane.showMessageDialog(framedettagli.frame, "Modifica già accettata");
	            }
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(framedettagli.frame, ex);
	        }
		
		
		
		
	}
}
