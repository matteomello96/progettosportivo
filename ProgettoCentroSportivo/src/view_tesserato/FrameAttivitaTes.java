package view_tesserato;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.ElencoAttivitaDAO;
import ClassiDaoTesserato.elencoattivitaattivedao;
import Model.Utente;
import ModelliTabelle_Tesserato.disc_attive;
import ModelliTabelle_Tesserato.disc_tabella;
import listener.Listen;
import listener.VariListener;


public class FrameAttivitaTes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public static JTable table_1;
	public static JTable table_2;
	public static JFrame frame;
	public JPanel contentPane,Panel1,tabellaPnl,PanelBottom,tab1,PanelBottom2,tab2;
	private disc_tabella model;
	public static float totale;
	 public static JButton svuotacarrello;
	 public static JButton Aggiungi;
	 public static JButton rimuovi;
	 public static JButton invia;
	 public String a;
	public DefaultTableModel modello;
    public Object[] dati;
    public boolean u;
	/**
	 * Create the panel.
	 */

	public FrameAttivitaTes() {
		


		
		
		frame = new JFrame("Tesserato");
		String username=""+Utente.getUsername()+"";
		int tesserato=GetInfoDB.getidTess(username);
		frame.setTitle("Elenco attività "+username+"");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1334, 700);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
		
		

	
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
		
		JMenu mnNewMenu = new JMenu("Torna al Pannello di Controllo");
		menuBar.add(mnNewMenu);
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("pantes");
		
		
		URL url1 = ClassLoader.getSystemResource("immaginijava/bottone8.png");
		URL url2 = ClassLoader.getSystemResource("immaginijava/bottone9.png");
		URL url3 = ClassLoader.getSystemResource("immaginijava/titolo4.png");
        ImageIcon im=new ImageIcon(url1);
        ImageIcon im2=new ImageIcon(url2);
        ImageIcon im3=new ImageIcon(url3);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new BorderLayout());
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (42,82,190));
		contentPane.setLayout(new BorderLayout());
		

		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
	    Panel1 = new JPanel();
		Panel1.setBackground(new Color (42,82,190));
		Panel1.setLayout(new GridBagLayout());
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2,"Discipline disponibili per l'iscrizione"), BorderLayout.NORTH);
		
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new BorderLayout());
		tabellaPnl.setBackground(new Color(42, 82, 190));
		
		tab1 = new JPanel();
		tab1.setLayout(new BorderLayout());
		tab1.setBackground(new Color(42, 82, 190));
		
		
		table = new JTable();
		model = new disc_tabella(ElencoAttivitaDAO.elencoiniziale());
		tab1.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);
		
		
		table_1 = new JTable();

		
		
	
		tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());
		tab2.setBackground(new Color(42, 82, 190));
		
		
		

		tab2.add(VariListener.SettaScroll2(table_1,50), BorderLayout.CENTER);
		
		
		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (42,82,190));
		
		
		PanelBottom2 = new JPanel();
		PanelBottom2.setLayout(new GridBagLayout());
		PanelBottom2.setBackground(new Color (42,82,190));

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(PanelBottom2, btn, lbl,"Aggiungi", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_2 = new JTable();
				new disc_attive(elencoattivitaattivedao.elencoiniziale());
				
				
				if(table.getSelectedRow()!=-1){
				
					int comb=GetInfoDB.getcombinazionelivdis( (String)table.getValueAt(table.getSelectedRow(), 1),(String)table.getValueAt(table.getSelectedRow(), 0));
					
					if(GetInfoDB.getocc(comb,tesserato)!=-1)
					{
					
						
						JOptionPane.showMessageDialog(FrameAttivitaTes.frame, "Hai già un iscrizione con la disciplina da te selezionata",null,JOptionPane.WARNING_MESSAGE);
						
					}
					else{
				dati = new Object[3];

				dati[0]=table.getValueAt(table.getSelectedRow(), 0);
				dati[1]=table.getValueAt(table.getSelectedRow(), 1);				
				dati[2]=table.getValueAt(table.getSelectedRow(), 2);
				modello = (DefaultTableModel) table_1.getModel();
				  u=true;
				}
				
				int c=0;
				int q;
				
				
				
					
				
				for(q=0;q<table_2.getRowCount();q++){
					
				
				
					
				}

				for(c=0;c<table_1.getRowCount();c++)
				{
				if(table_1.getRowCount()>=1){
						if(table.getValueAt(table.getSelectedRow(), 0).equals(table_1.getValueAt(c, 0))&&
								table.getValueAt(table.getSelectedRow(), 1).equals(table_1.getValueAt(c, 1)))
						{
							u=false;
							break;
						}

					}

				}
				
				
				
					if(u)
					{
						
					modello.addRow(dati);	
						
					}
						else{
						
						}
					}
				
					else{
				
					JOptionPane.showMessageDialog(FrameAttivitaTes.frame, "Non è possibile Aggiungere la stessa disciplina",null,JOptionPane.WARNING_MESSAGE);
					
					}
					
				
				
				
				
				
				
				
				
				
				
				
				
				
			
	
				
			}
		});
		
		tab1.add(PanelBottom2,BorderLayout.SOUTH);
		
		
		
		
		tabellaPnl.add(tab1,BorderLayout.WEST);
		
		
		
		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn2, lbl2,"Rimuovi", 2, 2,im2,true);
		btn2.setMnemonic('e');
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRow()!=-1){
				modello.removeRow(table_1.getSelectedRow());
				}
			}
		});
		
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn3, lbl3,"Svuota carrello", 3, 2,im2,true);
		btn3.setMnemonic('e');
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				for(int x=modello.getRowCount()-1;x>=0;x--)
				{
					modello.removeRow(x);
				}
			}
		});
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn4, lbl4,"Inserisci attività", 4, 2,im2,true);
		btn4.setMnemonic('e');
		btn4.addActionListener(new Listen(this));
		btn4.setActionCommand("conf");
		btn4.setEnabled(false);
		
		
		
		
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		table_1.getModel().addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e) {
			
				
			
				
				
				
				totale=0;
				int c=0;
				for (c=0;c<table_1.getModel().getRowCount();c++){
		
				totale=totale+((Integer)(table_1.getModel().getValueAt(c, 2)));
				
				}
			
				
				contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2,"TOTALE ISCRIZIONI: "+df.format(totale)+" EUR  "), BorderLayout.NORTH);
				
				
				if(table_1.getModel().getRowCount()>0)
					btn4.setEnabled(true);
				else table_1.setEnabled(false);
				if(table_1.getModel().getRowCount()<1)
					btn4.setEnabled(false);	
				
				
				
				
					
					
		}}
		);
	tab2.add(PanelBottom,BorderLayout.SOUTH);
	tabellaPnl.add(tab2,BorderLayout.EAST);
	contentPane.add(tabellaPnl,BorderLayout.CENTER);
	}
	
}


     





