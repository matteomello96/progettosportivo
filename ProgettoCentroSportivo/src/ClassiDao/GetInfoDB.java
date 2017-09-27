package ClassiDao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import DBInterfaccia.DbConnection;
import view_tesserato.FrameAttivitaTes;
import view_tesserato.FrameInserisciTurno;
import visteadmin.FrameDettagliDaAccResp;




public class GetInfoDB {
	
	
	
	
	public static  Image SettaImg (String disciplina){
		   Connection con = DbConnection.db;
	        Image im = null;
	        ImageIcon image=null;
	        Statement st;
	        
	        ResultSet rs;
	        
         try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT DISTINCT C.Immagine from disciplina as C where C.nomedisciplina= '"+disciplina+"';"); 
	          
	               if(rs.next()){
            byte[] img = rs.getBytes("C.Immagine");
              image = new ImageIcon(img);
               im = image.getImage();
	               }
                  
            
             
	        } catch (SQLException ex) {
	        
	        }
       
		   
		   
		return im;
		   
		   
	   }
	
  
	public static int getoccev(int cod,int tesserato){

	       
        
        Connection con = DbConnection.db;
        
        Statement st;
        
        ResultSet rs;
        
 
        int mod = -1;
        
        try {
            
            st = con.createStatement();
           
            rs = st.executeQuery("SELECT codiceiscrizioneevento FROM iscrizioneevento where evento='"+cod+"' and tesserato='"+tesserato+"'  "); 
          
                rs.next();
                mod=rs.getInt("codiceiscrizioneevento");
                		
            return mod; 
        } catch (SQLException ex) {
        
        }
        return mod;

}
	
	
	
	 public static int getocc(int comb,int tesserato){

	       
	        
	        Connection con = DbConnection.db;
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	        int mod = -1;
	        
	        try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT iddet FROM detiscr where combinazionelivdis='"+comb+"' and tesserato='"+tesserato+"'  "); 
	          
	                rs.next();
	                mod=rs.getInt("iddet");
	                		
	            return mod; 
	        } catch (SQLException ex) {
	        
	        }
	        return mod;

	}
	
	
	

	 public static String getTipo(String username){

	       
	        
	        Connection con = DbConnection.db;
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	        String mod = "";
	        
	        try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT tipoutente FROM elencoutenti WHERE elencoutenti.username='"+username+"' "); 
	          
	                rs.next();
	                mod=rs.getString("tipoutente");
	                		
	            return mod; 
	        } catch (SQLException ex) {
	        
	        }
	        return mod;

	}
	
	
	
	
	
	
	
public static boolean  SettaLogout(String username){

	       
        
        Connection con = DbConnection.db;
        
        Statement st;
        
        int rs;
        
 
        
        
        try {
            
            st = con.createStatement();
           
            rs = st.executeUpdate("UPDATE elencoutenti SET connessione=0 WHERE elencoutenti.username='"+username+"' "); 
          
                return true;
                
                		
             
        } catch (SQLException ex) {
        
        }
		return false;
 

	}
public static boolean  SettaConnesso(String username){

	       
        
        Connection con = DbConnection.db;
        
        Statement st;
        
        int rs;
        
 
        
        
        try {
            
            st = con.createStatement();
           
            rs = st.executeUpdate("UPDATE elencoutenti SET connessione= 1 WHERE elencoutenti.username='"+username+"' "); 
          
                return true;
                
                		
             
        } catch (SQLException ex) {
        
        }
		return false;
 

	}
