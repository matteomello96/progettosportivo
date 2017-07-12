

package ClassiDao;
import DBInterfaccia.*;
import VisteUtenteGenerico.FrameRegistrazione;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Reg_dao {
	
public static boolean registra(String nome, String cognome , String cod_fis , String citta, String via , String num_civ , String mail ,String user , String pass , String tipo){
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
         
rs=st.executeQuery("SELECT elencoutenti.username,elencoutenti.mail FROM elencoutenti WHERE elencoutenti.username='"+user+"' OR utente.email='" +mail+ "'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il nome utente \""+user+"\" e\\o l'email \""+mail+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);
        else{
           
         st2.executeUpdate("INSERT INTO `elencoutenti` (`idutente`, `nome`, `cognome`, `codicefiscale`,`citta`, `via`, `numerocivico`, `mail`,  `username`, `password`,`tipoutente`, `attivita`, `connessione`) VALUES (NULL, '"+nome+"', '"+cognome+"', '"+cod_fis+"','"+citta+"', '"+via+"', '"+num_civ+"', '"+mail+"', '"+user+"', '"+pass+"', '"+tipo+"', NULL,  '1' ");
         rs=st.executeQuery("SELECT elencoutenti.nome FROM elencoutenti WHERE elencoutenti.nome='"+nome+"'");
         rs.next();
         int userid=rs.getInt("idutente");
         st2.executeUpdate("INSERT INTO `tesserato` (`Matricolatesserato`, `idutente`) VALUES ( NULL, '"+userid+"')");
            
         JOptionPane.showMessageDialog(FrameRegistrazione.frame, "Ciao "+nome+"! Ti sei registrato come "+nometipo+" ","Registrazione completata ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    
}
return false;
}

public static boolean registraistruttore(String nome, String cognome , String cod_fis , String citta, String via , String num_civ , String mail ,String user , String pass , String tipo){

	
	 Connection con = DbConnection.db;
     Connection con2 = DbConnection.db;
     Statement st,st2;
     
     ResultSet rs;
     
     String nometipo=tipo;
     
     
     if (tipo.equals("Tesserato"))
      	tipo="T";
      if  (tipo.equals("Istruttore"))
      	tipo="I";
      
 try {
         
         st = con.createStatement();
        st2 = con2.createStatement();
        
rs=st.executeQuery("SELECT elencoutenti.username,elencoutenti.mail FROM elencoutenti WHERE elencoutenti.username='"+user+"' OR utente.email='" +mail+ "'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il nome utente \""+user+"\" e\\o l'email \""+mail+"\" sono già in uso, sceglierne altri"," ",JOptionPane.WARNING_MESSAGE);
        else{
           
           
         st2.executeUpdate("INSERT INTO `elencoutenti` (`idutente`, `nome`, `cognome`, `codicefiscale`, `via`, `numerocivico`, `citta`,`mail`, `username`,  `password`,`tipoutente`, `attivita`, `connessione`, ) VALUES (NULL, '"+nome+"', '"+cognome+"', '"+cod_fis+"','"+citta+"', '"+via+"', '"+num_civ+"','"+mail+"',  '"+user+"', '"+pass+"', '"+tipo+"', NULL, '1' ) ");
         rs=st.executeQuery("SELECT elencoutenti.nome FROM elencoutenti WHERE elencoutenti.nome='"+nome+"'");
         rs.next();
         int userid=rs.getInt("idutente");
         
         st2.executeUpdate("INSERT INTO `istruttore` (`Matricolaistruttore`, `telefonoist`,`idutente`) VALUES ( NULL, NULL,'"+userid+"')");
        // rs=st.executeQuery("SELECT istruttore.Matricolaistruttore FROM istruttore,elencoutenti WHERE istruttore.idutente="+userid+"");
       //  rs.next();
         
         JOptionPane.showMessageDialog(FrameRegistrazione.frame, "Ciao "+nome+"! Ti sei registrato come "+nometipo+" ","Registrazione completata ",JOptionPane.INFORMATION_MESSAGE);
         return true;
            }
 }
           
catch (SQLException ex) {
    
}
return false;
}
     

     
}




     





