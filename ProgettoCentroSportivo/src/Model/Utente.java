package Model;

import ClassiDao.*;


public class Utente {

	private static String username;
	private String password;
	
	public Utente() {
		super();
	}

	@SuppressWarnings("static-access")
	public Utente(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Utente.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login()
	{
		return UtenteDao.getInstance().userExists(this);
	}
	
}
