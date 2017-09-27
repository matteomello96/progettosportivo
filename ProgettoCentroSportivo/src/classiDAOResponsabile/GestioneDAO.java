package classiDAOResponsabile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DBInterfaccia.DbConnection;
import listener.VariListener;
import visteadmin.FrameGestione;
import visteadmin.FrameInserisciDiscDisp;
import visteadmin.FrameInserisciDisciplina;
import visteadmin.FrameInserisciIstrDisp;
import visteadmin.FrameInserisciLiv;
import visteadmin.FrameInserisciModPag;
import visteadmin.FrameModificaDiscDisp;
import visteadmin.FrameModificaDisciplina;
import visteadmin.FrameModificaLiv;
import visteadmin.FrameModificaModPag;

public class GestioneDAO {
 private static GestioneDAO instance;
	
	public static synchronized GestioneDAO getInstance() {
		if(instance==null)
			instance=new GestioneDAO();
		return instance;
	}
	
	
	
public static boolean eliminatest ( String commento,String data ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT codicetestimonianza FROM testimonianza WHERE testimonianza.commento='"+commento+"' and testimonianza.dataazione='"+data+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La testimonianza contenente il commento "+commento+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        Integer discip= rs.getInt("codicetestimonianza"); 
        st.executeUpdate("DELETE  FROM testimonianza WHERE codicetestimonianza='"+discip+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La disciplina contenente il commento "+commento+" è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}
	

public static boolean eliminamodpagam ( String modpag ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT modalitapagamento.Nomemodalita  FROM modalitapagamento WHERE modalitapagamento.Nomemodalita ='"+modpag+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La modalità di pagamento "+modpag+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        String discip= rs.getString("modalitapagamento.Nomemodalita"); 
        st.executeUpdate("DELETE  FROM modalitapagamento WHERE modalitapagamento.Nomemodalita ='"+discip+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La modalità di pagamento "+modpag+" è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}

public static boolean eliminalivello ( String livello ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT nomelivello FROM livello WHERE livello.nomelivello='"+livello+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "Il livello "+livello+" non è  stato eliminato"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        String discip= rs.getString("nomelivello"); 
        st.executeUpdate("DELETE  FROM livello WHERE livello.nomelivello='"+discip+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"Il livello "+livello+" è stato eliminato correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}

public static boolean eliminadisciplinadisp ( String disciplina,String livello ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT combinazionelivdis FROM disciplinedisponibili WHERE disciplinedisponibili.livello='"+livello+"' and disciplinedisponibili.disciplina='"+disciplina+"' "); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La combinazione data dalla "+disciplina+" a cui è associato il livello "+livello+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        int comb= rs.getInt("combinazionelivdis"); 
        st.executeUpdate("DELETE  FROM disciplinedisponibili WHERE disciplinedisponibili.combinazionelivdis='"+comb+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La combinazione data dalla "+disciplina+" a cui è associato il livello "+livello+" è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}

public static boolean eliminadisciplina ( String disciplina ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT nomedisciplina FROM disciplina WHERE disciplina.nomedisciplina='"+disciplina+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+disciplina+" non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        String discip= rs.getString("nomedisciplina"); 
        st.executeUpdate("DELETE  FROM disciplina WHERE  disciplina.nomedisciplina='"+disciplina+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"La disciplina "+disciplina+" è stata eliminato correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}

public static boolean eliminacombis ( String nomeis,String cognomeis,String disc,String liv ){
	 
	
	
	
	Connection con = DbConnection.db;
	Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs,rs2;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
    	 st2=con2.createStatement();
         rs= st.executeQuery("SELECT DISTINCT combinazionelivdis FROM disciplinedisponibili where disciplinedisponibili.disciplina='"+disc+"' and disciplinedisponibili.livello='"+liv+"'"); 
         rs2= st2.executeQuery("SELECT DISTINCT matricolaistruttore from istruttore inner join elencoutenti on elencoutenti.idutente=istruttore.idutente where elencoutenti.nome='"+nomeis+"' and elencoutenti.cognome='"+cognomeis+"'"); 
        
        if((rs.next())&&(rs2.next())){
        	
        int comb= rs.getInt("combinazionelivdis"); 
        int comb2=rs2.getInt("matricolaistruttore");
        st2.executeUpdate("DELETE  FROM istruttoridisponibiliperdisciplina WHERE  istruttoridisponibiliperdisciplina.combinazionelivdis='"+comb+"' and istruttoridisponibiliperdisciplina.istruttore='"+comb2+"' ");
      	JOptionPane.showMessageDialog(FrameGestione.frame,"La combinazione  è stata eliminata correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;  
        }
        else{
        JOptionPane.showMessageDialog(null, "La combinazione selezionata non è  stata eliminata"," ",JOptionPane.WARNING_MESSAGE);
        }
        
           
         
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}


public static boolean inserimentoliv ( String liv ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT livello.NomeLivello FROM livello WHERE livello.NomeLivello  ='"+liv+"'; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il livello  "+liv+" è già stato creato, inserirne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO  `livello`(NomeLivello) VALUES ('"+liv+"') ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameInserisciLiv.frame,"Il livello  \""+liv+"\" è stato inserito  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciLiv.frame, ex);
}
return false;
}

public static boolean inserimentomodpag ( String modp ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT modalitapagamento.Nomemodalita  FROM modalitapagamento WHERE modalitapagamento.Nomemodalita   ='"+modp+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La modalità di pagamento "+modp+" è già stata creata, inserirne un altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO  `modalitapagamento`(modalitapagamento.Nomemodalita ) VALUES ('"+modp+"') ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameInserisciModPag.frame,"La modalità di pagamento  \""+modp+"\" è stata inserita  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciModPag.frame, ex);
}
return false;
}

public static boolean inseriscicombis ( String nomeis,String cognomeis,String disc,String liv ){
	 
	
	
	
	Connection con = DbConnection.db;
	Connection con2 = DbConnection.db;
	Connection con3 = DbConnection.db;
	Connection con4 = DbConnection.db;
    Statement st,st2,st3,st4;
    ResultSet rs,rs2,rs3;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
    	 st2 =con2.createStatement();
    	 st3 =con3.createStatement();
    	 st4 =con4.createStatement();
         rs= st.executeQuery("SELECT DISTINCT combinazionelivdis FROM disciplinedisponibili where disciplinedisponibili.disciplina='"+disc+"' and disciplinedisponibili.livello='"+liv+"'"); 
         rs2= st2.executeQuery("SELECT DISTINCT matricolaistruttore from istruttore inner join elencoutenti on elencoutenti.idutente=istruttore.idutente where elencoutenti.nome='"+nomeis+"' and elencoutenti.cognome='"+cognomeis+"'"); 
          if((rs.next())&&rs2.next())
          {
         int comb= rs.getInt("combinazionelivdis"); 
         int comb2=rs2.getInt("matricolaistruttore");
         rs3=st3.executeQuery("SELECT DISTINCT combinazioneistrdis from istruttoridisponibiliperdisciplina where istruttore='"+comb2+"' and combinazionelivdis= '"+comb+"' ");
          if(rs3.next())
        		{
        	JOptionPane.showMessageDialog(null, "La combinazione selezionata esiste già"," ",JOptionPane.WARNING_MESSAGE);
        
         }
        else{
        
        st3.executeUpdate("INSERT INTO istruttoridisponibiliperdisciplina(istruttore,combinazionelivdis) VALUES ('"+comb2+"','"+comb+"') ");
      	JOptionPane.showMessageDialog(FrameInserisciIstrDisp.frame,"La combinazione  è stata inserita correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;  
        
        }
        
           
         
            }
     }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciIstrDisp.frame, ex);
}
return false;
}


public static boolean inserimentodiscdisp ( String dis ,String liv,String costomen){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT disciplinedisponibili.disciplina,disciplinedisponibili.livello FROM disciplinedisponibili WHERE livello  ='"+liv+"' and disciplina  ='"+dis+"'; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+dis+" cui è associato il livello "+liv+" è già stata creata, inserirne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO  `disciplinedisponibili`(disciplina,livello,costomensile) VALUES ('"+dis+"','"+liv+"','"+costomen+"') ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameInserisciDiscDisp.frame,"La disciplina  \""+dis+"\" cui è associato il livello "+liv+" è stata inserita  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciDiscDisp.frame, ex);
}
return false;
}



public static boolean inserimentodisc ( String dis ,String desc,String cal,String pathim,String nomefile,String pathprec) throws URISyntaxException{
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT disciplina.nomedisciplina FROM disciplina WHERE nomedisciplina  ='"+dis+"' ; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+dis+" è già stata creata, inserirne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        
       st2.executeUpdate("INSERT INTO  `disciplina`(nomedisciplina,descrizione,calendario,immagine) VALUES ('"+dis+"','"+desc+"','"+cal+"',NULL) ");

       InputStream is = new FileInputStream(new File(pathim));
       
       PreparedStatement ps = con.prepareStatement("UPDATE disciplina set immagine=? where nomedisciplina='"+dis+"'");
       ps.setBlob(1,is);
       ps.executeUpdate();
       JOptionPane.showMessageDialog(null, "Data Inserted");
   

        
        
         
            
       JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame,"La disciplina  \""+dis+"\"  è stata inserita  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
          
     }}
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, ex);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;

	





     
}

public static boolean modificadiscdisp ( String disc,String liv,float f,String nuovocm){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs,rs2;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT disciplinedisponibili.combinazionelivdis FROM disciplinedisponibili WHERE livello  ='"+liv+"' and disciplina  ='"+disc+"' and costomensile='"+nuovocm+"'");
        
        if(rs.next()){
      	  JOptionPane.showMessageDialog(null, "La disciplina disponibile "+disc+" cui è associato il livello  "+liv+" con il costo mensile "+nuovocm+"  e  è già stata creata, sceglierne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        }
        else{
            
         st2.executeUpdate("UPDATE disciplinedisponibili SET  costomensile='"+nuovocm+"'   WHERE livello  ='"+liv+"' and disciplina  ='"+disc+"' and costomensile  ='"+f+"' ;");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaDiscDisp.frame,"La combinazione  è stata cambiata  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaDiscDisp.frame, ex);
}
return false;
}




public static boolean modificadisc ( String exdisc,String dis ,String desc,String cal,String pathim,String nomefile){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
     
    
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
        
        rs= st.executeQuery("SELECT disciplina.nomedisciplina FROM disciplina WHERE nomedisciplina  ='"+dis+"' and descrizione= '"+desc+"' and calendario = '"+cal+"' and immagine= '"+pathim+"'; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La disciplina "+dis+" è già esistente, inserirne un' altra"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        	
        if (nomefile.equals("stesso file precedente"))
     { 
        	st2.executeUpdate("UPDATE  `disciplina`SET nomedisciplina='"+dis+"',descrizione='"+desc+"',calendario='"+cal+"' where nomedisciplina='"+exdisc+"' ");
     }
    
     else 
     {
        
        try {
       
        	st2.executeUpdate("UPDATE  `disciplina`SET nomedisciplina='"+dis+"',descrizione='"+desc+"',calendario='"+cal+"' where nomedisciplina='"+exdisc+"' ");
        
        	InputStream is = new FileInputStream(new File(pathim));
            
            PreparedStatement ps = con.prepareStatement("UPDATE disciplina set immagine=? where nomedisciplina='"+dis+"'");
            ps.setBlob(1,is);
            ps.executeUpdate();
        
        
        }
        catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
          } catch (IOException e) {
			
        	  JOptionPane.showMessageDialog(FrameInserisciDisciplina.frame, e);
		}
     }
        st2.executeUpdate("UPDATE  `disciplina`SET nomedisciplina='"+dis+"',descrizione='"+desc+"',calendario='"+cal+"' where nomedisciplina='"+exdisc+"' ");
            
       JOptionPane.showMessageDialog(FrameModificaDisciplina.frame,"La disciplina  \""+dis+"\"  è stata modificata  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
          
     }}
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaDisciplina.frame, ex);
}
return false;

	





     
}


