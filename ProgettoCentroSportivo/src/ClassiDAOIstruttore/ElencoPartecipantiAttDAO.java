package ClassiDAOIstruttore;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import DBInterfaccia.DbConnection;
import Model_Istruttore.ElencoPartecipanti;
import Model_Tesserato.ElencoAttivita;
public class ElencoPartecipantiAttDAO {
	
private static ElencoPartecipantiAttDAO instance;
	
	public static synchronized ElencoPartecipantiAttDAO getInstance() {
		if(instance==null)
			instance=new ElencoPartecipantiAttDAO();
		return instance;
	}
public static ArrayList<ElencoPartecipanti> elencoiniziale(int codiceturno) {
		
		
        ArrayList<ElencoPartecipanti> dati= new ArrayList<ElencoPartecipanti>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT distinct elencoutenti.nome,elencoutenti.cognome from elencoutenti inner join tesserato on tesserato.idutente=elencoutenti.idutente inner join iscrizioniperturno on iscrizioniperturno.tesserato=tesserato.matricolatesserato where iscrizioniperturno.codiceturno ='"+codiceturno+"'");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoPartecipanti d=new ElencoPartecipanti(); 	
        	d.setNomeTes(riga[0]);
        	d.setCognomeTes(riga[1]);
        	
        	

        	
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}

}
