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






import classiDAOResponsabile.GestioneIscrizioniDAO;
import classiDAOResponsabile.RichiesteDao;

import listener.Listen;
import listener.VariListener;

import modelliTabelleRespo.modelisc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FrameOrdini extends JFrame {
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
  
	private modelisc model,model2,model3;

    private JTabbedPane tabed = new JTabbedPane();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameOrdini() {
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
		mntmNewMenuItem.setActionCommand("Vai_home_da_ord");
		
		tabed = new JTabbedPane();
		
		
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
	    
	    
		
	    Panel1 = new JPanel();
		Panel1.setBackground(new Color(255,185,0));
		Panel1.setLayout(new GridBagLayout());
		
		
		
		
		
	    GPane1 = new JPanel();
		GPane1.setBackground(new Color (255,185,0));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel1, 1, 0, "Elenco Richieste Confermate"), BorderLayout.NORTH);		
		
		
		table = new JTable();
		model = new modelisc(RichiesteDao.elencoconfermati());
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
					new FrameDettagliAcc((int) FrameOrdini.table.getValueAt(FrameOrdini.table.getSelectedRow(), 0));
					} else
						JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
								JOptionPane.WARNING_MESSAGE);
				}
		});
		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn2, lbl2,"Elimina ordine", 4, 2,im2,true);
		btn2.setMnemonic('e');
		btn2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
				if (table.getSelectedRow() != -1) {
				b= (int) table.getValueAt(table.getSelectedRow(), 0);
		
			GestioneIscrizioniDAO.Uccidi_isc(b);
			frame.dispose();
			new FrameOrdini();
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
			
		
		GPane2.add(VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "Elenco Richieste da accettare"), BorderLayout.NORTH);	
		
		table2 = new JTable();
		model2 = new modelisc(RichiesteDao.elencodaconf());
		GPane2.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.CENTER);
		
		
		
		
		BotPnl2 = new JPanel();
		BotPnl2.setBackground(new Color (235,193,20));
		BotPnl2.setLayout(new GridBagLayout());
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn3, lbl3,"Richieste da accettare", 2, 2,im2,true);
		btn3.setMnemonic('e');
		btn3.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (table2.getSelectedRow() != -1) {
			      frame.setVisible(false);
			      frame.dispose();
				new FrameDettagliDaAccResp((int) FrameOrdini.table2.getValueAt(FrameOrdini.table2.getSelectedRow(), 0));
				} else
					JOptionPane.showMessageDialog(null, "Seleziona un ordine dall'elenco", "Errore ordine",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		
		
		
		BotPnl3 = new JPanel();
		BotPnl3.setBackground(new Color (235,193,20));
		BotPnl3.setLayout(new GridBagLayout());
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn4, lbl4,"Elimina ordine", 4, 2,im2,true);
		btn4.setMnemonic('e');
		btn4.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table2.getSelectedRow() != -1) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table2.getValueAt(table2.getSelectedRow(), 0);
		
			GestioneIscrizioniDAO.Uccidi_isc(b);
			frame.dispose();
			new FrameOrdini();
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
		
		Panel3 = new JPanel();
		Panel3.setBackground(new Color(255,185,0));
		Panel3.setLayout(new GridBagLayout());
		
		
		GPane3.add(VariListener.SettaPannelloTitolo(im3, Panel3, 1, 4, "Elenco ordini modificati"), BorderLayout.NORTH);	
		
		
		table3 = new JTable();
		model3 = new modelisc(RichiesteDao.elencomod());
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
				int b;
				if (table3.getSelectedRow() != -1) {
				b= (int) table3.getValueAt(table3.getSelectedRow(), 0);
		
			new FrameDettagliMod(b);
			frame.dispose();
		
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
