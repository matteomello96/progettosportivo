package ClassiDAOIstruttore;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import DBInterfaccia.DbConnection;
import Model_Istruttore.ElencoPartecipanti;

public class ElencoPartecipantiEvDAO {
	
private static ElencoPartecipantiEvDAO instance;
	
	public static synchronized ElencoPartecipantiEvDAO getInstance() {
		if(instance==null)
			instance=new ElencoPartecipantiEvDAO();
		return instance;
	}
public static ArrayList<ElencoPartecipanti> elencoiniziale(int codiceturno) {
		
		
        ArrayList<ElencoPartecipanti> dati= new ArrayList<ElencoPartecipanti>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT distinct elencoutenti.nome,elencoutenti.cognome from elencoutenti inner join tesserato on tesserato.idutente=elencoutenti.idutente inner join iscrizioniperturnoevento on iscrizioniperturnoevento.tesserato=tesserato.matricolatesserato where iscrizioniperturnoevento.codiceturnoevento ='"+codiceturno+"'");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoPartecipanti d=new ElencoPartecipanti(); 	
        	d.setNomeTes(riga[0]);
        	d.setCognomeTes(riga[1]);
        	
        	

        	
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}

}
