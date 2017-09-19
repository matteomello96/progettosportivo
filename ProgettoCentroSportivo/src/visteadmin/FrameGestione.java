package visteadmin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


import ClassiDao.ElencoDisciplineDAO;


import java.awt.ComponentOrientation;
import java.awt.Dimension;

import ModelliTabelle.ModDiscIni;

import VisteUtenteGenerico.setupTableWidths;
import classiDAOResponsabile.ElencoCalDAO;
import classiDAOResponsabile.ElencoDiscDispDAO;

import classiDAOResponsabile.ElencoIstrDispDAO;
import classiDAOResponsabile.ElencoLivDAO;
import classiDAOResponsabile.ElencoModPagDAO;
import classiDAOResponsabile.ElencoTestRespDao;

import classiDAOResponsabile.GestioneDAO;
import listener.Listen;
import listener.VariListener;
import modelliTabelleRespo.ModCal;
import modelliTabelleRespo.ModDiscDisp;

import modelliTabelleRespo.ModElTestResp;
import modelliTabelleRespo.ModIstrDisp;
import modelliTabelleRespo.ModLiv;
import modelliTabelleRespo.ModPagam;
import Model.Utente;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FrameGestione extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,bottoniPnl1,bottoniPnl2,bottoniPnl3,bottoniPnl7,tabellaPnl8,tabellaPnl4,tabellaPnl5,bottoniPnl4,bottoniPnl5,bottoniPnl6,tabellaPnl7,tabellaPnl6;
	public static JTable table,table2,table3,table4,table5,table6,table7,table8,tablemod1,tablemod2,tablemod3,tablemod4,tablemod5,tablemod6,tablemod7,tablemod8;
    private ModDiscIni model;
    private ModLiv model2;
    private ModDiscDisp model3;
    private JPanel GPane1,Panel1,BotPnl1,Panel2,BotPnl2,GPane2,GPane3,Panel3,BotPnl3,GPane4,Panel4,BotPnl4,GPane5,Panel5,BotPnl5,GPane6,Panel6,BotPnl6,GPane7,Panel7,BotPnl7,Panel8;
    private ModIstrDisp model5;
    private ModPagam model6;
	private ModElTestResp model7;
	private ModCal model8;
	private JTabbedPane tabel = new JTabbedPane();

    	/**
	 * Create the frame.
	 */
	public FrameGestione() {
		frame = new JFrame();
		String username=""+Utente.getUsername()+"";
		frame.setTitle("Gestione responsabile "+username+"");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 605, 391);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pannello di controllo");
		menuBar.add(mnNewMenu);
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Vai al pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("pandages");
		
		
		
		tabel = new JTabbedPane();
		
		
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
	    
		
		

		

	       Panel2 = new JPanel();
	  		Panel2.setBackground(new Color(255,185,0));
	  		Panel2.setLayout(new GridBagLayout());	
		
		
	    GPane1 = new JPanel();
		GPane1.setBackground(new Color (235,193,20));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		GPane1.add(VariListener.SettaPannelloTitolo(im3, Panel2, 1, 0, "Gestione disciplina"), BorderLayout.NORTH);		
		
		
		
		table = new JTable();
		model = new ModDiscIni(ElencoDisciplineDAO.elencoiniziale());
		GPane1.add(VariListener.SettaScroll(table,50,model), BorderLayout.CENTER);
		
		
		
		BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (235,193,20));
		BotPnl1.setLayout(new GridBagLayout());
		
		
		JButton btn = new JButton(im);
		JLabel lbl= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn, lbl,"Inserisci disciplina", 2, 2,im2,true);
		btn.setMnemonic('e');
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new FrameInserisciDisciplina();
					
			}
		});	

		
		
		

		JButton btn1 = new JButton(im);
		JLabel lbl1= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn1, lbl1,"Modifica disciplina", 4, 2,im2,true);
		btn1.setMnemonic('e');
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(true);
				if(table.getSelectedRow()!=-1)
				{
					
				new FrameModificaDisciplina((String)FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0));	
				frame.dispose();	
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco","Errore disciplina",JOptionPane.WARNING_MESSAGE);
			}
		});	
	

		JButton btn2 = new JButton(im);
		JLabel lbl2= new JLabel();
        VariListener.SettaBtn(BotPnl1, btn2, lbl2,"elimina disciplina", 6, 2,im2,true);
		btn2.setMnemonic('e');
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
				GestioneDAO.eliminadisciplina((String) FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0));
				frame.dispose();
				new FrameGestione();}
				else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco","Errore disciplina",JOptionPane.WARNING_MESSAGE);
			}
		});	

		
		
		
		
		
		
		GPane1.add(BotPnl1,BorderLayout.SOUTH);
		
	
		tabel.addTab("Gestione discipline", GPane1);
		
		

		
		
		  Panel3 = new JPanel();
			Panel3.setBackground(new Color(255,185,0));
			Panel3.setLayout(new GridBagLayout());
			
			
			
			
			
		    GPane2 = new JPanel();
			GPane2.setBackground(new Color (255,185,0));
			GPane2.setLayout(new BorderLayout());
			
			
			
			
			
	GPane2.add(VariListener.SettaPannelloTitolo(im3, Panel3, 1, 0, "Elenco Richieste Confermate"), BorderLayout.NORTH);		
		
		
	     table2 = new JTable();
		model2 = new ModLiv(ElencoLivDAO.elencoliv());
	
		GPane2.add(VariListener.SettaScroll(table2,50,model2), BorderLayout.CENTER);
		
		
		
		
	    BotPnl2 = new JPanel();
		BotPnl2.setBackground(new Color (235,193,20));
		BotPnl2.setLayout(new GridBagLayout());
		
		

		JButton btn3 = new JButton(im);
		JLabel lbl3= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn3, lbl3,"Inserisci livello", 2, 2,im2,true);
		btn3.setMnemonic('e');
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new FrameInserisciLiv();
			}
		});	

		
		
		JButton btn4 = new JButton(im);
		JLabel lbl4= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn4, lbl4,"Modifica livello", 4, 2,im2,true);
		btn4.setMnemonic('e');
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1)
				{
					new FrameModificaLiv(((String) FrameGestione.table2.getValueAt(FrameGestione.table2.getSelectedRow(), 0)));
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un livello dall'elenco","Errore livello",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		JButton btn5 = new JButton(im);
		JLabel lbl5= new JLabel();
        VariListener.SettaBtn(BotPnl2, btn5, lbl5,"Modifica livello", 6, 2,im2,true);
		btn5.setMnemonic('e');
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1)
			{
					GestioneDAO.eliminalivello((String) FrameGestione.table2.getValueAt(FrameGestione.table2.getSelectedRow(), 0));	
					frame.dispose();
					new FrameGestione();
			}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
	
	
	
		GPane2.add(BotPnl2,BorderLayout.SOUTH);
		
		tabel.addTab("Gestione livelli",GPane2);
		
        
		   Panel4 = new JPanel();
			Panel4.setBackground(new Color(255,185,0));
			Panel4.setLayout(new GridBagLayout());
			
			
			
			
			
		     GPane3 = new JPanel();
			GPane3.setBackground(new Color (255,185,0));
			GPane3.setLayout(new BorderLayout());
			
			
			
            GPane3.add(VariListener.SettaPannelloTitolo(im3, Panel4, 1, 0, "Elenco discipline disponibili"), BorderLayout.NORTH);		
		
		
		
		table3 = new JTable();
		model3 = new ModDiscDisp(ElencoDiscDispDAO.elencodiscdisp());
		
		GPane3.add(VariListener.SettaScroll(table3,50,model3), BorderLayout.CENTER);
		
		
	 BotPnl3 = new JPanel();
		BotPnl3.setBackground(new Color (235,193,20));
		BotPnl3.setLayout(new GridBagLayout());
		
		

		JButton btn6 = new JButton(im);
		JLabel lbl6= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn6, lbl6,"ins discipline disponibili", 2, 2,im2,true);
		btn6.setMnemonic('e');
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new FrameInserisciDiscDisp();
					
			}
		});	
		
		
		JButton btn7 = new JButton(im);
		JLabel lbl7= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn7, lbl7,"modifica discipline disponibili", 4, 2,im2,true);
		btn7.setMnemonic('e');
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameModificaDiscDisp((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 0),(String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 1),(float) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 2));
					frame.dispose();
			}
		});	
		
		
		
		JButton btn8 = new JButton(im);
		JLabel lbl8= new JLabel();
        VariListener.SettaBtn(BotPnl3, btn8, lbl8,"elimina discipline disponibili", 6, 2,im2,true);
		btn8.setMnemonic('e');
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table3.getSelectedRow()!=-1)
				{
					
					GestioneDAO.eliminadisciplinadisp(((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 0)),((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 1)));	
					frame.dispose();
					new FrameGestione();
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco","Errore disciplina",JOptionPane.WARNING_MESSAGE);
			}
		});	
		
		
		
		
		
		
	
		
		GPane3.add(BotPnl3,BorderLayout.SOUTH);
		tabel.addTab("Gestione discipline disponibili",GPane3);
		
		
		
		
		
		

		   Panel5 = new JPanel();
			Panel5.setBackground(new Color(255,185,0));
			Panel5.setLayout(new GridBagLayout());
			
			
			
			
			
		    GPane4 = new JPanel();
			GPane4.setBackground(new Color (255,185,0));
			GPane4.setLayout(new BorderLayout());
			
			
			
			
			
