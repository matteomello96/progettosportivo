package visteadmin;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;



import classiDAOResponsabile.GestioneIscrizioniEventiDAO;

import classiDAOResponsabile.downloaddao;
import classiDAOResponsabile.elencoeventidao;
import listener.Listen;
import listener.VariListener;

import modelliTabelleRespo.modeven;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FrameEventiResp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel GPane1,GPane2,GPane3,GPane4,contentPane,BotPnl1,BotPnl2,BotPnl3,BotPnl4,Panel1,Panel2,Panel3;
	public static JTable table;
	public static JTable table2;
	public static JTable table3;
	public JTable table4;
	public JTable tablemod;
	public JTable tablemod2;
	public JTable tablemod3;
	public JTable tablemod4;
  
	
	private modeven model,model2,model3;

    private JTabbedPane tabed = new JTabbedPane();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameEventiResp() {
		frame = new JFrame("Pagina Iscritti");
		
		frame.setTitle("Elenco delle iscrizioni agli eventi");
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
		mntmNewMenuItem.setActionCommand("iniresp2");
		
		tabed = new JTabbedPane();
		
		
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
		
		
	       Panel1 = new JPanel();
	  		Panel1.setBackground(new Color(255,185,0));
	  		Panel1.setLayout(new GridBagLayout());	
		
		
	    GPane1 = new JPanel();
		GPane1.setBackground(new Color (235,193,20));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Elenco delle Richieste Confermate"), BorderLayout.NORTH);		
		
		table = new JTable();
		model = new modeven(elencoeventidao.elencoevenconf());
		GPane1.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);

		
		
		
		
		BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (235,193,20));
		BotPnl1.setLayout(new GridBagLayout());
		
		
		
		
		JButton btn1 = new JButton(im);
		JLabel lbl1= new JLabel();
				btn1.setMnemonic('e');
	    VariListener.SettaBtn(BotPnl1, btn1, lbl1,"Visualizza certificato", 2, 2,im2,true);
        btn1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {
			Integer a;
			//String b;
			a=(int) table.getValueAt( table.getSelectedRow() , 0);
			downloaddao.scarica(a);
			//JOptionPane.showMessageDialog(frameeventidacanc.frame, "'"+b+"'");
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			

			}
		});	
		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
				btn2.setMnemonic('e');
	    VariListener.SettaBtn(BotPnl1, btn2, lbl2,"Annulla ordine", 4, 2,im2,true);
	    btn2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() != -1) {
					int idord,tesserato,codiceturno;
					String giorno,orario,spazio;
					
					        
							tesserato=(int) table.getValueAt(table.getSelectedRow(), 1);
				
					giorno=(String) table.getValueAt(table.getSelectedRow(), 10);
					orario=(String) table.getValueAt(table.getSelectedRow(), 11);
					spazio=(String) table.getValueAt(table.getSelectedRow(), 12);
					idord= (int) table.getValueAt(table.getSelectedRow(), 0);
					codiceturno= GetInfoDB.getcodiceturnoevento( orario, giorno,spazio);
					    GestioneIscrizioniEventiDAO.AnnullaConfEv(idord,tesserato,codiceturno);
						frame.dispose();
						new FrameEventiResp();
		
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		
		});
		

		
	    JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
				btn3.setMnemonic('e');
	    VariListener.SettaBtn(BotPnl1, btn3, lbl3,"Elimina ordine", 6, 2,im2,true);
		btn3.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() != -1) {
					int idord,tesserato,codiceturno;
					String giorno,orario,spazio;
					
					        
							tesserato=(int) table.getValueAt(table.getSelectedRow(), 1);
				
					giorno=(String) table.getValueAt(table.getSelectedRow(), 10);
					orario=(String) table.getValueAt(table.getSelectedRow(), 11);
					spazio=(String) table.getValueAt(table.getSelectedRow(), 12);
					idord= (int) table.getValueAt(table.getSelectedRow(), 0);
					codiceturno= GetInfoDB.getcodiceturnoevento( orario, giorno,spazio);
					    GestioneIscrizioniEventiDAO.Uccidiev(idord,codiceturno,tesserato);
						frame.dispose();
						new FrameEventiResp();
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		GPane1.add(BotPnl1,BorderLayout.SOUTH);
		
		tabed.add("Richieste confermate",GPane1);
		
		
		GPane2 = new JPanel();
		GPane2.setBackground(new Color (255,185,0));
		GPane2.setLayout(new BorderLayout());
		
		
	    Panel2 = new JPanel();
		Panel2.setBackground(new Color(255,185,0));
		Panel2.setLayout(new GridBagLayout());
			
		
		GPane2.add(VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "Elenco Richieste accettate"), BorderLayout.NORTH);	
		
		
	;
		
		table2 = new JTable();
		model2 = new modeven(elencoeventidao.elencoevendaconf());
		GPane2.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.CENTER);
		
		
		
		
		BotPnl2 = new JPanel();
		BotPnl2.setBackground(new Color (235,193,20));
		BotPnl2.setLayout(new GridBagLayout());
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
				btn4.setMnemonic('e');
	    VariListener.SettaBtn(BotPnl2, btn4, lbl4,"Conferma ordine", 2, 2,im2,true);
		btn4.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table2.getSelectedRow() != -1) {
				int idord,tesserato,codiceturno;
				String giorno,orario,spazio;
				
				        
						tesserato=(int) table2.getValueAt(table2.getSelectedRow(), 1);
			
				giorno=(String) table2.getValueAt(table2.getSelectedRow(), 10);
				orario=(String) table2.getValueAt(table2.getSelectedRow(), 11);
				spazio=(String) table2.getValueAt(table2.getSelectedRow(), 12);
				idord= (int) table2.getValueAt(table2.getSelectedRow(), 0);
				codiceturno= GetInfoDB.getcodiceturnoevento( orario, giorno,spazio);
				    GestioneIscrizioniEventiDAO.ConfermaIscrizioneEv(idord,tesserato,codiceturno);
					frame.dispose();
					new FrameEventiResp();
					}else
						JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
								JOptionPane.WARNING_MESSAGE);
				}
		});
		
		
		
		
		
		
		
		JButton btn5 = new JButton(im);
		JLabel lbl5= new JLabel();
				btn5.setMnemonic('e');
	    VariListener.SettaBtn(BotPnl2, btn5, lbl5,"Visualizza certificato", 4, 2,im2,true);
        btn5.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				if (table2.getSelectedRow() != -1) {
			Integer a;
			//String b;
			a=(int) table2.getValueAt( table2.getSelectedRow() , 0);
			downloaddao.scarica(a);
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			//JOptionPane.showMessageDialog(frameeventidacanc.frame, "'"+b+"'");
			
			

			}
		});	
		
		
		
		GPane2.add(BotPnl2,BorderLayout.SOUTH);
		
		tabed.add("Richieste da accettare",GPane2);
		
		
		GPane3 = new JPanel();
		GPane3.setBackground(new Color (235,193,20));
		GPane3.setLayout(new BorderLayout());
		
		
		
		Panel3 = new JPanel();
		Panel3.setBackground(new Color(255,185,0));
		Panel3.setLayout(new GridBagLayout());
		
		
		GPane3.add(VariListener.SettaPannelloTitolo(im3, Panel3, 1, 4, "Elenco delle richieste modificate"), BorderLayout.NORTH);	
		
		table3 = new JTable();
		model3 = new modeven(elencoeventidao.elencoevenmod());
		GPane3.add(VariListener.SettaScroll(table3,50,model3), BorderLayout.CENTER);


		
		
		
		
		BotPnl3 = new JPanel();
		BotPnl3.setBackground(new Color (235,193,20));
		BotPnl3.setLayout(new GridBagLayout());
		
		
		JButton btn6 = new JButton(im);
		JLabel lbl6= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn6, lbl6,"Dettagli ordine", 2, 2,im2,true);
		btn6.setMnemonic('e');
		btn6.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (table3.getSelectedRow() != -1) {
					int idord,tesserato,codiceturno;
					String giorno,orario,spazio;
					
					        
							tesserato=(int) table3.getValueAt(table3.getSelectedRow(), 1);
				
					giorno=(String) table3.getValueAt(table3.getSelectedRow(), 10);
					orario=(String) table3.getValueAt(table3.getSelectedRow(), 11);
					spazio=(String) table3.getValueAt(table3.getSelectedRow(), 12);
					idord= (int) table3.getValueAt(table3.getSelectedRow(), 0);
					codiceturno= GetInfoDB.getcodiceturnoevento( orario, giorno,spazio);
					    GestioneIscrizioniEventiDAO.ConfermaModEv(idord,tesserato,codiceturno);
						frame.dispose();
						new FrameEventiResp();
		
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		
		});
		
		JButton btn7 = new JButton(im);
		JLabel lbl7= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn7, lbl7,"Visualizza certificato", 4, 2,im2,true);
		btn7.setMnemonic('e');
        btn7.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				if (table3.getSelectedRow() != -1) {
			Integer a;
			//String b;
			a=(int) table3.getValueAt( table3.getSelectedRow() , 0);
			downloaddao.scarica(a);
			//JOptionPane.showMessageDialog(frameeventidacanc.frame, "'"+b+"'");
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			

			}
		});	
		
		
		GPane3.add(BotPnl3,BorderLayout.SOUTH);
		
		tabed.add("Richieste modificate",GPane3);
		
		
		
		
		
		
		
		
		
		
		contentPane.add(tabed);
	}
	

}
