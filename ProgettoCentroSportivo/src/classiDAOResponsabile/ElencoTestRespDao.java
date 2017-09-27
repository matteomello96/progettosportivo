package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


import DBInterfaccia.DbConnection;

import Model_Responsabile.ElencoTestResp;

public class ElencoTestRespDao {
private static ElencoTestRespDao instance;
	
	public static synchronized ElencoTestRespDao getInstance() {
		if(instance==null)
			instance=new ElencoTestRespDao();
		return instance;
	}
	
	
public static ArrayList<ElencoTestResp> elencotest() {
		
		
        ArrayList<ElencoTestResp> dati= new ArrayList<ElencoTestResp>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select testimonianza.commento,testimonianza.dataazione,elencoutenti.nome,elencoutenti.cognome from testimonianza inner join tesserato on testimonianza.tesserato=tesserato.matricolatesserato inner join elencoutenti on elencoutenti.idutente=tesserato.idutente");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoTestResp d=new ElencoTestResp(); 	
        	d.setCommento(riga[0]);
        	d.setDataAzione(riga[1]);
        	d.setNomeTes(riga[2]);
        	d.setCognomeTes(riga[3]);
        	

        	
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}

}
