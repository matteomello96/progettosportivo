package ModelliTabelleIstruttore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import VisteIstruttore.FrameInserisciEv;


public class ComboLivelloIs extends JComboBox<Object> {
	private static final long serialVersionUID = 1L;

	Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    public  ComboLivelloIs(String disciplina,int matricola) {
    	super();

    
     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("SELECT livello FROM disciplinedisponibili inner join istruttoridisponibiliperdisciplina on disciplinedisponibili.combinazionelivdis=istruttoridisponibiliperdisciplina.combinazionelivdis where istruttoridisponibiliperdisciplina.istruttore='"+matricola+"' ;"); 
            
    		
    		
            while(rs.next()){
                proj=(Object) rs.getString("livello");
                this.addItem(proj);
                        
            }
            
          
                
            
             
        } catch (SQLException ex) {
        	
        	JOptionPane.showMessageDialog(FrameInserisciEv.frame, ex ,"SQL injection",JOptionPane.WARNING_MESSAGE);
        }
 
  

    }
    
    
}
