package ClassiDAOIstruttore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoAtt;
import Model_Istruttore.ElencoEventi;
import DBInterfaccia.DbConnection;

public class ElencoAttDAO {

	private static ElencoAttDAO instance;
	
	public static synchronized ElencoAttDAO getInstance() {
		if(instance==null)
			instance=new ElencoAttDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoAtt> elencoiniziale(int matricola) {
		
		
        ArrayList<ElencoAtt> dati= new ArrayList<ElencoAtt>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct disciplinedisponibili.disciplina,disciplinedisponibili.livello from disciplinedisponibili inner join gestioneturno on gestioneturno.combinazionelivdis=disciplinedisponibili.combinazionelivdis inner join istruttoridisponibiliperdisciplina on istruttoridisponibiliperdisciplina.combinazionelivdis=disciplinedisponibili.combinazionelivdis inner join istruttore on istruttore.matricolaistruttore=istruttoridisponibiliperdisciplina.istruttore where istruttoridisponibiliperdisciplina.istruttore='"+matricola+"'");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoAtt d=new ElencoAtt(); 	
        	d.setDisciplina(riga[0]);
        	d.setLivello(riga[1]);
        	

        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}