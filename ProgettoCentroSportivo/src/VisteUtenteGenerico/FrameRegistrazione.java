package VisteUtenteGenerico;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent.KeyBinding;

import Listener.Listen;
import Model.Home;
import VisteUtenteGenerico.*;

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
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;






public class FrameRegistrazione extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	private JTextField textnome;
	private JTextField textcognome;
	private JTextField textcodice;
	private JTextField textcitta;
	private JTextField textvia;
	private JTextField textnumciv;
	private JTextField textmail;
	private JTextField textnomeutente;
	private JPasswordField pass;
	private JTextField secondapass;
	private boolean bool;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRegistrazione frame = new FrameRegistrazione();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameRegistrazione() {
		
		frame = new JFrame("Registrazione");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Registrati al nostro portale");
		if(FrameRegistrazione.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameRegistrazione.frame.getLocation());
		
		
		
		
	
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color (0,220,50));
		  
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
		mntmTornaAllaPagina.setActionCommand("Vai_home");
		
		
		
		JLabel lblFormDiRegistrazione = new JLabel("Form di registrazione");
		GridBagConstraints gbc_lblFormDiRegistrazione = new GridBagConstraints();
		gbc_lblFormDiRegistrazione.gridwidth = 2;
		gbc_lblFormDiRegistrazione.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormDiRegistrazione.gridx = 4;
		gbc_lblFormDiRegistrazione.gridy = 0;
		contentPane.add(lblFormDiRegistrazione, gbc_lblFormDiRegistrazione);
		
		JLabel lblDatiAnagrafici = new JLabel("Dati Anagrafici");
		GridBagConstraints gbc_lblDatiAnagrafici = new GridBagConstraints();
		gbc_lblDatiAnagrafici.gridwidth = 2;
		gbc_lblDatiAnagrafici.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatiAnagrafici.gridx = 4;
		gbc_lblDatiAnagrafici.gridy = 1;
		contentPane.add(lblDatiAnagrafici, gbc_lblDatiAnagrafici);
		
		
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 3;
		gbc_lblNome.gridy = 2;
		contentPane.add(lblNome, gbc_lblNome);
		
		textnome = new JTextField();
		GridBagConstraints gbc_textnome = new GridBagConstraints();
		gbc_textnome.gridwidth = 2;
		gbc_textnome.insets = new Insets(0, 0, 5, 5);
		gbc_textnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnome.gridx = 4;
		gbc_textnome.gridy = 2;
		contentPane.add(textnome, gbc_textnome);
		textnome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		GridBagConstraints gbc_lblCognome = new GridBagConstraints();
		gbc_lblCognome.anchor = GridBagConstraints.EAST;
		gbc_lblCognome.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognome.gridx = 3;
		gbc_lblCognome.gridy = 3;
		contentPane.add(lblCognome, gbc_lblCognome);
		
		textcognome = new JTextField();
		GridBagConstraints gbc_textcognome = new GridBagConstraints();
		gbc_textcognome.gridwidth = 2;
		gbc_textcognome.insets = new Insets(0, 0, 5, 5);
		gbc_textcognome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcognome.gridx = 4;
		gbc_textcognome.gridy = 3;
		contentPane.add(textcognome, gbc_textcognome);
		textcognome.setColumns(10);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		GridBagConstraints gbc_lblCodiceFiscale = new GridBagConstraints();
		gbc_lblCodiceFiscale.anchor = GridBagConstraints.EAST;
		gbc_lblCodiceFiscale.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodiceFiscale.gridx = 3;
		gbc_lblCodiceFiscale.gridy = 4;
		contentPane.add(lblCodiceFiscale, gbc_lblCodiceFiscale);
		
		textcodice = new JTextField();
		GridBagConstraints gbc_textcodice = new GridBagConstraints();
		gbc_textcodice.gridwidth =2;
		gbc_textcodice.insets = new Insets(0, 0, 5, 5);
		gbc_textcodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcodice.gridx = 4;
		gbc_textcodice.gridy = 4;
		contentPane.add(textcodice, gbc_textcodice);
		textcodice.setColumns(10);
		
		
		JLabel lblCitt = new JLabel("Citta");
		GridBagConstraints gbc_lblCitt = new GridBagConstraints();
		gbc_lblCitt.anchor = GridBagConstraints.EAST;
		gbc_lblCitt.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitt.gridx = 3;
		gbc_lblCitt.gridy = 5;
		contentPane.add(lblCitt, gbc_lblCitt);
		
		textcitta = new JTextField();
		GridBagConstraints gbc_textcitta = new GridBagConstraints();
		gbc_textcitta.gridwidth = 2;
		gbc_textcitta.insets = new Insets(0, 0, 5, 5);
		gbc_textcitta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcitta.gridx = 4;
		gbc_textcitta.gridy = 5;
		contentPane.add(textcitta, gbc_textcitta);
		textcitta.setColumns(10);
		
		JLabel lblVia = new JLabel("Via");
		GridBagConstraints gbc_lblVia = new GridBagConstraints();
		gbc_lblVia.anchor = GridBagConstraints.EAST;
		gbc_lblVia.insets = new Insets(0, 0, 5, 5);
		gbc_lblVia.gridx = 3;
		gbc_lblVia.gridy = 6;
		contentPane.add(lblVia, gbc_lblVia);
		
		textvia = new JTextField();
		GridBagConstraints gbc_textvia = new GridBagConstraints();
		gbc_textvia.gridwidth = 2;
		gbc_textvia.insets = new Insets(0, 0, 5, 5);
		gbc_textvia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textvia.gridx = 4;
		gbc_textvia.gridy = 6;
		contentPane.add(textvia, gbc_textvia);
		textvia.setColumns(10);
		
		JLabel lblNumeroCivico = new JLabel("Numero Civico");
		GridBagConstraints gbc_lblNumeroCivico = new GridBagConstraints();
		gbc_lblNumeroCivico.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroCivico.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroCivico.gridx = 3;
		gbc_lblNumeroCivico.gridy = 7;
		contentPane.add(lblNumeroCivico, gbc_lblNumeroCivico);
		
		textnumciv = new JTextField();
		GridBagConstraints gbc_textnumciv = new GridBagConstraints();
		gbc_textnumciv.gridwidth = 2;
		gbc_textnumciv.insets = new Insets(0, 0, 5, 5);
		gbc_textnumciv.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnumciv.gridx = 4;
		gbc_textnumciv.gridy = 7;
		contentPane.add(textnumciv, gbc_textnumciv);
		textnumciv.setColumns(10);
		
		JLabel lblDatiutenza = new JLabel("Dati di Accesso");
		GridBagConstraints gbc_lblDatiutenza = new GridBagConstraints();
		gbc_lblDatiutenza.gridwidth = 2;
		gbc_lblDatiutenza.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatiutenza.gridx = 4;
		gbc_lblDatiutenza.gridy = 8;
		contentPane.add(lblDatiutenza, gbc_lblDatiutenza);
		
		
		JLabel lblIndirizzoMail = new JLabel("Indirizzo mail");
		GridBagConstraints gbc_lblIndirizzoMail = new GridBagConstraints();
		gbc_lblIndirizzoMail.anchor = GridBagConstraints.EAST;
		gbc_lblIndirizzoMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndirizzoMail.gridx = 3;
		gbc_lblIndirizzoMail.gridy = 9;
		contentPane.add(lblIndirizzoMail, gbc_lblIndirizzoMail);
		
		textmail = new JTextField();
		GridBagConstraints gbc_textmail = new GridBagConstraints();
		gbc_textmail.gridwidth = 2;
		gbc_textmail.insets = new Insets(0, 0, 5, 5);
		gbc_textmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textmail.gridx = 4;
		gbc_textmail.gridy = 9;
		contentPane.add(textmail, gbc_textmail);
		textmail.setColumns(10);
		
		JLabel lblNomeutente = new JLabel("Nome Utente");
		GridBagConstraints gbc_lblNomeutente = new GridBagConstraints();
		gbc_lblCognome.anchor = GridBagConstraints.EAST;
		gbc_lblNomeutente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeutente.gridx = 3;
		gbc_lblNomeutente.gridy = 10;
		contentPane.add(lblNomeutente, gbc_lblNomeutente);
		
		
		
		
		
		JLabel inuso = new JLabel("Nome utente in uso");
		GridBagConstraints gbc_inuso = new GridBagConstraints();
		gbc_inuso.anchor = GridBagConstraints.EAST;
		gbc_inuso.insets = new Insets(0, 0, 5, 5);
		gbc_inuso.gridx = 3;
		gbc_inuso.gridy = 11;
		contentPane.add(inuso, gbc_inuso);
		inuso.setVisible(false);
		
		textnomeutente = new JTextField();
		GridBagConstraints gbc_textnomeutente = new GridBagConstraints();
		gbc_textnomeutente.gridwidth = 2;
		gbc_textnomeutente.insets = new Insets(0, 0, 5, 5);
		gbc_textnomeutente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnomeutente.gridx = 4;
		gbc_textnomeutente.gridy = 10;
		textnomeutente.setColumns(10);
		contentPane.add(textnomeutente, gbc_textnomeutente);
		
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 3;
		gbc_lblPassword.gridy = 12;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		pass = new JPasswordField();
		GridBagConstraints gbc_passwordField1 = new GridBagConstraints();
		gbc_passwordField1.gridwidth = 2;
		gbc_passwordField1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField1.gridx = 4;
		gbc_passwordField1.gridy = 12;
		contentPane.add(pass, gbc_passwordField1);
		pass.setColumns(10);
		
		
		
		JLabel lbl2Password = new JLabel("Ripeti Password");
		GridBagConstraints gbc_lbl2Password = new GridBagConstraints();
		gbc_lbl2Password.anchor = GridBagConstraints.EAST;
		gbc_lbl2Password.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2Password.gridx = 3;
		gbc_lbl2Password.gridy = 13;
		contentPane.add(lbl2Password, gbc_lbl2Password);
		
		secondapass = new JPasswordField();
		GridBagConstraints gbc_2passwordField = new GridBagConstraints();
		gbc_2passwordField.gridwidth = 2;
		gbc_2passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_2passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_2passwordField.gridx = 4;
		gbc_2passwordField.gridy = 13;
		contentPane.add(secondapass, gbc_2passwordField);
		secondapass.setColumns(10);
		
		JLabel lblTipoUtente = new JLabel("Tipo utente");
		GridBagConstraints gbc_lblTipoUtente = new GridBagConstraints();
		gbc_lblCognome.anchor = GridBagConstraints.EAST;
		gbc_lblTipoUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUtente.gridx = 3;
		gbc_lblTipoUtente.gridy = 14;
		contentPane.add(lblTipoUtente, gbc_lblTipoUtente);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tesserato", "Istruttore"}));
		comboBox.setVisible(true);
		comboBox.setEditable(false);
		GridBagConstraints gbc_combotipoutente = new GridBagConstraints();
		gbc_combotipoutente.gridwidth = 2;
		gbc_combotipoutente.insets = new Insets(0, 0, 5, 5);
		gbc_combotipoutente.fill = GridBagConstraints.HORIZONTAL;
		gbc_combotipoutente.gridx = 4;
		gbc_combotipoutente.gridy = 14;
		contentPane.add(comboBox, gbc_combotipoutente);
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		
		
		
		JButton btnRegistratiAlNostro = new JButton("Registrati al nostro portale!");
		GridBagConstraints gbc_btnRegistratiAlNostro = new GridBagConstraints();
		gbc_btnRegistratiAlNostro.gridwidth = 2;
		gbc_btnRegistratiAlNostro.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistratiAlNostro.gridx = 4;
		gbc_btnRegistratiAlNostro.gridy = 16;
		contentPane.add(btnRegistratiAlNostro, gbc_btnRegistratiAlNostro);
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {lblNome.setForeground(Color.BLACK);
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			lblCognome.setForeground(Color.BLACK);
			lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			lblNomeutente.setForeground(Color.BLACK);
			lblNomeutente.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
			lblIndirizzoMail.setForeground(Color.BLACK);
			lblIndirizzoMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
			lblPassword.setForeground(Color.BLACK);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			
		
		
		if(textnome.getText().isEmpty()||textcognome.getText().isEmpty()||textnomeutente.getText().isEmpty()||textmail.getText().isEmpty()||pass.getText().isEmpty()||secondapass.getText().isEmpty()||textcodice.getText().isEmpty()||textcitta.getText().isEmpty()||textvia.getText().isEmpty()||textnumciv.getText().isEmpty())
		{
			
			if(textnumciv.getText().isEmpty())
			{
				lblNumeroCivico.setForeground(Color.RED);
				lblNumeroCivico.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textvia.getText().isEmpty())
			{
				lblVia.setForeground(Color.RED);
				lblVia.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textcitta.getText().isEmpty())
			{
				lblCitt.setForeground(Color.RED);
				lblCitt.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textcodice.getText().isEmpty())
			{
				lblCodiceFiscale.setForeground(Color.RED);
				lblCodiceFiscale.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textnome.getText().isEmpty())
			{
				lblNome.setForeground(Color.RED);
				lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textcognome.getText().isEmpty())
			{
				lblCognome.setForeground(Color.RED);
				lblCognome.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textnomeutente.getText().isEmpty())
			{
				lblNomeutente.setForeground(Color.RED);
				lblNomeutente.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(textmail.getText().isEmpty())
			{
				lblIndirizzoMail.setForeground(Color.RED);
				lblIndirizzoMail.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(pass.getText().isEmpty())
			{
				lblPassword.setForeground(Color.RED);
				lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			if(secondapass.getText().isEmpty())
			{
				lbl2Password.setForeground(Color.RED);
				lbl2Password.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		else if(!pass.getText().equals(secondapass.getText())){
			lblPassword.setForeground(Color.RED);
			lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		
									
			lbl2Password.setForeground(Color.RED);
			lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
			JOptionPane.showMessageDialog(frame, "Le password inserite non coincidono"," ",JOptionPane.WARNING_MESSAGE);
		}
		else
			if(comboBox.getSelectedIndex()!=1)
			bool=Reg_dao.registra(textnome.getText(),textcognome.getText(),textcodice.getText(),textcitta.getText(),textvia.getText(),textnumciv.getText(), textmail.getText(),textnomeutente.getText(),pass.getText(), comboBox.getSelectedItem().toString());
			else bool=Reg_dao.registraistruttore(textnome.getText(),textcognome.getText(),textcodice.getText(),textcitta.getText(),textvia.getText(),textnumciv.getText(), textmail.getText(),textnomeutente.getText(),pass.getText(), comboBox.getSelectedItem().toString());
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameIniziale.frame.setEnabled(true);
			FrameIniziale.frame.setAlwaysOnTop(true);
			FrameIniziale.frame.setAlwaysOnTop(false);
	}
								
		
			}	
		
	})
		
		
		;


}}