public static boolean modificaliv ( String liv,String nuovoliv ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT livello.NomeLivello FROM livello WHERE livello.NomeLivello  ='"+nuovoliv+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il livello  "+liv+" è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("UPDATE livello SET  livello.NomeLivello = '"+nuovoliv+"'  where livello.NomeLivello  ='"+liv+"'  ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaLiv.frame,"Il livello precedente \""+liv+"\" è stato cambiato in \""+nuovoliv+"\"  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaLiv.frame, ex);
}
return false;
}


public static boolean modificamodpag ( String modp,String nuovamodp ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT modalitapagamento.Nomemodalita  FROM modalitapagamento WHERE modalitapagamento.Nomemodalita   ='"+nuovamodp+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "La modalità di pagamento "+nuovamodp+" è già stata creata, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("UPDATE modalitapagamento SET  modalitapagamento.Nomemodalita  = '"+nuovamodp+"'  where modalitapagamento.Nomemodalita   ='"+modp+"'  ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaModPag.frame,"La modalità di pagamento precedente \""+modp+"\" è stata cambiata in \""+nuovamodp+"\"  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaModPag.frame, ex);
}
return false;
}




public static boolean eliminacalendario ( String cal ){
	 
	
	
	
	Connection con = DbConnection.db;
    
    Statement st;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         rs=st.executeQuery("SELECT nomecalendario FROM calendario WHERE calendario.nomecalendario='"+cal+"'"); 
        
        
        if(!rs.next())
      	  JOptionPane.showMessageDialog(null, "Il calendario "+cal+" non è  stato eliminato"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
        String discip= rs.getString("nomecalendario"); 
        st.executeUpdate("DELETE  FROM calendario WHERE calendario.nomecalendario='"+discip+"' ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameGestione.frame,"Il calendario "+cal+" è stato eliminato correttamente ","Eliminazione riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameGestione.frame, ex);
}
return false;
}


