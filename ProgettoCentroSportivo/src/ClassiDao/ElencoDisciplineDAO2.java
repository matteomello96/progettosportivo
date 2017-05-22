package ClassiDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;





import Model.DisciplinaElenco2;
import DBInterfaccia.DbConnection;

public class ElencoDisciplineDAO2 {

	private static ElencoDisciplineDAO2 instance;
	
	public static synchronized ElencoDisciplineDAO2 getInstance() {
		if(instance==null)
			instance=new ElencoDisciplineDAO2();
		return instance;
	}
	
	
	public static ArrayList<DisciplinaElenco2> elencoiniziale() {
		
		
        ArrayList<DisciplinaElenco2> dati= new ArrayList<DisciplinaElenco2>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT DISTINCT C.NomeDisciplina,B.NomeLivello,A.MaxIscrittiTurno,A.CostoMensile,C.Descrizione,C.Calendario from disciplinedisponibili as A INNER JOIN livello as B ON A.Livello=B.NomeLivello INNER JOIN disciplina as C ON A.Disciplina=C.NomeDisciplina INNER JOIN calendario as D ON D.nomecalendario=C.Calendario ");
       
        Iterator<String[]> i = res.iterator();
       
        while((i.hasNext())) {
        	String[] riga = i.next();
        	
        	DisciplinaElenco2 d=new DisciplinaElenco2(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setNomeLivello(riga[1]);
        	d.setMaxIscrittiTurno(Integer.parseInt(riga[2]));
        	d.setCostoMensile(Float.parseFloat(riga[3]));
        	d.setDescrizione(riga[4]);
        	d.setCalendario(riga[5]);
       
        	//..
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}