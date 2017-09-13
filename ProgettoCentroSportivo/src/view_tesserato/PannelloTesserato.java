package view_tesserato;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import ClassiDAOIstruttore.ElencoAttDAO;
import ClassiDAOIstruttore.ElencoEventiDAO;
import ClassiDAOIstruttore.EliminaAttDAO;
import ClassiDAOIstruttore.EliminaEventoDAO;
import ClassiDao.DettagliUtenteDAO;
import ClassiDao.GetInfoDB;
import Model.Utente;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.FrameModificaDati;
import listener.Listen;
import modelliTabelleIstruttore.ModElAttIstr;
import modelliTabelleIstruttore.ModElEventiIstr;
public class PannelloTesserato extends JFrame {
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
    	public PannelloTesserato() {
    		frame = new JFrame();
    		String username=""+Utente.getUsername()+"";
    		frame.setTitle("Pannello di controllo tesserato "+username+"");
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setBounds(100, 100, 605, 391);
    		frame.setVisible(true);
    		frame.setAutoRequestFocus(true);
    		frame.setResizable(true);
    		
    		
    		JMenuBar menuBar = new JMenuBar();
    		frame.setJMenuBar(menuBar);
    		
    		JMenu mnNewMenu = new JMenu("Esci dal pannello di controllo");
    		menuBar.add(mnNewMenu);
    		
    		JMenu mnNewMenu_1 = new JMenu("Visualizza");
    		menuBar.add(mnNewMenu_1);
    		
    		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
    		mnNewMenu.add(mntmNewMenuItem);
    		mntmNewMenuItem.addActionListener(new Listen(this));
    		mntmNewMenuItem.setActionCommand("logouttes");
    		
    		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Elenco attività da scegliere ");
    		mntmNewMenuItem_4.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				frame.dispose();
    				new FrameAttivitaTes();
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_4);
    		
