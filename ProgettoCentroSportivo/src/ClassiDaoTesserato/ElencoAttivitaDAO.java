package ClassiDaoTesserato;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import DBInterfaccia.DbConnection;
import Model_Tesserato.ElencoAttivita;
public class ElencoAttivitaDAO {
	
private static ElencoAttivitaDAO instance;
	
	public static synchronized ElencoAttivitaDAO getInstance() {
		if(instance==null)
			instance=new ElencoAttivitaDAO();
		return instance;
	}
public static ArrayList<ElencoAttivita> elencoiniziale() {
		
		
        ArrayList<ElencoAttivita> dati= new ArrayList<ElencoAttivita>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT distinct Livello,Disciplina,CostoMensile from disciplinedisponibili,gestioneturno where disciplinedisponibili.combinazionelivdis=gestioneturno.combinazionelivdis ;");
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
