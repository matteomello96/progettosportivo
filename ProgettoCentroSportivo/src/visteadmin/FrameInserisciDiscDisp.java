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
import ModelliTabelle.ModDetLiv;
import ModelliTabelleIstruttore.ComboDis;
import ModelliTabelleIstruttore.ComboLivelloIs;
import ModelliTabelleIstruttore.ComboSpazio;
import ModelliTabelleIstruttore.ComboSpazioAltro;
import ModelliTabelleIstruttore.ModLivDis;
import ModelliTabelleRespo.ComboDiscipline;
import ModelliTabelleRespo.ComboLivelli;
import VisteUtenteGenerico.*;
import classiDAOResponsabile.InserisciDiscDispDAO;
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






public class FrameInserisciDiscDisp extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	
	private JTextField costomensile;
	private boolean bool;
	public static ComboDiscipline combodis;
	public static ComboLivelli combolivelli;
	public String disciplina="";
	public String livello="";
	
	
	public FrameInserisciDiscDisp() {
		
		frame = new JFrame("Inserimento disciplina disponibile");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci una nuova disciplina disponibile");
		if(FrameInserisciDiscDisp.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciDiscDisp.frame.getLocation());
		
		
	
	
		
		
		
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
		mntmTornaAllaPagina.setActionCommand("Vai_home_da_ins_disc");
		
		
		
		JLabel lblFormDiInserimento = new JLabel("Form di Inserimento della disciplina");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiInserimento, gbc);
		
		
				
		
		
		
		

		
	
		JLabel lblDisc = new JLabel("Scegli disciplina");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblDisc, gbc);
		
		combodis = new ComboDiscipline();
		combodis.setEnabled(true);
		combodis.setVisible(true);
		combodis.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(combodis, gbc);
		
		JLabel lblLiv = new JLabel("Scegli livello");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblLiv, gbc);
		
		combolivelli = new ComboLivelli();
		combolivelli.setEnabled(true);
		combolivelli.setVisible(true);
		combolivelli.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 3;
		contentPane.add(combolivelli, gbc);
		
		
		JLabel lblCostomensile = new JLabel("Costo mensile");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy =4;
		contentPane.add(lblCostomensile, gbc);
		
		costomensile = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(costomensile, gbc);
		costomensile.setColumns(10);

		
		
		JButton btnRegistratiAlNostro = new JButton("Inserisci la nuova disciplina");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 6;
		contentPane.add(btnRegistratiAlNostro, gbc);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			

			costomensile.setForeground(Color.BLACK);
			costomensile.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		
		
		if(costomensile.getText().isEmpty())
		{
			
			
			if(costomensile.getText().isEmpty())
			{
				costomensile.setForeground(Color.RED);
				costomensile.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
	
			bool=InserisciDiscDispDAO.inserimentodiscdisp(combodis.getSelectedItem().toString(),combolivelli.getSelectedItem().toString(),costomensile.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameGestione.frame.dispose();
			new FrameGestione();
			FrameGestione.frame.setVisible(true);
			FrameGestione.frame.setEnabled(true);
			
	}
								
		
			}	
		
	})
		
		
		;
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

