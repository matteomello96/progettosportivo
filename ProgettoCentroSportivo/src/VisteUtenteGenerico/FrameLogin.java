package VisteUtenteGenerico;



import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.border.Border;

import listener.Listen;
import listener.LoginListener;

import java.awt.Color;




public class FrameLogin extends JFrame {
	private static final long serialVersionUID = 1L;
   
	public static JFrame frame;
	public JTextField CasellaPassword;
    private JTable tabelladisc;
	public JTextField CasellaNomeutenteOLD;
	//private JTextField nullfield;
	public JTextField passwordField;
	private JScrollPane tablescroller;
	public JTextField CasellaNomeutente;
	public final JButton baccedi;
	public static boolean crypt=true;
	int xi;
	int yi;
	private JPanel contentPane;
	public FrameLogin() {
		//FrameLogin.setDefaultLookAndFeelDecorated(true);
		
		frame = new JFrame("Accesso centropolisportivo");
		frame.setTitle("Pagina Login");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		
		frame.setBounds(100, 100, 605, 391);
		
		
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
		
		 
		 frame.addMouseListener(new MouseAdapter(){
		       public void mousePressed(MouseEvent ev){
		        xi = ev.getX();
		        yi = ev.getY();
		       }
		    });
		   
		    frame.addMouseMotionListener(new MouseMotionAdapter() {
		                public void mouseDragged(MouseEvent evt) {
		                    int x = evt.getXOnScreen()-xi;
		                    int y = evt.getYOnScreen()-yi;
		                   System.out.println(x+","+y+"     "+xi+","+yi);
		                    frame.setLocation(x,y); 

		                }
		            });

		    JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			JMenuItem mnAccedi = new JMenuItem("Torna alla Home Page");
			menuBar.add(mnAccedi);
			mnAccedi.addActionListener(new Listen(this));
			mnAccedi.setActionCommand("Vai_home1");
			
			contentPane = new JPanel();
			contentPane.setBackground(new Color (255,193,20));
			contentPane.setLayout(new GridBagLayout());
			 
			GridBagConstraints gbc = new GridBagConstraints();	

			JScrollPane scroll = new JScrollPane(contentPane);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setBounds(50, 30, 300, 50);			
		    frame.getContentPane().add(scroll);
		
			
		
		
		

		

		
		
		

		

		JLabel lblNewLabel = new JLabel("Login al portale");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color (255,255,255));
		lblNewLabel.setBackground(new Color (100,133,217));
		Border b = BorderFactory.createLineBorder(new Color (255,255,255));
		lblNewLabel.setBorder(b);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		
		JLabel lblNomeUtente = new JLabel("Nome utente");
		lblNomeUtente.setOpaque(true);
		
		lblNomeUtente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeUtente.setForeground(new Color (255,255,255));
		lblNomeUtente.setBackground(new Color (100,233,17));
		lblNomeUtente.setBorder(b);
		lblNomeUtente.setBounds(253, 43, 86, 20);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblNomeUtente,gbc);
				


		CasellaNomeutente = new JTextField();
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		CasellaNomeutente.setBorder(border1);
		CasellaNomeutente.setToolTipText("Inserire il nome utente");
		CasellaNomeutente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CasellaNomeutente.setBounds(253, 43, 86, 20);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(CasellaNomeutente, gbc);
		CasellaNomeutente.setColumns(10);
		CasellaNomeutente.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent arg0) {
				CasellaNomeutente.setBackground(Color.WHITE);
				if(CasellaNomeutente.getText().isEmpty())
					CasellaNomeutente.setBackground(Color.CYAN);
				

			}
		});


	    JLabel lblPassword = new JLabel("Password");
	    lblPassword.setOpaque(true);
		lblPassword.setBounds(253, 95, 86, 20);
		lblPassword.setForeground(new Color (255,255,255));
		lblPassword.setBackground(new Color (100,233,17));
		lblPassword.setBorder(b);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(lblPassword, gbc);
		
		
		
		passwordField = new JTextField();
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setToolTipText("Inserire la password");
		passwordField.setBounds(253, 95, 86, 20);
		passwordField.setBorder(border2);
		passwordField.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(passwordField, gbc);
		passwordField.setColumns(10);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			
		
			public void focusGained(FocusEvent arg0) {
				passwordField.setBackground(Color.WHITE);
			    
				if(passwordField.getText().isEmpty())
					passwordField.setBackground(Color.CYAN);
				

			}
		});
		
		
		
		
        JLabel lblBlocMaiuscAttivo = new JLabel("BLOC MAIUSC attivato!");
		lblBlocMaiuscAttivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBlocMaiuscAttivo.setForeground(new Color(255, 69, 0));
		lblBlocMaiuscAttivo.setBounds(25, 30, 10, 10);
		lblBlocMaiuscAttivo.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		contentPane.add(lblBlocMaiuscAttivo,gbc);
		
		
		
            baccedi = new JButton("Accedi");
            baccedi.setVisible(false);
	        baccedi.setToolTipText("Esegui l'accesso");
		    baccedi.setFont(new Font("Dialog", Font.PLAIN, 12));
		    baccedi.setBounds(253, 151, 89, 23);
		    baccedi.setContentAreaFilled(true);
            baccedi.addActionListener(new LoginListener(this));
            baccedi.setForeground(new Color (255,255,255));
    		baccedi.setBackground(new Color (10,133,217));
    		baccedi.setBorder(b);
             gbc.insets = new Insets(0, 0, 5, 5);
		    gbc.gridx = 3;
		    gbc.gridy = 9;
		    gbc.anchor = GridBagConstraints.LINE_START;
		    contentPane.add(baccedi, gbc); 
		    frame.getRootPane().setDefaultButton(baccedi); //RENDE ACCEDI PULSANTE PREDEFINITO PER ENTER
            
            
        
   
		CasellaNomeutente.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() || passwordField.getText().isEmpty())
					baccedi.setVisible(false);
				else
				{
					baccedi.setVisible(true);
					baccedi.setEnabled(true);
				}
			}
		});
		 passwordField.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() || passwordField.getText().isEmpty())
					baccedi.setVisible(false);
				else
				{
					baccedi.setVisible(true);
					baccedi.setEnabled(true);
				}
			}
		});
			
		
		CasellaNomeutente.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if ( Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK))
				{
					lblBlocMaiuscAttivo.setVisible(true);
					//lblBlocMaiuscAttivo.setBounds(283, 282, 136, 14);
				}

				else
				{
					lblBlocMaiuscAttivo.setVisible(false);
				}
				
			}
		
	});
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) { //ascolta i keystrokes
				if ( Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK))
				{
					lblBlocMaiuscAttivo.setVisible(true);
					//lblBlocMaiuscAttivo.setBounds(283, 282, 136, 14);
				}

				else
				{
					lblBlocMaiuscAttivo.setVisible(false);
				}	
				
			}
		
		
	
                
		
		
		
		
	});
		
}}



