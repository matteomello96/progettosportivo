package classiDAOResponsabile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import visteadmin.FrameResponsabile;
import visteadmin.framedettagli;

public class modificaordinedao {
	
	public static void modifica(int idiscrizione){
		
		Connection con =DbConnection.db;
		Connection con1 =DbConnection.db;
		 Connection con2 = DbConnection.db;
	        Connection con3 = DbConnection.db;
		Statement st,st1,st2,st3;
		  ResultSet rs,rs1;
		int conf,ann;
		
		
		try{
			st= con.createStatement();	
			st1= con1.createStatement();
			st2= con2.createStatement();
			st3= con3.createStatement();
			
			
			 rs=st.executeQuery("select confermato from detiscr where iddet='"+idiscrizione+"'");
        	 rs.next();
             conf=rs.getInt("confermato");
            
             rs1=st1.executeQuery("select annullato from detiscr where iddet='"+idiscrizione+"'");
        	 rs1.next();
             ann=rs1.getInt("annullato");
             //JOptionPane.showMessageDialog(framedettagli.frame, "'"+idiscrizione+"','"+conf+"','"+ann+"',");
             
             if(conf==0 && ann==1){
			
			st.executeUpdate("UPDATE detiscr SET confermato=1 WHERE iddet='"+idiscrizione+"'");
			st1.executeUpdate("UPDATE detiscr SET annullato=0 WHERE iddet='"+idiscrizione+"'");
			
	JOptionPane.showMessageDialog(framedettagli.frame, "Modifica accettata");
	
             }
             
             else{
            	 
            	 st2.executeUpdate("UPDATE detiscr SET confermato=0 WHERE iddet='"+idiscrizione+"'");
     			st3.executeUpdate("UPDATE detiscr SET annullato=1 WHERE iddet='"+idiscrizione+"'");
     			
     	JOptionPane.showMessageDialog(framedettagli.frame, "Modifica negata");	 
             
             }
	
	


				
			}
			
			catch(SQLException ex){
				
				
			}
	}

}
