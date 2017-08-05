
package classiDAOResponsabile;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import visteadmin.FrameResponsabile;

public class credenzialidao {
	
	public static void credenziali(int idutente){
		
		
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
JOptionPane.showMessageDialog(FrameResponsabile.frame, "L'utente è stato attivato ");

        }
        else{
        	st.executeUpdate("UPDATE elencoutenti SET attivita=0 WHERE idutente='"+idutente+"'");
        	JOptionPane.showMessageDialog(FrameResponsabile.frame, "L'utente è stato disattivato ");
        	
        }
			
		}
		
		catch(SQLException ex){
			
			
		}
	}

}
