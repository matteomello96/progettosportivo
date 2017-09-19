package ClassiDAOIstruttore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;





import Model_Istruttore.ElencoLivDis;
import DBInterfaccia.DbConnection;

public class ElencoLivDisDAO {

	private static ElencoLivDisDAO instance;
	
	public static synchronized ElencoLivDisDAO getInstance() {
		if(instance==null)
			instance=new ElencoLivDisDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoLivDis> elencoiniziale(int matricola) {
		
		
        ArrayList<ElencoLivDis> dati= new ArrayList<ElencoLivDis>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT disciplina,livello FROM disciplinedisponibili inner join istruttoridisponibiliperdisciplina on disciplinedisponibili.combinazionelivdis=istruttoridisponibiliperdisciplina.combinazionelivdis where istruttoridisponibiliperdisciplina.istruttore='"+matricola+"' ;");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoLivDis d=new ElencoLivDis(); 	
        	d.setDisciplina(riga[0]);
        	d.setLivello(riga[1]);
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}