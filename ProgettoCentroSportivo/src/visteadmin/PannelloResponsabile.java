package visteadmin;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ScrollPaneConstants;

import ClassiDao.DettagliUtenteDAO;

import Model.Utente;

import VisteUtenteGenerico.FrameModificaDati;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModElAttIstr;
import modelliTabelleIstruttore.ModElEventiIstr;
public class PannelloResponsabile extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel contentPane,tabellaPnl,tabellaPnl2,bottoniPnl1,bottoniPnl2,Panel1,Panel2,Panel3;
	public static JTable table,table2;
    private ModElEventiIstr model;
    private ModElAttIstr model2;
	
    
    	
    	

    	/**
    	 * Create the frame.
    	 */
    	public PannelloResponsabile() {
    		frame = new JFrame();
    		String username=""+Utente.getUsername()+"";
    		frame.setTitle("Pannello di controllo responsabile "+username+"");
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
    		mntmNewMenuItem.setActionCommand("logoutresp");
    		
    		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Richieste di iscrizione alle discipline ");
    		mntmNewMenuItem_4.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				frame.dispose();
    				new FrameOrdini();
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_4);
    		
    		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Richieste di iscrizione agli eventi ");
    		mntmNewMenuItem_5.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				frame.dispose();
    				new FrameEventiResp();
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_5);

    		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Elenco Iscritti");
    		mntmNewMenuItem_2.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				frame.dispose();
    				new FrameElencoUtenti();
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_2);
    		
    		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Gestione Centro Polisportivo");
    		mntmNewMenuItem_3.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				
    				frame.dispose();
    				new FrameGestione();
    				
    				
    			}
    		});
    		mnNewMenu_1.add(mntmNewMenuItem_3);
    		
    		

    		ImageIcon im=new ImageIcon("src/immaginijava/bottone6.png");
            ImageIcon im2=new ImageIcon("src/immaginijava/bottone7.png");
            ImageIcon im3=new ImageIcon("src/immaginijava/titolo3.png");
    		
    		
    		contentPane = new JPanel();
    		contentPane.setBackground(new Color (255,185,0));
    		contentPane.setLayout(new BorderLayout());
    		
    		
    		
     
    		JScrollPane scroll = new JScrollPane(contentPane);
    		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    		scroll.setBounds(50, 30, 300, 50);			
    	    frame.getContentPane().add(scroll);
    		
    	    Panel1 = new JPanel();
    		Panel1.setBackground(new Color(255,185,0));
    		Panel1.setLayout(new GridBagLayout());
    		
    		
    		
    		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Pannello di controllo"), BorderLayout.NORTH);
    		
    		Panel2 = new JPanel();
    		Panel2.setBackground(new Color(255,185,0));
    		Panel2.setLayout(new GridBagLayout());
    		
    		
    		
    		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 1, "Dati Anagrafici");
    		
    		
    		
    		JLabel lblNome = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblNome, "Nome", 1, 2);
    		
    		JLabel lblErrNome = new JLabel();
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getNome()+"",lblErrNome, 2, 2, Panel2);

    		
    		
    		JLabel lblCognome = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblCognome,"Cognome", 1, 3);
    		
    		
    		JLabel lblErrCognome = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getCognome()+"");
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getCognome()+"",lblErrCognome, 2, 3, Panel2);
    		
    		
    	
    		JLabel lblCodiceFiscale = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblCodiceFiscale,"Codice Fiscale", 1, 4);
    		
    		
    		
    		JLabel lblErrCF = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getCodicefiscale()+"");
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getCodicefiscale()+"",lblErrCF, 2, 4, Panel2);
    		
    		
    		JLabel lblCitt = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblCitt,"Citta", 1, 5);
    		
    		JLabel lblErrCitta = new JLabel();
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getCitta()+"",lblErrCitta, 2, 5, Panel2);
    		
    		JLabel lblVia = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblVia,"Via", 1, 6);
    		
    		JLabel lblErrVia = new JLabel();
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getVia()+"",lblErrVia, 2, 6, Panel2);
    		
    		JLabel lblNumeroCivico = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblNumeroCivico,"Numero Civico", 1, 7);
    		
    		JLabel lblErrNC = new JLabel();
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getNumcivico()+"",lblErrNC, 2, 7, Panel2);
    		
    		JLabel lblTelefono = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblTelefono,"Recapito telefonico", 1, 8);
    		
    		JLabel lblErrT = new JLabel();
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getTelefono()+"",lblErrT, 2, 10, Panel2);
    		
    		
    		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 9, "Dati di accesso al Centro");
    		
    		
    		JLabel lblIndirizzoMail = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblIndirizzoMail,"Indirizzo mail", 1, 10);
    		
    		JLabel lblErrMail = new JLabel();
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getMail()+"",lblErrMail, 2, 8, Panel2);
    		
    		JLabel lblNomeutente = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblNomeutente,"Nome utente", 1, 11);
    		
    		JLabel lblErrNomeUt = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getUser()+"");
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getUser()+"",lblErrNomeUt, 2, 11, Panel2);
    			 
    		
    		
    		
    		JLabel lblPassword = new JLabel();
    		VariListener.SettaLabelGen(Panel2,lblPassword,"Password", 1, 12);
    		
    		JLabel lblErr1P = new JLabel(""+DettagliUtenteDAO.elencoutente(username).get(0).getPass()+"");
    		VariListener.SettaErr2(""+DettagliUtenteDAO.elencoutente(username).get(0).getPass()+"",lblErr1P, 2, 12, Panel2);
    		
    		
    		
    		
    		
    		
    		contentPane.add(Panel2,BorderLayout.CENTER);
    		
    		
    		
    		Panel3 = new JPanel();
    		Panel3.setBackground(new Color (255,185,0));
    		Panel3.setLayout(new GridBagLayout());

    		
    		
    		
    		JButton btn = new JButton(im);
    		JLabel lbl= new JLabel();
            VariListener.SettaBtn(Panel3, btn, lbl,"Modifica i dati", 2, 2,im2,true);
           
            
            btn.setToolTipText("Modifica i dati");
    		btn.setMnemonic('i');
    		btn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				lbl.setBackground(Color.WHITE);
    				frame.setVisible(false);
    				frame.dispose();
    				new FrameModificaDati(""+Utente.getUsername()+"");
    				
    			}
    		});	
    		
    		contentPane.add(Panel3,BorderLayout.SOUTH);
    	}
    }