    		JMenuItem mntmNewMenuItem_5 = new JMenuItem("I tuoi eventi da scegliere ");
    		mntmNewMenuItem_5.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				frame.dispose();
    				new FrameEventi();
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_5);

    		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Le tue testimonianze");
    		mntmNewMenuItem_2.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				frame.dispose();
    				new FrameVisTest();
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_2);
    		
    		JMenuItem mntmNewMenuItem_3 = new JMenuItem("I tuoi ordini:attività");
    		mntmNewMenuItem_3.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				
    				frame.dispose();
    				new FrameIscrDisc();
    				
    				
    				
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_3);
    		
    		JMenuItem mntmNewMenuItem_6 = new JMenuItem("I tuoi ordini:eventi");
    		mntmNewMenuItem_6.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				
    				frame.dispose();
    				new FrameIscrEventiTest();
    				
    				
    				
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_6);
    		
    		
    		
    		contentPane = new JPanel();
    		contentPane.setBackground(new Color (64,224,208));
    		contentPane.setLayout(new GridBagLayout());
    		
    		
    		GridBagConstraints gbc = new GridBagConstraints();
     
    		JScrollPane scroll = new JScrollPane(contentPane);
    		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    		scroll.setBounds(50, 30, 300, 50);			
    	    frame.getContentPane().add(scroll);
    		
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
    		
    		JLabel lblErrNome = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getNome()+"");
    		lblErrNome.setOpaque(true);
    		lblErrNome.setBackground(new Color(255, 255, 255));
    		lblErrNome.setForeground(new Color(0, 0, 0));
    		lblErrNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrNome.setBounds(25, 30, 10, 10);
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 2;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrNome,gbc);

    		
    		
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
    		
    		
    		JLabel lblErrCognome = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getCognome()+"");
    		lblErrCognome.setOpaque(true);
    		lblErrCognome.setBackground(new Color(255, 255, 255));
    		lblErrCognome.setForeground(new Color(0, 0, 0));
    		lblErrCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrCognome.setBounds(25, 30, 10, 10);
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 3;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrCognome,gbc);
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
    		lblCodiceFiscale.setOpaque(true);
    		lblCodiceFiscale.setBackground(new Color(205, 127, 50));
    		lblCodiceFiscale.setForeground(new Color(255, 255, 255));
    		lblCodiceFiscale.setFont(new Font("SansSerif", Font.PLAIN, 14));
    		gbc.anchor = GridBagConstraints.LINE_END;
    		gbc.insets = new Insets(5, 0, 0, 10);
    		gbc.gridx = 0;
    		gbc.gridy = 4;
    		contentPane.add(lblCodiceFiscale, gbc);
    		
    		
    		
    		JLabel lblErrCF = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getCodicefiscale()+"");
    		lblErrCF.setOpaque(true);
    		lblErrCF.setBackground(new Color(255, 255, 255));
    		lblErrCF.setForeground(new Color(0, 0, 0));
    		lblErrCF.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrCF.setBounds(25, 30, 10, 10);
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx =1;
    		gbc.gridy = 4;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		contentPane.add(lblErrCF,gbc);
    		
    		
    		
    		
    		
    		
    		
    		
    		
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
    		
    		JLabel lblErrCitta = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getCitta()+"");
    		lblErrCitta.setOpaque(true);
    		lblErrCitta.setBackground(new Color(255, 255,255));
    		lblErrCitta.setForeground(new Color(0, 0, 0));
    		lblErrCitta.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrCitta.setBounds(25, 30, 10, 10);
    		
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 5;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrCitta,gbc);
    		
    		
    		
    		
    		
    		
    		
    		
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
    		
    		JLabel lblErrVia = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getVia()+"");
    		lblErrVia.setOpaque(true);
    		lblErrVia.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrVia.setBackground(new Color(255, 255, 255));
    		lblErrVia.setForeground(new Color(0, 0, 0));
    		lblErrVia.setBounds(25, 30, 10, 10);
    		
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 6;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrVia,gbc);
    		
    		
    		
    		
    		
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
    		
    		JLabel lblErrNC = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getNumcivico()+"");
    		lblErrNC.setOpaque(true);
    		lblErrNC.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrNC.setBackground(new Color(255,255,255));
    		lblErrNC.setForeground(new Color(0, 0, 0));
    		lblErrNC.setBounds(25, 30, 10, 10);
    		
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 7;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrNC,gbc);
    		
    		
    		
    		

    		JLabel lblTelefono = new JLabel("Recapito telefonico");
    		lblTelefono.setOpaque(true);
    		lblTelefono.setBackground(new Color(205, 127, 50));
    		lblTelefono.setForeground(new Color(255, 255, 255));
    		lblTelefono.setFont(new Font("SansSerif", Font.PLAIN, 14));
    		gbc.anchor = GridBagConstraints.LINE_END;
    		gbc.insets = new Insets(5, 0, 0, 10);
    		gbc.gridx = 0;
    		gbc.gridy = 8;
    		contentPane.add(lblTelefono, gbc);
    		
    		JLabel lblErrT = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getTelefono()+"");
    		lblErrT.setOpaque(true);
    		lblErrT.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrT.setBackground(new Color(255, 255, 255));
    		lblErrT.setForeground(new Color(0, 0, 0));
    		lblErrT.setBounds(25, 30, 10, 10);
    		
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 8;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrT,gbc);
    		
    		
    		
    		

    			
    		
    		
    		JLabel lblDatiutenza = new JLabel("Dati di Accesso");
    		lblDatiutenza.setOpaque(true);
    		lblDatiutenza.setBackground(new Color(65, 105, 225));
    		lblDatiutenza.setForeground(new Color(255, 255, 255));
    		lblDatiutenza.setFont(new Font("SansSerif", Font.PLAIN, 14));
    		gbc.anchor = GridBagConstraints.LINE_END;
    		gbc.insets = new Insets(5, 0, 0, 10);
    		gbc.gridx = 0;
    		gbc.gridy = 9;
    		contentPane.add(lblDatiutenza, gbc);
    		
    		
    		JLabel lblIndirizzoMail = new JLabel("Indirizzo mail");
    		lblIndirizzoMail.setOpaque(true);
    		lblIndirizzoMail.setBackground(new Color(205, 127, 50));
    		lblIndirizzoMail.setForeground(new Color(255, 255, 255));
    		lblIndirizzoMail.setFont(new Font("SansSerif", Font.PLAIN, 14));
    		gbc.anchor = GridBagConstraints.LINE_END;
    		gbc.insets = new Insets(5, 0, 0, 10);
    		gbc.gridx = 0;
    		gbc.gridy = 10;
    		contentPane.add(lblIndirizzoMail, gbc);
    		
    		JLabel lblErrMail = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getMail()+"");
    		lblErrMail.setOpaque(true);
    		lblErrMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrMail.setBackground(new Color(255, 255,255));
    		lblErrMail.setForeground(new Color(0, 0,0));
    		lblErrMail.setBounds(25, 30, 10, 10);
    		
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 10;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrMail,gbc);
    		
    		
    		
    		
    		
    		
    		
    		
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
    		
    		JLabel lblErrNomeUt = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getUser()+"");
    		lblErrNomeUt.setOpaque(true);
    		lblErrNomeUt.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErrNomeUt.setBackground(new Color(255,255,255));
    		lblErrNomeUt.setForeground(new Color(0, 0, 0));
    		lblErrNomeUt.setBounds(25, 30, 10, 10);
    		
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 11;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErrNomeUt,gbc);
    			 
    		
    		
    		
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
    		
    		JLabel lblErr1P = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getPass()+"");
    		lblErr1P.setOpaque(true);
    		lblErr1P.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblErr1P.setBackground(new Color(255,255,255));
    		lblErr1P.setForeground(new Color(0,0,0));
    		lblErr1P.setBounds(25, 30, 10, 10);
    		
    		gbc.insets = new Insets(0, 0, 5, 5);
    		gbc.gridx = 1;
    		gbc.gridy = 12;
    		gbc.anchor = GridBagConstraints.LINE_START;
    		
    		contentPane.add(lblErr1P,gbc);
    		
    		
    		
    		
    		
    		
    		JButton btnNewButton7 = new JButton("Modifica dati");
    		btnNewButton7.setMnemonic('i');
    		btnNewButton7.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				frame.setVisible(false);
    				frame.dispose();
    				new FrameModificaDati(""+Utente.getUsername()+"");
    				
    			}
    		});	
    		gbc.anchor = GridBagConstraints.LINE_START;
    		gbc.gridwidth = 2;
    		gbc.gridx = 2;
    		gbc.gridy = 13;
    		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
    		
    	
    	
    		
    		
    		
    		
    		contentPane.add(btnNewButton7, gbc);
    	
    	}
    }
