package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;





import Model_Responsabile.ElencoModP;
import DBInterfaccia.DbConnection;

public class ElencoModPagDAO {

	private static ElencoModPagDAO instance;
	
	public static synchronized ElencoModPagDAO getInstance() {
		if(instance==null)
			instance=new ElencoModPagDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoModP> elencomodp() {
		
		
        ArrayList<ElencoModP> dati= new ArrayList<ElencoModP>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select modalitapagamento.Nomemodalita  from modalitapagamento");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoModP d=new ElencoModP(); 	
        	d.setModPag(riga[0]);
        	
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}