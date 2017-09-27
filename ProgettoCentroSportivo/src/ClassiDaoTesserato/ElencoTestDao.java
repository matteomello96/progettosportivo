package ClassiDaoTesserato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;
import Model_Tesserato.ElenoTest;

public class ElencoTestDao {
private static ElencoTestDao instance;
	
	public static synchronized ElencoTestDao getInstance() {
		if(instance==null)
			instance=new ElencoTestDao();
		return instance;
	}
	
	
public static ArrayList<ElenoTest> elencoiniziale() {
		
		
        ArrayList<ElenoTest> dati= new ArrayList<ElenoTest>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select Disciplina,Livello,Commento from disciplinedisponibili,testimonianza where tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and disciplinedisponibili.combinazionelivdis=testimonianza.combinazionelivdis");
        Iterator<String[]> i = res.iterator();
        while(i.hasNext())  {
        	String[] riga = i.next();
        	ElenoTest d=new ElenoTest(); 	
        	d.setDisciplina(riga[0]);
        	d.setLivello(riga[1]);
        	d.setCommento(riga[2]);
        	

        	
       
             	
        	
        	
        	dati.add(d);
        }
        return dati;
	}

}
