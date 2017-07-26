package ClassiDaoTesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import view_dipendente.FrameTestimonianze;

public class TestimnianzaDao {

	
	
	public static String momento;
	
 	
	public static String getDate(){
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		   Calendar cal = Calendar.getInstance();
		   String data=dateFormat.format(cal.getTime());
		   return data;
		}
	
	public static void instest(String disciplina,String livello,String commento){
		
		Connection con = DbConnection.db;
        Statement st;
        Connection con2 = DbConnection.db;
        Statement st2;
        ResultSet rs;
        int a;
        
        try {
        	st = con.createStatement();
        	st2=con2.createStatement();
        	momento=TriggerOrdine.getDate();
        	 rs=st2.executeQuery("select Combinazionelivdis from disciplinedisponibili where Disciplina='"+disciplina+"' and Livello='"+livello+"'");
        	 rs.next();
             a=rs.getInt("combinazionelivdis");
            // JOptionPane.showMessageDialog(null, "Il nome utente \""+GetInfoDB.getidTess(Utente.getUsername())+"\" e\\o l'email \""+commento+"\" sono gi� in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
           st.executeUpdate("INSERT INTO testimonianza (CodiceTestimonianza,Commento,DataAzione,Tesserato,combinazionelivdis) "
           		+"VALUES (NULL, '"+commento+"','"+momento+"','"+GetInfoDB.getidTess(Utente.getUsername())+"','"+a+"')"); 
            JOptionPane.showMessageDialog(FrameTestimonianze.frame, "Testimonianza inviata"," ",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
        }
		
		
	}
	
	
	
}