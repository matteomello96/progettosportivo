package ClassiDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model.DettagliOrari;

public class DettagliOrariDAO {

	 
	private static DettagliOrariDAO instance;
	
	public static synchronized DettagliOrariDAO getInstance() {
		if(instance==null)
			instance=new DettagliOrariDAO();
		return instance;
	}
public static ArrayList<DettagliOrari> elencoorario(String disciplina) {
		
		
        ArrayList<DettagliOrari> dati= new ArrayList<DettagliOrari>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select disciplinedisponibili.livello,gestioneturno.giornosettimana,gestioneturno.fasciaoraria,gestioneturno.spazio,gestioneturno.prenotazionidisponibili from gestioneturno inner join disciplinedisponibili on disciplinedisponibili.Combinazionelivdis=gestioneturno.Combinazionelivdis where disciplinedisponibili.disciplina='"+disciplina+"' ;");
        Iterator<String[]> i = res.iterator();
        
        while (i.hasNext()) {
        	String[] riga = i.next();
        	
        	DettagliOrari d= new DettagliOrari(); 	
        	d.setLivello(riga[0]);
        	d.setGiornoSettimana(riga[1]);
        	d.setFasciaOraria(riga[2]);
        	d.setSpazio(riga[3]);
        	d.setPrenotazioniDisp(Integer.parseInt(riga[4]));
       
        	//..
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
}