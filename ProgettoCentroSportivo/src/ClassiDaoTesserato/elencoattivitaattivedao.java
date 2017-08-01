package ClassiDaoTesserato;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import DBInterfaccia.DbConnection;
import Model_Tesserato.ElencoAttivita;
public class elencoattivitaattivedao{
	
private static elencoattivitaattivedao instance;
	
	public static synchronized elencoattivitaattivedao getInstance() {
		if(instance==null)
			instance=new elencoattivitaattivedao();
		return instance;
	}
public static ArrayList<ElencoAttivita> elencoiniziale() {
		
		
        ArrayList<ElencoAttivita> dati= new ArrayList<ElencoAttivita>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select Disciplina,Livello,giorno,orario from detiscr,disciplinedisponibili where confermato=1 and giorno!='null' and orario!='null' and detiscr.combinazionelivdis=disciplinedisponibili.combinazionelivdis;");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoAttivita d=new ElencoAttivita(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setNomeLivello(riga[1]);
        	d.setGiorno(riga[2]);
        	d.setOrario(riga[3]);
        	

        	
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}

}
