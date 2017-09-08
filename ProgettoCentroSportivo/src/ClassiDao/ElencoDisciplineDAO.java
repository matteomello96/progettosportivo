package ClassiDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.mysql.jdbc.Blob;
import com.sun.javafx.collections.MappingChange.Map;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;

import Model.DisciplinaElenco;
import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.Rule;
import VisteUtenteGenerico.ScrollablePicture;
import visteIstruttore.FrameInserisciEv;
import DBInterfaccia.DbConnection;

public class ElencoDisciplineDAO {

	private static ElencoDisciplineDAO instance;
	
	public  static synchronized ElencoDisciplineDAO getInstance() {
		if(instance==null)
			instance=new ElencoDisciplineDAO();
		return instance;
	}
	
	public static   ArrayList<DisciplinaElenco> elencoiniziale()  {
		
		
        ArrayList<DisciplinaElenco> dati= new ArrayList<DisciplinaElenco>(); 
        
        Vector<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT DISTINCT C.NomeDisciplina,C.Descrizione,C.Calendario,C.Immagine from disciplina as C; ");
        
        Iterator<String[]> i = res.iterator();
        
        while((i.hasNext())) {
        	String[] riga = i.next();
            DisciplinaElenco d=new DisciplinaElenco(); 	
        	d.setNomeDisciplina(riga[0]);
        	d.setDescrizione(riga[1]);
        	d.setCalendario(riga[2]);
       
        	try{
        		File is = new File(riga[3]);
        		Image im2 = ImageIO.read(is);
          
        	//d.setA(riga[3]);
        	d.setImage(new ImageIcon(im2));}
        	
        	
        	
        	catch (IOException ex) {
        	    JOptionPane.showMessageDialog(FrameIniziale.frame, ex);
        	}
           
        	
        	
        	
        	dati.add(d);
        }
        return dati;
	}
	
}