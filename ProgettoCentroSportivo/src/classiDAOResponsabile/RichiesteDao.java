package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DBInterfaccia.DbConnection;

import Model_Responsabile.ModelRichiestaIscrizione;

public class RichiesteDao {
	
	
	
private static RichiesteDao instance;
	
	public static synchronized RichiesteDao getInstance() {
		if(instance==null)
			instance=new RichiesteDao();
		return instance;
	}
	
	
	public static ArrayList<ModelRichiestaIscrizione> elencoiniziale() {
		
		
        ArrayList<ModelRichiestaIscrizione> dati= new ArrayList<ModelRichiestaIscrizione>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT iscrizionedisciplina.codiceiscrizionedisciplina,iscrizionedisciplina.dataazione,iscrizionedisciplina.tesserato,iscrizionedisciplina.modalitapagamento,iscrizionedisciplina.prezzotot,iscrizionedisciplina.Confermato,iscrizionedisciplina.Annullato,modificato from iscrizionedisciplina ; ");
       
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext())  {
        	String[] riga = i.next();
        	
        	ModelRichiestaIscrizione fa=new ModelRichiestaIscrizione(); 	
        	fa.setCodiceiscrizionedisciplina(Integer.parseInt(riga[0]));
        	fa.setDataazione(riga[1]);
        	fa.setTesserato(Integer.parseInt(riga[2]));
        	fa.setModalitapagamento(riga[3]); 
        	fa.setPrezzotot(Integer.parseInt(riga[4])); 
        	fa.setConfermato(Integer.parseInt(riga[5])); 
        	fa.setAnnullato(Integer.parseInt(riga[6])); 
        	fa.setModificato(Integer.parseInt(riga[7])); 
       
      
        	
        	
        	
        	dati.add(fa);
        }
        return dati;
	}
	
public static ArrayList<ModelRichiestaIscrizione> elencoconfermati() {
		
		
        ArrayList<ModelRichiestaIscrizione> dati= new ArrayList<ModelRichiestaIscrizione>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT iscrizionedisciplina.codiceiscrizionedisciplina,iscrizionedisciplina.dataazione,iscrizionedisciplina.tesserato,iscrizionedisciplina.modalitapagamento,iscrizionedisciplina.prezzotot,iscrizionedisciplina.Confermato,iscrizionedisciplina.Annullato,modificato from iscrizionedisciplina where Confermato= 1 ; ");
       
        Iterator<String[]> i = res.iterator();
       
        while(i.hasNext())  {
        	String[] riga = i.next();
        	
        	ModelRichiestaIscrizione fa=new ModelRichiestaIscrizione(); 	
        	fa.setCodiceiscrizionedisciplina(Integer.parseInt(riga[0]));
        	fa.setDataazione(riga[1]);
        	fa.setTesserato(Integer.parseInt(riga[2]));
        	fa.setModalitapagamento(riga[3]); 
        	fa.setPrezzotot(Integer.parseInt(riga[4])); 
        	fa.setConfermato(Integer.parseInt(riga[5])); 
        	fa.setAnnullato(Integer.parseInt(riga[6])); 
        	fa.setModificato(Integer.parseInt(riga[7])); 
       
      
        	
        	
        	
        	dati.add(fa);
        }
        return dati;
	}
	
	
public static ArrayList<ModelRichiestaIscrizione> elencodaconf() {
	
	
    ArrayList<ModelRichiestaIscrizione> dati= new ArrayList<ModelRichiestaIscrizione>(); 
    
    Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT iscrizionedisciplina.codiceiscrizionedisciplina,iscrizionedisciplina.dataazione,iscrizionedisciplina.tesserato,iscrizionedisciplina.modalitapagamento,iscrizionedisciplina.prezzotot,iscrizionedisciplina.Confermato,iscrizionedisciplina.Annullato,modificato from iscrizionedisciplina where Confermato=0 and Modificato=0 ; ");
   
    Iterator<String[]> i = res.iterator();
   
    while(i.hasNext())  {
    	String[] riga = i.next();
    	
    	ModelRichiestaIscrizione fa=new ModelRichiestaIscrizione(); 	
    	fa.setCodiceiscrizionedisciplina(Integer.parseInt(riga[0]));
    	fa.setDataazione(riga[1]);
    	fa.setTesserato(Integer.parseInt(riga[2]));
    	fa.setModalitapagamento(riga[3]); 
    	fa.setPrezzotot(Integer.parseInt(riga[4])); 
    	fa.setConfermato(Integer.parseInt(riga[5])); 
    	fa.setAnnullato(Integer.parseInt(riga[6])); 
    	fa.setModificato(Integer.parseInt(riga[7])); 
   
  
    	
    	
    	
    	dati.add(fa);
    }
    return dati;
}	
	
public static ArrayList<ModelRichiestaIscrizione> elencomod() {
	
	
    ArrayList<ModelRichiestaIscrizione> dati= new ArrayList<ModelRichiestaIscrizione>(); 
    
    Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT iscrizionedisciplina.codiceiscrizionedisciplina,iscrizionedisciplina.dataazione,iscrizionedisciplina.tesserato,iscrizionedisciplina.modalitapagamento,iscrizionedisciplina.prezzotot,iscrizionedisciplina.Confermato,iscrizionedisciplina.Annullato,modificato from iscrizionedisciplina where modificato=1 and confermato=0; ");
   
    Iterator<String[]> i = res.iterator();
   
    while(i.hasNext())  {
    	String[] riga = i.next();
    	
    	ModelRichiestaIscrizione fa=new ModelRichiestaIscrizione(); 	
    	fa.setCodiceiscrizionedisciplina(Integer.parseInt(riga[0]));
    	fa.setDataazione(riga[1]);
    	fa.setTesserato(Integer.parseInt(riga[2]));
    	fa.setModalitapagamento(riga[3]); 
    	fa.setPrezzotot(Integer.parseInt(riga[4])); 
    	fa.setConfermato(Integer.parseInt(riga[5])); 
    	fa.setAnnullato(Integer.parseInt(riga[6])); 
    	fa.setModificato(Integer.parseInt(riga[7])); 
   
  
    	
    	
    	
    	dati.add(fa);
    }
    return dati;
}
	
}
