package visteadmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import DBInterfaccia.DbConnection;


public class Combocal extends JComboBox<Object>{
	private static final long serialVersionUID = 1L;

	Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    public  Combocal(){
    	super();


     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("SELECT DISTINCT calendario.NomeCalendario from calendario;"); 
            
    		
    		proj=(Object) " Seleziona un calendario ";
    		this.addItem(proj);
            while(rs.next()){
                proj=(Object) rs.getString("calendario.NomeCalendario");
                this.addItem(proj);
                        
            }
            this.setBounds(10, 1, 171, 23);
          
                
            
             
        } catch (SQLException ex) {
          
        }
 
  

    }
    
    
}
