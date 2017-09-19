package ClassiDaoTesserato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;






import Model_Istruttore.ElencoLivDis;
import DBInterfaccia.DbConnection;

public class ElencoLivDisTesDAO {

	private static ElencoLivDisTesDAO instance;
	
	public static synchronized ElencoLivDisTesDAO getInstance() {
		if(instance==null)
			instance=new ElencoLivDisTesDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoLivDis> elencoiniziale(int tes) {
		
		
        ArrayList<ElencoLivDis> dati= new ArrayList<ElencoLivDis>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select disciplina,livello from disciplinedisponibili inner join detiscr on detiscr.combinazionelivdis=disciplinedisponibili.combinazionelivdis inner join iscrizionedisciplina on detiscr.idiscrizione=iscrizionedisciplina.codiceiscrizionedisciplina where detiscr.confermato=1 and iscrizionedisciplina.confermato=1 and iscrizionedisciplina.tesserato='"+tes+"' ;");
        
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