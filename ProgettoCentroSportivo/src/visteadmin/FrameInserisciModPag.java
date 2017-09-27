package visteadmin;



import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;



import classiDAOResponsabile.GestioneDAO;

import listener.Listen;
import listener.VariListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;






public class FrameInserisciModPag extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	private JTextField textmodpag;
	
	private boolean bool;
	
	
	
	
	public FrameInserisciModPag() {
	  
		frame = new JFrame("Inserisci modalità di pagamento"  );
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci modalità di pagamento  ");
		if(FrameInserisciModPag.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciModPag.frame.getLocation());
		
		
		
		
	
		
		
		
	
		
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Iniziale");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale della gestione");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_ges_da_ins");
		

		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone6.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone7.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo3.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,185,0));
		contentPane.setLayout(new BorderLayout());
		
		
		
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
	    
		JPanel Panel1 = new JPanel();
 		Panel1.setBackground(new Color(255,185,0));
 		Panel1.setLayout(new GridBagLayout());
		
		
		
    contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Form di inserimento mod pagamento"), BorderLayout.NORTH);	
		
		
		

    JPanel Panel2 = new JPanel();
  	Panel2.setLayout(new GridBagLayout());
  	Panel2.setBackground(new Color (255,185,0));
  	
  	
  	JLabel lblModP = new JLabel();
  	VariListener.SettaLabelGen(Panel2,lblModP, "Nome della modalità da inserire", 0, 1);
		
		
		

	
		
	JLabel lblErrNome = new JLabel("");
	VariListener.SettaErr("la disciplina non deve contenere errori",lblErrNome, 2, 1, Panel2);
		
		
	textmodpag= new JTextField();
	VariListener.SettaTextField(Panel2, textmodpag, "Inserire modalità", 1,1);
	VariListener.SettaFocus(textmodpag);
		
		textmodpag.addKeyListener(new KeyListener(){
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
		

		
		
		
		
		JPanel PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (255,185,0));
		
		 JButton btnRegistratiAlNostro = new JButton(im);
		 JLabel lbl= new JLabel();
		
		  VariListener.SettaBtn(PanelBottom, btnRegistratiAlNostro, lbl,"Inserisci modalità", 1, 1,im2,true);
		
		btnRegistratiAlNostro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
			
			lblModP.setForeground(Color.BLACK);
			lblModP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			
		
		
		if(textmodpag.getText().isEmpty())
		
			{
				lblModP.setForeground(Color.RED);
				lblModP.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrNome.setText("Il campo è vuoto");
				lblErrNome.setVisible(true);
			}
			
		else
			
			bool=GestioneDAO.inserimentomodpag(textmodpag.getText());
			
		
		if(bool)
		{
			frame.setVisible(false); 
			frame.dispose();
			FrameGestione.frame.dispose();
			new FrameGestione();
			
	}
								
		
			}	
		
	})
		
		
		;
		
		contentPane.add(Panel2,BorderLayout.NORTH);
		contentPane.add(PanelBottom,BorderLayout.CENTER);
		
	//	gbc_combotipoutente.setModel(new DefaultComboBoxModel(new String[] {"tesserato", "istruttore"}));
		
		

}}

