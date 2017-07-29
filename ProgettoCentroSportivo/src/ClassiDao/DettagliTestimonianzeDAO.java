package ClassiDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model.DettagliTestimonianze;

public class DettagliTestimonianzeDAO {

	 
	private static DettagliTestimonianzeDAO instance;
	
	public static synchronized DettagliTestimonianzeDAO getInstance() {
		if(instance==null)
			instance=new DettagliTestimonianzeDAO();
		return instance;
	}
public static ArrayList<DettagliTestimonianze> elencotestimonianze(String disciplina) {
		
		
        ArrayList<DettagliTestimonianze> dati= new ArrayList<DettagliTestimonianze>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select disciplinedisponibili.livello,testimonianza.commento,testimonianza.dataazione,elencoutenti.username,elencoutenti.nome,elencoutenti.cognome from testimonianza inner join tesserato on testimonianza.tesserato=tesserato.matricolatesserato inner join elencoutenti on tesserato.idutente=elencoutenti.idutente inner join disciplinedisponibili on disciplinedisponibili.Combinazionelivdis=testimonianza.combinazionelivdis where disciplinedisponibili.disciplina ='"+disciplina+"';");
        Iterator<String[]> i = res.iterator();
        
        while (i.hasNext()) {
        	String[] riga = i.next();
        	
        	DettagliTestimonianze d= new DettagliTestimonianze(); 	
        	d.setLivello(riga[0]);
        	d.setCommento(riga[1]);
        	d.setDataAzione(riga[2]);
        	d.setUsername(riga[3]);
        	d.setNomeUtente(riga[4]);
        	d.setCognomeUtente(riga[5]);
       
        	//..
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
}