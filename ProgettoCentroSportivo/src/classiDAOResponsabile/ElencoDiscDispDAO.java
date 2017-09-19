package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;





import Model_Responsabile.ElencoLivDis;
import DBInterfaccia.DbConnection;

public class ElencoDiscDispDAO {

	private static ElencoDiscDispDAO instance;
	
	public static synchronized ElencoDiscDispDAO getInstance() {
		if(instance==null)
			instance=new ElencoDiscDispDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoLivDis> elencodiscdisp() {
		
		
        ArrayList<ElencoLivDis> dati= new ArrayList<ElencoLivDis>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT disciplina,livello,costomensile,combinazionelivdis FROM disciplinedisponibili ;");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoLivDis d=new ElencoLivDis(); 	
        	d.setDisciplina(riga[0]);
        	d.setLivello(riga[1]);
        	d.setCostomensile(Float.parseFloat(riga[2]));
        	d.setCodicecomb(Integer.parseInt(riga[3]));
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}