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
		mntmTornaAllaPagina.setActionCommand("Vai_home");
		
		
		
		JLabel lblFormDiRegistrazione = new JLabel("Form di registrazione");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiRegistrazione, gbc);
		
		JLabel lblDatiAnagrafici = new JLabel("Dati Anagrafici");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblDatiAnagrafici, gbc);
		
		
		
		JLabel lblNome = new JLabel("Nome");
		gbc.anchor =  GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblNome, gbc);
		
		textnome = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textnome, gbc);
		textnome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblCognome, gbc);
		
		textcognome = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textcognome, gbc);
		textcognome.setColumns(10);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(lblCodiceFiscale, gbc);
		
		textcodice = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textcodice, gbc);
		textcodice.setColumns(10);
		
		
		JLabel lblCitt = new JLabel("Citta");
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblCitt, gbc);
		
		textcitta = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 5;
		contentPane.add(textcitta, gbc);
		textcitta.setColumns(10);
		
		JLabel lblVia = new JLabel("Via");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 6;
		contentPane.add(lblVia, gbc);
		
		textvia = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 6;
		contentPane.add(textvia, gbc);
		textvia.setColumns(10);
		
		JLabel lblNumeroCivico = new JLabel("Numero Civico");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 7;
		contentPane.add(lblNumeroCivico, gbc);
		
		textnumciv = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 7;
		contentPane.add(textnumciv, gbc);
		textnumciv.setColumns(10);
		
		JLabel lblDatiutenza = new JLabel("Dati di Accesso");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 8;
		contentPane.add(lblDatiutenza, gbc);
		
		
		JLabel lblIndirizzoMail = new JLabel("Indirizzo mail");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 9;
		contentPane.add(lblIndirizzoMail, gbc);
		
		textmail = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 9;
		contentPane.add(textmail, gbc);
		textmail.setColumns(10);
		
		JLabel lblNomeutente = new JLabel("Nome Utente");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 10;
		contentPane.add(lblNomeutente, gbc);
			
		textnomeutente = new JTextField();
	    gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 10;
		textnomeutente.setColumns(10);
		contentPane.add(textnomeutente, gbc);
		
		JLabel inuso = new JLabel("Nome utente in uso");
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 2;
		gbc.gridy = 10;
		contentPane.add(inuso, gbc);
		inuso.setVisible(false);
		
	
		
		
		JLabel lblPassword = new JLabel("Password");
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 11;
		contentPane.add(lblPassword, gbc);
		
		pass = new JPasswordField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 11;
		pass.setColumns(10);
		contentPane.add(pass, gbc);
		
		
		
		
		JLabel lbl2Password = new JLabel("Ripeti Password");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 12;
		contentPane.add(lbl2Password, gbc);
		
		secondapass = new JPasswordField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 12;
		secondapass.setColumns(10);
		contentPane.add(secondapass, gbc);
		
		
		JLabel lblTipoUtente = new JLabel("Tipo utente");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 13;
		contentPane.add(lblTipoUtente, gbc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tesserato","Istruttore"}));
		comboBox.setVisible(true);
		comboBox.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 13;
		contentPane.add(comboBox, gbc);
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		
		
		
		JButton btnRegistratiAlNostro = new JButton("Registrati al nostro portale!");
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 14;
		contentPane.add(btnRegistratiAlNostro, gbc);
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
			bool=Reg_dao.registratesserato(textnome.getText(),textcognome.getText(),textcodice.getText(),textcitta.getText(),textvia.getText(),textnumciv.getText(), textmail.getText(),textnomeutente.getText(),pass.getText(), comboBox.getSelectedItem().toString());
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

