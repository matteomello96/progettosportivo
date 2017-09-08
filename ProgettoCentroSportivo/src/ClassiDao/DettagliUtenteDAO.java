package ClassiDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;
import Model.DettagliIstruttore;
import Model.Utente;
public class DettagliUtenteDAO {
private static DettagliUtenteDAO instance;

public static synchronized DettagliUtenteDAO getInstance() {
	if(instance==null)
		instance=new DettagliUtenteDAO();
	return instance;
}
public static ArrayList<Utente> elencoutente(String username){
	 ArrayList<Utente> dati= new ArrayList<Utente>();
	 Vector<String[]> res = DbConnection.getInstance().eseguiQuery("select distinct nome,cognome,codicefiscale,via,citta,numerocivico,username,password,telefono,mail from elencoutenti where elencoutenti.username='"+username+"';");
       
       Iterator<String[]> i = res.iterator();
       while (i.hasNext())  {
       	String[] riga = i.next();
           Utente d= new Utente(); 	
       	d.setNome(riga[0]);
       	d.setCognome(riga[1]);
       	d.setCodicefiscale(riga[2]);
       	d.setVia(riga[3]);
       	d.setCitta(riga[4]);
       	d.setNumcivico(riga[5]);
       	d.setUser(riga[6]);
       	d.setPass(riga[7]);
       	d.setTelefono(riga[8]);
       	d.setMail(riga[9]);
       	
       	
       	
       	dati.add(d);
       }
       return dati;
       }
}