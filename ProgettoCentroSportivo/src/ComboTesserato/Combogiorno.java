package ComboTesserato;

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
    public  Combogiorno(String livello,String disciplina){
    	super();


     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("select distinct Giornosettimana from gestioneturno,disciplinedisponibili where Livello='"+livello+"' and Disciplina='"+disciplina+"' and gestioneturno.Combinazionelivdis=disciplinedisponibili.Combinazionelivdis;"); 
            
    		
    		proj=(Object) "giorno";
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
