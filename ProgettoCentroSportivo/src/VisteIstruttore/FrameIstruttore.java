package VisteIstruttore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAOIstruttore.ElencoAttDAO;
import ClassiDAOIstruttore.ElencoEventiDAO;
import ClassiDAOIstruttore.EliminaAttDAO;
import ClassiDAOIstruttore.EliminaEventoDAO;

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
import java.awt.event.KeyListener;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


import ClassiDao.ElencoDisciplineDAO;
import ClassiDao.GetInfoDB;
import ClassiDao.UtenteDao;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import ModelliTabelle.ModDiscIni;
import ModelliTabelleIstruttore.ModElAttIstr;
import ModelliTabelleIstruttore.ModElEventiIstr;
import VisteUtenteGenerico.DetDisciplina;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.FrameLogin;
import Listener.Listen;
import Model.Utente;

import javax.swing.JScrollPane;

public class FrameIstruttore extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel contentPane,tabellaPnl,tabellaPnl2,bottoniPnl1,bottoniPnl2;
	public static JTable table,table2;
    private ModElEventiIstr model;
    private ModElAttIstr model2;
	
	

	/**
	 * Create the frame.
	 */
	public FrameIstruttore() {
		frame = new JFrame();
		String username=""+Utente.getUsername()+"";
		frame.setTitle("Benvenuto istruttore "+username+"");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("home");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("visualizza");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("iniistr");
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CambiaPassword");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameCambia();
				frame.setEnabled(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Inserisci un nuovo evento");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameInserisciEv();
				frame.dispose();
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Inserisci una nuova attività");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameInserisciAtt();
				frame.dispose();
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (64,224,208));
		contentPane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		JLabel lblEventi = new JLabel("Elenco dei tuoi eventi");
		lblEventi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventi.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblEventi, gbc);
		int matricola = GetInfoDB.getidIstr(username);
		
		table = new JTable();
		model = new ModElEventiIstr(ElencoEventiDAO.elencoiniziale(matricola));
		table.setRowHeight(20);
		table.setRowHeight(3, 50);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		
		Dimension d = table.getPreferredSize();
		table.setPreferredSize(d);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =3;
				
		bottoniPnl1 = new JPanel();
		
		JButton btnNewButton = new JButton("Dettagli Evento");
		btnNewButton.setMnemonic('c');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				new DetEv();
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 6;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl1.add(btnNewButton,gbc);
		
		
		JButton btnNewButton3 = new JButton("Modifica Evento");
		btnNewButton3.setMnemonic('d');
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				new FrameModificaEv();
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 6;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl1.add(btnNewButton3,gbc);
		
		JButton btnNewButton4 = new JButton("Elimina Evento");
		btnNewButton4.setMnemonic('e');
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				EliminaEventoDAO.eliminaevento((String) FrameIstruttore.table.getValueAt(FrameIstruttore.table.getSelectedRow(), 0));
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		gbc.gridy = 6;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl1.add(btnNewButton4,gbc);
	
		JButton btnNewButton8 = new JButton("Elenco Iscritti all'evento");
		btnNewButton8.setMnemonic('l');
		btnNewButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				EliminaEventoDAO.eliminaevento((String) FrameIstruttore.table.getValueAt(FrameIstruttore.table.getSelectedRow(), 0));
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 3;
		gbc.gridy = 6;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl1.add(btnNewButton8,gbc);
		
		
		
		
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(3, 1));
		tabellaPnl.add(table.getTableHeader());
		tabellaPnl.add(table);
		tabellaPnl.add(bottoniPnl1,gbc);
		contentPane.add(tabellaPnl, gbc);
		

		
		
		JLabel lblDisc = new JLabel("Elenco delle tue attività");
		lblDisc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisc.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 7;
		contentPane.add(lblDisc, gbc);
		
		table2 = new JTable();
		model2 = new ModElAttIstr(ElencoAttDAO.elencoiniziale(matricola));
		table2.setRowHeight(20);
		table2.setRowHeight(3, 50);
		table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table2.setCellSelectionEnabled(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setModel(model2);
		
		Dimension e = table2.getPreferredSize();
		table2.setPreferredSize(e);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =8;
        bottoniPnl2 = new JPanel();
		
		JButton btnNewButton5 = new JButton("Dettagli Attività");
		btnNewButton5.setMnemonic('f');
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1)
				new DetAtt();
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 9;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl2.add(btnNewButton5,gbc);
		
		
		JButton btnNewButton6 = new JButton("Modifica Attività");
		btnNewButton6.setMnemonic('g');
		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1)
				new FrameModificaAtt();
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 9;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl2.add(btnNewButton6,gbc);
		
		JButton btnNewButton7 = new JButton("Elimina Attività");
		btnNewButton7.setMnemonic('i');
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1)
				{
					
				    EliminaAttDAO.eliminaatt(ClassiDao.GetInfoDB.getcombinazionelivdis((String) FrameIstruttore.table2.getValueAt(FrameIstruttore.table2.getSelectedRow(), 0),(String) FrameIstruttore.table2.getValueAt(FrameIstruttore.table2.getSelectedRow(), 1)));}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		gbc.gridy = 9;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl2.add(btnNewButton7,gbc);
	
		JButton btnNewButton10 = new JButton(" Elenco Iscritti all'attività");
		btnNewButton10.setMnemonic('m');
		btnNewButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				EliminaEventoDAO.eliminaevento((String) FrameIstruttore.table.getValueAt(FrameIstruttore.table.getSelectedRow(), 0));
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 3;
		gbc.gridy = 9;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl2.add(btnNewButton10,gbc);
		
		
		
		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new GridLayout(3 , 1));
		tabellaPnl2.add(table2.getTableHeader());
		tabellaPnl2.add(table2);
		tabellaPnl2.add(bottoniPnl2,gbc);
		contentPane.add(tabellaPnl2, gbc);
	
	}
}
