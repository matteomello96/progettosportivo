package ClassiDao;

import java.util.Vector;

import DBInterfaccia.DbConnection;

public class TipoUtente {

	public static String getTipo(String username, String password){
		Vector<String[]> result=new Vector<String[]>();
		result=null;
		result=DbConnection.getInstance().eseguiQuery("SELECT tipoutente FROM elencoutenti where  username=\""+ username +"\" and password=\""+password+"\"");
		String[] stringhe;
		if(result!=null){
			if(!result.isEmpty()){

				stringhe=result.elementAt(0);

				if(stringhe[0].equals("T"))
					return "T";
				if(stringhe[0].equals("I"))
					return "I";
				if(stringhe[0].equals("R"))
					return "R";

				else return "";

			}

			else return "";

		}
		else return "";

	}
}
