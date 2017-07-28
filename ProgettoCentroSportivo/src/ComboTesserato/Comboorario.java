package ComboTesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import DBInterfaccia.DbConnection;

public class Comboorario extends JComboBox<Object> {
	private static final long serialVersionUID = 1L;

	Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    public  Comboorario(String livello,String disciplina,String giorno){
    	super();


     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("select distinct fasciaoraria from gestioneturno,disciplinedisponibili where Livello='"+livello+"' and Disciplina='"+disciplina+"' and Giornosettimana='"+giorno+"'  and gestioneturno.Combinazionelivdis=disciplinedisponibili.Combinazionelivdis;"); 
            
    		
    		proj=(Object) "orario";
    		this.addItem(proj);
            while(rs.next()){
                proj=(Object) rs.getString("fasciaoraria");
                this.addItem(proj);
                        
            }
            this.setBounds(10, 1, 171, 23);
          
                
            
             
        } catch (SQLException ex) {
          
        }
 
  

    }
}
