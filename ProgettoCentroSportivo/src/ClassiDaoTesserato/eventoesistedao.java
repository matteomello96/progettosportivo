package ClassiDaoTesserato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model_Tesserato.ElencoEventiTes;

public class eventoesistedao {
	
	
private static eventoesistedao instance;
	
	public static synchronized eventoesistedao getInstance() {
		if(instance==null)
			instance=new eventoesistedao();
		return instance;
	}
	
	
public static ArrayList<ElencoEventiTes> elencoiniziale() {
		
		
        ArrayList<ElencoEventiTes> dati= new ArrayList<ElencoEventiTes>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select evento,tesserato from iscrizioneevento;");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoEventiTes d=new ElencoEventiTes(); 	
        	d.setCodiceevento(Integer.parseInt(riga[0]));
        	d.setTesserato(Integer.parseInt(riga[1]));
        	
        
        	

        	
       	dati.add(d);
        }
        return dati;
	}

}
