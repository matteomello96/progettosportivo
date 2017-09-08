
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
        JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente � stato attivato ");

        }
        else{
        	
        	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente � gi� stato disattivato ");
        	
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
        JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente � stato bloccato ");

        }
        else{
        	
        	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente � stato gi� bloccato ");
        	
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
    JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente � stato sbloccato ");

    }
    else{
    	
    	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente � stato gi� sbloccato ");
    	
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
    	
    	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "Le modifiche sono gi� state accettate ");
    	
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
	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente � stato eliminato ");
	return true;
	}
	
    else{
    	
    	JOptionPane.showMessageDialog(FrameElencoUtenti.frame, "L'utente non � stato eliminato ");
    	
    }
		
	}
	
	catch(SQLException ex){
		JOptionPane.showMessageDialog(FrameElencoUtenti.frame,ex);
		
	}
	return false;
}
	
}
