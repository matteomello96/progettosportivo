package view_tesserato;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.Modifica_Turno_Dao;
import ClassiDaoTesserato.RichiesteDaoTes;

import java.awt.ComponentOrientation;

import Model.Utente;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.setupTableWidths;
import classiDAOResponsabile.ElencoUtentiDAO;
import classiDAOResponsabile.GestioneIscrizioniDAO;
import classiDAOResponsabile.RichiesteDao;
import classiDAOResponsabile.credenzialidao;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModElEventiIstr;
import modelliTabelleRespo.ModElUtenti;
import modelliTabelleRespo.modelisc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FrameIscrDisc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel GPane1,GPane2,GPane3,GPane4,contentPane,BotPnl1,BotPnl2,BotPnl3,BotPnl4;
	public static JTable table;
	public static JTable table2;
	public static JTable table3;
	public JTable table4;
	public JTable tablemod;
	public JTable tablemod2;
	public JTable tablemod3;
	public JTable tablemod4;
  
	private modelisc model,model2,model3,model4;

    private JTabbedPane tabed = new JTabbedPane();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameIscrDisc() {
		frame = new JFrame("Pagina Iscritti");
		
		frame.setTitle("Elenco degli utenti");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
	
		JMenu mnNewMenu = new JMenu("Pannello di controllo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna al pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("Vai_home_da_ord2");
		
		tabed = new JTabbedPane();
		
		
		int tesserato=GetInfoDB.getidTess(Utente.getUsername());
		
		
		
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
		
		
		
		
		
	    GPane1 = new JPanel();
		GPane1.setBackground(new Color (42,82,190));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Le tue richieste confermate"), BorderLayout.NORTH);		
		
		
		table = new JTable();
		model = new modelisc(RichiesteDaoTes.elencoconfermati(tesserato));
		GPane1.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);

		
		
		
		

		BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (235,193,20));
		BotPnl1.setLayout(new GridBagLayout());
		
		

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn, lbl,"Dettagli ordine", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {
				     frame.setVisible(false);
					frame.dispose();
				    new FrameDettagliConfTess((int)FrameIscrDisc.table.getValueAt(FrameIscrDisc.table.getSelectedRow(), 0));
					FrameDettagliConfTess.frame.setVisible(true);
					
					} else
						JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
								JOptionPane.WARNING_MESSAGE);
				}
		});
		
		
		JButton btn1 = new JButton(im);
		JLabel lbl1= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn1, lbl1,"Elimina ordine", 4, 2,im2,true);
		btn1.setMnemonic('e');
		btn1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
				if (table.getSelectedRow() != -1) {
				b= (int) table.getValueAt(table.getSelectedRow(), 0);
		
			Modifica_Turno_Dao.Uccidi_isc(b);
			frame.dispose();
			new FrameIscrDisc();
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		GPane1.add(BotPnl1,BorderLayout.SOUTH);
		
		tabed.add("Richieste confermate",GPane1);
		
		
		
		GPane2 = new JPanel();
		GPane2.setBackground(new Color (235,193,20));
		GPane2.setLayout(new BorderLayout());
		
		
		
		 JPanel Panel2 = new JPanel();
			Panel2.setBackground(new Color(42,82,190));
			Panel2.setLayout(new GridBagLayout());
				
			
			GPane2.add(VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "Le tue richieste in attesa di conferma "), BorderLayout.NORTH);	
			
		
		table2 = new JTable();
		model2 = new modelisc(RichiesteDaoTes.elencodaconf(tesserato));
		GPane2.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.CENTER);

		
		
		
		
		BotPnl2 = new JPanel();
		BotPnl2.setBackground(new Color (235,193,20));
		BotPnl2.setLayout(new GridBagLayout());
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn3, lbl3,"Dettagli ordine", 2, 2,im2,true);
		btn3.setMnemonic('e');
		btn3.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (table2.getSelectedRow() != -1) {
			      frame.setVisible(false);
			      frame.dispose();
			      new FrameDettagliDaAccTess((int)FrameIscrDisc.table2.getValueAt(FrameIscrDisc.table2.getSelectedRow(), 0));
					FrameDettagliDaAccTess.frame.setVisible(true);
					
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn4, lbl4,"Elimina richiesta iscrizione", 4, 2,im2,true);
		btn4.setMnemonic('e');
		btn4.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table2.getSelectedRow() != -1) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table2.getValueAt(table2.getSelectedRow(), 0);
		
			Modifica_Turno_Dao.Uccidi_isc(b);
			frame.dispose();
			new FrameIscrDisc();
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		}	
		);
		
		GPane2.add(BotPnl2,BorderLayout.SOUTH);
		
		tabed.add("Richieste da accettare",GPane2);
		
		
		GPane3 = new JPanel();
		GPane3.setBackground(new Color (235,193,20));
		GPane3.setLayout(new BorderLayout());
		
		
		
		 JPanel Panel3 = new JPanel();
			Panel3.setBackground(new Color(42,82,190));
			Panel3.setLayout(new GridBagLayout());
				
			
			GPane2.add(VariListener.SettaPannelloTitolo(im3, Panel3, 1, 0, "Le tue richieste modificate "), BorderLayout.NORTH);	
		
		table3 = new JTable();
		model3 = new modelisc(RichiesteDaoTes.elencomod(tesserato));
		GPane3.add(VariListener.SettaScroll(table3,50,model3), BorderLayout.CENTER);

		
		
		
		
		BotPnl3 = new JPanel();
		BotPnl3.setBackground(new Color (235,193,20));
		BotPnl3.setLayout(new GridBagLayout());
		
		
		JButton btn5 = new JButton(im);
		JLabel lbl5= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn5, lbl5,"Dettagli ordine", 2, 2,im2,true);
		btn5.setMnemonic('e');
		btn5.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (table3.getSelectedRow() != -1) {
			      frame.setVisible(false);
			      frame.dispose();
			      new FrameDettagliModTess2((int)FrameIscrDisc.table3.getValueAt(FrameIscrDisc.table3.getSelectedRow(), 0));
					FrameDettagliModTess2.frame.setVisible(true);
					
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		
		JButton btn6 = new JButton(im);
		JLabel lbl6= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn6, lbl6,"Elimina richiesta di iscrizione", 4, 2,im2,true);
		btn6.setMnemonic('e');
		btn6.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table3.getSelectedRow() != -1) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table3.getValueAt(table3.getSelectedRow(), 0);
		
			Modifica_Turno_Dao.Uccidi_isc(b);
			frame.dispose();
			new FrameIscrDisc();
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		}	
		);
		
		
		
		
		
		
		GPane3.add(BotPnl3,BorderLayout.SOUTH);
		
		tabed.add("Richieste modificate",GPane3);
		
		
		
		
		
		
		
		
		
		
		contentPane.add(tabed);
	}
	

}
