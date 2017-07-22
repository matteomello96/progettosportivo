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
import Model.ElencoUtenti;
import DBInterfaccia.DbConnection;

public class ElencoUtentiDAO {

	private static ElencoUtentiDAO instance;
	
	public static synchronized ElencoUtentiDAO getInstance() {
		if(instance==null)
			instance=new ElencoUtentiDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoUtenti> elencoiniziale() {
		
		
        ArrayList<ElencoUtenti> dati= new ArrayList<ElencoUtenti >(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT  elencoutenti.idutente,elencoutenti.nome,elencoutenti.cognome,elencoutenti.codicefiscale,elencoutenti.citta,elencoutenti.via,elencoutenti.numerocivico,elencoutenti.telefono,elencoutenti.mail,elencoutenti.username,elencoutenti.password,elencoutenti.attivita,elencoutenti.connessione,elencoutenti.tipoutente from elencoutenti ; ");
       
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext())  {
        	String[] riga = i.next();
        	
        	ElencoUtenti e=new ElencoUtenti(); 	
        	e.setIdutente(Integer.parseInt(riga[0]));
        	e.setNome(riga[1]);
        	e.setCognome(riga[2]);
        	e.setCodicefiscale(riga[3]); 
        	e.setCitta(riga[4]);
        	e.setVia(riga[5]);
        	e.setNumciv(Integer.parseInt(riga[6]));
        	e.setTelefono(riga[7]);
        	e.setEmail(riga[8]);
        	e.setUsername(riga[9]);
        	e.setPassword(riga[10]);
        	e.setAttivita(Integer.parseInt(riga[11]));
        	e.setConnessione(Integer.parseInt(riga[12]));
            e.setTipoUtente(riga[13]);
			
			
       
        	//..
        	
        	
        	
        	dati.add(e);
        }
        return dati;
	}
	
}