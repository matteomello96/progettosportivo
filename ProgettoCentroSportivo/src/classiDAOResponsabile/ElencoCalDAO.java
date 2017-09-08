package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import Model_Responsabile.ElencoCal;

import DBInterfaccia.DbConnection;

public class ElencoCalDAO {

	private static ElencoCalDAO instance;
	
	public static synchronized ElencoCalDAO getInstance() {
		if(instance==null)
			instance=new ElencoCalDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoCal> elencocal() {
		
		
        ArrayList<ElencoCal> dati= new ArrayList<ElencoCal>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT nomecalendario FROM calendario ;");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoCal d=new ElencoCal(); 	
        	d.setCalendario(riga[0]);
        	
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}