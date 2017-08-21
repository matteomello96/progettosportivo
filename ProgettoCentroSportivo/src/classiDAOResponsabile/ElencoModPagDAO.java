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
import Model_Responsabile.ElencoDisc;
import Model_Responsabile.ElencoLiv;
import Model_Responsabile.ElencoModP;
import DBInterfaccia.DbConnection;

public class ElencoModPagDAO {

	private static ElencoModPagDAO instance;
	
	public static synchronized ElencoModPagDAO getInstance() {
		if(instance==null)
			instance=new ElencoModPagDAO();
		return instance;
	}
	
	
	public static ArrayList<ElencoModP> elencomodp() {
		
		
        ArrayList<ElencoModP> dati= new ArrayList<ElencoModP>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select modalitapagamento.Nomemodalita  from modalitapagamento");
        
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext()) {
        	String[] riga = i.next();
        	
        	ElencoModP d=new ElencoModP(); 	
        	d.setModPag(riga[0]);
        	
        
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}