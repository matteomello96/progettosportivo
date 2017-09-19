package view_tesserato;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.ElencoEventiTessDAO;
import ClassiDaoTesserato.eventoesistedao;
import ModelliTabelle_Tesserato.ModElEventiTes;
import ModelliTabelle_Tesserato.controlloevento;
import listener.Listen;
import listener.VariListener;
import Model.Utente;


import javax.swing.JScrollPane;

public class FrameEventi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel contentPane,tabellaPnl,bottoniPnl1,Panel1,tab1,tab2,PanelBottom,PanelBottom2;
	public static JTable table;
	
	public static JTable table2;
    private ModElEventiTes model;
    private controlloevento model1;
    public static JTable table_1;
    public static JButton Aggiungi;
    public static JButton rimuovi;
    public static JButton svuotacarrello;
    public static JButton invia;
    public Object[] dati;
    public DefaultTableModel modello;
    public boolean u;
	

	public FrameEventi() {
		frame = new JFrame();
		
		frame.setTitle("Frame Eventi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		String username=""+Utente.getUsername()+"";
		int tesserato=GetInfoDB.getidTess(username);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
		
		JMenu mnNewMenu = new JMenu("Torna al Pannello di Controllo");
		menuBar.add(mnNewMenu);
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("pantes2");
		                                                            
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
		
		
	    Panel1 = new JPanel();
		Panel1.setBackground(new Color(42, 82, 190));
		Panel1.setLayout(new GridBagLayout());
		
		
		contentPane.add(VariListener.SettaPannelloTitolo(im3, Panel1, 2, 2,"Elenco degli eventi disponibili"), BorderLayout.NORTH);
		
		
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new BorderLayout());
		tabellaPnl.setBackground(new Color(42, 82, 190));
		
		tab1 = new JPanel();
		tab1.setLayout(new BorderLayout());
		tab1.setBackground(new Color(42, 82, 190));
		
		
		
		table = new JTable();
		model = new ModElEventiTes(ElencoEventiTessDAO.elencoiniziale());
		tab1.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);
		
		
		
		JPanel tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new BorderLayout());
		
        table_1 = new JTable();
		
        table_1 = new JTable();

		
		
    	
		tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());
		tab2.setBackground(new Color(42, 82, 190));
		
		
		

		tab2.add(VariListener.SettaScroll3(table_1,50), BorderLayout.CENTER);
		
	
		 
		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color (42,82,190));
		
		
		PanelBottom2 = new JPanel();
		PanelBottom2.setLayout(new GridBagLayout());
		PanelBottom2.setBackground(new Color (42,82,190));

		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(PanelBottom2, btn, lbl,"Dettagli evento", 2, 2,im2,true);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				new DetEvTes();
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		
		
		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(PanelBottom2, btn2, lbl2,"Aggiungi", 2, 3,im2,true);
		btn2.setMnemonic('e');
		
        tab1.add(PanelBottom2,BorderLayout.SOUTH);
		
		
		
		
		tabellaPnl.add(tab1,BorderLayout.WEST);
		
		
		
		
		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn3, lbl3,"Rimuovi", 2, 2,im2,true);
		btn3.setMnemonic('e');
		
		table2 = new JTable();
		model1 = new controlloevento(eventoesistedao.elencoiniziale());
		table2.setModel(model1);
		int tess;
		tess= GetInfoDB.getidTess(Utente.getUsername());
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			
			int i;
				
				
				
				int b;
				int prenotazioni,codice;
				
				codice=(int) table.getValueAt(table.getSelectedRow(), 8);
				prenotazioni=GetInfoDB.getprenotazionievento1(codice);
				for(i=0;i<table2.getRowCount();i++){
					b= (int) table2.getValueAt(i, 1);
			
				
			
				}		
	
				
				if(table.getSelectedRow()!=-1){
					
					
					
					
					if(GetInfoDB.getoccev(codice,tesserato)!=-1)
					{
						
						
						JOptionPane.showMessageDialog(FrameAttivitaTes.frame, "Hai già un iscrizione effettuata con la disciplina da te selezionata",null,JOptionPane.WARNING_MESSAGE);
						
					}
					else{
				dati = new Object[9];

				dati[0]=table.getValueAt(table.getSelectedRow(), 0);
				dati[1]=table.getValueAt(table.getSelectedRow(), 1);				
				dati[2]=table.getValueAt(table.getSelectedRow(), 2);
				dati[3]=table.getValueAt(table.getSelectedRow(), 3);
				dati[4]=table.getValueAt(table.getSelectedRow(), 4);
				dati[5]=table.getValueAt(table.getSelectedRow(), 5);
				dati[6]=table.getValueAt(table.getSelectedRow(), 6);
				dati[7]=table.getValueAt(table.getSelectedRow(), 7);
				dati[8]=table.getValueAt(table.getSelectedRow(), 8);
				 modello = (DefaultTableModel) table_1.getModel();
				 u=true;
					}
				
				
				int c;
				
				for(c=0;c<table_1.getRowCount();c++)
				{
				if(table_1.getRowCount()>=1){
						
					if(table.getValueAt(table.getSelectedRow(), 8).equals(table_1.getValueAt(c, 8)))
						{
						JOptionPane.showMessageDialog(FrameEventi.frame, "Non è possibile Aggiungere lo stesso evento",null,JOptionPane.WARNING_MESSAGE);
							u=false;
							
						
							
						}
                   
					}

				}
				if(u)
				{
				if(prenotazioni==0)	{
					JOptionPane.showMessageDialog(FrameEventi.frame, "Numero massimo prenotazioni raggiunto!!",null,JOptionPane.WARNING_MESSAGE);
				}
				else if(table_1.getRowCount() >= 1)
				{
					
					JOptionPane.showMessageDialog(FrameEventi.frame, "Non è possibile Aggiungere più di un evento",null,JOptionPane.WARNING_MESSAGE);
					
					
				}
				else{
				modello.addRow(dati);
				}
				
				
				}
				
				
				
				}
				
			}
		});
		
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRow()!=-1){
				modello.removeRow(table_1.getSelectedRow());
				}
			}
		});
		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(PanelBottom, btn4, lbl4,"Svuota carrello", 3, 2,im2,true);
		btn4.setMnemonic('e');
			
			
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
					for(int x=modello.getRowCount()-1;x>=0;x--)
					{
						modello.removeRow(x);
					}
				}
			});
			
			
			
			JButton btn5 = new JButton(im);
			JLabel lbl5= new JLabel();
	        VariListener.SettaBtn(PanelBottom, btn5, lbl5,"Inserisci evento", 4, 2,im2,true);
			btn5.setMnemonic('e');
				
	
				btn5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						frame.setEnabled(false);
						new sendeventframe((String) FrameEventi.table.getValueAt(table.getSelectedRow(), 2));
						sendeventframe.frame.setVisible(true);
				
						
					}
				});

				
				
				table_1.getModel().addTableModelListener(new TableModelListener(){
					public void tableChanged(TableModelEvent e) {
					
					
					
						
						
					
						
						
						if(table_1.getModel().getRowCount()>0)
							btn5.setEnabled(true);
						else table_1.setEnabled(false);
						if(table_1.getModel().getRowCount()<1)
							btn5.setEnabled(false);	
						
						
					}});
				
				tab2.add(PanelBottom,BorderLayout.SOUTH);
					tabellaPnl.add(tab2,BorderLayout.EAST);
					contentPane.add(tabellaPnl,BorderLayout.CENTER);
		
	}
	

}
