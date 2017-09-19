package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;






import Model_Responsabile.ElencoLiv;
import DBInterfaccia.DbConnection;

public class ElencoLivDAO {

	private static ElencoLivDAO instance;
	
	public static synchronized ElencoLivDAO getInstance() {
		if(instance==null)
			instance=new ElencoLivDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoLiv> elencoliv() {
		
		
        ArrayList<ElencoLiv> dati= new ArrayList<ElencoLiv>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT nomelivello FROM livello ;");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoLiv d=new ElencoLiv(); 	
        	d.setLivello(riga[0]);
        	
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}