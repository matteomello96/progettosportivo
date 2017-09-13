package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import visteadmin.FrameDettagliDaAccResp;
import visteadmin.FrameDettagliMod;


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
	            
	            st.executeUpdate("UPDATE detiscr SET confermato=0  WHERE iddet='"+idordine+"'");
	     
	      st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+tesserato+"' and codiceturno='"+codiceturno+"' ");
			st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'+1 WHERE codiceturno='"+codiceturno+"'");
	   JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, "Conferma annullata");
	   
	      
		            }
		      
		            else
		            {
		            	
		            	JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, "Parte di ordine già annullata");
		            }
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame,"GestioneDETiscrConf "+ ex+"");
	        }
		
		
		
	}
	
	public static void AnnullaDetModIsc(int idordine,int tesserato,int codiceturno){
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
	            
	            st.executeUpdate("UPDATE detiscr SET confermato=0,modificato=1  WHERE iddet='"+idordine+"'");
	     
	      st.executeUpdate("DELETE FROM iscrizioniperturno where tesserato='"+tesserato+"' and codiceturno='"+codiceturno+"' ");
			st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'+1 WHERE codiceturno='"+codiceturno+"'");
	   JOptionPane.showMessageDialog(FrameDettagliMod.frame, "Conferma modifica annullata");
	   
	      
		            }
		      
		            else
		            {
		            	
		            	JOptionPane.showMessageDialog(FrameDettagliMod.frame, "Parte di ordine già annullata");
		            }
	      
	      
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(FrameDettagliMod.frame,"GestioneDETiscrConf "+ ex+"");
	        }
		
		
		
	}
	
	
	
	
	public static void ConfermaDetIscrizione(int idordine,int tesserato,int codiceturno,int ord){
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
	      st.executeUpdate("INSERT INTO iscrizioniperturno (codiceturno,tesserato,iddet) VALUES('"+codiceturno+"','"+tesserato+"','"+ord+"')");
	  		st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'-1 WHERE codiceturno='"+codiceturno+"'");
	  	      JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, "Parte di ordine accettata");
	      
	            }
	      
	            else
	            {
	            	
	            	JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, "Parte di ordine già accettata");
	            }
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, ex);
	        }
		
		
		
	}
	

	public static void ConfermaDetMod(int idordine,int tesserato,int codiceturno,int ord){
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
	      st.executeUpdate("INSERT INTO iscrizioniperturno (codiceturno,tesserato,iddet) VALUES('"+codiceturno+"','"+tesserato+"','"+ord+"')");
	  		st.executeUpdate("UPDATE gestioneturno SET prenotazionidisponibili='"+GetInfoDB.getprenotazioni(codiceturno)+"'-1 WHERE codiceturno='"+codiceturno+"'");
	  	      JOptionPane.showMessageDialog(FrameDettagliMod.frame, "Modifica accettata");
	      
	            }
	      
	            else
	            {
	            	
	            	JOptionPane.showMessageDialog(FrameDettagliMod.frame, "Modifica già accettata");
	            }
	  
		           	
	            
	           
	            
	        } catch (SQLException ex) {
	        	JOptionPane.showMessageDialog(FrameDettagliMod.frame, ex);
	        }
		
		
		
		
	}
}