GPane4.add(VariListener.SettaPannelloTitolo(im3, Panel5, 1, 0, "Gestione istruttore"), BorderLayout.NORTH);		
	
    table5 = new JTable();
	model5 = new ModIstrDisp(ElencoIstrDispDAO.elencoistrdisp());
	GPane4.add(VariListener.SettaScroll(table5,50,model5), BorderLayout.CENTER);
	
 BotPnl4 = new JPanel();
	BotPnl4.setBackground(new Color (235,193,20));
	BotPnl4.setLayout(new GridBagLayout());
	
	

	JButton btn9 = new JButton(im);
	JLabel lbl9= new JLabel();
    VariListener.SettaBtn(BotPnl4, btn9, lbl9,"ins istruttore", 2, 2,im2,true);
	btn9.setMnemonic('e');
	btn9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciIstrDisp();
				frame.dispose();
		}
	});	

	JButton btn10 = new JButton(im);
	JLabel lbl10= new JLabel();
    VariListener.SettaBtn(BotPnl4, btn10, lbl10,"modifica istruttore", 4, 2,im2,true);
	btn10.setMnemonic('e');
	btn10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				
		}
	});	
	
	
	
	JButton btn11 = new JButton(im);
	JLabel lbl11= new JLabel();
    VariListener.SettaBtn(BotPnl4, btn11, lbl11,"elimina istruttore", 6, 2,im2,true);
	btn11.setMnemonic('e');
	btn11.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table5.getSelectedRow()!=-1)
			{
				GestioneDAO.eliminacombis(((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 0)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 1)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 2)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 3)));
				frame.dispose();
				new FrameGestione();
		}
			else{
			JOptionPane.showMessageDialog(null, "Seleziona una combinazione dall'elenco","Errore combinazione",JOptionPane.WARNING_MESSAGE);}
	}});	

	
	
	
	GPane4.add(BotPnl4,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione Istruttori Disponibii",GPane4);
	
	
	
	
	Panel6 = new JPanel();
	Panel6.setBackground(new Color(255,185,0));
	Panel6.setLayout(new GridBagLayout());
	
	
	
	
	
    GPane5 = new JPanel();
	GPane5.setBackground(new Color (255,185,0));
	GPane5.setLayout(new BorderLayout());
	
	
	
	
	
	GPane5.add(VariListener.SettaPannelloTitolo(im3, Panel6, 1, 0, "Elenco modalita pagamento"), BorderLayout.NORTH);		
	
	
	
	table6 = new JTable();
	model6 = new ModPagam(ElencoModPagDAO.elencomodp());
	GPane5.add(VariListener.SettaScroll(table6,50,model6), BorderLayout.CENTER);
	
	
	
	BotPnl5 = new JPanel();
	BotPnl5.setBackground(new Color (235,193,20));
	BotPnl5.setLayout(new GridBagLayout());
	
	
	
	
	JButton btn12 = new JButton(im);
	JLabel lbl12= new JLabel();
    VariListener.SettaBtn(BotPnl5, btn12, lbl12,"inserisci modalita pagamento", 2, 2,im2,true);
	btn12.setMnemonic('e');
	btn12.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciModPag();
				frame.dispose();
		}
	});	

	
	
	JButton btn13 = new JButton(im);
	JLabel lbl13= new JLabel();
    VariListener.SettaBtn(BotPnl5, btn13, lbl13,"modifica modalita pagamento", 4, 2,im2,true);
	btn13.setMnemonic('e');
	btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table6.getSelectedRow()!=-1)
			{
				new FrameModificaModPag((String) FrameGestione.table6.getValueAt(FrameGestione.table6.getSelectedRow(), 0));
				frame.dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona una modalità dall'elenco","Errore modalità",JOptionPane.WARNING_MESSAGE);
		}
	});	

	
	JButton btn14 = new JButton(im);
	JLabel lbl14= new JLabel();
    VariListener.SettaBtn(BotPnl5, btn14, lbl14,"elimina modalita pagamento", 6, 2,im2,true);
	btn14.setMnemonic('e');
	btn14.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table6.getSelectedRow()!=-1)
			{
				GestioneDAO.eliminamodpagam((String) FrameGestione.table6.getValueAt(FrameGestione.table6.getSelectedRow(), 0));	
				frame.dispose();
				new FrameGestione();
				
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona una modalità dall'elenco","Errore modalità",JOptionPane.WARNING_MESSAGE);
		}
	});	

		
	
	
	
	GPane5.add(BotPnl5,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione modalità di pagamento", GPane5);
	
	
	
	
	

    Panel7 = new JPanel();
	Panel7.setBackground(new Color(255,185,0));
	Panel7.setLayout(new GridBagLayout());
	
	
	
	
	
    GPane6 = new JPanel();
	GPane6.setBackground(new Color (255,185,0));
	GPane6.setLayout(new BorderLayout());
	
	
	
	
	
	GPane6.add(VariListener.SettaPannelloTitolo(im3, Panel7, 1, 0, "Elenco testimonianze"), BorderLayout.NORTH);		
	
	
	table7 = new JTable();
	model7 = new ModElTestResp(ElencoTestRespDao.elencotest());
	GPane6.add(VariListener.SettaScroll(table7,50,model7), BorderLayout.CENTER);
	
	
	
	
	
	
	BotPnl6 = new JPanel();
	BotPnl6.setBackground(new Color (235,193,20));
	BotPnl6.setLayout(new GridBagLayout());
	
	

	JButton btn15 = new JButton(im);
	JLabel lbl15= new JLabel();
    VariListener.SettaBtn(BotPnl6, btn15, lbl15,"Cancella testimonianza", 2, 2,im2,true);
	btn15.setMnemonic('e');
	btn15.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table7.getSelectedRow()!=-1)
			{
				GestioneDAO.eliminatest(((String) FrameGestione.table7.getValueAt(FrameGestione.table7.getSelectedRow(), 0)),((String) FrameGestione.table7.getValueAt(FrameGestione.table7.getSelectedRow(), 1)));		
				frame.dispose();
				new FrameGestione();
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona una testimonianza dall'elenco","Errore testimonianza",JOptionPane.WARNING_MESSAGE);
		}
				
		
	});	
	
	
	
	
	

		
	
	
	
	GPane6.add(BotPnl6,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione testimonianze",GPane6);
	
	

    Panel8 = new JPanel();
	Panel8.setBackground(new Color(255,185,0));
	Panel8.setLayout(new GridBagLayout());
	
	
	
	
	
    GPane7 = new JPanel();
	GPane7.setBackground(new Color (255,185,0));
	GPane7.setLayout(new BorderLayout());
	
	
	
	
	
	GPane7.add(VariListener.SettaPannelloTitolo(im3, Panel8, 1, 0, "Calendario"), BorderLayout.NORTH);		
	
	
	table8 = new JTable();
	model8 = new ModCal(ElencoCalDAO.elencocal());
	GPane7.add(VariListener.SettaScroll(table8,50,model8), BorderLayout.CENTER);
	
	

	BotPnl7 = new JPanel();
	BotPnl7.setBackground(new Color (235,193,20));
	BotPnl7.setLayout(new GridBagLayout());
	
	

	JButton btn16 = new JButton(im);
	JLabel lbl16= new JLabel();
    VariListener.SettaBtn(BotPnl7, btn16, lbl16,"Inserisci calendario", 2, 2,im2,true);
	btn16.setMnemonic('e');
	btn16.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciCal();
				frame.dispose();
		}
	});	

	
	
	JButton btn17 = new JButton(im);
	JLabel lbl17= new JLabel();
    VariListener.SettaBtn(BotPnl7, btn17, lbl17,"Modifica calendario", 4, 2,im2,true);
	btn17.setMnemonic('e');
	btn17.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table8.getSelectedRow()!=-1)
			{
				new FrameModificaCal((String) FrameGestione.table8.getValueAt(FrameGestione.table8.getSelectedRow(), 0));
				frame.dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona un calendario dall'elenco","Errore calendario",JOptionPane.WARNING_MESSAGE);
		}
	});	

	
	JButton btn18 = new JButton(im);
	JLabel lbl18= new JLabel();
    VariListener.SettaBtn(BotPnl7, btn18, lbl18,"Cancella calendario", 6, 2,im2,true);
	btn18.setMnemonic('e');
	btn18.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table8.getSelectedRow()!=-1)
			{
				GestioneDAO.eliminacalendario(((String) FrameGestione.table8.getValueAt(FrameGestione.table8.getSelectedRow(), 0)));		
				frame.dispose();
				new FrameGestione();
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona un calendario dall'elenco","Errore calendario",JOptionPane.WARNING_MESSAGE);
		}
				
		
	});	

	

	
	
	
	GPane7.add(BotPnl7,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione calendario",GPane7);
	
	
	contentPane.add(tabel);

}
	
	
}
