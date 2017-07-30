package VisteUtenteGenerico;



import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.border.Border;


import Listener.Listen;
import Listener.LoginListener;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			JMenuItem mnAccedi = new JMenuItem("Home");
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
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 0;
		contentPane.add(lblNewLabel, gbc);
		
		
		JLabel lblNomeUtente = new JLabel("Nome utente");
		lblNomeUtente.setForeground(Color.GRAY);
		lblNomeUtente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeUtente.setBounds(253, 43, 86, 20);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 5;
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
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(CasellaNomeutente, gbc);
		CasellaNomeutente.setColumns(10);
		CasellaNomeutente.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent arg0) {
				CasellaNomeutente.setBackground(Color.WHITE);
			
				

			}
		});


	    JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(253, 95, 86, 20);
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 7;
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
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(passwordField, gbc);
		passwordField.setColumns(10);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			
		
			public void focusLost(FocusEvent arg0) {
				passwordField.setBackground(Color.WHITE);
			
				if(passwordField.getText().isEmpty())
					lblPassword.setBounds(1075, 0, 150, 24);
				

			}
		});
		

            baccedi = new JButton("Accedi");
	        baccedi.setToolTipText("Esegui l'accesso");
		    baccedi.setFont(new Font("Dialog", Font.PLAIN, 12));
		    baccedi.setBounds(253, 151, 89, 23);
		    baccedi.setContentAreaFilled(true);
            baccedi.addActionListener(new LoginListener(this));
            gbc.insets = new Insets(0, 0, 5, 5);
		    gbc.gridx = 3;
		    gbc.gridy = 9;
		    contentPane.add(baccedi, gbc);
		    frame.getRootPane().setDefaultButton(baccedi); //RENDE ACCEDI PULSANTE PREDEFINITO PER ENTER
        

		
		
			
		
		

	



		passwordField.addKeyListener(new KeyAdapter() {
		
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() && passwordField.getText().isEmpty())
					baccedi.setEnabled(false);
				else
				{
					baccedi.setEnabled(true);
				}
			}
		});



		
		CasellaNomeutente.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() && passwordField.getText().isEmpty())
					baccedi.setEnabled(false);
				else
				{
					baccedi.setEnabled(true);
				}
			}
		});
		
		CasellaNomeutente.addFocusListener(new FocusAdapter() {
			@Override
			
		public void focusLost(FocusEvent arg0) {
			CasellaNomeutente.setBackground(Color.WHITE);
			
			
	}});
		
		
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			
		public void focusLost(FocusEvent arg0) {
			passwordField.setBackground(Color.WHITE);
			
			
	}});		
		
		
		
		
	
                
		
		
		
		
	}
		
		
}



