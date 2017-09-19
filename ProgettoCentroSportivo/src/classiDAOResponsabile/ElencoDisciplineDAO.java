package classiDAOResponsabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import java.awt.Image;

import java.io.File;

import java.io.IOException;


import Model_Responsabile.ElencoDisc;
import VisteUtenteGenerico.FrameIniziale;
import DBInterfaccia.DbConnection;

public class ElencoDisciplineDAO {

	private static ElencoDisciplineDAO instance;
	
	public static synchronized ElencoDisciplineDAO getInstance() {
		if(instance==null)
			instance=new ElencoDisciplineDAO();
		return instance;
	}
	
	
	
	public static ArrayList<ElencoDisc> elencoiniziale() throws IOException {
		
		
        ArrayList<ElencoDisc> dati= new ArrayList<ElencoDisc>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT  C.NomeDisciplina,C.Descrizione,C.Calendario,C.immagine from disciplina as C ; ");
    
        Iterator<String[]> i = res.iterator();
        
        while((i.hasNext())) {
        	String[] riga = i.next();
        	
        	ElencoDisc d=new ElencoDisc(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setDescrizione(riga[1]);
        	d.setCalendario(riga[2]);
        	
        	try{
        		File is = new File(riga[3]);
        		Image im2 = ImageIO.read(is);
          
        	
        	d.setImage(new ImageIcon(im2));}
        	
        	
        	
        	catch (IOException ex) {
        	    JOptionPane.showMessageDialog(FrameIniziale.frame, ex);
        	}
           
        	
        	
        	
        }
        
        return dati;
	}
	
}