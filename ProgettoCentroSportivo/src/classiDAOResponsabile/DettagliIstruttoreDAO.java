package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model_Responsabile.DettagliIstruttore;
public class DettagliIstruttoreDAO {
private static DettagliIstruttoreDAO instance;

public static synchronized DettagliIstruttoreDAO getInstance() {
	if(instance==null)
		instance=new DettagliIstruttoreDAO();
	return instance;
}
public static ArrayList<DettagliIstruttore> elencoistruttore(){
	 ArrayList<DettagliIstruttore> dati= new ArrayList<DettagliIstruttore>();
	
	 Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct elencoutenti.nome,elencoutenti.cognome from elencoutenti where elencoutenti.tipoutente='I' ;");
       
       Iterator<String[]> i = res.iterator();
       while (i.hasNext())  {
       	String[] riga = i.next();
           DettagliIstruttore d= new DettagliIstruttore(); 	
       	d.setNomeIstruttore(riga[0]);
       	d.setCognomeIstruttore(riga[1]);
       	
       	
       	dati.add(d);
       }
       return dati;
       }
}