public static int getAttUt(String username){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int bloc = 1;
    
    try {
        
        st = con.createStatement();
       
        rs = st.executeQuery("SELECT attivita FROM elencoutenti WHERE elencoutenti.username='"+username+"' "); 
      
            rs.next();
            bloc=rs.getInt("attivita");
            		
        return bloc; 
    } catch (SQLException ex) {
    
    }
    return bloc;


}



	public static int getBlcUt(String username){

	       
        
        Connection con = DbConnection.db;
        
        Statement st;
        
        ResultSet rs;
        
 
        int bloc = 1;
        
        try {
            
            st = con.createStatement();
           
            rs = st.executeQuery("SELECT bloccato FROM elencoutenti WHERE elencoutenti.username='"+username+"' "); 
          
                rs.next();
                bloc=rs.getInt("bloccato");
                		
            return bloc; 
        } catch (SQLException ex) {
        
        }
        return bloc;


	}
	 public static int getModUt(String username){

	       
	        
	        Connection con = DbConnection.db;
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	        int mod = 1;
	        
	        try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT modificato FROM elencoutenti WHERE elencoutenti.username='"+username+"' "); 
	          
	                rs.next();
	                mod=rs.getInt("modificato");
	                		
	            return mod; 
	        } catch (SQLException ex) {
	        
	        }
	        return mod;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public static int getidTess(String username){

	       
	        
	        Connection con = DbConnection.db;
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	        int ris=1;
	        
	        try {
	            
	            st = con.createStatement();
	           
	            rs = st.executeQuery("SELECT tesserato.Matricolatesserato FROM tesserato,elencoutenti WHERE elencoutenti.username='"+username+"' AND elencoutenti.idutente=tesserato.idutente"); 
	          
	                rs.next();
	                ris=rs.getInt("Matricolatesserato");
	                		
	            return ris; 
	        } catch (SQLException ex) {
	        
	        }
	        return ris;

	}
	 public static float getcosto(String evento ){
		   
	     Connection con = DbConnection.db;
	 
	     Statement st;
	     
	     ResultSet rs;
	     

	  Float ris = null;
	     
	     try {
	         
	         st = con.createStatement();
	       
	         rs = st.executeQuery("select costoevento from evento where nomeevento='"+evento+"';  "); 
	         rs.next();	               
	         ris=rs.getFloat("costoevento");    
	         return ris;
	     } 
	     
	     catch (SQLException ex) {
	     	
	     }
			
	     return ris;}
	 
	 public static float getcostoatt(String disciplina,String livello ){
		   
	     Connection con = DbConnection.db;
	 
	     Statement st;
	     
	     ResultSet rs;
	     

	  Float ris = null;
	     
	     try {
	         
	         st = con.createStatement();
	       
	         rs = st.executeQuery("select costomensile from disciplinedisponibili where disciplina='"+disciplina+"' and livello ='"+livello+"';  "); 
	         rs.next();	               
	         ris=rs.getFloat("costomensile");    
	         return ris;
	     } 
	     
	     catch (SQLException ex) {
	     	
	     }
			
	     return ris;
	     }
	  public static int getlastorder(String num){
	       	 Connection con = DbConnection.db;
		        
		        Statement st;
		        
		        ResultSet rs;
		        
		       
		        int ris=1;
		        
		        try {
		            
		            st = con.createStatement();
		           
		            rs = st.executeQuery("select iscrizionedisciplina.codiceiscrizionedisciplina from iscrizionedisciplina WHERE iscrizionedisciplina.dataazione='"+num+"'"); 
		           
		                rs.next();     
		                ris=rs.getInt("codiceiscrizionedisciplina");
		                		
		            return ris; 
		        } catch (SQLException ex) {
		           
		        }
		        return ris;
	       }
	  
	    public static String getDate(){
		 	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		 	   new Date();
		 	   Calendar cal = Calendar.getInstance();
		 	  
		 	   String data=dateFormat.format(cal.getTime());
		 	   return data;
		 	}
	    
	    
	    public static String getDateOnly(){
		 	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

		 	   new Date();
		 	   Calendar cal = Calendar.getInstance();
		 	  
		 	   String data=dateFormat.format(cal.getTime());
		 	   return data;
		 	}
	    
	    
 public static int getcombinazionelivdis(String disciplina , String livello){
   
	        Connection con = DbConnection.db;
	    
	        Statement st;
	        
	        ResultSet rs;
	        
	 
	      int ris=-1;
	        
	        try {
	            
	            st = con.createStatement();
	          
	            rs = st.executeQuery("select combinazionelivdis from disciplinedisponibili where Disciplina='"+disciplina+"' and Livello='"+livello+"'  "); 
	            rs.next();	               
	            ris=rs.getInt("combinazionelivdis");    
	            return ris;
	        } 
	        
	        catch (SQLException ex) {
	        	
	        }
			
	        return ris;

	}
 public static int getcomb(String disciplina , String livello,int tesserato){
	   
     Connection con = DbConnection.db;
 
     Statement st;
     
     ResultSet rs;
     

   int ris=-1;
     
     try {
         
         st = con.createStatement();
       
         rs = st.executeQuery("select combinazionelivdis from iddet where combinazionelivdis="+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"and tesserato='"+tesserato+"'"); 
         rs.next();	               
         ris=rs.getInt("combinazionelivdis");    
         return ris;
     } 
     
     catch (SQLException ex) {
     	
     }
		
     return ris;

}
	    
 public static int getidIstr(String username){

     
     
     Connection con = DbConnection.db;
     
     Statement st;
     
     ResultSet rs;
     

     int ris=1;
     
     try {
         
         st = con.createStatement();
        
         rs = st.executeQuery("SELECT istruttore.matricolaistruttore FROM istruttore,elencoutenti WHERE elencoutenti.username='"+username+"' AND elencoutenti.idutente=istruttore.idutente"); 
       
             rs.next();
             ris=rs.getInt("matricolaistruttore");
             		
         return ris; 
     } catch (SQLException ex) {
     
     }
     return ris;

}
public static int getcodiceturno(String fasciaor,String giornoset, String spazio ){

     
     
     Connection con = DbConnection.db;
     
     Statement st;
     
     ResultSet rs;
     

     int ris=1;
     
     try {
         
         st = con.createStatement();
        
         rs = st.executeQuery("SELECT codiceturno from gestioneturno WHERE fasciaoraria='"+fasciaor+"' AND giornosettimana='"+giornoset+"' AND spazio='"+spazio+"'"); 
       
             rs.next();
             ris=rs.getInt("codiceturno");
             		
         return ris; 
     } catch (SQLException ex) {
     
     }
     return ris;

}

