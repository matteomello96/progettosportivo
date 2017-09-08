package VisteUtenteGenerico;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent.KeyBinding;

import Model.Home;
import VisteUtenteGenerico.*;
import listener.Listen;
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
	private JTextField texttelefono;
	private boolean bool;
	public String  erroreCF= "";
	
	
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
		lblFormDiRegistrazione.setOpaque(true);
		lblFormDiRegistrazione.setBackground(new Color(65, 105, 225));
		lblFormDiRegistrazione.setForeground(new Color(255, 255, 255));
		lblFormDiRegistrazione.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblFormDiRegistrazione, gbc);
		
		JLabel lblDatiAnagrafici = new JLabel("Dati Anagrafici");
		lblDatiAnagrafici.setOpaque(true);
		lblDatiAnagrafici.setBackground(new Color(65, 105, 225));
		lblDatiAnagrafici.setForeground(new Color(255, 255, 255));
		lblDatiAnagrafici.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblDatiAnagrafici, gbc);
		
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setOpaque(true);
		lblNome.setBackground(new Color(205, 127, 50));
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor =  GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(lblNome, gbc);
		
		JLabel lblErrNome = new JLabel("Il nome non deve contenere numeri");
		lblErrNome.setOpaque(true);
		lblErrNome.setBackground(new Color(128, 0, 0));
		lblErrNome.setForeground(new Color(255, 255, 255));
		lblErrNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrNome.setBounds(25, 30, 10, 10);
		lblErrNome.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrNome,gbc);

		
		textnome = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textnome, gbc);
		textnome.setColumns(10);
		
		textnome.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrNome.setVisible(true);
                }
				else
				{
				lblErrNome.setVisible(false);
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
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setOpaque(true);
		lblCognome.setBackground(new Color(205, 127, 50));
		lblCognome.setForeground(new Color(255, 255, 255));
		lblCognome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(lblCognome, gbc);
		
		
		JLabel lblErrCognome = new JLabel("Il cognome non deve contenere numeri");
		lblErrCognome.setOpaque(true);
		lblErrCognome.setBackground(new Color(128, 0, 0));
		lblErrCognome.setForeground(new Color(255, 255, 255));
		lblErrCognome.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblErrCognome.setBounds(25, 30, 10, 10);
		lblErrCognome.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrCognome,gbc);
		
		
		textcognome = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textcognome, gbc);
		textcognome.setColumns(10);
		
		textcognome.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrCognome.setVisible(true);
                }
				else
				{
				lblErrCognome.setVisible(false);
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
		
		
		
		
		
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale(Premi spazio alla fine)");
		lblCodiceFiscale.setOpaque(true);
		lblCodiceFiscale.setBackground(new Color(205, 127, 50));
		lblCodiceFiscale.setForeground(new Color(255, 255, 255));
		lblCodiceFiscale.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(lblCodiceFiscale, gbc);
		
		
		
		JLabel lblErrCF = new JLabel("");
		lblErrCF.setOpaque(true);
		lblErrCF.setBackground(new Color(128, 0, 0));
		lblErrCF.setForeground(new Color(255, 255, 255));
		lblErrCF.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblErrCF.setBounds(25, 30, 10, 10);
		lblErrCF.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrCF,gbc);
		
		
		
		
		
		textcodice = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(textcodice, gbc);
		textcodice.setColumns(10);
		
		textcodice.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((!(textcodice.getText().length()==16)))
				{
			    erroreCF="Il codice fiscale deve essere di 16 caratteri";
			    lblErrCF.setText(erroreCF);
			    lblErrCF.setVisible(true);
				}
			    else 
				{
			    	String s="\\D\\D\\D\\D\\D\\D\\d\\d\\D\\d\\d\\D\\d\\d\\d\\D";
		            Pattern p=Pattern.compile(s);
		            Matcher match=p.matcher(textcodice.getText());
		            if (match.matches()==false)
			    	
		            {
			    	erroreCF="Ricontrolla il formato del codice fiscale";                                          
			    	lblErrCF.setText(erroreCF);
				    lblErrCF.setVisible(true);
				    
		            }
		            else 
		            {
		            	
		            	
					    lblErrCF.setVisible(false);
					    
		            	}
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
		
		
		
		JLabel lblCitt = new JLabel("Citta");
		lblCitt.setOpaque(true);
		lblCitt.setBackground(new Color(205, 127, 50));
		lblCitt.setForeground(new Color(255, 255, 255));
		lblCitt.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 5;
		contentPane.add(lblCitt, gbc);
		
		JLabel lblErrCitta = new JLabel("La città non deve contenere numeri");
		lblErrCitta.setOpaque(true);
		lblErrCitta.setBackground(new Color(128, 0, 0));
		lblErrCitta.setForeground(new Color(255, 255, 255));
		lblErrCitta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrCitta.setBounds(25, 30, 10, 10);
		lblErrCitta.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrCitta,gbc);
		
		
		textcitta = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 5;
		contentPane.add(textcitta, gbc);
		textcitta.setColumns(10);
		
		textcitta.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrCitta.setVisible(true);
                }
				else
				{
				lblErrCitta.setVisible(false);
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
		
		
		
		
		
		
		JLabel lblVia = new JLabel("Via");
		lblVia.setOpaque(true);
		lblVia.setBackground(new Color(205, 127, 50));
		lblVia.setForeground(new Color(255, 255, 255));
		lblVia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 6;
		contentPane.add(lblVia, gbc);
		
		JLabel lblErrVia = new JLabel("La via non deve contenere numeri");
		lblErrVia.setOpaque(true);
		lblErrVia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrVia.setBackground(new Color(128, 0, 0));
		lblErrVia.setForeground(new Color(255, 255, 255));
		lblErrVia.setBounds(25, 30, 10, 10);
		lblErrVia.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrVia,gbc);
		
		
		
		textvia = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 6;
		contentPane.add(textvia, gbc);
		textvia.setColumns(10);
		
		
		textvia.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
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
		
		JLabel lblNumeroCivico = new JLabel("Numero Civico");
		lblNumeroCivico.setOpaque(true);
		lblNumeroCivico.setBackground(new Color(205, 127, 50));
		lblNumeroCivico.setForeground(new Color(255, 255, 255));
		lblNumeroCivico.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 7;
		contentPane.add(lblNumeroCivico, gbc);
		
		JLabel lblErrNC = new JLabel("Il numero civico non può contenere lettere");
		lblErrNC.setOpaque(true);
		lblErrNC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrNC.setBackground(new Color(128, 0, 0));
		lblErrNC.setForeground(new Color(255, 255, 255));
		lblErrNC.setBounds(25, 30, 10, 10);
		lblErrNC.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrNC,gbc);
		
		
		
		textnumciv = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 7;
		contentPane.add(textnumciv, gbc);
		textnumciv.setColumns(10);
		
		textnumciv.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrNC.setVisible(true);
                }
				else
				{
				lblErrNC.setVisible(false);
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
		

		JLabel lblTelefono = new JLabel("Recapito telefonico(Premi spazio dopo)");
		lblTelefono.setOpaque(true);
		lblTelefono.setBackground(new Color(205, 127, 50));
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 8;
		contentPane.add(lblTelefono, gbc);
		
		JLabel lblErrT = new JLabel("");
		lblErrT.setOpaque(true);
		lblErrT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrT.setBackground(new Color(128, 0, 0));
		lblErrT.setForeground(new Color(255, 255, 255));
		lblErrT.setBounds(25, 30, 10, 10);
		lblErrT.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrT,gbc);
		
		
		
		texttelefono = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 8;
		contentPane.add(texttelefono, gbc);
		texttelefono.setColumns(10);
		
		texttelefono.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((!(texttelefono.getText().length()==10)))
				{
			    String erroreT="Il telefono deve essere di 10 caratteri";
			    lblErrT.setText(erroreT);
			    lblErrT.setVisible(true);
				}
			    else 
				{
			    	String s="\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d";
		            Pattern p=Pattern.compile(s);
		            Matcher match=p.matcher(texttelefono.getText());
		            if (match.matches()==false)
			    	
		            {
			    	String erroreT2="Ricontrolla il formato del telefono";                                          
			    	lblErrT.setText(erroreT2);
				    lblErrT.setVisible(true);
				    
		            }
		            else 
		            {
		            	
		            	
					    lblErrT.setVisible(false);
					    
		            	}
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
		
		
		JLabel lblDatiutenza = new JLabel("Dati di Accesso");
		lblDatiutenza.setOpaque(true);
		lblDatiutenza.setBackground(new Color(65, 105, 225));
		lblDatiutenza.setForeground(new Color(255, 255, 255));
		lblDatiutenza.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 9;
		contentPane.add(lblDatiutenza, gbc);
		
		
		JLabel lblIndirizzoMail = new JLabel("Indirizzo mail(Premi spazio dopo)");
		lblIndirizzoMail.setOpaque(true);
		lblIndirizzoMail.setBackground(new Color(205, 127, 50));
		lblIndirizzoMail.setForeground(new Color(255, 255, 255));
		lblIndirizzoMail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 10;
		contentPane.add(lblIndirizzoMail, gbc);
		
		JLabel lblErrMail = new JLabel("");
		lblErrMail.setOpaque(true);
		lblErrMail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrMail.setBackground(new Color(128, 0, 0));
		lblErrMail.setForeground(new Color(255, 255, 255));
		lblErrMail.setBounds(25, 30, 10, 10);
		lblErrMail.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrMail,gbc);
		
		
		
		textmail = new JTextField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 10;
		contentPane.add(textmail, gbc);
		textmail.setColumns(10);
		
		textmail.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				
			    	String s="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		            Pattern p=Pattern.compile(s,Pattern.CASE_INSENSITIVE);
		            Matcher match=p.matcher(textmail.getText());
		            if (match.matches()==false)
			    	
		            {
			    	String erroreT2="Ricontrolla il formato della mail";                                          
			    	lblErrMail.setText(erroreT2);
				    lblErrMail.setVisible(true);
				    
		            }
		            else 
		            {
		            	
		            	
					    lblErrMail.setVisible(false);
					    
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
		
		
		
		
		
		JLabel lblNomeutente = new JLabel("Nome Utente");
		lblNomeutente.setOpaque(true);
		lblNomeutente.setBackground(new Color(205, 127, 50));
		lblNomeutente.setForeground(new Color(255, 255, 255));
		lblNomeutente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 11;
		contentPane.add(lblNomeutente, gbc);
		
		JLabel lblErrNomeUt = new JLabel("Il numero civico non può contenere lettere");
		lblErrNomeUt.setOpaque(true);
		lblErrNomeUt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrNomeUt.setBackground(new Color(128, 0, 0));
		lblErrNomeUt.setForeground(new Color(255, 255, 255));
		lblErrNomeUt.setBounds(25, 30, 10, 10);
		lblErrNomeUt.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErrNomeUt,gbc);
			 
		textnomeutente = new JTextField();
	    gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 11;
		textnomeutente.setColumns(10);
		contentPane.add(textnomeutente, gbc);
		
		
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setBackground(new Color(205, 127, 50));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 12;
		contentPane.add(lblPassword, gbc);
		
		JLabel lblErr1P = new JLabel("Il numero civico non può contenere lettere");
		lblErr1P.setOpaque(true);
		lblErr1P.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErr1P.setBackground(new Color(128, 0, 0));
		lblErr1P.setForeground(new Color(255, 255, 255));
		lblErr1P.setBounds(25, 30, 10, 10);
		lblErr1P.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErr1P,gbc);
		
		pass = new JPasswordField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 12;
		pass.setColumns(10);
		contentPane.add(pass, gbc);
		
		
		
		
		JLabel lbl2Password = new JLabel("Ripeti Password");
		lbl2Password.setOpaque(true);
		lbl2Password.setBackground(new Color(205, 127, 50));
		lbl2Password.setForeground(new Color(255, 255, 255));
		lbl2Password.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 13;
		contentPane.add(lbl2Password, gbc);
		
		JLabel lblErr2P = new JLabel("Il numero civico non può contenere lettere");
		lblErr2P.setOpaque(true);
		lblErr2P.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErr2P.setBackground(new Color(128, 0, 0));
		lblErr2P.setForeground(new Color(255, 255, 255));
		lblErr2P.setBounds(25, 30, 10, 10);
		lblErr2P.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 13;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblErr2P,gbc);
		
		secondapass = new JPasswordField();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 13;
		secondapass.setColumns(10);
		contentPane.add(secondapass, gbc);
		
		
		JLabel lblTipoUtente = new JLabel("Tipo utente");
		lblTipoUtente.setOpaque(true);
		lblTipoUtente.setBackground(new Color(205, 127, 50));
		lblTipoUtente.setForeground(new Color(255, 255, 255));
		lblTipoUtente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 14;
		contentPane.add(lblTipoUtente, gbc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tesserato","Istruttore"}));
		comboBox.setVisible(true);
		comboBox.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 14;
		contentPane.add(comboBox, gbc);
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		
		
		
		JButton btnRegistratiAlNostro = new JButton("Registrati al nostro portale!");
		btnRegistratiAlNostro.setBackground(new Color(0, 168, 107));
		btnRegistratiAlNostro.setForeground(new Color(255, 255, 255));
		btnRegistratiAlNostro.setFont(new Font("SansSerif", Font.PLAIN, 14));
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.gridx = 1;
		gbc.gridy = 16;
		contentPane.add(btnRegistratiAlNostro, gbc);
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			lblNome.setForeground(Color.BLACK);
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			lblCognome.setForeground(Color.BLACK);
			lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			lblNomeutente.setForeground(Color.BLACK);
			lblNomeutente.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
			lblIndirizzoMail.setForeground(Color.BLACK);
			lblIndirizzoMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
			lblPassword.setForeground(Color.BLACK);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			lblTelefono.setForeground(Color.BLACK);
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		if(texttelefono.getText().isEmpty()||textnome.getText().isEmpty()||textcognome.getText().isEmpty()||textnomeutente.getText().isEmpty()||textmail.getText().isEmpty()||pass.getText().isEmpty()||secondapass.getText().isEmpty()||textcodice.getText().isEmpty()||textcitta.getText().isEmpty()||textvia.getText().isEmpty()||textnumciv.getText().isEmpty())
		{
			if(texttelefono.getText().isEmpty())
			{
				lblTelefono.setForeground(Color.RED);
				lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrT.setText("Il campo è vuoto");
				lblErrT.setVisible(true);
			}
			if(textnumciv.getText().isEmpty())
			{
				lblNumeroCivico.setForeground(Color.RED);
				lblNumeroCivico.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNC.setText("Il campo è vuoto");
				lblErrNC.setVisible(true);
			}
			if(textvia.getText().isEmpty())
			{
				lblVia.setForeground(Color.RED);
				lblVia.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrVia.setText("Il campo è vuoto");
				lblErrVia.setVisible(true);
			}
			if(textcitta.getText().isEmpty())
			{
				lblCitt.setForeground(Color.RED);
				lblCitt.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrCitta.setText("Il campo è vuoto");
				lblErrCitta.setVisible(true);
			}
			if(textcodice.getText().isEmpty())
			{
				lblCodiceFiscale.setForeground(Color.RED);
				lblCodiceFiscale.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrCF.setText("Il campo è vuoto");
				lblErrCF.setVisible(true);
			}
			if(textnome.getText().isEmpty())
			{
				lblNome.setForeground(Color.RED);
				lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNome.setText("Il campo è vuoto");
				lblErrNome.setVisible(true);
			}
			if(textcognome.getText().isEmpty())
			{
				lblCognome.setForeground(Color.RED);
				lblCognome.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrCognome.setText("Il campo è vuoto");
				lblErrCognome.setVisible(true);
			}
			if(textnomeutente.getText().isEmpty())
			{
				lblNomeutente.setForeground(Color.RED);
				lblNomeutente.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNomeUt.setText("Il campo è vuoto");
				lblErrNomeUt.setVisible(true);
			}
			if(textmail.getText().isEmpty())
			{
				lblIndirizzoMail.setForeground(Color.RED);
				lblIndirizzoMail.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrMail.setText("Il campo è vuoto");
				lblErrMail.setVisible(true);
			}
			if(pass.getText().isEmpty())
			{
				lblPassword.setForeground(Color.RED);
				lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErr1P.setText("Il campo è vuoto");
				lblErr1P.setVisible(true);
			}
			if(secondapass.getText().isEmpty())
			{
				lbl2Password.setForeground(Color.RED);
				lbl2Password.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErr2P.setText("Il campo è vuoto");
				lblErr2P.setVisible(true);
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
			bool=Reg_dao.registratesserato(textnome.getText(),textcognome.getText(),textcodice.getText(),textcitta.getText(),textvia.getText(),textnumciv.getText(), textmail.getText(),texttelefono.getText(),textnomeutente.getText(),pass.getText(), comboBox.getSelectedItem().toString());
			else bool=Reg_dao.registraistruttore(textnome.getText(),textcognome.getText(),textcodice.getText(),textcitta.getText(),textvia.getText(),textnumciv.getText(), textmail.getText(),texttelefono.getText(),textnomeutente.getText(),pass.getText(), comboBox.getSelectedItem().toString());
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameIniziale.frame.setVisible(true);
			FrameIniziale.frame.setEnabled(true);
			
	}
								

			}	
		
	})
		
		
		;


}}

