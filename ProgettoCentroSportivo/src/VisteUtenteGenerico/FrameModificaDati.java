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

import ClassiDAOIstruttore.ModificaDatiDAO;
import Model.Home;
import Model.Utente;
import VisteUtenteGenerico.*;
import listener.Listen;
import visteIstruttore.PannelloIstruttore;
import visteadmin.PannelloResponsabile;
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






public class FrameModificaDati extends JFrame {
	
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
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameModificaDati(String user) {
		user= ""+Utente.getUsername()+"";
		frame = new JFrame("Registrazione");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Registrati al nostro portale");
		if(FrameModificaDati.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaDati.frame.getLocation());
		
		
		
		
	
		
		
		
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
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna al pannello di controllo");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_home_p");
		
		
		
		JLabel lblFormDiRegistrazione = new JLabel("Form di Modifica");
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
		
		
		
		
		
		
		
		
		
		
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		
		
		JButton btnRegistratiAlNostro = new JButton("Modifica i tuoi dati");
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
			
	
			lblIndirizzoMail.setForeground(Color.BLACK);
			lblIndirizzoMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
			
		
			lblTelefono.setForeground(Color.BLACK);
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		if(texttelefono.getText().isEmpty()||textmail.getText().isEmpty()||textcitta.getText().isEmpty()||textvia.getText().isEmpty()||textnumciv.getText().isEmpty())
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
			
			if(textmail.getText().isEmpty())
			{
				lblIndirizzoMail.setForeground(Color.RED);
				lblIndirizzoMail.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrMail.setText("Il campo è vuoto");
				lblErrMail.setVisible(true);
			}
			
			
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
			
			bool=ModificaDatiDAO.modificadati(textcitta.getText(),textvia.getText(),textnumciv.getText(), textmail.getText(),texttelefono.getText(),""+Utente.getUsername()+"");
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("I"))
			{
			PannelloIstruttore.frame.setVisible(true);
			PannelloIstruttore.frame.setEnabled(true);
			}
			if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("R"))
			{
			PannelloResponsabile.frame.setVisible(true);
			PannelloResponsabile.frame.setEnabled(true);
			}
			
			
	}
								

			}	
		
	});
		
		
		
       JButton cambia = new JButton("Cambia Password");
		cambia.setBackground(new Color(0, 168, 107));
		cambia.setForeground(new Color(255, 255, 255));
		cambia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc.gridx = 1;
		gbc.gridy = 17;
		contentPane.add(cambia, gbc);
		cambia.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			frame.dispose();
			new FrameCambia();
			}});
		

}}