public static int getcodiceturnoevento(String fasciaor,String giornoset, String spazio ){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=1;
    
    try {
        
        st = con.createStatement();
       
        rs = st.executeQuery("SELECT codiceturnoevento from gestioneturnoevento WHERE giornosettimana='"+giornoset+"' AND fasciaoraria='"+fasciaor+"' AND spazio='"+spazio+"'"); 
      
            rs.next();
            ris=rs.getInt("codiceturnoevento");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}

public static int getiddet3(String disciplina,String livello,int tesserato,String giorno,String orario){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    
    int comb= GetInfoDB.getcombinazionelivdis(disciplina, livello);
    int ris=0;
    
    try {
        
        st = con.createStatement();

      
   //   JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, " '"+a+"','"+disciplina+"','"+livello+"','"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' "," ",JOptionPane.WARNING_MESSAGE);				
        rs = st.executeQuery("SELECT iddet FROM detiscr WHERE tesserato='"+tesserato+"' and combinazionelivdis= '"+comb+"' and giorno= '"+giorno+"' and orario='"+orario+"' "); 
      
            rs.next();
            ris=rs.getInt("iddet");
            		
        return ris; 
    } catch (SQLException ex) {
   	 JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame,"GetIDDET "+ ex+"");
    }
    return ris;

}
 
 
public static int getiddet(String disciplina,String livello,int tesserato,String giorno,String orario){

     
     
     Connection con = DbConnection.db;
     
     Statement st;
     
     ResultSet rs;
     

     int ris=0;
     
     try {
         
         st = con.createStatement();

       
    //   JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, " '"+a+"','"+disciplina+"','"+livello+"','"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' "," ",JOptionPane.WARNING_MESSAGE);				
         rs = st.executeQuery("SELECT iddet FROM detiscr WHERE tesserato='"+tesserato+"' and combinazionelivdis= '"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' and giorno= '"+giorno+"' and orario='"+orario+"' "); 
       
             rs.next();
             ris=rs.getInt("iddet");
             		
         return ris; 
     } catch (SQLException ex) {
    	 JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame,"GetIDDET "+ ex+"");
     }
     return ris;

}
public static int getiddet2(String disciplina,String livello,int tesserato){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=0;
    
    try {
        
        st = con.createStatement();

      int comb= GetInfoDB.getcombinazionelivdis(disciplina, livello);
   //   JOptionPane.showMessageDialog(FrameDettagliDaAccResp.frame, " '"+a+"','"+disciplina+"','"+livello+"','"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"' "," ",JOptionPane.WARNING_MESSAGE);				
        rs = st.executeQuery("SELECT iddet FROM detiscr WHERE tesserato='"+tesserato+"' and combinazionelivdis='"+comb+"';  "); 
      
            rs.next();
            ris=rs.getInt("iddet");
            		
        return ris; 
    } catch (SQLException ex) {
   	 JOptionPane.showMessageDialog(FrameAttivitaTes.frame,"GetIDDET "+ ex+"");
    }
    return ris;

}
public static int getconf(String disciplina,String livello,String giorno, String orario){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select codiceturno from gestioneturno where fasciaoraria='"+orario+"' and Giornosettimana='"+giorno+"' and Combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"'");
      
            rs.next();
            ris=rs.getInt("codiceturno");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}



