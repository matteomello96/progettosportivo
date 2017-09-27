package VisteUtenteGenerico;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ClassiDAOIstruttore.ModificaDatiDAO;
import Model.Utente;
import listener.Listen;
import listener.VariListener;
import view_tesserato.PannelloTesserato;
import visteIstruttore.PannelloIstruttore;
import visteadmin.PannelloResponsabile;
import ClassiDao.GetInfoDB;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;






public class FrameModificaDati extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,Panel1,Panel2,Panel3;
	
	
	private JTextField textcitta;
	private JTextField textvia;
	private JTextField textnumciv;
	private JTextField textmail;
	
	private JTextField texttelefono;
	private boolean bool;
	public String  erroreCF= "";
	
	
	
	
	public FrameModificaDati(String user) {
		user= ""+Utente.getUsername()+"";
		frame = new JFrame("Frame di modifica");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Modifica dei tuoi dati");
		if(FrameModificaDati.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameModificaDati.frame.getLocation());
		
		
		
		
	
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone1.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone2.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo1.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (64,224,208));
		contentPane.setLayout(new BorderLayout());
		 
		
 
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
		
		JButton btn = new JButton(im);
		
		JLabel lbl= new JLabel("Modifica dati");
		
		
		Panel1 = new JPanel();
		Panel1.setBackground(new Color(229, 43, 80));
		Panel1.setLayout(new GridBagLayout());
		
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2, "Form di modifica dei dati"), BorderLayout.NORTH);
		
		Panel2 = new JPanel();
		Panel2.setBackground(new Color(229, 43, 80));
		Panel2.setLayout(new GridBagLayout());
		
		
		
		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 4, "Dati Anagrafici");
		
		
		
		
		
		JLabel lblCitt = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblCitt, "Città", 0, 5);
		
		JLabel lblErrCitta = new JLabel();
		VariListener.SettaErr("La città non deve contenere numeri",lblErrCitta, 2, 5, Panel2);
		
		
		
		textcitta = new JTextField();
		VariListener.SettaTextField(Panel2, textcitta, "Inserire città", 1,5);
		VariListener.SettaFocus(textcitta);
		
		textcitta.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrCitta.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrCitta.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		
		
		
		
		
		
		JLabel lblVia = new JLabel("Via");
		VariListener.SettaLabelGen(Panel2,lblVia, "Via", 0, 6);
		
		JLabel lblErrVia = new JLabel();
		VariListener.SettaErr("La via non deve contenere numeri",lblErrVia, 2, 6, Panel2);
		
		
		
		textvia = new JTextField();
		VariListener.SettaTextField(Panel2, textvia, "Inserire via", 1,6);
		VariListener.SettaFocus(textvia);
		
		
		textvia.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrVia.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrVia.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		
		JLabel lblNumeroCivico = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblNumeroCivico, "Numero civico", 0, 7);
		
		JLabel lblErrNC = new JLabel();
		VariListener.SettaErr("Il numero civico non deve contenere lettere",lblErrNC, 2, 7, Panel2);
		
		
		
		textnumciv = new JTextField();
		VariListener.SettaTextField(Panel2, textnumciv, "Inserire il numero civico", 1,7);
		VariListener.SettaFocus(textnumciv);
		
		textnumciv.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if(!(ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrNC.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrNC.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		

		JLabel lblTelefono = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblTelefono, "Telefono(premi spazio dopo)", 0, 8);
		
		JLabel lblErrT = new JLabel();
		VariListener.SettaErr("Il telefono non deve contenere lettere",lblErrT, 2,8, Panel2);
		
		
		
		texttelefono = new JTextField();
		VariListener.SettaTextField(Panel2, texttelefono, "Inserire il telefono", 1,8);
		VariListener.SettaFocus(texttelefono);
		
		texttelefono.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((!(texttelefono.getText().length()==10)))
				{
			    String erroreT="Il telefono deve essere di 10 caratteri";
			    lblErrT.setText(erroreT);
			    lblErrT.setVisible(true);
			    btn.setVisible(false);
                lbl.setVisible(false);
				}
			    else 
				{
			    	String s="\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d";
		            Pattern p=Pattern.compile(s);
		            Matcher match=p.matcher(texttelefono.getText());
		            if (match.matches()==false)
			    	
		            {
		            	btn.setVisible(false);
			    	String erroreT2="Ricontrolla il formato del telefono";                                          
			    	lblErrT.setText(erroreT2);
				    lblErrT.setVisible(true);
				    btn.setVisible(false);
	                lbl.setVisible(false);
		            }
		            else 
		            {
		            	
		            	btn.setVisible(true);
		                lbl.setVisible(true);
					    lblErrT.setVisible(false);
					    
		            	}
			     }
			    
				
				
		}

			});
		
		
		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 9, "Dati di accesso al Centro");
		
		
		JLabel lblIndirizzoMail = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblIndirizzoMail, "Indirizzo mail(premi spazio dopo)", 0, 10);
		
		JLabel lblErrMail = new JLabel();
		VariListener.SettaErr("",lblErrMail, 2,10, Panel2);
		
		
		
		textmail = new JTextField();
		VariListener.SettaTextField(Panel2, textmail, "Inserire la mail", 1,10);
		VariListener.SettaFocus(textmail);
		
		textmail.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				
			    	String s="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		            Pattern p=Pattern.compile(s,Pattern.CASE_INSENSITIVE);
		            Matcher match=p.matcher(textmail.getText());
		            if (match.matches()==false)
		            	
		            {
		            btn.setVisible(false);
			    	String erroreT2="Ricontrolla il formato della mail";                                          
			    	lblErrMail.setText(erroreT2);
				    lblErrMail.setVisible(true);
				    btn.setVisible(false);
	                lbl.setVisible(false);
		            }
		            else 
		            {
		            	
		            	btn.setVisible(true);
		                lbl.setVisible(true);
					    lblErrMail.setVisible(false);
					    
		            	}
			     
			    
				
				
		}

			});
		
		
		contentPane.add(Panel2,BorderLayout.CENTER);
		
		
		
		Panel3 = new JPanel();
		Panel3.setBackground(new Color(229, 43, 80));
		Panel3.setLayout(new GridBagLayout());

		
		
		
		
        VariListener.SettaBtn(Panel3, btn, lbl,"Modifica i dati", 2, 2,im2,false);
       
        
        btn.setToolTipText("Modifica i dati");
        
         
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
	
			
		
		
		if(texttelefono.getText().isEmpty()||textmail.getText().isEmpty()||textcitta.getText().isEmpty()||textvia.getText().isEmpty()||textnumciv.getText().isEmpty())
		{
			
			if(texttelefono.getText().isEmpty())
			{
				lblTelefono.setForeground(Color.BLUE);
				lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrT.setText("Il campo è vuoto");
				lblErrT.setVisible(true);
			}
			if(textnumciv.getText().isEmpty())
			{
				lblNumeroCivico.setForeground(Color.BLUE);
				lblNumeroCivico.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrNC.setText("Il campo è vuoto");
				lblErrNC.setVisible(true);
			}
			if(textvia.getText().isEmpty())
			{
				lblVia.setForeground(Color.BLUE);
				lblVia.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrVia.setText("Il campo è vuoto");
				lblErrVia.setVisible(true);
			}
			if(textcitta.getText().isEmpty())
			{
				lblCitt.setForeground(Color.BLUE);
				lblCitt.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrCitta.setText("Il campo è vuoto");
				lblErrCitta.setVisible(true);
			}
			
			if(textmail.getText().isEmpty())
			{
				lblIndirizzoMail.setForeground(Color.BLUE);
				lblIndirizzoMail.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrMail.setText("Il campo è vuoto");
				lblErrMail.setVisible(true);
			}
			
			btn.setVisible(false);
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		
		else
			btn.setVisible(true);
		    lbl.setVisible(true);
		    lbl.setForeground(Color.WHITE);
			bool=ModificaDatiDAO.modificadati(textcitta.getText(),textvia.getText(),textnumciv.getText(), textmail.getText(),texttelefono.getText(),""+Utente.getUsername()+"");
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("I"))
			{
				new PannelloIstruttore();
			PannelloIstruttore.frame.setVisible(true);
			PannelloIstruttore.frame.setEnabled(true);
			}
			if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("R"))
			{
				new PannelloResponsabile();
			PannelloResponsabile.frame.setVisible(true);
			PannelloResponsabile.frame.setEnabled(true);
			}
			if (GetInfoDB.getTipo(""+Utente.getUsername()+"").equals("T"))
			{
				new PannelloTesserato();
			PannelloTesserato.frame.setVisible(true);
			PannelloTesserato.frame.setEnabled(true);
			}
			
	}
								

			}	
		
	});
		
		
		
       JButton cambia = new JButton(im);
       JLabel lbl2= new JLabel();
       VariListener.SettaBtn(Panel3, cambia, lbl2,"Cambia la password", 2, 5,im2,true);
       
       cambia.setToolTipText("Cambia la password");
		cambia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				lbl2.setForeground( Color.WHITE);
			frame.setVisible(false);
			frame.dispose();
			new FrameCambia();
			}});
		
 contentPane.add(Panel3,BorderLayout.SOUTH);
}}

