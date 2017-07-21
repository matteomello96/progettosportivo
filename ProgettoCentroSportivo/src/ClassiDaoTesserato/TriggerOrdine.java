package ClassiDaoTesserato;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import ClassiDao.GetInfoDB;
import Model.Utente;
import view_dipendente.FrameTesserato;




public class TriggerOrdine {
	public static String momento;
	public static String getDate(){
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		   Calendar cal = Calendar.getInstance();
		   String data=dateFormat.format(cal.getTime());
		   return data;
		}
	
	
	 public static PDDocument writePDF() {
     	final DecimalFormat df = new DecimalFormat("0.00");
 		df.setRoundingMode(RoundingMode.HALF_EVEN);
			try {
				
				PDDocument text = new PDDocument();
				PDPage pagina = new PDPage(PDPage.PAGE_SIZE_A4);
				text.addPage(pagina);
				PDPageContentStream vers = new PDPageContentStream(text, pagina);
				String s0,s1,s2,s3,s4;
	    		vers.beginText();
	    		vers.setFont(PDType1Font.COURIER_BOLD, 20);
	    		vers.moveTextPositionByAmount(20, 800);
	    		vers.drawString(":: DISTINTA ISCRIZIONE DISCIPLINE ::\r\r\n");
	    		vers.setFont(PDType1Font.HELVETICA, 8);
				vers.moveTextPositionByAmount(5, -25);
	    		vers.drawString("Data ordine: "+momento+"\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("ID Tesserato: "+GetInfoDB.getidTess(Utente.getUsername())+"\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("Nome dipendente: "+Utente.getUsername()+"\r\n");
	    	//	vers.moveTextPositionByAmount(0, -12);
	    		//cos.drawString("Sede dipendente: "+GetInfoDB.getnomeSede(Utente.getUsername())+"\r\n");
	    		//cos.moveTextPositionByAmount(0, -12);
	    		
	    		//cos.drawString("Magazzino predefinito del dipendente: "+GetInfoDB.getnomeMagdelDip(Utente.getUsername())+"\r\n");
	    		//cos.moveTextPositionByAmount(0, -12);
	    		//cos.moveTextPositionByAmount(0, -12);
	    		//cos.drawString("Tariffe costi spedizione (EUR):\r\n \r\n");
	    		//cos.moveTextPositionByAmount(0, -12);
	    		//cos.moveTextPositionByAmount(0, -12);
	    	//	cos.drawString("Prezzo spedizione Magazzino predefinito: "+GetInfoDB.getspNorm());
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.drawString("Prezzo spedizione altro magazzino: "+GetInfoDB.getspExtra()+"\r\n\r\n");
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.drawString("__________________________________________________________________________________________________________________________\r\n");
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.setFont(PDType1Font.HELVETICA_BOLD, 8);
	    	//	cos.drawString("ID_ART       Nome articolo                                                               Pezzi ordinati       Prezzo singolo art. (EUR)                        Magazzino");
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.setFont(PDType1Font.HELVETICA, 8);
	    	//	cos.drawString("__________________________________________________________________________________________________________________________\r\n");
	    	//	cos.moveTextPositionByAmount(0, -12);
	    		
	    		for(int c=0;c<FrameTesserato.table_1.getRowCount();c++)
	    		{
	    		
	    			s0=FrameTesserato.table_1.getValueAt(c, 0).toString();
	    			s1=FrameTesserato.table_1.getValueAt(c, 1).toString();	
	    	     	s2=FrameTesserato.table_1.getValueAt(c,2).toString();
	    			s3=FrameTesserato.table_1.getValueAt(c,3).toString();
	    		
	    			
	    			                   
	    	    	vers.drawString(s0);
	    			vers.moveTextPositionByAmount(45, 0);
	    			vers.drawString(s1);
	    			vers.moveTextPositionByAmount(210, 0);
	    			vers.drawString(s2);
	    			vers.moveTextPositionByAmount(70, 0);
	    			vers.drawString(s3);
	    			
	    			
	    				
	    			vers.moveTextPositionByAmount(-45-210-70-130, -12);
	    			
	    			 
	    		}
	    		//float total=ConfOrd.floatsped+DipenFrame.totale;
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.drawString("Prezzo articoli: \t\t"+df.format(DipenFrame.totale)+" EUR\r\n");
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.drawString("Prezzo spedizione ordine: \t"+ConfOrd.floatsped+" EUR\r\n");
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.moveTextPositionByAmount(0, -12);
	    	//	cos.setFont(PDType1Font.HELVETICA_BOLD, 10);
	    		//cos.drawImage(DipenFrame.class.getResource("/resources/cart.png"), 100, 100);
	    	//	cos.drawString("PREZZO TOTALE ORDINE: \t\t"+df.format(total)+" EUR\r\n");
	    		
	    			
			
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
 		String s0,s1,s2,s3;
 		String rigaord="",prezzoart,prezzosped;
 		
 		String tit=":: DISTINTA ORDINE ::\r\r\n";
 		
 
 		String dataord="Data ordine: "+momento+"\r\n";
 		String datidip="ID Tesserato: "+GetInfoDB.getidTess(Utente.getUsername())+"\r\nNome tesserato: "+Utente.getUsername()+"\r\n";
 		//String magpredef="Magazzino predefinito del dipendente: "+GetInfoDB.getnomeMagdelDip(Utente.getUsername())+"\r\n";
 	//	String tariffe="\r\n \r\nTariffe costi spedizione (EUR):\r\n \r\nPrezzo spedizione Magazzino predefinito: "+GetInfoDB.getspNorm()+"\r\nPrezzo spedizione altro magazzino: "+GetInfoDB.getspExtra()+"\r\n\r\n";
 		//String titoli="___________________________________________________________________________________________________\r\nID_ART     Nome articolo          Pezzi ordinati     Prezzo singolo art. (EUR)         Magazzino\r\n___________________________________________________________________________________________________\r\n";
 		for(int c=0;c<FrameTesserato.table_1.getRowCount();c++)
 		{
 		
 			s0=FrameTesserato.table_1.getValueAt(c, 0).toString();
 			s1=FrameTesserato.table_1.getValueAt(c, 1).toString();	
 			s2=FrameTesserato.table_1.getValueAt(c,2).toString();
 			s3=FrameTesserato.table_1.getValueAt(c,3).toString();
 		
 		rigaord=rigaord+s0+";          "+s1+";              "+s2+";                    "+s3+"\r\n";
 			
 			
 		}
 		
 	//	prezzoart="\r\nPrezzo articoli: \t\t"+DipenFrame.totale+" EUR\r\n";
 	//	prezzosped="Prezzo spedizione ordine: \t"+ConfOrd.floatsped+" EUR\r\n";
 	//	float total=ConfOrd.floatsped+DipenFrame.totale;
 	//	String prezzototale="\r\nPrezzo totale ordine: \t\t"+total+" EUR\r\n";;
 		//String ris=tit+ordn+dataord+datidip+magpredef+tariffe+titoli+rigart+prezzoart+prezzosped+prezzototale;
 		String ris=tit+dataord+datidip+rigaord;
 			return ris;
 	}
     
}
