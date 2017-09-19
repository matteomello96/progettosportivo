package ClassiDaoTesserato;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
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
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select Disciplina,Livello,giorno,orario,confermato from detiscr,disciplinedisponibili where tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and detiscr.combinazionelivdis=disciplinedisponibili.combinazionelivdis and detiscr.confermato= 0  and detiscr.annullato= 0 and detiscr.modificato= 0;");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoAttivita d=new ElencoAttivita(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setNomeLivello(riga[1]);
        	d.setGiorno(riga[2]);
        	d.setOrario(riga[3]);
        	d.setConfermato(Integer.parseInt(riga[4]));
        	

        	
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
public static ArrayList<ElencoAttivita> elencodopo(String momento) {
	
	
    ArrayList<ElencoAttivita> dati= new ArrayList<ElencoAttivita>(); 
    
    Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select Disciplina,Livello,giorno,orario,confermato from detiscr,disciplinedisponibili where tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and detiscr.combinazionelivdis=disciplinedisponibili.combinazionelivdis and detiscr.confermato= 0  and detiscr.annullato= 0 and detiscr.modificato= 0 and detiscr.idiscrizione='"+GetInfoDB.getlastorder(momento)+"';");
    Iterator<String[]> i = res.iterator();
    while(i.hasNext())  {
    	String[] riga = i.next();
    	ElencoAttivita d=new ElencoAttivita(); 	
    	d.setNomeDisciplina(riga[0]);
    	d.setNomeLivello(riga[1]);
    	d.setGiorno(riga[2]);
    	d.setOrario(riga[3]);
    	d.setConfermato(Integer.parseInt(riga[4]));
    	

    	
   
         	
    	
    	
    	dati.add(d);
    }
    return dati;
}
}
