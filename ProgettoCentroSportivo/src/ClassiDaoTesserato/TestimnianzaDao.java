package ClassiDaoTesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;

import view_tesserato.FrameInsTest;

public class TestimnianzaDao {

	
	
	public static String momento;
	
 	
	public static String getDate(){
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		   Calendar cal = Calendar.getInstance();
		   String data=dateFormat.format(cal.getTime());
		   return data;
		}
	
	public static void instest(String disciplina,String livello,String commento,int matricola,int a){
		
		Connection con = DbConnection.db;
        Statement st;
        Connection con2 = DbConnection.db;
        Statement st2;
        ResultSet rs;
        ;
        
        try {
        	st = con.createStatement();
        	st2=con2.createStatement();
        	momento=TriggerOrdine.getDate();
        	JOptionPane.showMessageDialog(FrameInsTest.frame, momento," ",JOptionPane.INFORMATION_MESSAGE);
           st.executeUpdate("INSERT INTO testimonianza(Commento,DataAzione,Tesserato,combinazionelivdis) "
           		+"VALUES ('"+commento+"','"+momento+"','"+matricola+"','"+a+"')"); 
            JOptionPane.showMessageDialog(FrameInsTest.frame, "Testimonianza inviata"," ",JOptionPane.INFORMATION_MESSAGE);
            FrameInsTest.frame.dispose();
            FrameInsTest.frame.setEnabled(true);
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(FrameInsTest.frame, ex," ",JOptionPane.WARNING_MESSAGE);				
        	 
        }
		
		
	}
	
	
	
}