public static int getcodiceturno2(String disciplina,String livello,String giorno, String orario){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select codiceturno from gestioneturno where fasciaoraria='"+orario+"' and Giornosettimana='"+giorno+"' and Combinazionelivdis='"+GetInfoDB.getcombinazionelivdis(disciplina, livello)+"'");
      
            rs.next();
            ris=rs.getInt("codiceturno");
            		
        return ris; 
    } catch (SQLException ex) {
    	JOptionPane.showMessageDialog(FrameInserisciTurno.frame,"Getcodiceturno2 "+ ex+"");
    }
    return ris;

}
public static int getprenotazioniev(int codiceturno){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select prenotazionidisponibili from gestioneturnoevento where codiceturnoevento='"+codiceturno+"'");
      
            rs.next();
            ris=rs.getInt("prenotazionidisponibili");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}


public static int getprenotazioni(int codiceturno){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select prenotazionidisponibili from gestioneturno where codiceturno='"+codiceturno+"';");
      
            rs.next();
            ris=rs.getInt("prenotazionidisponibili");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}
public static String getPath(String nomedisc){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    String ris="";
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("SELECT immagine from disciplina  where nomedisciplina='"+nomedisc+"' ; ");
      
            rs.next();
            ris=rs.getString("immagine");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}
 
 

 
public static int getprenotazionievento(Object codiceturno){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select prenotazionidisponibili from gestioneturnoevento where codiceturnoevento='"+codiceturno+"'");
      
            rs.next();
            ris=rs.getInt("prenotazionidisponibili");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}
 

public static int getprenotazionievento1(Object codiceturno){

    
    
    Connection con = DbConnection.db;
    
    Statement st;
    
    ResultSet rs;
    

    int ris=-1;
    
    try {
        
        st = con.createStatement();
     
				
        rs = st.executeQuery("select prenotazionidisponibili from gestioneturnoevento where evento='"+codiceturno+"'");
      
            rs.next();
            ris=rs.getInt("prenotazionidisponibili");
            		
        return ris; 
    } catch (SQLException ex) {
    
    }
    return ris;

}

	    
}
