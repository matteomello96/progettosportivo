package view_dipendente;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;


import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeSelectionModel;



import ClassiDao.ElencoAttivitaDAO;
import ClassiDao.ElencoDisciplineDAO;
import Listener.Listen;
import Model.ElencoAttivita;
import ModelliTabelle.ModDiscIni;
import ModelliTabelle.disc_tabella;

public class FrameTesserato extends JPanel {
	private JTable table;
	private JTable table_1;
	public static JFrame frame;
	private JPanel contentPane;
	 private disc_tabella model;

	/**
	 * Create the panel.
	 */
	public FrameTesserato() {
		
		
		frame = new JFrame("Tesserato");
		frame.setTitle("Frame Tesserato");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
		
		JMenu mnNewMenu = new JMenu("home");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("ini");
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CambiaPassword");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(240, 240, 240));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 225, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{50, 0, 0, 21, 33, 96, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		table = new JTable();
		model = new disc_tabella(ElencoAttivitaDAO.elencoiniziale());
	 
	
		
		table.setCellSelectionEnabled(true);
		table.setModel(model);
		
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.fill = GridBagConstraints.HORIZONTAL;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.anchor = GridBagConstraints.NORTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		contentPane.add(table, gbc_table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Disciplina", "Livello", "MaxIscritti", "CostoMensile"
			}
		){
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class,Float.class
				};
				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			
		});
		table_1.setAutoCreateRowSorter(true);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridwidth = 4;
		gbc_table_1.insets = new Insets(0, 0, 5, 5);
		gbc_table_1.gridx = 4;
		gbc_table_1.gridy = 1;
		contentPane.add(table_1, gbc_table_1);
		JButton btnDettagliOrario = new JButton("Dettagli orario");
		GridBagConstraints gbc_btnDettagliOrario = new GridBagConstraints();
		gbc_btnDettagliOrario.insets = new Insets(0, 0, 5, 5);
		gbc_btnDettagliOrario.gridx = 1;
		gbc_btnDettagliOrario.gridy = 2;
		contentPane.add(btnDettagliOrario, gbc_btnDettagliOrario);

		JButton Aggiungi = new JButton("Aggiungi");
		GridBagConstraints gbc_Aggiungi = new GridBagConstraints();
		gbc_Aggiungi.gridwidth = 2;
		gbc_Aggiungi.insets = new Insets(0, 0, 5, 5);
		gbc_Aggiungi.gridx = 2;
		gbc_Aggiungi.gridy = 2;
		contentPane.add(Aggiungi, gbc_Aggiungi);
		Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
				Object[] dati = new Object[4];

				dati[0]=table.getValueAt(table.getSelectedRow(), 0);
				dati[1]=table.getValueAt(table.getSelectedRow(), 1);				
				dati[2]=table.getValueAt(table.getSelectedRow(), 2);
				dati[3]=table.getValueAt(table.getSelectedRow(), 3);
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				
				int c=0;
				boolean u=true;
				

				for(c=0;c<table_1.getRowCount();c++)
				{
					if(table_1.getRowCount()>=1){
						if(table.getValueAt(table.getSelectedRow(), 0).equals(table_1.getValueAt(c, 0))&&
								table.getValueAt(table.getSelectedRow(), 1).equals(table_1.getValueAt(c, 1)))
						{
							u=false;
							break;
						}

					}


				}
				
				int pdisp = (Integer) table.getValueAt(table.getSelectedRow(),2);
				if(pdisp==0){
					 JOptionPane.showMessageDialog(null, "Posti attualmente non disponibili");
					
				}
				else {
					if(u)
					{
						modello.addRow(dati);						
					}
				
					else{
				
					JOptionPane.showMessageDialog(null, "Non è possibile Aggiungere la stessa disciplina",null,JOptionPane.WARNING_MESSAGE);
					
					}
					}
				
				
				
				
				
				
				
				
				
				
				
				
				}
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		JButton rimuovi = new JButton("rimuovi");
		GridBagConstraints gbc_rimuovi = new GridBagConstraints();
		gbc_rimuovi.insets = new Insets(0, 0, 5, 5);
		gbc_rimuovi.gridx = 4;
		gbc_rimuovi.gridy = 2;
		contentPane.add(rimuovi, gbc_rimuovi);
		rimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRow()!=-1){
				modello.removeRow(table_1.getSelectedRow());
				}
			}
		});
		
		
		
		JButton svuotacarrello = new JButton("svuotacarrello");
		GridBagConstraints gbc_svuotacarrello = new GridBagConstraints();
		gbc_svuotacarrello.insets = new Insets(0, 0, 5, 5);
		gbc_svuotacarrello.gridx = 5;
		gbc_svuotacarrello.gridy = 2;
		contentPane.add(svuotacarrello, gbc_svuotacarrello);
		
		svuotacarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				for(int x=modello.getRowCount()-1;x>=0;x--)
				{
					modello.removeRow(x);
				}
			}
		});
		
		JButton invia = new JButton("invia");
		GridBagConstraints gbc_invia = new GridBagConstraints();
		gbc_invia.insets = new Insets(0, 0, 5, 5);
		gbc_invia.gridx = 6;
		gbc_invia.gridy = 2;
		contentPane.add(invia, gbc_invia);
	
	}

}


     





