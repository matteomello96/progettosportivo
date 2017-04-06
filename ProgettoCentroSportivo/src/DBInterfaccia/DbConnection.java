package DBInterfaccia;
/*
  Classe dedicata alla gestione del Database
  Gestisce l'apertura e la chiusura della connessione col Database
  Fornisce i metodi per l'esecuzione delle query sul Database
 */
import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

//import connessioneDB.DbConnection;

public class DbConnection {

   public static Connection db;       // La connessione col Database
   private static boolean connesso;    // Flag che indica se la connessione e' attiva o meno
   private static DbConnection instance; 
   

   public static String nomebase="centropolisportivo";
   public static String rootu="root";
   public static String rootp="Bla.bla.12";
   public static String host="127.0.0.1";
   
   
  

   public static DbConnection getInstance() {
	   if(instance == null)
		   instance = new DbConnection();
	   if(connesso != true)
			connetti(nomebase, rootu, rootp);
	   return instance;
   }
   
   // Apre la connessione con il Database
   public static boolean connetti(String nomeDB, String nomeUtente, String pwdUtente) {

	  connesso = false;
      try {

         // Carico il driver JDBC per la connessione con il database MySQL
         Class.forName("com.mysql.jdbc.Driver");
         db = DriverManager.getConnection("jdbc:mysql:://"+host+"/"  + nomeDB + "?user=" + nomeUtente + "&password=" + pwdUtente);
         
         connesso=true;
         
         
      } catch (Exception e) {
    	  //e.printStackTrace(); VISUALIZZA GLI ERRORI SULLA CONSOLE
    	  JOptionPane.showMessageDialog(null,"<html>Access failed to selected database.<br>Change connetion settings and check server availability. <br> <br>  Error: "+ e.getMessage(),"Cannot connect",JOptionPane.ERROR_MESSAGE);
     }
      return connesso;
   }

   // Esegue una query di selezione dati sul Database
   // query: una stringa che rappresenta un'istruzione SQL di tipo SELECT da eseguire
   // colonne: il numero di colonne di cui sara' composta la tupla del risultato
   // ritorna un Vector contenente tutte le tuple del risultato
   public Vector<String[]> eseguiQuery(String query) {
      Vector<String[]> v = null;
      String [] record;
      int colonne = 0;
      try {
         Statement stmt = db.createStatement();     // Creo lo Statement per l'esecuzione della query
         ResultSet rs = stmt.executeQuery(query);   // Ottengo il ResultSet dell'esecuzione della query
         v = new Vector<String[]>();
         ResultSetMetaData rsmd = rs.getMetaData();
         colonne = rsmd.getColumnCount();

         while(rs.next()) {   // Creo il vettore risultato scorrendo tutto il ResultSet
            record = new String[colonne];
            for (int i=0; i<colonne; i++) record[i] = rs.getString(i+1);
            v.add( (String[]) record.clone() );
         }
         rs.close();     // Chiudo il ResultSet
         stmt.close();   // Chiudo lo Statement
      } catch (Exception e) { 
    	  //e.printStackTrace(); 
    	    
      }

      return v;
   }
   
   
  

   // Esegue una query di aggiornamento sul Database
   // query: una stringa che rappresenta un'istuzione SQL di tipo UPDATE da eseguire
   // ritorna TRUE se l'esecuzione e' adata a buon fine, FALSE se c'e' stata un'eccezione
   public boolean eseguiAggiornamento(String query) {
      boolean risultato = false;
      try {
         Statement stmt = db.createStatement();
         risultato = true;
         stmt.close();
      } catch (Exception e) {
         e.printStackTrace();
         risultato = false;
      }
      return risultato;
   }

   // Chiude la connessione con il Database
   public static void disconnetti() {
      try {
         db.close();
         connesso = false;
         
      } catch (Exception e) { e.printStackTrace(); }
   }

   public static boolean isConnesso() { return connesso; }   // Ritorna TRUE se la connessione con il Database e' attiva
}