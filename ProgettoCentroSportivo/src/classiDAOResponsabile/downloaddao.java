package classiDAOResponsabile;


import java.io.File;
import java.util.Vector;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import visteadmin.frameeventi;

public class downloaddao {
	

	public static String scarica(Object a2){
		Vector<String[]> result=new Vector<String[]>();
		result=null;
		result=DbConnection.getInstance().eseguiQuery("select certificatomed from iscrizioneevento  where codiceiscrizioneevento='"+a2+"'");
   String aw ;
   aw=result.toString();
		
	JOptionPane.showMessageDialog(frameeventi.frame, "'"+aw+"'");	
		
return aw;
	}

}
