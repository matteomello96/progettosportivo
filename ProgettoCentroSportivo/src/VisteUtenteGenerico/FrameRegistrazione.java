package VisteUtenteGenerico;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;
import listener.Listen;
import listener.VariListener;
import ClassiDao.Reg_dao;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;






public class FrameRegistrazione extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane,Panel1,Panel2,Panel3;
	
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
		
		
		
		
	
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone1.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone2.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo1.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (64,224,208));
		contentPane.setLayout(new BorderLayout());
		 
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
		
        JButton btn = new JButton(im);
		
		JLabel lbl= new JLabel("Registrati al portale"); 
		
		
		Panel1 = new JPanel();
		Panel1.setBackground(new Color(229, 43, 80));
		Panel1.setLayout(new GridBagLayout());
		
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2, "Form di registrazione"), BorderLayout.NORTH);
		
		Panel2 = new JPanel();
		Panel2.setBackground(new Color(229, 43, 80));
		Panel2.setLayout(new GridBagLayout());
		
		
		
		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "Dati Anagrafici");
		
		
		
		JLabel lblNome = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblNome, "Nome", 0, 1);
		
		JLabel lblErrNome = new JLabel();
		VariListener.SettaErr("Il nome non deve contenere numeri",lblErrNome, 2, 1, Panel2);

		
		textnome = new JTextField();
		VariListener.SettaTextField(Panel2, textnome, "Inserire nome", 1,1);
		VariListener.SettaFocus(textnome);
		
		textnome.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrNome.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrNome.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		
		JLabel lblCognome = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblCognome, "Cognome", 0, 2);
		
		
		JLabel lblErrCognome = new JLabel();
		VariListener.SettaErr("Il cognome non deve contenere numeri",lblErrCognome, 2, 2, Panel2);
		
		
		
		
		textcognome = new JTextField();
		VariListener.SettaTextField(Panel2, textcognome, "Inserire città", 1,2);
		VariListener.SettaFocus(textcognome);
		
		textcognome.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((ke.getKeyChar()+"").matches("[0-9]+$")){
                lblErrCognome.setVisible(true);
                btn.setVisible(false);
                lbl.setVisible(false);
                }
				else
				{
				lblErrCognome.setVisible(false);
				btn.setVisible(true);
                lbl.setVisible(true);
				}
		}

			});
		
		
		
		
		
		
		JLabel lblCodiceFiscale = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblCodiceFiscale, "Codice Fiscale(Premi spazio alla fine)", 0, 3);
		
		
		
		JLabel lblErrCF = new JLabel("");
		VariListener.SettaErr("",lblErrCF, 2, 3, Panel2);
		
		
		
		
		
		textcodice = new JTextField();
		VariListener.SettaTextField(Panel2, textcodice, "Inserire codice fiscale", 1,3);
		VariListener.SettaFocus(textcodice);
		
		textcodice.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
		
		{
				
				if((!(textcodice.getText().length()==16)))
				{
			    erroreCF="Il codice fiscale deve essere di 16 caratteri";
			    lblErrCF.setText(erroreCF);
			    lblErrCF.setVisible(true);
			    btn.setVisible(false);
                lbl.setVisible(false);
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
				    btn.setVisible(false);
	                lbl.setVisible(false);
				    
		            }
		            else 
		            {
		            	
		            	
					    lblErrCF.setVisible(false);
					    btn.setVisible(true);
		                lbl.setVisible(true);
		            	}
			     }
			    
				
				
		}

			});
		
		
		
		JLabel lblCitt = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblCitt,"Citta" , 0, 4);
		
		JLabel lblErrCitta = new JLabel();
		VariListener.SettaErr("La città non deve contenere numeri",lblErrCitta, 2, 4, Panel2);
		
		
		textcitta = new JTextField();
		VariListener.SettaTextField(Panel2, textcitta, "Inserire città", 1,4);
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
		
		
		
		
		
		
		JLabel lblVia = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblVia,"Via" , 0, 5);
		
		JLabel lblErrVia = new JLabel();
		VariListener.SettaErr("La via non deve contenere numeri",lblErrVia, 2, 5, Panel2);
		
		
		
		textvia = new JTextField();
		VariListener.SettaTextField(Panel2, textvia, "Inserire via", 1,5);
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
		VariListener.SettaLabelGen(Panel2,lblNumeroCivico,"Numero Civico" , 0, 6);
		
		JLabel lblErrNC = new JLabel();
		VariListener.SettaErr("Il numero civico non può contenere lettere",lblErrNC, 2, 6, Panel2);
		
		
		
		textnumciv = new JTextField();
		VariListener.SettaTextField(Panel2, textnumciv, "Inserire numero civico", 1,6);
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
		VariListener.SettaLabelGen(Panel2,lblTelefono,"Recapito telefonico(Premi spazio dopo)" , 0, 7);
		
		JLabel lblErrT = new JLabel();
		VariListener.SettaErr("",lblErrT, 2, 7, Panel2);
		
		
		
		texttelefono = new JTextField();
		VariListener.SettaTextField(Panel2, texttelefono, "Inserire telefono", 1,7);
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
			    	String erroreT2="Ricontrolla il formato del telefono";                                          
			    	lblErrT.setText(erroreT2);
				    lblErrT.setVisible(true);
				    btn.setVisible(false);
	                lbl.setVisible(false);
				    
		            }
		            else 
		            {
		            	
		            	
					    lblErrT.setVisible(false);
					    btn.setVisible(true);
		                lbl.setVisible(true);
		            	}
			     }
			    
				
				
		}

			});
		
		
		
		VariListener.SettaPannelloTitolo(im3, Panel2, 1, 9, "Dati di accesso al Centro");
		
		
		JLabel lblIndirizzoMail = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblIndirizzoMail,"Indirizzo mail(Premi spazio dopo)" , 0, 10);
		
		JLabel lblErrMail = new JLabel("");
		VariListener.SettaErr("",lblErrMail, 2, 10, Panel2);
		
		
		
		textmail = new JTextField();
		VariListener.SettaTextField(Panel2, textmail, "Inserire mail", 1,10);
		VariListener.SettaFocus(textmail);
		
		textmail.addKeyListener(new KeyAdapter(){
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
				    btn.setVisible(false);
	                lbl.setVisible(false);
		            }
		            else 
		            {
		            	
		            	
					    lblErrMail.setVisible(false);
					    btn.setVisible(true);
		                lbl.setVisible(true);
		            	}
			     
			    
				
				
		}

			});
		
		
		
		
		
		JLabel lblNomeutente = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblNomeutente,"Nome Utente" , 0, 11);
		
		JLabel lblErrNomeUt = new JLabel("");
		VariListener.SettaErr("",lblErrNomeUt, 2, 11, Panel2);
			 
		textnomeutente = new JTextField();
		VariListener.SettaTextField(Panel2, textnomeutente, "Inserire nome utente", 1,11);
		VariListener.SettaFocus(textnomeutente);
		
		
		
		
		JLabel lblPassword = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblPassword,"Password" , 0, 12);
		
		JLabel lblErr1P = new JLabel();
		VariListener.SettaErr("",lblErr1P, 2, 12, Panel2);
		
		pass = new JPasswordField();
		VariListener.SettaTextField(Panel2, pass, "Inserire passowrd", 1,12);
		VariListener.SettaFocus(pass);
		
		
		
		
		JLabel lbl2Password = new JLabel();
		VariListener.SettaLabelGen(Panel2,lbl2Password,"Ripeti Password" , 0, 13);
		
		JLabel lblErr2P = new JLabel();
		VariListener.SettaErr("",lblErr2P, 2, 13, Panel2);
		
		secondapass = new JPasswordField();
		VariListener.SettaTextField(Panel2, secondapass, "Inserire seconda passowrd", 1,13);
		VariListener.SettaFocus(secondapass);
		
		
		JLabel lblTipoUtente = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblTipoUtente,"Tipo Utente" , 0, 14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tesserato","Istruttore"}));
		comboBox.setVisible(true);
		comboBox.setEditable(false);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 14;
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Panel2.add(comboBox, gbc);
		
	
		
