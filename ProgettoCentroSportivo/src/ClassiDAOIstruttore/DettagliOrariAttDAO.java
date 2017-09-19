package ClassiDAOIstruttore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;

import Model_Istruttore.DettagliOrariAtt;


public class DettagliOrariAttDAO {

	 
	private static DettagliOrariAttDAO instance;
	
	public static synchronized DettagliOrariAttDAO getInstance() {
		if(instance==null)
			instance=new DettagliOrariAttDAO();
		return instance;
	}
public static ArrayList<DettagliOrariAtt> elencoorario(int comblivdis) {
		
		
        ArrayList<DettagliOrariAtt> dati= new ArrayList<DettagliOrariAtt>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select gestioneturno.giornosettimana,gestioneturno.fasciaoraria,gestioneturno.spazio,gestioneturno.prenotazionidisponibili from gestioneturno  where gestioneturno.combinazionelivdis='"+comblivdis+"' ;");
        Iterator<String[]> i = res.iterator();
        
        while (i.hasNext()) {
        	String[] riga = i.next();
        	
        	DettagliOrariAtt d= new DettagliOrariAtt(); 	
        	d.setGiornoSettimana(riga[0]);
        	d.setFasciaOraria(riga[1]);
        	d.setSpazio(riga[2]);
        	d.setPrenotazioniDisp(Integer.parseInt(riga[3]));
       
        	//..
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
}