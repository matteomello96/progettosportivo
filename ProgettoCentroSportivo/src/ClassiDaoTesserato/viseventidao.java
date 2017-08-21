package ClassiDaoTesserato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import Model_Tesserato.elencoiscrizioniattivita;

public class viseventidao {
	
	
private static viseventidao instance;
	
	public static synchronized viseventidao getInstance() {
		if(instance==null)
			instance=new viseventidao();
		return instance;
	}
	
	
	
public static ArrayList<elencoiscrizioniattivita> elencoiniziale() {
		
		
        ArrayList<elencoiscrizioniattivita> dati= new ArrayList<elencoiscrizioniattivita>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery(" select modalitapagamento,costotot,nomeevento from evento,iscrizioneevento where tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and confermato=1 and evento.codiceevento=iscrizioneevento.evento;");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	elencoiscrizioniattivita d=new elencoiscrizioniattivita(); 	
        	d.setModalitapagamento(riga[0]);
        	d.setCostotot(Integer.parseInt(riga[1]));
        	d.setNomeevento(riga[2]);
        	

  
        	
        	dati.add(d);
        }
        return dati;
	}

}
