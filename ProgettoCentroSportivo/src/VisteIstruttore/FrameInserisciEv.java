package VisteIstruttore;


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
import ClassiDAOIstruttore.InserisciEventoDAO;
import Listener.Listen;
import Model.Home;
import Model.Utente;
import ModelliTabelleIstruttore.ComboSpazio;
import ModelliTabelleIstruttore.ModLivDis;
import VisteUtenteGenerico.*;
import ClassiDao.GetInfoDB;
import ClassiDao.Reg_dao;

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






public class FrameInserisciEv extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,tabellaPnl;
	
	private JTextField textnomeevento;
	private JTextField textdescrizione;
	private JTextField textcostoev;
	private JComboBox comboinfopag;
	private JComboBox  combotipoev;
	private JComboBox  combobiscert;
	private JComboBox combofasciaor;
	private JComboBox combogiornoset;
	private JTextField comboprendisp;
	private boolean bool;
	public static ComboSpazio combospazio;
	public static JTable table1;
	public ModLivDis model1;
	
	
	public FrameInserisciEv() {
		String username=""+Utente.getUsername()+"";
		int matricola = GetInfoDB.getidIstr(username);
		frame = new JFrame("Inserimento eventi");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci un nuovo evento");
		if(FrameInserisciEv.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciEv.frame.getLocation());
		
		
		
		
	
		
		
		
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
		mntmTornaAllaPagina.setActionCommand("Vai_home3");
		
		
		
		JLabel lblFormDiInserimento = new JLabel("Form di Inserimento dell'Evento");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiInserimento, gbc);
		
		
		
		JLabel lblDatiDisc = new JLabel("Dati sulle discipline disponibili");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
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
		
		Dimension b = table1.getPreferredSize();
		table1.setPreferredSize(b);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =2;
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(2, 1));
		tabellaPnl.add(table1.getTableHeader());
		tabellaPnl.add(table1);
		contentPane.add(tabellaPnl, gbc);
		
		JLabel lblNomeEvento = new JLabel("Nome dell'evento");
		gbc.anchor =  GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblNomeEvento, gbc);
		
		textnomeevento = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textnomeevento, gbc);
		textnomeevento.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione dell'evento");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(lblDescrizione, gbc);
		
		textdescrizione = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textdescrizione, gbc);
		textdescrizione.setColumns(10);
		
		JLabel lblInfopag = new JLabel("Info pagamento");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblInfopag, gbc);
		
		comboinfopag = new JComboBox();
		comboinfopag.setModel(new DefaultComboBoxModel(new String[] {"Gratuito","A pagamento"}));
		comboinfopag.setEnabled(true);
		comboinfopag.setVisible(true);
		comboinfopag.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 5;
		contentPane.add(comboinfopag, gbc);
		
		
		JLabel lblCostoEv = new JLabel("Costo dell'evento");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		contentPane.add(lblCostoEv, gbc);
		
		textcostoev = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textcostoev, gbc);
		textcostoev.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("Tipo evento");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 7;
		contentPane.add(lblTipoEvento, gbc);
		
		combotipoev = new JComboBox();
		combotipoev.setModel(new DefaultComboBoxModel(new String[] {"Gara","Stage"}));
		combotipoev.setVisible(true);
		combotipoev.setEnabled(true);
		combotipoev.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 7;
		contentPane.add(combotipoev, gbc);
		
		JLabel lblBiscert = new JLabel("Bisogno certificato");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 8;
		contentPane.add(lblBiscert, gbc);
		
		combobiscert = new JComboBox();
		combobiscert.setModel(new DefaultComboBoxModel(new String[] {"Si","No"}));
		combobiscert.setEnabled(true);
		combobiscert.setVisible(true);
		combobiscert.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 8;
		contentPane.add(combobiscert, gbc);
		
		
		
		
		JLabel lblDatiorario = new JLabel("Dati sull'orario");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 9;
		contentPane.add(lblDatiorario, gbc);
		
		
		JLabel lblFasciaoraria = new JLabel("Fascia oraria");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 10;
		contentPane.add(lblFasciaoraria, gbc);
		
		combofasciaor = new JComboBox();
		combofasciaor.setModel(new DefaultComboBoxModel(new String[] {"08:30-09:30","09:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","15:30-16:30","16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30",}));
		combofasciaor.setVisible(true);
		combofasciaor.setEnabled(true);
		combofasciaor.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 10;
		contentPane.add(combofasciaor, gbc);
		
		JLabel lblGiornoset = new JLabel("Giorno della settimana");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 11;
		contentPane.add(lblGiornoset, gbc);
			
		combogiornoset = new JComboBox();
		combogiornoset.setModel(new DefaultComboBoxModel(new String[] {"lunedi","martedi","mercoledi","giovedi","venerdi","sabato"}));
		combogiornoset.setVisible(true);
		combogiornoset.setEnabled(true);
		combogiornoset.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 11;
		contentPane.add(combogiornoset, gbc);
		
	
		JLabel lblSpazio = new JLabel("Spazio");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 12;
		contentPane.add(lblSpazio, gbc);
		
		combospazio = new ComboSpazio();
		combospazio.setEnabled(true);
		combospazio.setVisible(true);
		combospazio.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 12;
		contentPane.add(combospazio, gbc);
		
		JLabel lblPrenDisp = new JLabel("Prenotazioni disponibili");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 13;
		contentPane.add(lblPrenDisp, gbc);
		
		comboprendisp = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 13;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(comboprendisp, gbc);
		comboprendisp.setColumns(10);

		
		
		JButton btnRegistratiAlNostro = new JButton("Inserisci il nuovo evento");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 15;
		contentPane.add(btnRegistratiAlNostro, gbc);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			lblNomeEvento.setForeground(Color.BLACK);
			lblNomeEvento.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			lblDescrizione.setForeground(Color.BLACK);
			lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			lblCostoEv.setForeground(Color.BLACK);
			lblCostoEv.setFont(new Font("Tahoma", Font.PLAIN, 11));

			lblPrenDisp.setForeground(Color.BLACK);
			lblPrenDisp.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		
		
		if(textnomeevento.getText().isEmpty()||textdescrizione.getText().isEmpty()||textcostoev.getText().isEmpty()||comboprendisp.getText().isEmpty())
		{
			
			if(textnomeevento.getText().isEmpty())
			{
				lblNomeEvento.setForeground(Color.RED);
				lblNomeEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textdescrizione.getText().isEmpty())
			{
				lblDescrizione.setForeground(Color.RED);
				lblDescrizione.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textcostoev.getText().isEmpty())
			{
				lblCostoEv.setForeground(Color.RED);
				lblCostoEv.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(comboprendisp.getText().isEmpty())
			{
				lblPrenDisp.setForeground(Color.RED);
				lblPrenDisp.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
			
			bool=InserisciEventoDAO.registraevento(GetInfoDB.getcombinazionelivdis((String)FrameInserisciEv.table1.getValueAt(FrameInserisciEv.table1.getSelectedRow(), 0),(String)FrameInserisciEv.table1.getValueAt(FrameInserisciEv.table1.getSelectedRow(),1)),textnomeevento.getText(),textdescrizione.getText(),textcostoev.getText(),comboinfopag.getSelectedItem().toString(),combotipoev.getSelectedItem().toString(),combobiscert.getSelectedItem().toString(),combofasciaor.getSelectedItem().toString(),combogiornoset.getSelectedItem().toString(),combospazio.getSelectedItem().toString(),comboprendisp.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameIstruttore.frame.setVisible(true);
			FrameIstruttore.frame.setEnabled(true);
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

