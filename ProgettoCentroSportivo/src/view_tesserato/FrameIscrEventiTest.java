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
import ClassiDaoTesserato.ElencoeventidaoTess;

import java.awt.ComponentOrientation;

import Model.Utente;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.setupTableWidths;
import classiDAOResponsabile.ElencoUtentiDAO;
import classiDAOResponsabile.GestioneIscrizioniDAO;
import classiDAOResponsabile.GestioneIscrizioniEventiDAO;
import classiDAOResponsabile.RichiesteDao;
import classiDAOResponsabile.credenzialidao;
import classiDAOResponsabile.downloaddao;
import classiDAOResponsabile.elencoeventidao;
import listener.Listen;
import listener.VariListener;
import modelliTabelleIstruttore.ModElEventiIstr;
import modelliTabelleRespo.ModElUtenti;
import modelliTabelleRespo.modelisc;
import modelliTabelleRespo.modeven;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FrameIscrEventiTest extends JFrame {
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
  
	
	private modeven model,model2,model3,model4;

    private JTabbedPane tabed = new JTabbedPane();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameIscrEventiTest() {
		frame = new JFrame("Pagina Iscritti");
		
		frame.setTitle("Elenco delle tue iscrizioni agli eventi");
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
		mntmNewMenuItem.setActionCommand("inites2");
		
		tabed = new JTabbedPane();
		
		
		
		int tes= GetInfoDB.getidTess(Utente.getUsername());
		
		
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
		
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Elenco Richieste Confermate"), BorderLayout.NORTH);		
		
		
		table = new JTable();
		model = new modeven(ElencoeventidaoTess.elencoevenconf(tes));
		GPane1.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);

		
		
		
		
		BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (42,82,190));
		BotPnl1.setLayout(new GridBagLayout());
		
		

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn, lbl,"Visualizza certificato", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1) {
			String a;
			//String b;
			a=(String) table.getValueAt( table.getSelectedRow() , 6);
			downloaddao.scarica(a);
			//JOptionPane.showMessageDialog(frameeventidacanc.frame, "'"+b+"'");
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
						new FrameIscrEventiTest();
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		GPane1.add(BotPnl1,BorderLayout.SOUTH);
		
		tabed.add("Richieste confermate",GPane1);
		

		GPane2 = new JPanel();
		GPane2.setBackground(new Color (42,82,190));
		GPane2.setLayout(new BorderLayout());
		
		
	    JPanel Panel2 = new JPanel();
		Panel2.setBackground(new Color(42,82,190));
		Panel2.setLayout(new GridBagLayout());
			
		
		GPane2.add(VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "Elenco Richieste accettate"), BorderLayout.NORTH);	
		
		
		table2 = new JTable();
		model2 = new modeven(ElencoeventidaoTess.elencoevendaconf(tes));
		GPane2.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.CENTER);

		
		
		
		
		BotPnl2 = new JPanel();
		BotPnl2.setBackground(new Color (42,82,190));
		BotPnl2.setLayout(new GridBagLayout());
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn3, lbl3,"Elimina ordine", 2, 2,im2,true);
		btn3.setMnemonic('e');
		btn3.addActionListener(new ActionListener() {
		
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
					    GestioneIscrizioniEventiDAO.Uccidiev(idord,codiceturno,tesserato);
						frame.dispose();
						new FrameIscrEventiTest();
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		
		
		
		
		
		
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn4, lbl4,"Visualizza certificato", 4, 2,im2,true);
		btn4.setMnemonic('e');
       btn4.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				if (table2.getSelectedRow() != -1) {
			String a;
			//String b;
			a=(String) table2.getValueAt( table2.getSelectedRow() , 6);
			downloaddao.scarica(a);
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			//JOptionPane.showMessageDialog(frameeventidacanc.frame, "'"+b+"'");
			
			

			}
		});	
		
		
		
		GPane2.add(BotPnl2,BorderLayout.SOUTH);
		
		tabed.add("Richieste da accettare",GPane2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		contentPane.add(tabed);
	}
	

}
