package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;





import Model_Responsabile.ElencoLivDisDisp;
import DBInterfaccia.DbConnection;

public class ElencoDiscLivDispDAO {

	private static ElencoDiscLivDispDAO instance;
	
	public static synchronized ElencoDiscLivDispDAO getInstance() {
		if(instance==null)
			instance=new ElencoDiscLivDispDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoLivDisDisp> elencoiniziale() {
		
		
        ArrayList<ElencoLivDisDisp> dati= new ArrayList<ElencoLivDisDisp>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct disciplinedisponibili.disciplina,disciplinedisponibili.livello from disciplinedisponibili ");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoLivDisDisp d=new ElencoLivDisDisp(); 	
        	d.setDisciplina(riga[0]);
        	d.setLivello(riga[1]);
        	

        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}