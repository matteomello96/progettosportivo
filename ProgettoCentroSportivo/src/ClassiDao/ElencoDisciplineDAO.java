package ClassiDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Model.DisciplinaElenco;
import DBInterfaccia.DbConnection;

public class ElencoDisciplineDAO {

	private static ElencoDisciplineDAO instance;
	
	public static synchronized ElencoDisciplineDAO getInstance() {
		if(instance==null)
			instance=new ElencoDisciplineDAO();
		return instance;
	}
	
	
	public static ArrayList<DisciplinaElenco> elencoiniziale() {
		
		
        ArrayList<DisciplinaElenco> dati= new ArrayList<DisciplinaElenco>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT  C.NomeDisciplina,B.NomeLivello,A.MaxIscrittiTurno,A.CostoMensile,C.Descrizione,C.Calendario from disciplinedisponibili as A INNER JOIN livello as B ON A.Livello=B.NomeLivello INNER JOIN disciplina as C ON A.Disciplina=C.NomeDisciplina INNER JOIN calendario as D ON D.nomecalendario=C.Calendario; ");
        Vector<InputStream[]> res2 = DbConnection.getInstance().eseguiImmagine("SELECT  C.Immagine from disciplinedisponibili as A INNER JOIN livello as B ON A.Livello=B.NomeLivello INNER JOIN disciplina as C ON A.Disciplina=C.NomeDisciplina INNER JOIN calendario as D ON D.nomecalendario=C.Calendario;");
        Iterator<String[]> i = res.iterator();
        Iterator<InputStream[]> i2 = res2.iterator();
        while((i.hasNext()) && (i2.hasNext())) {
        	String[] riga = i.next();
        	InputStream[] riga2 = i2.next();
        	DisciplinaElenco d=new DisciplinaElenco(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setNomeLivello(riga[1]);
        	d.setMaxIscrittiTurno(Integer.parseInt(riga[2]));
        	d.setCostoMensile(Float.parseFloat(riga[3]));
        	d.setDescrizione(riga[4]);
        	d.setCalendario(riga[5]);

			try {
        	// inputstream -> path dell'img sul pc
        	File f;
				f = File.createTempFile("mioprefisso", ".tmp");
			
        	
        	OutputStream out=new FileOutputStream(f);
        	byte[] buffer = new byte[80*1024];
        	int bytesRead;
        	while((bytesRead=riga2[0].read(buffer))!=-1)
        		out.write(buffer, 0, bytesRead);
        	out.close();
        d.setImmaginePath(f.getAbsolutePath());
        f.deleteOnExit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
        	//..
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}