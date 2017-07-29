package ClassiDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model.DettagliLivello;

public class DettagliLivelloDAO{

	 
	private static DettagliLivelloDAO instance;
	
	public static synchronized DettagliLivelloDAO getInstance() {
		if(instance==null)
			instance=new DettagliLivelloDAO();
		return instance;
	}
	
	
	public static ArrayList<DettagliLivello> elencolivelli(String disciplina){
		 ArrayList<DettagliLivello> dati= new ArrayList<DettagliLivello>();
		 Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct disciplinedisponibili.livello,disciplinedisponibili.costomensile from disciplinedisponibili inner join  istruttoridisponibiliperdisciplina on disciplinedisponibili.Combinazionelivdis=istruttoridisponibiliperdisciplina.combinazionelivdis inner join istruttore on istruttore.Matricolaistruttore = istruttoridisponibiliperdisciplina.istruttore inner join elencoutenti on istruttore.idutente = elencoutenti.idutente inner join livello on disciplinedisponibili.livello= livello.NomeLivello WHERE disciplinedisponibili.disciplina='"+disciplina+"';");
	        
	        Iterator<String[]> i = res.iterator();
	        while (i.hasNext())  {
	        	String[] riga = i.next();
	        	DettagliLivello d= new DettagliLivello(); 	
	        	d.setNomeLivello(riga[0]);
	        	d.setCostoMensile(Float.parseFloat(riga[1]));
	        	
	        	
	        	dati.add(d);
	        }
	        return dati;
	        } }