public static boolean modificacal ( String cal,String nuovocal ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT calendario.nomecalendario FROM calendario WHERE calendario.nomecalendario  ='"+nuovocal+"'");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il calendario  "+nuovocal+" è già stato creato, sceglierne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("UPDATE calendario SET calendario.nomecalendario = '"+nuovocal+"'  where calendario.nomecalendario  ='"+cal+"'  ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameModificaLiv.frame,"Il calendario precedente \""+cal+"\" è stato cambiato in \""+nuovocal+"\"  correttamente ","Modifica riuscita! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameModificaLiv.frame, ex);
}
return false;
}
public static boolean inserimentocal ( String cal ){
	 
	
	
	
	Connection con = DbConnection.db;
    Connection con2 = DbConnection.db;
    Statement st,st2;
    ResultSet rs;
	
    
     
     
     
    
   
     
     try {
    	 st = con.createStatement();
         st2 = con2.createStatement(); 
         
         
        rs= st.executeQuery("SELECT calendario.nomecalendario FROM calendario WHERE calendario.nomecalendario  ='"+cal+"'; ");
        
        if(rs.next())
      	  JOptionPane.showMessageDialog(null, "Il calendario  "+cal+" è già stato creato, inserirne un altro"," ",JOptionPane.WARNING_MESSAGE);
        
        else{
         st2.executeUpdate("INSERT INTO  `calendario`(nomecalendario) VALUES ('"+cal+"') ");
        
         
         
            
         JOptionPane.showMessageDialog(FrameInserisciLiv.frame,"Il calendario  \""+cal+"\" è stato inserito  correttamente ","Inserimento riuscito! ",JOptionPane.INFORMATION_MESSAGE);
         return true;
        }
            }
           
           
catch (SQLException ex) {
    JOptionPane.showMessageDialog(FrameInserisciLiv.frame, ex);
}
return false;
}
     
}




