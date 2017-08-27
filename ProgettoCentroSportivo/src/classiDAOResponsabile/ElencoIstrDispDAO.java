package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoEventi;
import Model_Istruttore.ElencoLivDis;
import Model_Responsabile.ElencoIstrDisp;
import DBInterfaccia.DbConnection;

public class ElencoIstrDispDAO {

	private static ElencoIstrDispDAO instance;
	
	public static synchronized ElencoIstrDispDAO getInstance() {
		if(instance==null)
			instance=new ElencoIstrDispDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoIstrDisp> elencoistrdisp() {
		
		
        ArrayList<ElencoIstrDisp> dati= new ArrayList<ElencoIstrDisp>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct elencoutenti.nome,elencoutenti.cognome,disciplinedisponibili.disciplina,disciplinedisponibili.livello from elencoutenti inner join istruttore on istruttore.idutente=elencoutenti.idutente inner join istruttoridisponibiliperdisciplina on istruttoridisponibiliperdisciplina.istruttore =istruttore.matricolaistruttore inner join disciplinedisponibili on disciplinedisponibili.combinazionelivdis=istruttoridisponibiliperdisciplina.combinazionelivdis;");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoIstrDisp d=new ElencoIstrDisp(); 	
        	d.setNomeistr(riga[0]);
        	d.setCognomeistr(riga[1]);
        	d.setDisciplina(riga[2]);
        	d.setLivello(riga[3]);
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}