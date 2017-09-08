package visteIstruttore;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import ClassiDao.GetInfoDB;
import Model.Utente;
import view_tesserato.Confermaordine;
import view_tesserato.FrameTesserato;
import DBInterfaccia.DbConnection;




public class TriggerPartecipantiAtt {
	public static String giornoset;
	public static String fasciaoraria;
	public static String spazio;
	
	

	 
	 
	 
	 public static PDDocument writePDF(String giornoset,String fasciaoraria,String spazio) {
     	final DecimalFormat df = new DecimalFormat("0.00");
 		df.setRoundingMode(RoundingMode.HALF_EVEN);
			try {
				
				PDDocument text = new PDDocument();
				PDPage pagina = new PDPage(PDPage.PAGE_SIZE_A4);
				text.addPage(pagina);
				PDPageContentStream vers = new PDPageContentStream(text, pagina);
				String s0,s1,s2;
	    		vers.beginText();
	    		vers.setFont(PDType1Font.COURIER_BOLD, 20);
	    		vers.moveTextPositionByAmount(20, 800);
	    		vers.drawString("            ELENCO PARTECIPANTI \r\r\n");
	    		vers.setFont(PDType1Font.HELVETICA, 8);
				vers.moveTextPositionByAmount(5, -25);
				vers.drawString("Giorno "+giornoset+" \r\n\r\n");
				vers.moveTextPositionByAmount(0, -12);
				vers.drawString("Fascia oraria: "+fasciaoraria+"\r\n");
				vers.moveTextPositionByAmount(0, -12);
				vers.drawString("Spazio: "+spazio+"\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		
	    		
	    		
	    		
	    		
	    		
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("__________________________________________________________________________________________________________________________\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA_BOLD, 8);
	    		vers.drawString("Nome Tesserato                                                                                             Cognome Tesserato   ");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA, 8);
	    		vers.drawString("__________________________________________________________________________________________________________________________\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		
	    		for(int c=0;c<DetPartAtt.table1.getRowCount();c++)
	    		{
	    		
	    			s0=DetPartAtt.table1.getValueAt(c, 0).toString();
	    			s1=DetPartAtt.table1.getValueAt(c, 1).toString();
	    			
	                
	    		
	    			
	    			                   
	    	    	vers.drawString(s0);
	    			vers.moveTextPositionByAmount(120, 0);
	    			vers.drawString(s1);
	    			vers.moveTextPositionByAmount(120, 0);
	    			
	    		
	    			
	    				
	    			vers.moveTextPositionByAmount(-120-120, -12);
	    			
	    			 
	    		}
	    		
	    		
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA_BOLD, 10);
	    		
	    			
			
				vers.endText();
				
				vers.close();
				
				
				return text;
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			
			return null;
			
     }
	 
	 
	 public static String scriviDistinta(){
 		String s0,s3;
 		String rigaord="";
 		
 		String tit=":: ELENCO PARTECIPANTI ::\r\r\n";
 		
 
 		String dataord="Giorno settimana: "+giornoset+"\r\n";
 		String datidip="Fascioraria: "+fasciaoraria+"\r\nSpazio: "+spazio+"\r\n";
 		
 		String titoli="___________________________________________________________________________________________________\r\nNome tesserato                  Cognome Tesserato\r\n___________________________________________________________________________________________________\r\n";
 		for(int c=0;c<DetPartAtt.table1.getRowCount();c++)
 		{
 		
 			s0=DetPartAtt.table1.getValueAt(c, 0).toString();
 		    s3=DetPartAtt.table1.getValueAt(c, 1).toString();
 			
 			
 		rigaord=rigaord+s0+";                            "+s3+"\r\n";
 			
 			
 		}
 		
 		
 		String ris=tit+dataord+datidip+titoli+rigaord;
 			return ris;
 	}
     
}
