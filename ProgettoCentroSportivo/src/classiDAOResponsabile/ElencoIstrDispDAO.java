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
import Model_Istruttore.ElencoEventi;
import Model_Istruttore.ElencoLivDis;
import Model_Responsabile.ElencoIstrDisp;
import DBInterfaccia.DbConnection;

public class ElencoIstrDispDAO {

	private static ElencoIstrDispDAO instance;
	
	public static synchronized ElencoIstrDispDAO getInstance() {
		if(instance==null)
			instance=new ElencoIstrDispDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoIstrDisp> elencoistrdisp() {
		
		
        ArrayList<ElencoIstrDisp> dati= new ArrayList<ElencoIstrDisp>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct istruttore,combinazionelivdis from istruttoridisponibiliperdisciplina;");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoIstrDisp d=new ElencoIstrDisp(); 	
        	d.setMatricolaistr(Integer.parseInt(riga[0]));
        	d.setCodicecomblivdis(Integer.parseInt(riga[1]));
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}