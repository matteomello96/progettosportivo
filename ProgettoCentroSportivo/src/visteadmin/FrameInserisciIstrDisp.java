package visteadmin;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent.KeyBinding;
import javax.swing.tree.TreeSelectionModel;

import ClassiDAOIstruttore.ElencoLivDisDAO;
import ClassiDAOIstruttore.InserisciAttDAO;
import ClassiDAOIstruttore.InserisciEventoDAO;
import Listener.Listen;
import Model.Home;
import Model.Utente;
import Model_Responsabile.DettagliIstruttore;
import ModelliTabelle.ModDetLiv;
import ModelliTabelleIstruttore.ComboDis;
import ModelliTabelleIstruttore.ComboLivelloIs;
import ModelliTabelleIstruttore.ComboSpazio;
import ModelliTabelleIstruttore.ComboSpazioAltro;
import ModelliTabelleRespo.ModLivDis;
import ModelliTabelleRespo.ModDetIstr;
import ModelliTabelleRespo.ModIstrDisp;
import VisteUtenteGenerico.*;
import classiDAOResponsabile.InserisciCombIstrDAO;
import classiDAOResponsabile.ElencoDiscLivDispDAO;
import classiDAOResponsabile.ElencoIstrDispDAO;
import classiDAOResponsabile.DettagliIstruttoreDAO;
import ClassiDao.DettagliLivelloDAO;
import ClassiDao.GetInfoDB;
import ClassiDao.Reg_dao;
import ComboTesserato.Comboliv;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Rectangle;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import classiDAOResponsabile.InserisciCombIstrDAO;






public class FrameInserisciIstrDisp extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,tabellaPnl,bottoniPnl;
	public ModLivDis model2;
	public ModDetIstr model1;
	public static JTable table1,table2;
	
	private boolean bool;
	
	
	
	public FrameInserisciIstrDisp( ) {
		
		frame = new JFrame("Inserimento istruttore disponibile");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci un nuovo istruttore disponibile");
		if(FrameInserisciIstrDisp.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciIstrDisp.frame.getLocation());
		
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (64,224,208));
		contentPane.setLayout(new GridBagLayout());
		 
		 GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Iniziale");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home_da_ins_istr");
		
		
		
		JLabel lblFormDiInserimento = new JLabel("Form di Inserimento dell'istruttore disponibile");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiInserimento, gbc);
		
		
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(3 , 2));
		
		JLabel lblISD = new JLabel("Elenco degli istruttori");
		lblISD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblISD.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx =1;
		gbc.gridy =1;
		tabellaPnl.add(lblISD);
		
		JScrollPane scrollt1 = new JScrollPane();
		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBounds(50, 30, 300, 50);
		
		
		model1 = new ModDetIstr(DettagliIstruttoreDAO.elencoistruttore());
		table1 = new JTable(model1);
		table1.setRowHeight(20);
		table1.setRowHeight(3, 50);
		table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table1.setCellSelectionEnabled(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension txy = table1.getPreferredSize();
		table1.setPreferredSize(txy);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =1;
		gbc.gridy =2;
			
			
		scrollt1.setPreferredSize(txy);
		scrollt1.setViewportView(table1);
		tabellaPnl.add(scrollt1);
		
		
		
		
		
		
		JLabel lblDD = new JLabel("Elenco delle discipline disponibili");
		lblDD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDD.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx =2;
		gbc.gridy =1;
		tabellaPnl.add(lblDD);
		
		JScrollPane scrollt2 = new JScrollPane();
		scrollt2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt2.setBounds(50, 30, 300, 50);
		
		
		model2 = new ModLivDis(ElencoDiscLivDispDAO.elencoiniziale());
		table2 = new JTable(model2);
		table2.setRowHeight(20);
		table2.setRowHeight(3, 50);
		table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table2.setCellSelectionEnabled(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension txyz = table2.getPreferredSize();
		table2.setPreferredSize(txyz);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =2;
		gbc.gridy =2;
			
			
		scrollt2.setPreferredSize(txyz);
		scrollt2.setViewportView(table2);
		tabellaPnl.add(scrollt2);
		
		
		bottoniPnl = new JPanel();
		
		
	  
		
		JButton btnNewButton12 = new JButton("Inserisci istruttore  disponibile");
		btnNewButton12.setMnemonic('h');
		btnNewButton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			if((table1.getSelectedRow()!=-1)&&(table2.getSelectedRow()!=-1))
			{
			
			bool = InserisciCombIstrDAO.inseriscicombis(((String) FrameInserisciIstrDisp.table1.getValueAt(FrameInserisciIstrDisp.table1.getSelectedRow(), 0)),((String) FrameInserisciIstrDisp.table1.getValueAt(FrameInserisciIstrDisp.table1.getSelectedRow(), 1)),((String) FrameInserisciIstrDisp.table2.getValueAt(FrameInserisciIstrDisp.table2.getSelectedRow(), 0)),((String) FrameInserisciIstrDisp.table2.getValueAt(FrameInserisciIstrDisp.table2.getSelectedRow(), 1)));
			}
					
			else{	
			JOptionPane.showMessageDialog(null, "Seleziona una combinazione dall'elenco","Errore combinazione",JOptionPane.WARNING_MESSAGE);
			}
			}			
			
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx =1;
		gbc.gridy =5;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl.add(btnNewButton12,gbc);
		
		Dimension o = bottoniPnl.getPreferredSize();
		bottoniPnl.setPreferredSize(o);
		
		
		tabellaPnl.add(bottoniPnl,gbc);
		Dimension sex= tabellaPnl.getPreferredSize();
		tabellaPnl.setPreferredSize(sex);
	
		contentPane.add(tabellaPnl,gbc);
		
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameGestione.frame.dispose();
			new FrameGestione();
			FrameGestione.frame.setVisible(true);
			FrameGestione.frame.setEnabled(true);	
	}	
								
		
				
		
	
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

