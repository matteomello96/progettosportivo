package view_tesserato;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import ClassiDAOIstruttore.ElencoEventiDAO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


import ClassiDao.ElencoDisciplineDAO;
import ClassiDao.GetInfoDB;
import ClassiDao.UtenteDao;
import ClassiDaoTesserato.ElencoEventiTessDAO;
import ClassiDaoTesserato.eventoesistedao;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import ModelliTabelle.ModDiscIni;
import ModelliTabelleIstruttore.ModElEventiIstr;
import ModelliTabelle_Tesserato.ModElEventiTes;
import ModelliTabelle_Tesserato.controlloevento;
import VisteUtenteGenerico.DetDisciplina;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.FrameLogin;
import Listener.Listen;
import Model.Utente;
import Model_Tesserato.ElencoEventiTes;

import javax.swing.JScrollPane;

public class FrameEventi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel contentPane,tabellaPnl,bottoniPnl1;
	public static JTable table;
	
	public static JTable table2;
    private ModElEventiTes model;
    private controlloevento model1;
    public static JTable table_1;
    public static JButton Aggiungi;
    public static JButton rimuovi;
    public static JButton svuotacarrello;
    public static JButton invia;


	

	/**
	 * Create the frame.
	 */
	public FrameEventi() {
		frame = new JFrame();
		
		frame.setTitle("Frame Eventi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("home");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnNewMenu_1 = new JMenuItem("visualizza");
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new frameviseventi();
				frame.setEnabled(false);
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("iniistr2");
		                                                                                                            

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		JLabel lblEventi = new JLabel("Elenco dei tuoi eventi");
		lblEventi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEventi.setForeground(Color.BLACK);
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.gridx = 4;
		gbc.gridy = 0;
		contentPane.add(lblEventi, gbc);
		
		
		table = new JTable();
		model = new ModElEventiTes(ElencoEventiTessDAO.elencoiniziale());
		table.setRowHeight(20);
		table.setRowHeight(3, 50);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		
		Dimension d = table.getPreferredSize();
		table.setPreferredSize(d);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =2;
		gbc.gridy =0;
		
		bottoniPnl1 = new JPanel();
		
		
		
		
		
table_1 = new JTable();
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome Evento","Descrizione","TipoEvento","Nome istruttore","Cognome istruttore","Disciplina","Livello","Costo Evento","Codice Evento"
			}
		){
			
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class,String.class, String.class, String.class, String.class, Integer.class , Integer.class
					
				};
			
				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				
			
		});
		
	
		table_1.setAutoCreateRowSorter(true);
		
		
		
		JScrollPane pane = new JScrollPane(table_1);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 7;
		gbc.gridy = 4;
		contentPane.add(pane, gbc);
		
	
		 
		
		
		JButton btnNewButton = new JButton("Dettagli Evento");
		btnNewButton.setMnemonic('d');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				new DetEvTes();
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 6;
		bottoniPnl1.add(btnNewButton,gbc);
		
		
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(3, 1));
		tabellaPnl.add(table.getTableHeader());
		tabellaPnl.add(table);
		tabellaPnl.add(bottoniPnl1,gbc);
		contentPane.add(tabellaPnl, gbc);
		
		
		
		Aggiungi = new JButton("Aggiungi");
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 5, 0);
		gbc.gridx = 2;
		gbc.gridy = 7;
		contentPane.add(Aggiungi,gbc);
		
		
		rimuovi = new JButton("rimuovi");
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 7;
		contentPane.add(rimuovi, gbc);
		
		table2 = new JTable();
		model1 = new controlloevento(eventoesistedao.elencoiniziale());
		table2.setModel(model1);
		int tess;
		tess= GetInfoDB.getidTess(Utente.getUsername());
		
		Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			
			int i;
				
				
				int esci=0;
				int b;
				int prenotazioni,codice;
				
				codice=(int) table.getValueAt(table.getSelectedRow(), 8);
				prenotazioni=GetInfoDB.getprenotazionievento1(codice);
				for(i=0;i<table2.getRowCount();i++){
					b= (int) table2.getValueAt(i, 1);
			if(table2.getValueAt(i, 0)==table.getValueAt(table.getSelectedRow(), 8) && b==tess){
				
				
				esci=1;
			}
				
			
				}		
	
				if(esci==1){
					
					JOptionPane.showMessageDialog(FrameEventi.frame, " evento già prenotato!!");
				}
				else{
				if(table.getSelectedRow()!=-1){
				Object[] dati = new Object[9];

				dati[0]=table.getValueAt(table.getSelectedRow(), 0);
				dati[1]=table.getValueAt(table.getSelectedRow(), 1);				
				dati[2]=table.getValueAt(table.getSelectedRow(), 2);
				dati[3]=table.getValueAt(table.getSelectedRow(), 3);
				dati[4]=table.getValueAt(table.getSelectedRow(), 4);
				dati[5]=table.getValueAt(table.getSelectedRow(), 5);
				dati[6]=table.getValueAt(table.getSelectedRow(), 6);
				dati[7]=table.getValueAt(table.getSelectedRow(), 7);
				dati[8]=table.getValueAt(table.getSelectedRow(), 8);
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				

				
				boolean u=true;
				int c;
				
				for(c=0;c<table_1.getRowCount();c++)
				{
				if(table_1.getRowCount()>=1){
						//if(table.getValueAt(table.getSelectedRow(), 5).equals(table_1.getValueAt(c, 5))&&
							//	table.getValueAt(table.getSelectedRow(), 6).equals(table_1.getValueAt(c, 6)))
					if(table.getValueAt(table.getSelectedRow(), 8).equals(table_1.getValueAt(c, 8)))
						{
							u=false;
							break;
						}

					}

				}
				if(u)
				{
				if(prenotazioni==0)	{
					JOptionPane.showMessageDialog(FrameEventi.frame, "Numero massimo prenotazioni raggiunto!!",null,JOptionPane.WARNING_MESSAGE);
				}
				else{
				modello.addRow(dati);
				}
				}
				
				else{
					
					JOptionPane.showMessageDialog(FrameEventi.frame, "Non è possibile Aggiungere lo stesso evento",null,JOptionPane.WARNING_MESSAGE);
				}
				}
				}
			}
		});
		
		
		rimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRow()!=-1){
				modello.removeRow(table_1.getSelectedRow());
				}
			}
		});
		
		
		 svuotacarrello = new JButton("svuotacarrello");
		   
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 6;
			gbc.gridy = 7;
			contentPane.add(svuotacarrello, gbc);
			
			
			svuotacarrello.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
					for(int x=modello.getRowCount()-1;x>=0;x--)
					{
						modello.removeRow(x);
					}
				}
			});
			
			
			
			  invia = new JButton("invia");

	
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = 8;
				gbc.gridy = 7;
				invia.setEnabled(false);
				contentPane.add(invia, gbc);
				
				
				
				invia.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						frame.setEnabled(false);
						new sendeventframe();
						sendeventframe.frame.setVisible(true);
				
						
					}
				});

				
				
				table_1.getModel().addTableModelListener(new TableModelListener(){
					public void tableChanged(TableModelEvent e) {
					
					
					
						
						
					
						
						
						if(table_1.getModel().getRowCount()>0)
							invia.setEnabled(true);
						else table_1.setEnabled(false);
						if(table_1.getModel().getRowCount()<1)
							invia.setEnabled(false);	
						
						
					}});
		
	}
	

}
