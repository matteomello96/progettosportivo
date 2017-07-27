package view_tesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import DBInterfaccia.DbConnection;

public class Combogiorno  extends JComboBox<Object>{
	private static final long serialVersionUID = 1L;

	Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    public  Combogiorno(){
    	super();


     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("select giornosettimana from gestioneturno;"); 
            
    		
    		proj=(Object) " Seleziona il giorno ";
    		this.addItem(proj);
            while(rs.next()){
                proj=(Object) rs.getString("giornosettimana");
                this.addItem(proj);
                        
            }
            this.setBounds(10, 1, 171, 23);
          
                
            
             
        } catch (SQLException ex) {
          
        }
 
  

    }
}
