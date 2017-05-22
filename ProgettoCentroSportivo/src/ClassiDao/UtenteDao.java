package ClassiDao;

import java.util.Vector;



import DBInterfaccia.DbConnection;
import Model.Utente;


public class UtenteDao {
private static UtenteDao instance;
	
	
	public static UtenteDao getInstance()
	{
		if(instance==null)
		{	
			instance = new UtenteDao();
		}
		return instance;
	}
	
	@SuppressWarnings("static-access")
	public boolean userExists(Utente utente)
	{
		String username = utente.getUsername();
		String password = utente.getPassword();
		
		
		//SINGLETON
		
		
		Vector<String[]> result = new Vector<String[]>();
		try{
		
		
		result=DbConnection.getInstance().eseguiQuery("SELECT * FROM elencoutenti WHERE username='"+ username +"' and Password='"+password+"'");
		//String[] stringhe;
		
		if(result.isEmpty())
		{
		return (false);
		}
		
		else return (true);
		}
		catch(Exception e)
		{
			return false;
		}
		}
}
