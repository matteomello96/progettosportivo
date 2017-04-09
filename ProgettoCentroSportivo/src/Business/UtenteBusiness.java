package Business;

import Model.Utente;

public class UtenteBusiness {
private static UtenteBusiness instance;
	
	//SINGLETON
	public static UtenteBusiness getInstance()
	{
		if(instance == null)
			instance = new UtenteBusiness();
		return instance;
	}
	
	public boolean verificaLogin(String username, String password)
	{
		Utente u=new Utente(username, password);
		return u.login();
	}
}
