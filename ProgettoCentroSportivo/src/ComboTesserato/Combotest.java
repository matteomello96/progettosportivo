package ComboTesserato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import ClassiDao.GetInfoDB;
import DBInterfaccia.DbConnection;
import Model.Utente;

public class Combotest  extends JComboBox<Object>{
	private static final long serialVersionUID = 1L;

	Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    public  Combotest(){
    	super();


     
        Object proj;
        
        try {
            
            st = con.createStatement();
            
            rs = st.executeQuery("select distinct Disciplina from disciplinedisponibili,detiscr where tesserato='"+GetInfoDB.getidTess(Utente.getUsername())+"' and confermato='1' and detiscr.combinazionelivdis=disciplinedisponibili.Combinazionelivdis;");  
            
    		
    		proj=(Object) "disciplina";
    		this.addItem(proj);
            while(rs.next()){
                proj=(Object) rs.getString("Disciplina");
                this.addItem(proj);
                        
            }
            this.setBounds(10, 1, 171, 23);
          
                
            
             
        } catch (SQLException ex) {
          
        }
 
  

    }
}
