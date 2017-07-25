package ClassiDaoTesserato;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import DBInterfaccia.DbConnection;
import Model.ElencoAttivita;
public class ElencoAttivitaDAO {
	
private static ElencoAttivitaDAO instance;
	
	public static synchronized ElencoAttivitaDAO getInstance() {
		if(instance==null)
			instance=new ElencoAttivitaDAO();
		return instance;
	}
public static ArrayList<ElencoAttivita> elencoiniziale() {
		
		
        ArrayList<ElencoAttivita> dati= new ArrayList<ElencoAttivita>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT  C.NomeDisciplina,B.NomeLivello,A.CostoMensile from disciplinedisponibili as A INNER JOIN livello as B ON A.Livello=B.NomeLivello INNER JOIN disciplina as C ON A.Disciplina=C.NomeDisciplina ;");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoAttivita d=new ElencoAttivita(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setNomeLivello(riga[1]);
        	d.setCostoMensile(Integer.parseInt(riga[2]));
        	

        	
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}

}
