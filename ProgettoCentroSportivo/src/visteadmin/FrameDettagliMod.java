package visteadmin;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;

import classiDAOResponsabile.GestioneDetIscrizioniDAO;
import classiDAOResponsabile.GestioneIscrizioniDAO;

import classiDAOResponsabile.dettagliiscrizionedao;

import listener.Listen;
import listener.VariListener;
import modelliTabelleRespo.modellidettagli;

public class FrameDettagliMod extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	
	public static JTable table_2,tablemod2;
	private modellidettagli model;
	public JPanel contentPane,pannello,Panel,BotPnl1;
	public JButton bottone;
	public JButton bottone1,bottone3;
	
	
	public FrameDettagliMod(int cod) {
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
		mntmNewMenuItem.setActionCommand("orddm");
		
	
		
		ImageIcon im=new ImageIcon("src/immaginijava/bottone4.png");
        ImageIcon im2=new ImageIcon("src/immaginijava/bottone5.png");
        ImageIcon im3=new ImageIcon("src/immaginijava/titolo2.png");
		
		
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
		
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel, 1, 0, "Dettagli ordine modificato"), BorderLayout.NORTH);		
		
	
		
		table_2 = new JTable();
		model = new modellidettagli(dettagliiscrizionedao.elencoiniziale(cod));
		contentPane.add(VariListener.SettaScroll(table_2,50,model), BorderLayout.CENTER);	
		
		BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (235,193,20));
		BotPnl1.setLayout(new GridBagLayout());
		
		
		
		
		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn, lbl,"conferma parte mod. ordine", 2, 2,im2,true);
		btn.setMnemonic('e');
		
		btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int iddet,tesserato,codiceturno;
			String disciplina,livello,giorno,orario;
			
			        disciplina= (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
					livello=(String) table_2.getValueAt(table_2.getSelectedRow(), 1);
					tesserato=(int) FrameOrdini.table3.getValueAt(FrameOrdini.table3.getSelectedRow(), 2);
		
			giorno=(String) table_2.getValueAt(table_2.getSelectedRow(), 5);
			orario=(String) table_2.getValueAt(table_2.getSelectedRow(), 6);
			iddet= GetInfoDB.getiddet(disciplina,livello,tesserato,giorno,orario);
			codiceturno= GetInfoDB.getcodiceturno2(disciplina, livello, giorno, orario);
			    GestioneDetIscrizioniDAO.ConfermaDetMod(iddet,tesserato,codiceturno,cod);
				frame.dispose();
				new FrameDettagliMod(cod);
			
		}
				
				}
	
			);		
				
	
		
		
		JButton btn1 = new JButton(im);
		JLabel lbl1= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn1, lbl1,"Annulla mod. parte ordine", 4, 2,im2,true);
		btn.setMnemonic('e');

	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int iddet,tesserato,codiceturno,conf;
			String disciplina,livello,giorno,orario;
			
			disciplina= (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
			livello=(String) table_2.getValueAt(table_2.getSelectedRow(), 1);
			tesserato=(int) FrameOrdini.table3.getValueAt(FrameOrdini.table3.getSelectedRow(), 2);
		    
			giorno=(String) table_2.getValueAt(table_2.getSelectedRow(), 5);
			orario=(String) table_2.getValueAt(table_2.getSelectedRow(), 6);
			
			
			iddet= GetInfoDB.getiddet(disciplina,livello,tesserato,giorno,orario);
		    codiceturno= GetInfoDB.getcodiceturno2(disciplina, livello, giorno, orario);
				GestioneDetIscrizioniDAO.AnnullaDetModIsc(iddet,tesserato,codiceturno);
				
				frame.dispose();
				new FrameDettagliMod(cod);
		
		}
	}
			);	
	 
	JButton btn2 = new JButton(im);
	JLabel lbl2= new JLabel();
    VariListener.SettaBtn(BotPnl1, btn2, lbl2,"Conferma modifiche ordine", 6, 2,im2,false);
	btn2.setMnemonic('e');
	
	
	int i=table_2.getRowCount();
		int count=table_2.getRowCount();
		String o="b";
		
		int[] array= new int[i];
			for(i=0;i<count;i++){
			array[i] =  (int)table_2.getValueAt(i, 2);
			}
			for (i=0;i <count;i++)
			{
				
				if(array[i]== 0){o="a";}
					
			}
			
			if (o.equals("a")){btn2.setVisible(false);}
			else
			{
				btn2.setVisible(true);
				lbl2.setVisible(true);
			}
			
					
		
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			GestioneIscrizioniDAO.AccettaModifiche(cod);
			frame.dispose();
			new FrameOrdini();
	}}
			);	
	
	contentPane.add(BotPnl1,BorderLayout.SOUTH);
	
	}
	
	
	
	
	

	
	    
	
}
