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
		Connection con1 = DbConnection.db;
		Statement st,st1;
		ResultSet rs;
		int conf;
		try{
		st= con.createStatement();	
		st1= con1.createStatement();
		
		rs=st1.executeQuery("select attivita from elencoutenti where idutente='"+idutente+"'");
   	 rs.next();
        conf=rs.getInt("attivita");
        
        if(conf==0){
		
		st.executeUpdate("UPDATE elencoutenti SET attivita=1 WHERE idutente='"+idutente+"'");
JOptionPane.showMessageDialog(FrameResponsabile.frame, "L'utente � stato attivato ");

        }
        else{
        	st.executeUpdate("UPDATE elencoutenti SET attivita=0 WHERE idutente='"+idutente+"'");
        	JOptionPane.showMessageDialog(FrameResponsabile.frame, "L'utente � stato disattivato ");
        	
        }
			
		}
		
		catch(SQLException ex){
			
			
		}
	}

}
