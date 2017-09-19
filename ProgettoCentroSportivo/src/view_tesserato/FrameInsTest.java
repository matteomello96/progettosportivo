package view_tesserato;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.TreeSelectionModel;

import ClassiDAOIstruttore.ElencoLivDisDAO;
import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.ElencoLivDisTesDAO;
import ClassiDaoTesserato.TestimnianzaDao;
import ClassiDaoTesserato.TriggerOrdine;
import ComboTesserato.Comboliv;
import ComboTesserato.Combotest;
import Model.Utente;
import VisteUtenteGenerico.setupTableWidths;
import listener.VariListener;
import modelliTabelleIstruttore.ModLivDis;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;

public class FrameInsTest extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public static JFrame frame;
	public static Combotest combotest;
	public static String disciplina;
	public static Comboliv comboliv;
	public static String livello;
	public static String commento;
	public JPanel contentPane;
	public static JTable table1,tablemod;
	public ModLivDis model1;
	
	
	
	public FrameInsTest() {
		
		frame = new JFrame("Testimonianze");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 705, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		
		
		
		ImageIcon im=new ImageIcon("src/immaginijava/bottone8.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone9.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo4.png");
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new BorderLayout());
		
		
		
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    
		
	    JPanel Panel1 = new JPanel();
		Panel1.setBackground(new Color(42,82,190));
		Panel1.setLayout(new GridBagLayout());
		
		
		
		
		
	    JPanel GPane1 = new JPanel();
		GPane1.setBackground(new Color (42,82,190));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Inserisci testimonianza"), BorderLayout.NORTH);		
		
		
			
		int matricola=GetInfoDB.getidTess(Utente.getUsername());
		
		
		table1 = new JTable();
		model1 = new ModLivDis(ElencoLivDisTesDAO.elencoiniziale(matricola));
		GPane1.add(VariListener.SettaScroll(table1,50,model1), BorderLayout.CENTER);
		
		
		JPanel Panel2 = new JPanel();
	  	Panel2.setLayout(new GridBagLayout());
	  	Panel2.setBackground(new Color (42,82,190));
	  	
	  	
	  	JLabel lblNewLabel_3 = new JLabel();
	  	VariListener.SettaLabelGen(Panel2,lblNewLabel_3, "inserisci la tua testimonianza", 0, 1);
			
		
		
		
		
		
	  	JTextField editorPane = new JTextField();
	  	editorPane.setText("Scrivi un commento...");
		VariListener.SettaTextField(Panel2, editorPane, "Inserisci", 1,1);
		VariListener.SettaFocus(editorPane);
		
			
			
			
				
		
		JPanel PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (42,82,190));
		
		 JButton bottone = new JButton(im);
		 JLabel lbl= new JLabel();
		
		  VariListener.SettaBtn(PanelBottom, bottone, lbl,"Inserisci commento", 1, 1,im2,true);

				bottone.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
					disciplina=	(String)table1.getValueAt(table1.getSelectedRow(), 0);
					livello=	(String)table1.getValueAt(table1.getSelectedRow(), 1);
		            int comb=GetInfoDB.getcombinazionelivdis(disciplina,livello);
		            JOptionPane.showMessageDialog(FrameInsTest.frame, comb +""+disciplina+""+livello+""," ",JOptionPane.INFORMATION_MESSAGE);
		        	TestimnianzaDao.instest(disciplina,livello,editorPane.getText(),matricola,comb);
		      
			
					}});
			
			
	frame.addWindowListener(new java.awt.event.WindowAdapter() {
		   @Override
		   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		    	if(FrameAttivitaTes.frame!=null)
		    		FrameAttivitaTes.frame.setEnabled(true);
		    
		    }
		});
	
	contentPane.add(GPane1,BorderLayout.NORTH);
	contentPane.add(Panel2,BorderLayout.CENTER);
	contentPane.add(PanelBottom,BorderLayout.SOUTH);
	
	
	
	}

}
