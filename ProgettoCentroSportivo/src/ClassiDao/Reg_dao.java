

package ClassiDao;
import DBInterfaccia.DbConnection ;
import VisteUtenteGenerico.FrameRegistrazione;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;


public class Reg_dao {

	
    
    
public static boolean registratesserato(String nome, String cognome , String cod_fis , String citta, String via , String num_civ , String mail ,String tel,String user , String pass , String tipo){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
	
     String nometipo = tipo;
     
     if (tipo.equals("Tesserato"))
     	tipo="T";
     if (tipo.equals("Istruttore"))
     	tipo="I";
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT elencoutenti.username,elencoutenti.mail FROM elencoutenti WHERE elencoutenti.username='"+user+"' OR elencoutenti.mail='"+mail+"' ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il nome utente \""+user+"\" e\\o l'email \""+mail+"\" sono gi� in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO `elencoutenti` ( `nome`, `cognome`, `codicefiscale`,`citta`, `via`, `numerocivico`, `mail`, `telefono`,  `username`, `password`,`tipoutente`, `attivita`, `connessione`,`bloccato`,`modificato`) VALUES ('"+nome+"', '"+cognome+"', '"+cod_fis+"','"+citta+"', '"+via+"', '"+num_civ+"', '"+mail+"','"+tel+"', '"+user+"', '"+pass+"', '"+tipo+"', '0',  '0','0','0' )");
         rs=st.executeQuery("SELECT elencoutenti.idutente FROM elencoutenti WHERE elencoutenti.username='"+user+"'and elencoutenti.password='"+pass+"'");
         
         rs.next();
         int userid= rs.getInt("idutente");
         st2.executeUpdate("INSERT INTO `tesserato`(`idutente`) VALUES('"+userid+"')");
            
         JOptionPane.showMessageDialog(FrameRegistrazione.frame,"Ciao "+nome+"! Ti sei registrato come "+nometipo+" ","Registrazione completata ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameRegistrazione.frame, ex);
}
return false;
}

public static boolean registraistruttore(String nome, String cognome , String cod_fis , String citta, String via , String num_civ , String mail ,String tel,String user , String pass , String tipo){

	

	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
	
     String nometipo=tipo;
     
     if (tipo.equals("Tesserato"))
     	tipo="T";
     if (tipo.equals("Istruttore"))
     	tipo="I";
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT elencoutenti.username,elencoutenti.mail FROM elencoutenti WHERE elencoutenti.username='"+user+"' OR elencoutenti.mail='"+mail+"' ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il nome utente \""+user+"\" e\\o l'email \""+mail+"\" sono gi� in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO `elencoutenti` ( `nome`, `cognome`, `codicefiscale`,`citta`, `via`, `numerocivico`, `mail`, `telefono`,  `username`, `password`,`tipoutente`, `attivita`, `connessione`,`bloccato`,`modificato`) VALUES ('"+nome+"', '"+cognome+"', '"+cod_fis+"','"+citta+"', '"+via+"', '"+num_civ+"', '"+mail+"','"+tel+"', '"+user+"', '"+pass+"', '"+tipo+"', '0',  '0','0','0' )");
         rs=st.executeQuery("SELECT elencoutenti.idutente FROM elencoutenti WHERE elencoutenti.username='"+user+"'and elencoutenti.password='"+pass+"'");
         
         rs.next();
         int userid=rs.getInt("idutente"); 
         st2.executeUpdate("INSERT INTO `istruttore`(`idutente`) VALUES ('"+userid+"')");
            
         JOptionPane.showMessageDialog(FrameRegistrazione.frame,"Ciao "+nome+"! Ti sei registrato come "+nometipo+" ","Registrazione completata ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
catch (SQLException ex) {
	JOptionPane.showMessageDialog(FrameRegistrazione.frame, ex);
}
return false;
}
     
public static boolean esistenome(String nome)
{

    
    Connection con = DbConnection.db;
    Statement st;
    
    ResultSet rs;
    
   
 
    
    try {
        
        st = con.createStatement();
        rs=st.executeQuery("SELECT elencoutenti.username,elencoutenti.mail FROM elencoutenti WHERE elencoutenti.username='"+nome+"'");
      
      if(rs.next())
    	  return true;
      else{
       return false;
      
      
      }
      }
       
        
 catch (SQLException ex) {
	 JOptionPane.showMessageDialog(FrameRegistrazione.frame, ex);
    }
    return false;
}




     
}






     





