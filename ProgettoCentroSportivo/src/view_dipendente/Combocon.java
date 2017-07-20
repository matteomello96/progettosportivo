package view_dipendente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import DBInterfaccia.DbConnection;


public class Combocon extends JComboBox<Object>{
	private static final long serialVersionUID = 1L;

	Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    public  Combocon(){
    	super();


     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("SELECT DISTINCT NomeModalità FROM modalitapagamento "); 
            
    		
    		proj=(Object) " Seleziona una modalità di pagamento ";
    		this.addItem(proj);
            while(rs.next()){
                proj=(Object) rs.getString("NomeModalità");
                this.addItem(proj);
                        
            }
            this.setBounds(10, 1, 171, 23);
          
                
            
             
        } catch (SQLException ex) {
          
        }
 
  

    }
    
    
}
