package ClassiDaoTesserato;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import view_dipendente.FrameTesserato;

public class TestimnianzaDao {

	
	
	public static String momento;
	
	public static String getDate(){
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		   Calendar cal = Calendar.getInstance();
		   String data=dateFormat.format(cal.getTime());
		   return data;
		}
	
	public static void instest(){
		
		Connection con = DbConnection.db;
        Statement st;
        try {
        	st = con.createStatement();
        	momento=TriggerOrdine.getDate();
        	 
            
        	
            st.executeUpdate("INSERT INTO testimonianza (CodiceTestimonianza,Commento,DataAzione,Tesserato,combinazionelivdis) "
            		+ "VALUES (NULL, '"+GetInfoDB.getidTess(Utente.getUsername())+"','"+momento+"', '"+GetInfoDB.getidTess(Utente.getUsername())+"', '0','"+momento+"')"); 
        } catch (SQLException ex) {
        }
		
		
	}
	
	
	
}
