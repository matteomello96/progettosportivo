package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model.ElencoUtenti;
import Model.ModelRichiestaIscrizione;

public class RichiesteDao {
	
	
	
private static RichiesteDao instance;
	
	public static synchronized RichiesteDao getInstance() {
		if(instance==null)
			instance=new RichiesteDao();
		return instance;
	}
	
	
	public static ArrayList<ModelRichiestaIscrizione> elencoiniziale() {
		
		
        ArrayList<ModelRichiestaIscrizione> dati= new ArrayList<ModelRichiestaIscrizione>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT ordine.idordine,ordine.matricolatesserato,ordine.prezzototale,ordine.dataconsegnaordine from ordine ; ");
       
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext())  {
        	String[] riga = i.next();
        	
        	ModelRichiestaIscrizione fa=new ModelRichiestaIscrizione(); 	
        	fa.setIdordine(Integer.parseInt(riga[0]));
        	fa.setMatricolatesserato(Integer.parseInt(riga[1]));
        	fa.setPrezzototale(Integer.parseInt(riga[2]));
        	fa.setDataconsegnaordine(riga[3]); 
        	
			
			
       
      
        	
        	
        	
        	dati.add(fa);
        }
        return dati;
	}
}
