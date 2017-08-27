package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Model.DisciplinaElenco;
import Model_Istruttore.ElencoAtt;
import Model_Istruttore.ElencoEventi;
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