package ClassiDaoTesserato;

import java.io.IOException;
import java.math.RoundingMode;

import java.text.DecimalFormat;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import ClassiDao.GetInfoDB;
import Model.Utente;


import view_dipendente.FrameTesserato;




public class TriggerOrdine {
	public static String momento;
	
	
	 public static PDDocument writePDF() {
     	final DecimalFormat df = new DecimalFormat("0.00");
 		df.setRoundingMode(RoundingMode.HALF_EVEN);
			try {
				
				PDDocument text = new PDDocument();
				PDPage pagina = new PDPage(PDPage.PAGE_SIZE_A4);
				text.addPage(pagina);
				PDPageContentStream vers = new PDPageContentStream(text, pagina);
				String s0,s1,s3;
	    		vers.beginText();
	    		vers.setFont(PDType1Font.COURIER_BOLD, 20);
	    		vers.moveTextPositionByAmount(20, 800);
	    		vers.drawString(":: DISTINTA ISCRIZIONE DISCIPLINE ::\r\r\n");
	    		vers.setFont(PDType1Font.HELVETICA, 8);
				vers.moveTextPositionByAmount(5, -25);
				vers.drawString("ID Tesserato: "+GetInfoDB.getidTess(Utente.getUsername())+"\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("Nome dipendente: "+Utente.getUsername()+"\r\n");
	    		
	    		
	    		
	    		
	    		
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("__________________________________________________________________________________________________________________________\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA_BOLD, 8);
	    		vers.drawString("Nome Disciplina                           Livello                                           Prezzo Singola Attività (EUR)   ");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA, 8);
	    		vers.drawString("__________________________________________________________________________________________________________________________\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		
	    		for(int c=0;c<FrameTesserato.table_1.getRowCount();c++)
	    		{
	    		
	    			s0=FrameTesserato.table_1.getValueAt(c, 0).toString();
	    			s1=FrameTesserato.table_1.getValueAt(c, 1).toString();
	    			s3=FrameTesserato.table_1.getValueAt(c,3).toString();
	    		
	    			
	    			                   
	    	    	vers.drawString(s0);
	    			vers.moveTextPositionByAmount(120, 0);
	    			vers.drawString(s1);
	    			vers.moveTextPositionByAmount(210, 0);
	    			vers.drawString(s3);
	    			
	    			
	    				
	    			vers.moveTextPositionByAmount(-120-210, -12);
	    			
	    			 
	    		}
	    		
	    		
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA_BOLD, 10);
	    		vers.drawString("PREZZO TOTALE ORDINE: \t\t"+df.format(FrameTesserato.totale)+" EUR\r\n");
	    			
			
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
 		String s0,s1,s3;
 		String rigaord="",prezzototale;
 		
 		String tit=":: DISTINTA ORDINE ::\r\r\n";
 		
 
 		String dataord="Data ordine: "+momento+"\r\n";
 		String datidip="ID Tesserato: "+GetInfoDB.getidTess(Utente.getUsername())+"\r\nNome tesserato: "+Utente.getUsername()+"\r\n";
 		
 		String titoli="___________________________________________________________________________________________________\r\nnomedisciplina          livello      Prezzo singola attivita (EUR)      \r\n___________________________________________________________________________________________________\r\n";
 		for(int c=0;c<FrameTesserato.table_1.getRowCount();c++)
 		{
 		
 			s0=FrameTesserato.table_1.getValueAt(c, 0).toString();
 		    s1=FrameTesserato.table_1.getValueAt(c, 1).toString();
 			s3=FrameTesserato.table_1.getValueAt(c,3).toString();
 		
 		rigaord=rigaord+s0+";               "+s1+";             "+s3+"\r\n";
 			
 			
 		}
 		
 		prezzototale="\r\nPrezzo totale ordine: \t\t"+FrameTesserato.totale+" EUR\r\n";
 		String ris=tit+dataord+datidip+titoli+rigaord+prezzototale;
 			return ris;
 	}
     
}
