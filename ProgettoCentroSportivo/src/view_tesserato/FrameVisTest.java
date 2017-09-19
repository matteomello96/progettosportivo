package view_tesserato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import ClassiDaoTesserato.DistruggiTestimonianza;
import ClassiDaoTesserato.ElencoTestDao;
import ClassiDaoTesserato.ModificaCommDao;

import ModelliTabelle_Tesserato.disc_testimonianza;
import listener.Listen;
import listener.VariListener;

public class FrameVisTest extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_1;
	public static JFrame frame;
	 private disc_testimonianza model;
	 public String disciplina;
	 public String livello;
	 public String commento;
	 public JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public FrameVisTest() {
		
		
		frame = new JFrame("Visualizza Testimonianze");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 705, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
	
		JMenu mnNewMenu = new JMenu("Pannello di controllo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna al pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("vaitest");	
		
	
	  
		
			
		ImageIcon im=new ImageIcon("src/immaginijava/bottone8.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone9.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo4.png");
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new BorderLayout());
		
		
		
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
	    
	    
		
	    JPanel Panel1 = new JPanel();
		Panel1.setBackground(new Color(42,82,190));
		Panel1.setLayout(new GridBagLayout());
		
		
		
		
		
	    JPanel GPane1 = new JPanel();
		GPane1.setBackground(new Color (42,82,190));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Le tue testimonianze"), BorderLayout.NORTH);		
		
		
		table_1 = new JTable();
		model = new disc_testimonianza(ElencoTestDao.elencoiniziale());
		GPane1.add(VariListener.SettaScroll(table_1,50,model), BorderLayout.CENTER);
		
		
		JPanel BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (42,82,190));
		BotPnl1.setLayout(new GridBagLayout());
		
		

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn, lbl,"Elimina testimonianze", 2, 2,im2,true);
		btn.setMnemonic('e');
		
	
		
		JButton btn1 = new JButton(im);
		JLabel lbl1= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn1, lbl1,"Modifica testimonianze", 4, 2,im2,true);
		btn.setMnemonic('e');

		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn2, lbl2,"Inserisci commento", 6, 2,im2,true);
		btn2.setMnemonic('e');
			
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				disciplina=(String) table_1.getValueAt(table_1.getSelectedRow(), 0);
				livello=(String) table_1.getValueAt(table_1.getSelectedRow(), 1);
				DistruggiTestimonianza.EliminaTest(disciplina,livello);
				frame.dispose();
				new FrameVisTest();
			}
			
		});
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				new FrameInsTest();
			}
			
		});
		

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commento=(String) table_1.getValueAt(table_1.getSelectedRow(), 2);
				disciplina=(String) table_1.getValueAt(table_1.getSelectedRow(), 0);
				livello=(String) table_1.getValueAt(table_1.getSelectedRow(), 1);
				ModificaCommDao.Mod_Comm(commento,disciplina,livello);
				
			
			}
			
		});	
		GPane1.add(BotPnl1,BorderLayout.SOUTH);	
	
		contentPane.add(GPane1);
	}
}
