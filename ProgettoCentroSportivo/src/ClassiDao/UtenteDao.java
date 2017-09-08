package ClassiDao;

import java.util.Vector;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import Model.Utente;
import VisteUtenteGenerico.FrameLogin;


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
		
		
			
result=DbConnection.getInstance().eseguiQuery("SELECT username,password FROM elencoutenti where  username=\""+ username +"\" and password=\""+password+"\" ");
				
		
		
		if(result.isEmpty())
		{
		return (false);
		}
		
		else return (true);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Qualcuno vuole eseguire una SQL injection...?","SQL injection",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		}
	
}		 
	