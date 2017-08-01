package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model_Responsabile.Dettagliiscrizione;


public class dettagliiscrizionedao {
	


	
		
		
		
		private static dettagliiscrizionedao instance;
			
			public static synchronized dettagliiscrizionedao getInstance() {
				if(instance==null)
					instance=new dettagliiscrizionedao();
				return instance;
			}
			
			
			public static ArrayList<Dettagliiscrizione> elencoiniziale(int cod) {
				
				
		        ArrayList<Dettagliiscrizione> dati= new ArrayList<Dettagliiscrizione>(); 
		        
		        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT Disciplina,Livello,confermato,annullato from detiscr,disciplinedisponibili where idiscrizione='"+cod+"' and giorno!='null' and orario!='null' and disciplinedisponibili.combinazionelivdis=detiscr.combinazionelivdis; ");
		       
		        Iterator<String[]> i = res.iterator();
		       
		        while(i.hasNext())  {
		        	String[] riga = i.next();
		        	
		        	Dettagliiscrizione fa=new Dettagliiscrizione(); 	
		        	fa.setDisciplina(riga[0]);
		        	fa.setLivello(riga[1]);
		        	fa.setConferma(Integer.parseInt(riga[2]));
		        	fa.setAnnullla(Integer.parseInt(riga[3]));
		       
					
		       
		      
		        	
		        	
		        	
		        	dati.add(fa);
		        }
		        return dati;
			}
}
