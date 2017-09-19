package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;






import Model_Responsabile.ElencoIstr;

import DBInterfaccia.DbConnection;

public class ElencoIstrDAO {

	private static ElencoIstrDAO instance;
	
	public static synchronized ElencoIstrDAO getInstance() {
		if(instance==null)
			instance=new ElencoIstrDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoIstr> elencoistr() {
		
		
        ArrayList<ElencoIstr> dati= new ArrayList<ElencoIstr>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT DISTINCT elencoutenti.nome,elencoutenti.cognome,istruttore.matricolaistruttore from elencoutenti inner join istruttore on istruttore.idutente=elencoutenti.idutente ");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoIstr d=new ElencoIstr(); 	
        	d.setNomeIstruttore(riga[0]);
        	d.setCognomeIstruttore(riga[1]);
        	d.setMatricolaistruttore(Integer.parseInt(riga[2]));
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}