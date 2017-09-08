package visteIstruttore;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent.KeyBinding;
import javax.swing.tree.TreeSelectionModel;

import ClassiDAOIstruttore.ElencoLivDisDAO;
import ClassiDAOIstruttore.InserisciAttDAO;
import ClassiDAOIstruttore.InserisciEventoDAO;
import Model.Home;
import Model.Utente;
import ModelliTabelle.ModDetLiv;
import VisteUtenteGenerico.*;
import listener.Listen;
import modelliTabelleIstruttore.ComboDis;
import modelliTabelleIstruttore.ComboLivelloIs;
import modelliTabelleIstruttore.ComboSpazio;
import modelliTabelleIstruttore.ComboSpazioAltro;
import modelliTabelleIstruttore.ModLivDis;
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
import javax.swing.BorderFactory;
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






public class FrameInserisciAtt extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,tabellaPnl;
	public ModLivDis model1;
	public static JTable table1,tablemod;
	private JComboBox combofasciaor;
	private JComboBox combogiornoset;
	private JTextField comboprendisp;
	private boolean bool;
	public static ComboSpazioAltro combospazio;
	public static ComboDis combodis;
	public static ComboLivelloIs combolivellois;
	public String disciplina="";
	public String livello="";
	
	
	public FrameInserisciAtt() {
		
		frame = new JFrame("Inserimento attivit�");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci una nuova attivit�");
		if(FrameInserisciAtt.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciAtt.frame.getLocation());
		
		
		String username=""+Utente.getUsername()+"";
		int matricola = GetInfoDB.getidIstr(username);
	
		
		
		
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
		
		JMenu mnNewMenu = new JMenu("Torna alle attivit�");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alle attivit�");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home4");
		
		
		
		JLabel lblFormDiInserimento = new JLabel("Form di Inserimento dell'Attivit�");
		lblFormDiInserimento.setOpaque(true);
		Border bordo2 = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblFormDiInserimento.setBorder(bordo2);
		lblFormDiInserimento.setForeground(new Color(255, 255, 255));
		lblFormDiInserimento.setBackground(new Color(0, 133, 217));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiInserimento, gbc);
		
		JLabel lblDatiDisc = new JLabel("Dati sulle discipline disponibili");
		lblDatiDisc.setOpaque(true);
		lblDatiDisc.setBorder(bordo2);
		lblDatiDisc.setForeground(new Color(255, 255, 255));
		lblDatiDisc.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(lblDatiDisc, gbc);
				
		table1 = new JTable();
		model1 = new ModLivDis(ElencoLivDisDAO.elencoiniziale(matricola));
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
		gbc.gridy =3;
		contentPane.add(scrollt1, gbc);
		
		
	
		
		JLabel lblDatiorario = new JLabel("Dati sull'orario");
		lblDatiorario.setOpaque(true);
		lblDatiorario.setBorder(bordo2);
		lblDatiorario.setForeground(new Color(255, 255, 255));
		lblDatiorario.setBackground(new Color(0, 133, 217));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 5;
		contentPane.add(lblDatiorario, gbc);
		
		
		JLabel lblFasciaoraria = new JLabel("Fascia oraria");
		lblFasciaoraria.setOpaque(true);
		lblFasciaoraria.setBorder(bordo2);
		lblFasciaoraria.setForeground(new Color(255, 255, 255));
		lblFasciaoraria.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		contentPane.add(lblFasciaoraria, gbc);
		
		combofasciaor = new JComboBox();
		combofasciaor.setModel(new DefaultComboBoxModel(new String[] {"08:30-09:30","09:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","15:30-16:30","16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30",}));
		combofasciaor.setVisible(true);
		combofasciaor.setEnabled(true);
		combofasciaor.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 6;
		contentPane.add(combofasciaor, gbc);
		
		JLabel lblGiornoset = new JLabel("Giorno della settimana");
		lblGiornoset.setOpaque(true);
		lblGiornoset.setBorder(bordo2);
		lblGiornoset.setForeground(new Color(255, 255, 255));
		lblGiornoset.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 7;
		contentPane.add(lblGiornoset, gbc);
			
		combogiornoset = new JComboBox();
		combogiornoset.setModel(new DefaultComboBoxModel(new String[] {"lunedi","martedi","mercoledi","giovedi","venerdi","sabato"}));
		combogiornoset.setVisible(true);
		combogiornoset.setEnabled(true);
		combogiornoset.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 7;
		contentPane.add(combogiornoset, gbc);
		
	
		JLabel lblSpazio = new JLabel("Spazio");
		lblSpazio.setOpaque(true);
		lblSpazio.setBorder(bordo2);
		lblSpazio.setForeground(new Color(255, 255, 255));
		lblSpazio.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 8;
		contentPane.add(lblSpazio, gbc);
		
		combospazio = new ComboSpazioAltro();
		combospazio.setEnabled(true);
		combospazio.setVisible(true);
		combospazio.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 8;
		contentPane.add(combospazio, gbc);
		
		JLabel lblPrenDisp = new JLabel("Prenotazioni disponibili");
		lblPrenDisp.setOpaque(true);
		lblPrenDisp.setBorder(bordo2);
		lblPrenDisp.setForeground(new Color(255, 255, 255));
		lblPrenDisp.setBackground(new Color(245, 222, 179));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy =9;
		contentPane.add(lblPrenDisp, gbc);
		
		JLabel lblErrVia = new JLabel("Il campo non deve contenere lettere");
		lblErrVia.setOpaque(true);
		lblErrVia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrVia.setBackground(new Color(128, 0, 0));
		lblErrVia.setForeground(new Color(255, 255, 255));
		lblErrVia.setBounds(25, 30, 10, 10);
		lblErrVia.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(lblErrVia,gbc);
		
		comboprendisp = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(comboprendisp, gbc);
		comboprendisp.setColumns(10);
		
		
		comboprendisp.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrVia.setVisible(true);
                }
				else
				{
				lblErrVia.setVisible(false);
				}
		}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
		
		JButton btnRegistratiAlNostro = new JButton("Inserisci la nuova attivit�");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 14;
		contentPane.add(btnRegistratiAlNostro, gbc);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			

			lblPrenDisp.setForeground(Color.BLACK);
			lblPrenDisp.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		
		
		if(comboprendisp.getText().isEmpty())
		{
			
			
			if(comboprendisp.getText().isEmpty())
			{
				lblPrenDisp.setForeground(Color.RED);
				lblPrenDisp.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrVia.setText("Il campo � nullo");
				lblErrVia.setVisible(true);
			}
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
	
			bool=InserisciAttDAO.registraatt((String)FrameInserisciAtt.table1.getValueAt(FrameInserisciAtt.table1.getSelectedRow(), 0),(String)FrameInserisciAtt.table1.getValueAt(FrameInserisciAtt.table1.getSelectedRow(),1),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			new FrameAttIstr();
			
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

