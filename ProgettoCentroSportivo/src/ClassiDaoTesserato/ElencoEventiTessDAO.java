package ClassiDaoTesserato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;




import Model_Tesserato.ElencoEventiTes;
import DBInterfaccia.DbConnection;

public class ElencoEventiTessDAO {

	private static ElencoEventiTessDAO instance;
	
	public static synchronized ElencoEventiTessDAO getInstance() {
		if(instance==null)
			instance=new ElencoEventiTessDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoEventiTes> elencoiniziale() {
		
		
        ArrayList<ElencoEventiTes> dati= new ArrayList<ElencoEventiTes>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct evento.nomeevento,evento.descrizione,evento.Tipoevento,elencoutenti.nome,elencoutenti.cognome,disciplinedisponibili.disciplina,disciplinedisponibili.livello from evento inner join disciplinedisponibili on evento.combinazionelivdis=disciplinedisponibili.combinazionelivdis inner join istruttoridisponibiliperdisciplina on evento.Istruttoredisp=istruttoridisponibiliperdisciplina.istruttore inner join istruttore on istruttore.Matricolaistruttore=istruttoridisponibiliperdisciplina.istruttore inner join elencoutenti on istruttore.idutente=elencoutenti.idutente");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoEventiTes d=new ElencoEventiTes(); 	
        	d.setNomeEvento(riga[0]);
        	d.setDescrizione(riga[1]);
        	d.setTipoEvento(riga[2]);
        	d.setNomeIstruttore(riga[3]);
        	d.setCognomeIstruttore(riga[4]);
            d.setDisciplina(riga[5]);
            d.setLivello(riga[6]);
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}