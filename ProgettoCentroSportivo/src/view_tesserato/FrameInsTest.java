package view_tesserato;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

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
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new GridBagLayout());
		
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel lblNewLabel = new JLabel("Inserisci Testimonianze");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		
		
		JLabel lblDatiDisc = new JLabel("Dati sulle discipline disponibili");
		lblDatiDisc.setOpaque(true);
		
		lblDatiDisc.setForeground(new Color(255, 255, 255));
		lblDatiDisc.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(lblDatiDisc, gbc);
			
		int matricola=GetInfoDB.getidTess(Utente.getUsername());
		
		
		table1 = new JTable();
		model1 = new ModLivDis(ElencoLivDisTesDAO.elencoiniziale(matricola));
		table1.setRowHeight(20);
		table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table1.setCellSelectionEnabled(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.setModel(model1);
		tablemod = setupTableWidths.setupTableWidths(table1);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));
		
		JScrollPane scrollt1 = new JScrollPane();

		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBackground(new Color(255, 193, 20));
		scrollt1.setViewportView(tablemod);
		gbc.gridx =0;
		gbc.gridy =0;
		contentPane.add(scrollt1, gbc);
		
		
		JLabel lblNewLabel_3 = new JLabel("Inserisci la tua testimonianza");
			lblNewLabel_3.setForeground(Color.black);
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridwidth = 4;
			gbc.gridx = 1;
			gbc.gridy = 1;
			contentPane.add(lblNewLabel_3, gbc);
			
		
		
		
		
		
		JEditorPane editorPane = new JEditorPane();
		
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane.setText("Scrivi un commento...");
		gbc.gridwidth = 7;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		contentPane.add(editorPane, gbc);
		
		
			
			
			
				
				JButton bottone = new JButton("Invia testimonianza");
				
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = 5;
				gbc.gridy = 4;
				contentPane.add(bottone, gbc);

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
	
	
	
	}

}
