package ClassiDaoTesserato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import ClassiDao.GetInfoDB;
import Model_Tesserato.ElencoEventiTes;
import Model_Tesserato.ElencoGiornoOra;
import DBInterfaccia.DbConnection;

public class ElencoGiornoOraDAO {

	private static ElencoGiornoOraDAO instance;
	
	public static synchronized ElencoGiornoOraDAO getInstance() {
		if(instance==null)
			instance=new ElencoGiornoOraDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoGiornoOra> elencoiniziale(String disciplina,String livello) {
		
		
        ArrayList<ElencoGiornoOra> dati= new ArrayList<ElencoGiornoOra>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct giornosettimana,fasciaoraria from gestioneturno where combinazionelivdis="+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"");
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoGiornoOra d=new ElencoGiornoOra(); 	
        	d.setGiorno(riga[0]);
        	d.setOra(riga[1]);
        	
        	dati.add(d);
        }
        return dati;
	}
	
}