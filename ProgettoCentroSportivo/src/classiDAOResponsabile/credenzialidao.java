
package classiDAOResponsabile;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import visteadmin.FrameElencoUtenti;

public class credenzialidao {
	
	public static void attiva(int idutente){
		
		
		Connection con =DbConnection.db;
	
		Statement st;
		ResultSet rs;
		int conf;
		try{
		st= con.createStatement();	
	
		
		rs=st.executeQuery("select attivita from elencoutenti where idutente='"+idutente+"'");
   	 rs.next();
        conf=rs.getInt("attivita");
        
        if(conf==0){
		
		st.executeUpdate("UPDATE elencoutenti SET attivita=1 WHERE idutente='"+idutente+"'");
        JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente è stato attivato ");

        }
        else{
        	
        	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente è già stato disattivato ");
        	
        }
			
		}
		
		catch(SQLException ex){
			
			JOptionPane.showMessageDialog(FrameElencoUtenti.frame, ex);
		}
	}

	
public static void blocca(int idutente){
		
		
		Connection con =DbConnection.db;
	
		Statement st;
		ResultSet rs;
		int conf;
		try{
		st= con.createStatement();	
	
		
		rs=st.executeQuery("select bloccato from elencoutenti where idutente='"+idutente+"'");
   	 rs.next();
        conf=rs.getInt("bloccato");
        
        if(conf==0){
		
		st.executeUpdate("UPDATE elencoutenti SET bloccato=1 WHERE idutente='"+idutente+"'");
        JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente è stato bloccato ");

        }
        else{
        	
        	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente è stato già bloccato ");
        	
        }
			
		}
		
		catch(SQLException ex){
			JOptionPane.showMessageDialog(FrameElencoUtenti.frame,ex);
			
		}
	}
	
public static void sblocca(int idutente){
	
	
	Connection con =DbConnection.db;

	Statement st;
	ResultSet rs;
	int conf;
	try{
	st= con.createStatement();	

	
	rs=st.executeQuery("select bloccato from elencoutenti where idutente='"+idutente+"'");
	 rs.next();
    conf=rs.getInt("bloccato");
    
    if(conf==1){
	
	st.executeUpdate("UPDATE elencoutenti SET bloccato=0 WHERE idutente='"+idutente+"'");
    JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente è stato sbloccato ");

    }
    else{
    	
    	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente è stato già sbloccato ");
    	
    }
		
	}
	
	catch(SQLException ex){
		JOptionPane.showMessageDialog(FrameElencoUtenti.frame,ex);
		
	}
}
public static void accmod(int idutente){
	
	
	Connection con =DbConnection.db;

	Statement st;
	ResultSet rs;
	int conf;
	try{
	st= con.createStatement();	

	
	rs=st.executeQuery("select modificato from elencoutenti where idutente='"+idutente+"'");
	 rs.next();
    conf=rs.getInt("modificato");
    
    if(conf==1){
	
	st.executeUpdate("UPDATE elencoutenti SET modificato=0 WHERE idutente='"+idutente+"'");
    JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "Le modifiche sono state accettate ");

    }
    else{
    	
    	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "Le modifiche sono già state accettate ");
    	
    }
		
	}
	
	catch(SQLException ex){
		JOptionPane.showMessageDialog(FrameElencoUtenti.frame,ex);
		
	}
}
	
public static boolean eliminaiscr(int idutente){
	
	
	Connection con =DbConnection.db;

	Statement st;
	int rs;
	
	try{
	st= con.createStatement();	

	
	rs=st.executeUpdate("delete from elencoutenti where idutente='"+idutente+"'");
   if (rs==1)
	{
	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente è stato eliminato ");
	return true;
	}
	
    else{
    	
    	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente non è stato eliminato ");
    	
    }
		
	}
	
	catch(SQLException ex){
		JOptionPane.showMessageDialog(FrameElencoUtenti.frame,ex);
		
	}
	return false;
}
	
}
