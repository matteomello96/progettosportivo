package InterfacciaUtentegenerico;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import DBInterfaccia.DbConnection;

public class ComboDisc extends JComboBox<Object>{
	



	

	    
	    
	  
	    
	    
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public  ComboDisc(){
	    	super();
	
	  
	       
	        
	        Object disc;
	        disc=(Object) " - Discipline - ";
	        super.setBounds(5,28,232, 26);
	        super.addItem(disc);
	        
	        try {
	        	  Connection con = DbConnection.db;
	      	    
	      	    Statement st;
	      	    
	      	    ResultSet rs;
	        	
	            st = con.createStatement();
	            
	            rs = st.executeQuery("SELECT DISTINCT nomedisciplina FROM disciplina"); 
	            
	    		
	    		
	            while(rs.next()){
	            
	                disc =(Object) rs.getString("nomedisciplina");
	                super.addItem(disc);
	            
	                        
	            }
	            
	            
	             
	        } catch (SQLException ex) {
	           
	        }
	 
	        super.setSelectedIndex(0);
            super.repaint();


	    }
	    
	
	 
	}




