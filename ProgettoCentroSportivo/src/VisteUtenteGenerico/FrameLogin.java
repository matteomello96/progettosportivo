package VisteUtenteGenerico;



import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.border.Border;

import ClassiDao.ElencoDisciplineDAO;
import Listener.Listen;
import Listener.LoginListener;

import java.awt.Color;
import ModelliTabelle.ModDiscIni;

import Model.DisciplinaElenco;



public class FrameLogin extends JFrame {
	private static final long serialVersionUID = 1L;
    private ModDiscIni model;
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
	
	public FrameLogin() {
		//FrameLogin.setDefaultLookAndFeelDecorated(true);
		
		frame = new JFrame("Accesso centropolisportivo");
		frame.setTitle("Pagina Login");
		
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
			

		baccedi = new JButton("Accedi");
		baccedi.setEnabled(true);
	
		frame.getRootPane().setDefaultButton(baccedi); //RENDE ACCEDI PULSANTE PREDEFINITO PER ENTER

		baccedi.setToolTipText("Esegui l'accesso");
		baccedi.setFont(new Font("Dialog", Font.PLAIN, 12));
		baccedi.setBounds(253, 151, 89, 23);
		frame.getContentPane().setLayout(null);
		

		baccedi.setContentAreaFilled(true);
        baccedi.addActionListener(new LoginListener(this));
		frame.getContentPane().add(baccedi);

		
		
		

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 579, 331);
		frame.getContentPane().add(layeredPane);

		final JLabel lblNomeUtente = new JLabel("Nome utente");
		lblNomeUtente.setForeground(Color.GRAY);
		lblNomeUtente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeUtente.setBounds(253, 43, 86, 20);
		layeredPane.add(lblNomeUtente,2,0);
				


		CasellaNomeutente = new JTextField();
		layeredPane.setLayer(CasellaNomeutente, 0);
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		CasellaNomeutente.setBorder(border1);
		
		
		CasellaNomeutente.setToolTipText("Inserire il nome utente");
		CasellaNomeutente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CasellaNomeutente.setBounds(253, 43, 86, 20);
		layeredPane.add(CasellaNomeutente);
		CasellaNomeutente.setColumns(10);
		CasellaNomeutente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblNomeUtente.setBounds(0, 0, 0, 0);
			
				
				

			}
			public void focusLost(FocusEvent arg0) {
				CasellaNomeutente.setBackground(Color.WHITE);
			
				if(CasellaNomeutente.getText().isEmpty())
					lblNomeUtente.setBounds(920, 0, 150, 24);
				

			}
		});


		final JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(253, 95, 86, 20);
		layeredPane.add(lblPassword,2,0);
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		
		passwordField = new JTextField();
		
		passwordField.setToolTipText("Inserire la password");
		passwordField.setBounds(253, 95, 86, 20);
		passwordField.setBorder(border1);
		layeredPane.add(passwordField);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblPassword.setBounds(0, 0, 0, 0);

			}
		
			public void focusLost(FocusEvent arg0) {
				passwordField.setBackground(Color.WHITE);
			
				if(passwordField.getText().isEmpty())
					lblPassword.setBounds(1075, 0, 150, 24);
				

			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setForeground(Color.BLACK);



		
		
			
		;
	
		

	



		passwordField.addKeyListener(new KeyAdapter() {
		
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() || passwordField.getText().isEmpty())
					baccedi.setEnabled(false);
				else
				{
					baccedi.setEnabled(true);
				}
			}
		});



		


		if(CasellaNomeutente.getText().isEmpty()||CasellaPassword.getText().isEmpty())
			baccedi.setEnabled(false);
		else
			baccedi.setEnabled(true);

		

		CasellaNomeutente.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() || passwordField.getText().isEmpty())
					baccedi.setEnabled(false);
				else
				{
					baccedi.setEnabled(true);
				}
			}
		});
		CasellaNomeutente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				
				
				

			}
		public void focusLost(FocusEvent arg0) {
			CasellaNomeutente.setBackground(Color.WHITE);
			
			if(CasellaNomeutente.getText().isEmpty())
				lblNomeUtente.setBounds(253, 43, 86, 20);
			

		}
	});
		
		
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				
				
				

			}
		public void focusLost(FocusEvent arg0) {
			passwordField.setBackground(Color.WHITE);
			
			if(passwordField.getText().isEmpty())
				lblPassword.setBounds(253, 95, 86, 20);
			

		}
	});		
		
		
		
		
	
                
		
		
		
		
	}
		
		
}



