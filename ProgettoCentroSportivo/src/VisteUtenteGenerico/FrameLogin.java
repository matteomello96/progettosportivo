package VisteUtenteGenerico;



import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;
import java.net.URL;

import listener.Listen;
import listener.LoginListener;
import listener.VariListener;

import java.awt.BorderLayout;
import java.awt.Color;




public class FrameLogin extends JFrame {
	private static final long serialVersionUID = 1L;
   
	public static JFrame frame;
	public JTextField CasellaPassword;
   
	public JTextField CasellaNomeutenteOLD;
	
	public JTextField passwordField;
	
	public JTextField CasellaNomeutente;
	public final JButton baccedi;
	public static boolean crypt=true;
	int xi;
	int yi;
	private JPanel contentPane,Panel,Panel2,Panel3;
	public FrameLogin() {
		
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
			
			URL url1 = ClassLoader.getSystemResource("immaginijava/bottone1.png");
			URL url2 = ClassLoader.getSystemResource("immaginijava/bottone2.png");
			URL url3 = ClassLoader.getSystemResource("immaginijava/titolo1.png");
	        ImageIcon im=new ImageIcon(url1);
	        ImageIcon im2=new ImageIcon(url2);
	        ImageIcon im3=new ImageIcon(url3);
			
			contentPane = new JPanel();
			contentPane.setBackground(new Color(229, 43, 80));
			contentPane.setLayout(new BorderLayout());
			 
			GridBagConstraints gbc = new GridBagConstraints();	
  
			
			
			JScrollPane scroll = new JScrollPane(contentPane);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setBounds(50, 30, 300, 50);			
		    frame.getContentPane().add(scroll);
		
			
		
		
		

		

		    Panel = new JPanel();
			Panel.setBackground(new Color(229, 43, 80));
			Panel.setLayout(new GridBagLayout());
		
		

		

			contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel, 2, 2, "Pagina di Login"), BorderLayout.NORTH);
		
			
			    Panel2 = new JPanel();
				Panel2.setBackground(new Color(229, 43, 80));
				Panel2.setLayout(new GridBagLayout());
			
		
		JLabel lblNomeUtente = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblNomeUtente, "Nome Utente", 2, 3);
		
				


		CasellaNomeutente = new JTextField();
		VariListener.SettaTextField(Panel2,CasellaNomeutente,"Inserire il nome utente",3,3);
		VariListener.SettaFocus(CasellaNomeutente);
		


	    JLabel lblPassword = new JLabel();
	    VariListener.SettaLabelGen(Panel2,lblPassword, "Password", 2, 5);
	    
		
		
		
		passwordField = new JTextField();
		VariListener.SettaTextField(Panel2,passwordField,"Inserire la password",3,5);
		VariListener.SettaFocus(passwordField);
		
		
		
		
        JLabel lblBlocMaiuscAttivo = new JLabel("BLOC MAIUSC attivato!");
		lblBlocMaiuscAttivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBlocMaiuscAttivo.setForeground(new Color(255, 69, 0));
		lblBlocMaiuscAttivo.setBounds(25, 30, 10, 10);
		lblBlocMaiuscAttivo.setVisible(false);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		
		Panel2.add(lblBlocMaiuscAttivo,gbc);
		
		
		

		contentPane.add(Panel2,BorderLayout.CENTER);
		
		Panel3 = new JPanel();
		Panel3.setBackground(new Color(229, 43, 80));
		Panel3.setLayout(new GridBagLayout());
		
		
		
		
            baccedi = new JButton(im);
            JLabel lbl= new JLabel();
            VariListener.SettaBtn(Panel3, baccedi, lbl,"Accedi", 2, 2,im2,false);
            baccedi.setVisible(false);
            lbl.setVisible(false);
	        baccedi.setToolTipText("Esegui l'accesso");
            
            contentPane.add(Panel3,BorderLayout.SOUTH);
            
		     baccedi.addActionListener(new LoginListener(this));
		    frame.getRootPane().setDefaultButton(baccedi); //RENDE ACCEDI PULSANTE PREDEFINITO PER ENTER
            
            
        
   
		CasellaNomeutente.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) { //ascolta i keystrokes
				if(CasellaNomeutente.getText().isEmpty() || passwordField.getText().isEmpty())
					baccedi.setVisible(false);
				else
				{
					baccedi.setVisible(true);
					lbl.setVisible(true);
					lbl.setForeground( Color.WHITE);
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
					lbl.setVisible(true);
					lbl.setForeground( Color.WHITE);
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



