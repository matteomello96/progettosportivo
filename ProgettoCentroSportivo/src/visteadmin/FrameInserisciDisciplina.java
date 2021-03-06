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
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.GridBagLayout;


import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;






public class FrameInserisciDisciplina extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel contentPane;
	
	
	private JTextField textnomed;
	private JTextField descr;
	private Combocal combocal;
	private JTextField immagine;
	private boolean bool;
	public String nomefile="";
	public String percorso="";
	public String path="";
	public String pathprecedente="";
	public File fileprec;
	private JLabel lblIm;
	
	public FrameInserisciDisciplina() {
	  
		frame = new JFrame("Inserisci disciplina"  );
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setSize(450, 300);
        frame.setTitle("Inserisci disciplina");
		if(FrameInserisciDisciplina.frame==null)
			frame.setLocationRelativeTo(null);
			else
			frame.setLocation(FrameInserisciDisciplina.frame.getLocation());
		
		
		
		
	
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,185,0));
		contentPane.setLayout(new GridBagLayout());
		 
		
		
		
		frame.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pagina Iniziale");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTornaAllaPagina = new JMenuItem("Torna alla pagina iniziale della gestione");
	
		mnNewMenu.add(mntmTornaAllaPagina);
		mntmTornaAllaPagina.addActionListener(new Listen(this));
		mntmTornaAllaPagina.setActionCommand("Vai_ges_da_ins_disc");
		
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
		
		
		
    contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Form di inserimento disciplina"), BorderLayout.NORTH);	
		
		

    JPanel Panel2 = new JPanel();
	Panel2.setLayout(new GridBagLayout());
	Panel2.setBackground(new Color (255,185,0));
	
	
	JLabel lblNomeD = new JLabel();
	VariListener.SettaLabelGen(Panel2,lblNomeD, "Nome della disciplina", 0, 1);
		
	JLabel lblErrNome = new JLabel("");
	VariListener.SettaErr("la disciplina non deve contenere errori",lblErrNome, 2, 1, Panel2);
		
	textnomed= new JTextField();
	VariListener.SettaTextField(Panel2, textnomed, "Inserire nome", 1,1);
	VariListener.SettaFocus(textnomed);
		
		textnomed.addKeyListener(new KeyListener(){
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
		
		
		JLabel lblDesc = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblDesc, "Descrizione", 0, 2);
		
		JLabel lblErrNome2 = new JLabel("");
		VariListener.SettaErr("",lblErrNome2, 2, 2, Panel2);
		
		descr = new JTextField();
		VariListener.SettaTextField(Panel2, descr, "Inserire descrizione", 1,2);
		VariListener.SettaFocus(descr);
		
		JLabel lblcal = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblcal, "sel Calendario", 0, 4);
		
		combocal = new Combocal();
	     VariListener.SettaBox(Panel2, combocal, 1, 4);
		
		
		
		lblIm = new JLabel();
		VariListener.SettaLabelGen(Panel2,lblIm, "sel. immagine", 0, 3);
		
		immagine = new JTextField();
		VariListener.SettaTextField(Panel2, immagine, "Inserire descrizione", 1,3);
		VariListener.SettaFocus(immagine);
		
		JButton sfoglia = new JButton(im);
		JLabel lbl6= new JLabel();
		 VariListener.SettaBtn(Panel2, sfoglia, lbl6,"cerca immagine", 2, 3,im2,true);
		
		sfoglia.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {
			{
				JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             nomefile=fileChooser.getSelectedFile().getName();
		              path = selectedFile.getAbsolutePath();
		             immagine.setText(nomefile);
		            
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
			
			
			
		             
			
			
			
		}}}});
		
	

		JPanel PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (255,185,0));
		
		 JButton btninsdisc = new JButton(im);
		 JLabel lbl= new JLabel();
		
		  VariListener.SettaBtn(PanelBottom, btninsdisc, lbl,"Inserisci disciplina", 1, 1,im2,true);
		
		btninsdisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 
			
			
		
		if(textnomed.getText().isEmpty()||descr.getText().isEmpty()){
			if(textnomed.getText().isEmpty())
			{
				lblNomeD.setForeground(Color.RED);
				lblNomeD.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblErrNome.setText("Il campo � vuoto");
				lblErrNome.setVisible(true);
				
			}	
			if(descr.getText().isEmpty())
			{
				lblDesc.setForeground(Color.RED);
				lblDesc.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblErrNome2.setText("Il campo � vuoto");
				lblErrNome2.setVisible(true);
			}
			}
			
		else
			
			try {
				bool=GestioneDAO.inserimentodisc(textnomed.getText(),descr.getText(),combocal.getSelectedItem().toString(),path,nomefile,pathprecedente);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
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
		
		
	
		
		

}}

