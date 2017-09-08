package modelliTabelleRespo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import visteIstruttore.FrameInserisciEv;


public class ComboDiscipline extends JComboBox<Object> {
	private static final long serialVersionUID = 1L;

	Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    public  ComboDiscipline(){
    	super();

    
     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("SELECT  nomedisciplina FROM disciplina;"); 
            
    		
    		
            while(rs.next()){
                proj=(Object) rs.getString("nomedisciplina");
                this.addItem(proj);
                        
            }
            
          
                
            
             
        } catch (SQLException ex) {
        	
        	JOptionPane.showMessageDialog(FrameInserisciEv.frame, ex ,"SQL injection",JOptionPane.WARNING_MESSAGE);
        }
 
  

    }
    
    
}
