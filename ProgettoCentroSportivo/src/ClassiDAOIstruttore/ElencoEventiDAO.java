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
import Model_Istruttore.ElencoEventi;
import DBInterfaccia.DbConnection;

public class ElencoEventiDAO {

	private static ElencoEventiDAO instance;
	
	public static synchronized ElencoEventiDAO getInstance() {
		if(instance==null)
			instance=new ElencoEventiDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoEventi> elencoiniziale(int matricola) {
		
		
        ArrayList<ElencoEventi> dati= new ArrayList<ElencoEventi> (); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct evento.nomeevento,evento.descrizione,evento.Tipoevento from evento inner join istruttoridisponibiliperdisciplina on evento.Istruttoredisp=istruttoridisponibiliperdisciplina.istruttore inner join istruttore on istruttore.Matricolaistruttore=istruttoridisponibiliperdisciplina.istruttore  where evento.istruttoredisp='"+matricola+"'");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoEventi d=new ElencoEventi(); 	
        	d.setNomeEvento(riga[0]);
        	d.setDescrizione(riga[1]);
        	d.setTipoEvento(riga[2]);

        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}