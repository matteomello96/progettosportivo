package ClassiDao;
import DBInterfaccia.*;
import VisteUtenteGenerico.FrameRegistrazione;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Reg_dao {
	
public static boolean registra(String nome, String cognome , String cod_fis , String citta, String via , int num_civ , String mail ,String user , String pass , String tipo){
	 Connection con = DbConnection.db;
     Connection con2 = DbConnection.db;
     Statement st,st2;
     
     ResultSet rs;
     String nometipo=tipo;
     
     if (tipo.equals("Tesserato"))
     	tipo="T";
     else if (tipo.equals("Istruttore"))
     	tipo="I";
     else if (tipo.equals("Responsabile"))
     	tipo="R";
     
     try {
         
         st = con.createStatement();
        st2 = con2.createStatement();
         
       
           
         st2.executeUpdate("INSERT INTO `elencoutenti` (`idutente`, `nome`, `cognome`, `codicefiscale`, `via`, `numerocivico`, `citta`, `username`, `password`, `telefono`, `mail`, `attivita`, `connessione`, `tipoutente`) VALUES (NULL, '"+nome+"', '"+cognome+"'), '"+cod_fis+"', '"+via+"', '"+num_civ+"', '"+citta+"', '"+user+"', '"+pass+"', '"+citta+"', NULL, '"+mail+"', NULL, '1' '"+tipo+"') ");
         rs=st.executeQuery("SELECT elencoutenti.nome FROM elencoutenti WHERE elencoutenti.nome='"+nome+"'");
         rs.next();
         int userid=rs.getInt("idutente");
         st2.executeUpdate("INSERT INTO `tesserato` (`Matricolatesserato`, `idutente`) VALUES ( NULL, '"+userid+"')");
       //  rs=st.executeQuery("SELECT tesserato.Matricolatesserato FROM tesserato,elencoutenti WHERE tesserato.idutente="+userid+"");
        // rs.next();
         
         JOptionPane.showMessageDialog(FrameRegistrazione.frame, "Ciao "+nome+"! Ti sei registrato come "+nometipo+" ","Registrazione completata ",JOptionPane.INFORMATION_MESSAGE);
         return true;
            }
           
           
catch (SQLException ex) {
    
}
return false;
}

public static boolean registraistruttore(String nome, String cognome , String cod_fis , String citta, String via , int num_civ , String mail ,String user , String pass , String tipo, String telefonoist){

	
	 Connection con = DbConnection.db;
     Connection con2 = DbConnection.db;
     Statement st,st2;
     
     ResultSet rs;
     
     String nometipo=tipo;
     
     
     if (tipo.equals("Tesserato"))
      	tipo="T";
      else if (tipo.equals("Istruttore"))
      	tipo="I";
      else if (tipo.equals("Responsabile"))
      	tipo="R";
 try {
         
         st = con.createStatement();
        st2 = con2.createStatement();
         
       
           
         st2.executeUpdate("INSERT INTO `elencoutenti` (`idutente`, `nome`, `cognome`, `codicefiscale`, `via`, `numerocivico`, `citta`, `username`, `password`, `telefono`, `mail`, `attivita`, `connessione`, `tipoutente`) VALUES (NULL, '"+nome+"', '"+cognome+"'), '"+cod_fis+"', '"+via+"', '"+num_civ+"', '"+citta+"', '"+user+"', '"+pass+"', '"+citta+"', NULL, '"+mail+"', NULL, '1' '"+tipo+"') ");
         rs=st.executeQuery("SELECT elencoutenti.nome FROM elencoutenti WHERE elencoutenti.nome='"+nome+"'");
         rs.next();
         int userid=rs.getInt("idutente");
         st2.executeUpdate("INSERT INTO `magazziniere` (`Matricolaistruttore`, `telefonoist`,`idutente`) VALUES ( NULL, '"+telefonoist+"','"+userid+"')");
        // rs=st.executeQuery("SELECT istruttore.Matricolaistruttore FROM istruttore,elencoutenti WHERE istruttore.idutente="+userid+"");
       //  rs.next();
         
         JOptionPane.showMessageDialog(FrameRegistrazione.frame, "Ciao "+nome+"! Ti sei registrato come "+nometipo+" ","Registrazione completata ",JOptionPane.INFORMATION_MESSAGE);
         return true;
            }
           
           
catch (SQLException ex) {
    
}
return false;
}
     
     
     
}




     




