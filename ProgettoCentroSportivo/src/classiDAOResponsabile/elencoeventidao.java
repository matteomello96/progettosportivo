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
import Model_Responsabile.ElencoLivDis;
import Model_Responsabile.elencoeventi;
import DBInterfaccia.DbConnection;

public class elencoeventidao {

	private static elencoeventidao instance;
	
	public static synchronized elencoeventidao getInstance() {
		if(instance==null)
			instance=new elencoeventidao();
		return instance;
	}
	
	
	public static ArrayList<elencoeventi> elencoeven() {
		
		
        ArrayList<elencoeventi> dati= new ArrayList<elencoeventi>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select codiceiscrizioneevento,nome,cognome,NomeEvento,modalitapagamento,costotot,confermato,annullato from iscrizioneevento,evento,elencoutenti,tesserato where iscrizioneevento.evento=evento.CodiceEvento and tesserato.Matricolatesserato=iscrizioneevento.tesserato and tesserato.idutente=elencoutenti.idutente;");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	elencoeventi d=new elencoeventi(); 	
        	d.setCodiceiscrizioneevento(riga[0]);
        	d.setNome(riga[1]);
          	d.setCognome(riga[2]);
          	d.setNomeevento(riga[3]);
          	d.setModalitapagamento(riga[4]);
        	d.setCostotot(Integer.parseInt(riga[5]));
        	d.setConfermato(Integer.parseInt(riga[6]));
        	d.setAnnullato(Integer.parseInt(riga[7]));
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}