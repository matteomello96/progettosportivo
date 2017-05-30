package VisteUtenteGenerico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Listener.Listen;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FrameRegistrazione extends JFrame {
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
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public FrameRegistrazione() {
		frame = new JFrame("Registrazione");
		frame.setTitle("Registrati al nostro portale");
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Iniziale");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFormDiRegistrazione = new JLabel("Form di registrazione");
		GridBagConstraints gbc_lblFormDiRegistrazione = new GridBagConstraints();
		gbc_lblFormDiRegistrazione.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormDiRegistrazione.gridx = 3;
		gbc_lblFormDiRegistrazione.gridy = 0;
		contentPane.add(lblFormDiRegistrazione, gbc_lblFormDiRegistrazione);
		
		JLabel lblDatiAnagrafici = new JLabel("Dati Anagrafici");
		GridBagConstraints gbc_lblDatiAnagrafici = new GridBagConstraints();
		gbc_lblDatiAnagrafici.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatiAnagrafici.gridx = 1;
		gbc_lblDatiAnagrafici.gridy = 1;
		contentPane.add(lblDatiAnagrafici, gbc_lblDatiAnagrafici);
		
		JLabel lblDatiutenza = new JLabel("Dati di Accesso");
		GridBagConstraints gbc_lblDatiutenza = new GridBagConstraints();
		gbc_lblDatiutenza.gridwidth = 2;
		gbc_lblDatiutenza.anchor = GridBagConstraints.NORTH;
		gbc_lblDatiutenza.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatiutenza.gridx = 4;
		gbc_lblDatiutenza.gridy = 1;
		contentPane.add(lblDatiutenza, gbc_lblDatiutenza);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 3;
		contentPane.add(lblNome, gbc_lblNome);
		
		textnome = new JTextField();
		GridBagConstraints gbc_textnome = new GridBagConstraints();
		gbc_textnome.insets = new Insets(0, 0, 5, 5);
		gbc_textnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnome.gridx = 1;
		gbc_textnome.gridy = 3;
		contentPane.add(textnome, gbc_textnome);
		textnome.setColumns(10);
		
		JLabel lblIndirizzoMail = new JLabel("Indirizzo mail");
		GridBagConstraints gbc_lblIndirizzoMail = new GridBagConstraints();
		gbc_lblIndirizzoMail.anchor = GridBagConstraints.EAST;
		gbc_lblIndirizzoMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndirizzoMail.gridx = 4;
		gbc_lblIndirizzoMail.gridy = 3;
		contentPane.add(lblIndirizzoMail, gbc_lblIndirizzoMail);
		
		textmail = new JTextField();
		GridBagConstraints gbc_textmail = new GridBagConstraints();
		gbc_textmail.gridwidth = 4;
		gbc_textmail.insets = new Insets(0, 0, 5, 0);
		gbc_textmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textmail.gridx = 5;
		gbc_textmail.gridy = 3;
		contentPane.add(textmail, gbc_textmail);
		textmail.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		GridBagConstraints gbc_lblCognome = new GridBagConstraints();
		gbc_lblCognome.anchor = GridBagConstraints.EAST;
		gbc_lblCognome.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognome.gridx = 0;
		gbc_lblCognome.gridy = 4;
		contentPane.add(lblCognome, gbc_lblCognome);
		
		textcognome = new JTextField();
		GridBagConstraints gbc_textcognome = new GridBagConstraints();
		gbc_textcognome.insets = new Insets(0, 0, 5, 5);
		gbc_textcognome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcognome.gridx = 1;
		gbc_textcognome.gridy = 4;
		contentPane.add(textcognome, gbc_textcognome);
		textcognome.setColumns(10);
		
		JLabel lblNomeutente = new JLabel("Nome Utente");
		GridBagConstraints gbc_lblNomeutente = new GridBagConstraints();
		gbc_lblNomeutente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeutente.gridx = 4;
		gbc_lblNomeutente.gridy = 4;
		contentPane.add(lblNomeutente, gbc_lblNomeutente);
		
		textnomeutente = new JTextField();
		GridBagConstraints gbc_textnomeutente = new GridBagConstraints();
		gbc_textnomeutente.gridwidth = 4;
		gbc_textnomeutente.insets = new Insets(0, 0, 5, 0);
		gbc_textnomeutente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnomeutente.gridx = 5;
		gbc_textnomeutente.gridy = 4;
		contentPane.add(textnomeutente, gbc_textnomeutente);
		textnomeutente.setColumns(10);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		GridBagConstraints gbc_lblCodiceFiscale = new GridBagConstraints();
		gbc_lblCodiceFiscale.anchor = GridBagConstraints.EAST;
		gbc_lblCodiceFiscale.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodiceFiscale.gridx = 0;
		gbc_lblCodiceFiscale.gridy = 5;
		contentPane.add(lblCodiceFiscale, gbc_lblCodiceFiscale);
		
		textcodice = new JTextField();
		GridBagConstraints gbc_textcodice = new GridBagConstraints();
		gbc_textcodice.insets = new Insets(0, 0, 5, 5);
		gbc_textcodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcodice.gridx = 1;
		gbc_textcodice.gridy = 5;
		contentPane.add(textcodice, gbc_textcodice);
		textcodice.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 4;
		gbc_lblPassword.gridy = 5;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 4;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 5;
		gbc_passwordField.gridy = 5;
		contentPane.add(passwordField, gbc_passwordField);
		
		JLabel lblCitt = new JLabel("Citt\u00E0");
		GridBagConstraints gbc_lblCitt = new GridBagConstraints();
		gbc_lblCitt.anchor = GridBagConstraints.EAST;
		gbc_lblCitt.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitt.gridx = 0;
		gbc_lblCitt.gridy = 6;
		contentPane.add(lblCitt, gbc_lblCitt);
		
		textcitta = new JTextField();
		GridBagConstraints gbc_textcitta = new GridBagConstraints();
		gbc_textcitta.insets = new Insets(0, 0, 5, 5);
		gbc_textcitta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcitta.gridx = 1;
		gbc_textcitta.gridy = 6;
		contentPane.add(textcitta, gbc_textcitta);
		textcitta.setColumns(10);
		
		JLabel lblTipoUtente = new JLabel("Tipo utente");
		GridBagConstraints gbc_lblTipoUtente = new GridBagConstraints();
		gbc_lblTipoUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUtente.gridx = 4;
		gbc_lblTipoUtente.gridy = 6;
		contentPane.add(lblTipoUtente, gbc_lblTipoUtente);
		
		JComboBox combotipoutente = new JComboBox();
		combotipoutente.setEditable(false);
		GridBagConstraints gbc_combotipoutente = new GridBagConstraints();
		gbc_combotipoutente.gridwidth = 4;
		gbc_combotipoutente.insets = new Insets(0, 0, 5, 0);
		gbc_combotipoutente.fill = GridBagConstraints.HORIZONTAL;
		gbc_combotipoutente.gridx = 5;
		gbc_combotipoutente.gridy = 6;
		contentPane.add(combotipoutente, gbc_combotipoutente);
		
		JLabel lblVia = new JLabel("Via");
		GridBagConstraints gbc_lblVia = new GridBagConstraints();
		gbc_lblVia.anchor = GridBagConstraints.EAST;
		gbc_lblVia.insets = new Insets(0, 0, 5, 5);
		gbc_lblVia.gridx = 0;
		gbc_lblVia.gridy = 7;
		contentPane.add(lblVia, gbc_lblVia);
		
		textvia = new JTextField();
		GridBagConstraints gbc_textvia = new GridBagConstraints();
		gbc_textvia.insets = new Insets(0, 0, 5, 5);
		gbc_textvia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textvia.gridx = 1;
		gbc_textvia.gridy = 7;
		contentPane.add(textvia, gbc_textvia);
		textvia.setColumns(10);
		
		JLabel lblNumeroCivico = new JLabel("Numero Civico");
		GridBagConstraints gbc_lblNumeroCivico = new GridBagConstraints();
		gbc_lblNumeroCivico.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroCivico.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroCivico.gridx = 0;
		gbc_lblNumeroCivico.gridy = 8;
		contentPane.add(lblNumeroCivico, gbc_lblNumeroCivico);
		
		textnumciv = new JTextField();
		GridBagConstraints gbc_textnumciv = new GridBagConstraints();
		gbc_textnumciv.insets = new Insets(0, 0, 5, 5);
		gbc_textnumciv.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnumciv.gridx = 1;
		gbc_textnumciv.gridy = 8;
		contentPane.add(textnumciv, gbc_textnumciv);
		textnumciv.setColumns(10);
		
		JButton btnRegistratiAlNostro = new JButton("Registrati al nostro portale!");
		GridBagConstraints gbc_btnRegistratiAlNostro = new GridBagConstraints();
		gbc_btnRegistratiAlNostro.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistratiAlNostro.gridx = 3;
		gbc_btnRegistratiAlNostro.gridy = 9;
		contentPane.add(btnRegistratiAlNostro, gbc_btnRegistratiAlNostro);
	}
}

	
