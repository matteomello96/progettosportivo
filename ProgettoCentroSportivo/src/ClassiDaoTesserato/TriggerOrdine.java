package ClassiDaoTesserato;

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




public class TriggerOrdine {
	public static String momento;
	
	public static String getDate(){
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		   Calendar cal = Calendar.getInstance();
		   String data=dateFormat.format(cal.getTime());
		   return data;
		}
	
	
	
	
	 public static void insOrdine(String pag){	
	        
	        Connection con = DbConnection.db;
	        Statement st;
	        
	       
	        
	        try {
	        	st = con.createStatement();
	        	momento=TriggerOrdine.getDate();
	        	 
	            
	        	//JOptionPane.showMessageDialog(null, "Il nome utente \""+FrameTesserato.totale+"\" e\\o l'email \""+momento+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);				
	            st.executeUpdate("INSERT INTO iscrizionedisciplina (codiceiscrizionedisciplina,dataazione,tesserato,modalitapagamento,prezzotot,confermato,annullato) "
	            		+ "VALUES (NULL,'"+momento+"','"+GetInfoDB.getidTess(Utente.getUsername())+"','"+pag+"','"+FrameTesserato.totale+"', '0', '0')"); 
	        } catch (SQLException ex) {
	        }
	    }
	 
	 
	 
	 public static void insdetiscr(String disciplina,String livello,String momento){	
	        
	        Connection con = DbConnection.db;
	        Statement st;
	        
	       
	        
	        try {
	        	st = con.createStatement();

	        	 
	  //JOptionPane.showMessageDialog(Confermaordine.frame, " \""+GetInfoDB.getcombinazionelivdis(disciplina,livello)+"\" \\o \""+livello+"\","+disciplina+" "," ",JOptionPane.INFORMATION_MESSAGE);	
			
	        st.executeUpdate("INSERT INTO detiscr (iddet,combinazionelivdis,idiscrizione,tesserato,confermato,annullato) "
	        		+ "VALUES (NULL,'"+GetInfoDB.getcombinazionelivdis(disciplina,livello)+"','"+GetInfoDB.getlastorder(momento)+"','"+GetInfoDB.getidTess(Utente.getUsername())+"','0','0')"); 
	      } catch (SQLException ex) {
	        	
	        	
	        }
	    }

	 
	 
	 
	 public static PDDocument writePDF(String pagamento,String momento) {
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
	    		vers.drawString("            DISTINTA ISCRIZIONE DISCIPLINE\r\r\n");
	    		vers.setFont(PDType1Font.HELVETICA, 8);
				vers.moveTextPositionByAmount(5, -25);
				vers.drawString("Ordine n. "+GetInfoDB.getlastorder(momento)+" \r\n\r\n");
				vers.moveTextPositionByAmount(0, -12);
				vers.drawString("Data ordine: "+momento+"\r\n");
				vers.moveTextPositionByAmount(0, -12);
				vers.drawString("ID Tesserato: "+GetInfoDB.getidTess(Utente.getUsername())+"\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("Nome dipendente: "+Utente.getUsername()+"\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("Hai effettuato il pagamento con: "+pagamento+"\r\n");
	    		
	    		
	    		
	    		
	    		
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.drawString("__________________________________________________________________________________________________________________________\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA_BOLD, 8);
	    		vers.drawString("Nome Disciplina                           Livello                              Prezzo mensile (EUR)   ");
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA, 8);
	    		vers.drawString("__________________________________________________________________________________________________________________________\r\n");
	    		vers.moveTextPositionByAmount(0, -12);
	    		
	    		for(int c=0;c<FrameTesserato.table_1.getRowCount();c++)
	    		{
	    		
	    			s0=FrameTesserato.table_1.getValueAt(c, 0).toString();
	    			s1=FrameTesserato.table_1.getValueAt(c, 1).toString();
	    			s2=FrameTesserato.table_1.getValueAt(c,2).toString();
	                
	    		
	    			
	    			                   
	    	    	vers.drawString(s0);
	    			vers.moveTextPositionByAmount(120, 0);
	    			vers.drawString(s1);
	    			vers.moveTextPositionByAmount(120, 0);
	    			vers.drawString(s2);
	    		
	    			
	    				
	    			vers.moveTextPositionByAmount(-120-120, -12);
	    			
	    			 
	    		}
	    		
	    		
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.moveTextPositionByAmount(0, -12);
	    		vers.setFont(PDType1Font.HELVETICA_BOLD, 10);
	    		vers.drawString("PREZZO TOTALE : \t\t"+df.format(FrameTesserato.totale)+" EUR\r\n");
	    			
			
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
 		
 		String titoli="___________________________________________________________________________________________________\r\nnomedisciplina          livello      Prezzo mensile (EUR)      \r\n___________________________________________________________________________________________________\r\n";
 		for(int c=0;c<FrameTesserato.table_1.getRowCount();c++)
 		{
 		
 			s0=FrameTesserato.table_1.getValueAt(c, 0).toString();
 		    s1=FrameTesserato.table_1.getValueAt(c, 1).toString();
 			s3=FrameTesserato.table_1.getValueAt(c,2).toString();
 			
 		rigaord=rigaord+s0+";               "+s1+";             "+s3+"\r\n";
 			
 			
 		}
 		
 		prezzototale="\r\nPrezzo totale : \t\t"+FrameTesserato.totale+" EUR\r\n";
 		String ris=tit+dataord+datidip+titoli+rigaord+prezzototale;
 			return ris;
 	}
     
}