contentPane.add(Panel2,BorderLayout.CENTER);
		
		
		
		Panel3 = new JPanel();
		Panel3.setBackground(new Color(229, 43, 80));
		Panel3.setLayout(new GridBagLayout());

		
		
		
		
        VariListener.SettaBtn(Panel3, btn, lbl,"Registrati al portale", 2, 2,im2,false);
       
        
        btn.setToolTipText("Registrati");
		btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			
		
		
		if(texttelefono.getText().isEmpty()||textnome.getText().isEmpty()||textcognome.getText().isEmpty()||textnomeutente.getText().isEmpty()||textmail.getText().isEmpty()||pass.getText().isEmpty()||secondapass.getText().isEmpty()||textcodice.getText().isEmpty()||textcitta.getText().isEmpty()||textvia.getText().isEmpty()||textnumciv.getText().isEmpty())
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
			if(textcodice.getText().isEmpty())
			{
				lblCodiceFiscale.setForeground(Color.BLUE);
				lblCodiceFiscale.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrCF.setText("Il campo è vuoto");
				lblErrCF.setVisible(true);
			}
			if(textnome.getText().isEmpty())
			{
				lblNome.setForeground(Color.BLUE);
				lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrNome.setText("Il campo è vuoto");
				lblErrNome.setVisible(true);
			}
			if(textcognome.getText().isEmpty())
			{
				lblCognome.setForeground(Color.BLUE);
				lblCognome.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrCognome.setText("Il campo è vuoto");
				lblErrCognome.setVisible(true);
			}
			if(textnomeutente.getText().isEmpty())
			{
				lblNomeutente.setForeground(Color.BLUE);
				lblNomeutente.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrNomeUt.setText("Il campo è vuoto");
				lblErrNomeUt.setVisible(true);
			}
			if(textmail.getText().isEmpty())
			{
				lblIndirizzoMail.setForeground(Color.BLUE);
				lblIndirizzoMail.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErrMail.setText("Il campo è vuoto");
				lblErrMail.setVisible(true);
			}
			if(pass.getText().isEmpty())
			{
				lblPassword.setForeground(Color.BLUE);
				lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErr1P.setText("Il campo è vuoto");
				lblErr1P.setVisible(true);
			}
			if(secondapass.getText().isEmpty())
			{
				lbl2Password.setForeground(Color.BLUE);
				lbl2Password.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblErr2P.setText("Il campo è vuoto");
				lblErr2P.setVisible(true);
			}
			
			JOptionPane.showMessageDialog(frame, "Riempire tutti i campi obbligatori"," ",JOptionPane.WARNING_MESSAGE);
		}
		else if(!pass.getText().equals(secondapass.getText())){
			lblPassword.setForeground(Color.BLUE);
			lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		
									
			lbl2Password.setForeground(Color.BLUE);
			lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
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
			new FrameIniziale();
			FrameIniziale.frame.setVisible(true);
			FrameIniziale.frame.setEnabled(true);
			
	}
								

			}	
		
	})
		
		
		;

		 contentPane.add(Panel3,BorderLayout.SOUTH);
}}

