package ClassiDAOIstruttore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;

import Model_Istruttore.DettagliOrariEv;

public class DettagliOrariEvDAO {

	 
	private static DettagliOrariEvDAO instance;
	
	public static synchronized DettagliOrariEvDAO getInstance() {
		if(instance==null)
			instance=new DettagliOrariEvDAO();
		return instance;
	}
public static ArrayList<DettagliOrariEv> elencoorario(String evento) {
		
		
        ArrayList<DettagliOrariEv> dati= new ArrayList<DettagliOrariEv>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select gestioneturnoevento.giornosettimana,gestioneturnoevento.fasciaoraria,gestioneturnoevento.spazio,gestioneturnoevento.prenotazionidisponibili from gestioneturnoevento inner join evento on gestioneturnoevento.evento=evento.codiceevento where evento.nomeevento='"+evento+"' ;");
        Iterator<String[]> i = res.iterator();
        
        while (i.hasNext()) {
        	String[] riga = i.next();
        	
        	DettagliOrariEv d= new DettagliOrariEv(); 	
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