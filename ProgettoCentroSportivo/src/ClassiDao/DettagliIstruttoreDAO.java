package ClassiDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model.DettagliIstruttore;
public class DettagliIstruttoreDAO {
private static DettagliIstruttoreDAO instance;

public static synchronized DettagliIstruttoreDAO getInstance() {
	if(instance==null)
		instance=new DettagliIstruttoreDAO();
	return instance;
}
public static ArrayList<DettagliIstruttore> elencoistruttore(String disciplina){
	 ArrayList<DettagliIstruttore> dati= new ArrayList<DettagliIstruttore>();
	 Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct elencoutenti.nome,elencoutenti.cognome from istruttoridisponibiliperdisciplina inner join istruttore on istruttore.Matricolaistruttore=istruttoridisponibiliperdisciplina.istruttore inner join elencoutenti on istruttore.idutente=elencoutenti.idutente inner join disciplinedisponibili on disciplinedisponibili.Combinazionelivdis=istruttoridisponibiliperdisciplina.combinazionelivdis inner join livello on disciplinedisponibili.livello= livello.NomeLivello where disciplinedisponibili.disciplina='"+disciplina+"';");
       
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