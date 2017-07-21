package ClassiDaoTesserato;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model.DisciplinaElenco;
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
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT DISTINCT C.NomeDisciplina,B.NomeLivello,A.MaxIscrittiTurno,A.CostoMensile from disciplinedisponibili as A INNER JOIN livello as B ON A.Livello=B.NomeLivello INNER JOIN disciplina as C ON A.Disciplina=C.NomeDisciplina INNER JOIN calendario as D ON D.nomecalendario=C.Calendario; ");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElencoAttivita d=new ElencoAttivita(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setNomeLivello(riga[1]);
        	d.setMaxIscrittiTurno(Integer.parseInt(riga[2]));
        	d.setCostoMensile(Float.parseFloat(riga[3]));
        	

		
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}

}
