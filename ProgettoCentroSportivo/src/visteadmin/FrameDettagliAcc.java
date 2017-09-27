package visteadmin;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridBagLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


import classiDAOResponsabile.dettagliiscrizionedao;

import listener.Listen;
import listener.VariListener;
import modelliTabelleRespo.modellidettagli;

public class FrameDettagliAcc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	
	public static JTable table_2,tablemod2;
	private modellidettagli model;
	public JPanel contentPane,pannello,GPane,Panel;
	public JButton bottone;
	public JButton bottone1,bottone3;
	
	
	public FrameDettagliAcc(int cod) {
		frame = new JFrame("FrameDettagliDaAccResp");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setTitle("Dettagli dell'ordine numero "+cod+"");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
	
		JMenu mnNewMenu = new JMenu("Pannello Ordini");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna agli ordini");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("ordacc");
		
		pannello= new JPanel();
		pannello.setBackground(new Color (255,193,20));
		pannello.setLayout(new BorderLayout());
		
		
		
		
		
	
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
	    
	  
		
		Panel = new JPanel();
		Panel.setBackground(new Color(255,185,0));
		Panel.setLayout(new GridBagLayout());
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel, 1, 0, "Dettagli ordine accettato"), BorderLayout.NORTH);		
		
	
		
		table_2 = new JTable();
		model = new modellidettagli(dettagliiscrizionedao.elencoiniziale(cod));
		contentPane.add(VariListener.SettaScroll(table_2,50,model), BorderLayout.CENTER);		
       
	
					
				
				
				
		 
	
	
	
	
	

	}
	    
	
}
