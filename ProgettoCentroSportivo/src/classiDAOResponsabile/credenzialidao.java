package classiDAOResponsabile;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import visteadmin.FrameResponsabile;

public class credenzialidao {
	
	public static void credenziali(int idutente){
		
		
		Connection con =DbConnection.db;
		Statement st;
		
		try{
		st= con.createStatement();	
			
		
		st.executeUpdate("UPDATE elencoutenti SET attivita=1 WHERE idutente='"+idutente+"'");
JOptionPane.showMessageDialog(FrameResponsabile.frame, "L'utente è stato attivato ");


			
		}
		
		catch(SQLException ex){
			
			
		}
	}

}
