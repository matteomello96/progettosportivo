package ClassiDaoTesserato;

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

public class ElencoeventidaoTess {

	private static ElencoeventidaoTess instance;
	
	public static synchronized ElencoeventidaoTess getInstance() {
		if(instance==null)
			instance=new ElencoeventidaoTess();
		return instance;
	}
	
	
	public static ArrayList<elencoeventi> elencoevenconf(int tes) {
		
		
        ArrayList<elencoeventi> dati= new ArrayList<elencoeventi>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select I.codiceiscrizioneevento,I.tesserato,I.evento,I.tipoevento,I.costotot,I.modalitapagamento,I.certificatomed,I.confermato,I.annullato,I.modificato,B.giornosettimana,B.fasciaoraria,B.spazio from iscrizioneevento as I inner join gestioneturnoevento as B on I.evento=B.evento where I.confermato=1 and I.modificato=0 and I.annullato=0 and tesserato='"+tes+"';");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	elencoeventi d=new elencoeventi(); 	
        	d.setCodiceiscrizioneevento(Integer.parseInt(riga[0]));
        	d.setTesserato(Integer.parseInt(riga[1]));
        	d.setEvento(Integer.parseInt(riga[2]));
        	d.setTipoevento(riga[3]);
        	d.setCostotot(Integer.parseInt(riga[4]));
        	d.setModalitapagamento(riga[5]);
        	d.setCertificatomed(riga[6]);
        	d.setConfermato(Integer.parseInt(riga[7]));
        	d.setAnnullato(Integer.parseInt(riga[8]));
        	d.setModificato(Integer.parseInt(riga[9]));
        	d.setGiorno(riga[10]);
          	d.setFasciaoraria(riga[11]);
          	d.setSpazio(riga[12]);
    
        	
          
           
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
	
public static ArrayList<elencoeventi> elencoevendaconf(int tes) {
		
		
        ArrayList<elencoeventi> dati= new ArrayList<elencoeventi>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select I.codiceiscrizioneevento,I.tesserato,I.evento,I.tipoevento,I.costotot,I.modalitapagamento,I.certificatomed,I.confermato,I.annullato,I.modificato,B.giornosettimana,B.fasciaoraria,B.spazio from iscrizioneevento as I inner join gestioneturnoevento as B on I.evento=B.evento where I.confermato=0 and I.modificato=0 and I.annullato=0 and tesserato='"+tes+"';");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	elencoeventi d=new elencoeventi(); 	
        	d.setCodiceiscrizioneevento(Integer.parseInt(riga[0]));
        	d.setTesserato(Integer.parseInt(riga[1]));
        	d.setEvento(Integer.parseInt(riga[2]));
        	d.setTipoevento(riga[3]);
        	d.setCostotot(Integer.parseInt(riga[4]));
        	d.setModalitapagamento(riga[5]);
        	d.setCertificatomed(riga[6]);
        	d.setConfermato(Integer.parseInt(riga[7]));
        	d.setAnnullato(Integer.parseInt(riga[8]));
        	d.setModificato(Integer.parseInt(riga[9]));
        	d.setGiorno(riga[10]);
          	d.setFasciaoraria(riga[11]);
          	d.setSpazio(riga[12]);
    
        	
          
           
        	
        	
        	dati.add(d);
        }
        return dati;
	}

public static ArrayList<elencoeventi> elencoevenmod(int tes) {
	
	
    ArrayList<elencoeventi> dati= new ArrayList<elencoeventi>(); 
    
    Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select I.codiceiscrizioneevento,I.tesserato,I.evento,I.tipoevento,I.costotot,I.modalitapagamento,I.certificatomed,I.confermato,I.annullato,I.modificato,B.giornosettimana,B.fasciaoraria,B.spazio from iscrizioneevento as I inner join gestioneturnoevento as B on I.evento=B.evento where I.confermato=0 and I.modificato=1 and I.annullato=0 and tesserato='"+tes+"';");
    
    Iterator<String[]> i = res.iterator();
   
    while(i.hasNext()) {
    	String[] riga = i.next();
    	
    	elencoeventi d=new elencoeventi(); 	
    	d.setCodiceiscrizioneevento(Integer.parseInt(riga[0]));
    	d.setTesserato(Integer.parseInt(riga[1]));
    	d.setEvento(Integer.parseInt(riga[2]));
    	d.setTipoevento(riga[3]);
    	d.setCostotot(Integer.parseInt(riga[4]));
    	d.setModalitapagamento(riga[5]);
    	d.setCertificatomed(riga[6]);
    	d.setConfermato(Integer.parseInt(riga[7]));
    	d.setAnnullato(Integer.parseInt(riga[8]));
    	d.setModificato(Integer.parseInt(riga[9]));
    	d.setGiorno(riga[10]);
      	d.setFasciaoraria(riga[11]);
      	d.setSpazio(riga[12]);

    	
      
       
    	
    	
    	dati.add(d);
    }
    return dati;
}


	
	
	
	
}