package visteadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAOIstruttore.ElencoAttDAO;
import ClassiDAOIstruttore.ElencoEventiDAO;
import ClassiDAOIstruttore.EliminaAttDAO;
import ClassiDAOIstruttore.EliminaEventoDAO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


import ClassiDao.ElencoDisciplineDAO;
import ClassiDao.GetInfoDB;
import ClassiDao.UtenteDao;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import ModelliTabelle.ModDiscIni;
import ModelliTabelleIstruttore.ModElAttIstr;
import ModelliTabelleIstruttore.ModElEventiIstr;
import ModelliTabelleRespo.ModDiscDisp;
import ModelliTabelleRespo.ModElIstr;
import ModelliTabelleRespo.ModElTestResp;
import ModelliTabelleRespo.ModIstrDisp;
import ModelliTabelleRespo.ModLiv;
import ModelliTabelleRespo.ModPagam;
import VisteIstruttore.FrameIstruttore;
import VisteUtenteGenerico.DetDisciplina;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.FrameLogin;
import classiDAOResponsabile.ElencoDiscDispDAO;
import classiDAOResponsabile.ElencoIstrDAO;
import classiDAOResponsabile.ElencoIstrDispDAO;
import classiDAOResponsabile.ElencoLivDAO;
import classiDAOResponsabile.ElencoModPagDAO;
import classiDAOResponsabile.ElencoTestRespDao;
import classiDAOResponsabile.EliminaCombIstrDAO;
import classiDAOResponsabile.EliminaDisciplinaDAO;
import classiDAOResponsabile.EliminaDisciplinaDispDAO;
import classiDAOResponsabile.EliminaLivelloDAO;
import classiDAOResponsabile.EliminaModPagDAO;
import classiDAOResponsabile.EliminaTestimonianzaDAO;
import Listener.Listen;
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
	
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,bottoniPnl1,bottoniPnl2,bottoniPnl3,tabellaPnl4,tabellaPnl5,bottoniPnl4,bottoniPnl5,bottoniPnl6,tabellaPnl7,tabellaPnl6;
	public static JTable table,table2,table3,table4,table5,table6,table7;
    private ModDiscIni model;
    private ModLiv model2;
    private ModDiscDisp model3;
    private ModElIstr model4;
    private ModIstrDisp model5;
    private ModPagam model6;
	private ModElTestResp model7;
	private JTabbedPane tabel = new JTabbedPane();
    private JTabbedPane tabel2= new JTabbedPane();	/**
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
		
		JMenu mnNewMenu = new JMenu("home");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("visualizza");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("iniistr");
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CambiaPassword");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameCambia();
				frame.setEnabled(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		

		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (164,204,208));
		contentPane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		JLabel lblEventi = new JLabel("Gestione del centro polisportivo");
		lblEventi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventi.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(lblEventi, gbc);
		
		
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(4 , 1));
		
		
		JLabel lblG = new JLabel("Elenco delle discipline");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblG.setForeground(Color.BLACK);
		Dimension g = lblG.getPreferredSize();
		lblG.setPreferredSize(g);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		tabellaPnl.add(lblG);
		
		
			
		JScrollPane scrollt1 = new JScrollPane();
		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBounds(30, 30, 200, 30);
		
		
		
		
		model = new ModDiscIni(ElencoDisciplineDAO.elencoiniziale());
		table = new JTable(model);
		table.setRowHeight(20);
		table.setRowHeight(3, 50);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension d = table.getPreferredSize();
		table.setPreferredSize(d);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =1;
		gbc.gridy =2;
		
		scrollt1.setPreferredSize(d);
		scrollt1.setViewportView(table);
		tabellaPnl.add(scrollt1);
		
		
		
		
		bottoniPnl1 = new JPanel();
		
		JButton btnNewButton = new JButton("Inserisci disciplina");
		btnNewButton.setEnabled(true);
		btnNewButton.setMnemonic('a');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameInserisciDisciplina();
					
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =0;
		gbc.gridy =3;
		gbc.gridwidth = 2;
		bottoniPnl1.add(btnNewButton,gbc);
		
		
		
		
		JButton btnNewButton1 = new JButton("Modifica Disciplina");
		btnNewButton1.setEnabled(true);
		btnNewButton1.setMnemonic('b');
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(true);
				if(table.getSelectedRow()!=-1)
				{
					
				new FrameModificaDisciplina((String)FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0));	
					
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco","Errore disciplina",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =1;
		gbc.gridy =3;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl1.add(btnNewButton1,gbc);
		
		JButton btnNewButton2 = new JButton("Elimina Disciplina");
		btnNewButton2.setEnabled(true);
		btnNewButton2.setMnemonic('c');
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				EliminaDisciplinaDAO.eliminadisciplina((String) FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0));
				else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco","Errore disciplina",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =2;
		gbc.gridy =3;
		gbc.gridwidth = 2;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl1.add(btnNewButton2,gbc);
		Dimension b = bottoniPnl1.getPreferredSize();
		bottoniPnl1.setPreferredSize(b);
		
		
		
		
		
		
		tabellaPnl.add(bottoniPnl1,gbc);
		
		Dimension x = tabellaPnl.getPreferredSize();
		tabellaPnl.setPreferredSize(x);
		tabel.addTab("Gestione discipline", tabellaPnl);
		
		

		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new GridLayout(4 , 1));
		
		
		JLabel lblDisc = new JLabel("Elenco dei livelli");
		lblDisc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisc.setForeground(Color.BLACK);
		Dimension a = lblDisc.getPreferredSize();
		lblDisc.setPreferredSize(a);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx =1;
		gbc.gridy =4;
		tabellaPnl2.add(lblDisc);
		
		JScrollPane scrollt2 = new JScrollPane();
		scrollt2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt2.setBounds(50, 30, 300, 50);
		
		
		
		model2 = new ModLiv(ElencoLivDAO.elencoliv());
		table2 = new JTable(model2);
		table2.setRowHeight(20);
		table2.setRowHeight(3, 50);
		table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table2.setCellSelectionEnabled(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension e = table2.getPreferredSize();
		table2.setPreferredSize(e);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =1;
		gbc.gridy =5;
		scrollt2.setPreferredSize(e);
		
		scrollt2.setViewportView(table2);
		tabellaPnl2.add(scrollt2);
		
		
		
		
        bottoniPnl2 = new JPanel();
		
		JButton btnNewButton3 = new JButton("Inserisci Livello");
		btnNewButton3.setMnemonic('d');
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameInserisciLiv();
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx =0;
		gbc.gridy =6;
		gbc.gridwidth = 2;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl2.add(btnNewButton3,gbc);
		
		
		JButton btnNewButton4 = new JButton("Modifica Livello");
		btnNewButton4.setMnemonic('e');
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1)
				{
					new FrameModificaLiv(((String) FrameGestione.table2.getValueAt(FrameGestione.table2.getSelectedRow(), 0)));
					
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un livello dall'elenco","Errore livello",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx =1;
		gbc.gridy =6;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl2.add(btnNewButton4,gbc);
		
		JButton btnNewButton5 = new JButton("Elimina Livello");
		btnNewButton5.setMnemonic('f');
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1)
			{
					EliminaLivelloDAO.eliminalivello((String) FrameGestione.table2.getValueAt(FrameGestione.table2.getSelectedRow(), 0));	
					
			}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un'attività dall'elenco","Errore attività",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx =2;
		gbc.gridy =6;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl2.add(btnNewButton5,gbc);
	
	
		tabellaPnl2.add(bottoniPnl2,gbc);
		Dimension t = tabellaPnl2.getPreferredSize();
		tabellaPnl2.setPreferredSize(t);
		tabel.addTab("Gestione livelli",tabellaPnl2);
		
        
	
		tabellaPnl3 = new JPanel();
		tabellaPnl3.setLayout(new GridLayout(4 , 1));
		
		
		
		JLabel lblDD = new JLabel("Elenco delle discipline disponibili");
		lblDD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDD.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx =1;
		gbc.gridy =7;
		tabellaPnl3.add(lblDD);
		
		
		
		
		model3 = new ModDiscDisp(ElencoDiscDispDAO.elencodiscdisp());
		table3 = new JTable(model3);
		table3.setRowHeight(20);
		table3.setRowHeight(3, 50);
		table3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table3.setCellSelectionEnabled(true);
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension n = table3.getPreferredSize();
		table3.setPreferredSize(n);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =1;
		gbc.gridy =8;
			
		JScrollPane scrollt3 = new JScrollPane();
		scrollt3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt3.setBounds(50, 30, 300, 50);	
		scrollt3.setPreferredSize(n);
		scrollt3.setViewportView(table3);
		tabellaPnl3.add(scrollt3);
		
		bottoniPnl3 = new JPanel();
		
		JButton btnNewButton10 = new JButton("Inserisci disciplina disponibile");
		btnNewButton10.setMnemonic('g');
		btnNewButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameInserisciDiscDisp();
					
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx =0;
		gbc.gridy =9;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl3.add(btnNewButton10,gbc);
		
		JButton btnNewButton101 = new JButton("Modifica disciplina disponibile");
		btnNewButton101.setMnemonic('x');
		btnNewButton101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameModificaDiscDisp((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 0),(String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 1),(float) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 2));
					
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx =1;
		gbc.gridy =9;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl3.add(btnNewButton101,gbc);
		
		
		
		JButton btnNewButton11 = new JButton("Elimina disciplina disponibile");
		btnNewButton11.setMnemonic('y');
		btnNewButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table3.getSelectedRow()!=-1)
				{
					
					EliminaDisciplinaDispDAO.eliminadisciplinadisp(((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 0)),((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 1)));	
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona una disciplina dall'elenco","Errore disciplina",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx =2;
		gbc.gridy =9;
		
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl3.add(btnNewButton11,gbc);
		Dimension v = bottoniPnl3.getPreferredSize();
		bottoniPnl3.setPreferredSize(v);
		
		
		
		
	
		
		tabellaPnl3.add(bottoniPnl3,gbc);
		Dimension s = tabellaPnl3.getPreferredSize();
		tabellaPnl3.setPreferredSize(s);
		tabel.addTab("Gestione discipline disponibili",tabellaPnl3);
		
		
		
		
		
		

	
	tabellaPnl5 = new JPanel();
	tabellaPnl5.setLayout(new GridLayout(4 , 1));
	
	
	
	JLabel lblISD = new JLabel("Elenco degli istruttori disponibili");
	lblISD.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblISD.setForeground(Color.BLACK);
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx =1;
	gbc.gridy =12;
	tabellaPnl5.add(lblISD);
	
	JScrollPane scrollt5 = new JScrollPane();
	scrollt5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollt5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollt5.setBounds(50, 30, 300, 50);
	
	
	model5 = new ModIstrDisp(ElencoIstrDispDAO.elencoistrdisp());
	table5 = new JTable(model5);
	table5.setRowHeight(20);
	table5.setRowHeight(3, 50);
	table5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	table5.setCellSelectionEnabled(true);
	table5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	Dimension txy = table5.getPreferredSize();
	table5.setPreferredSize(txy);
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =1;
	gbc.gridy =13;
		
		
	scrollt5.setPreferredSize(txy);
	scrollt5.setViewportView(table5);
	tabellaPnl5.add(scrollt5);
	
	
	bottoniPnl4 = new JPanel();
	
	JButton btnNewButton12 = new JButton("Inserisci istruttore  disponibile");
	btnNewButton12.setMnemonic('h');
	btnNewButton12.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciIstrDisp();
				
		}
	});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridwidth = 2;
	gbc.gridx =0;
	gbc.gridy =14;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl4.add(btnNewButton12,gbc);
	
	JButton btnNewButton122 = new JButton("Modifica istruttore  disponibile");
	btnNewButton122.setMnemonic('i');
	btnNewButton122.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				
		}
	});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridwidth = 2;
	gbc.gridx =0;
	gbc.gridy =14;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl4.add(btnNewButton122,gbc);
	
	
	JButton btnNewButton13 = new JButton("Elimina istruttore disponibile");
	btnNewButton13.setMnemonic('l');
	btnNewButton13.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table5.getSelectedRow()!=-1)
			{
				EliminaCombIstrDAO.eliminacombis(((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 0)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 1)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 2)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 3)));
				
		}
			else{
			JOptionPane.showMessageDialog(null, "Seleziona una combinazione dall'elenco","Errore combinazione",JOptionPane.WARNING_MESSAGE);}
	}});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridwidth = 2;
	gbc.gridx =1;
	gbc.gridy =14;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl4.add(btnNewButton13,gbc);
	Dimension o = bottoniPnl3.getPreferredSize();
	bottoniPnl4.setPreferredSize(o);
	
	
	tabellaPnl5.add(bottoniPnl4,gbc);
	Dimension sex= tabellaPnl5.getPreferredSize();
	tabellaPnl5.setPreferredSize(sex);
	tabel.addTab("Gestione Istruttori Disponibii",tabellaPnl5);
	
	tabellaPnl6 = new JPanel();
	tabellaPnl6.setLayout(new GridLayout(4 , 1));
	
	
	
	
	JLabel lblM = new JLabel("Elenco delle modalità di pagamento");
	lblM.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblM.setForeground(Color.BLACK);
	Dimension i = lblM.getPreferredSize();
	lblM.setPreferredSize(i);
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 15;
	tabellaPnl6.add(lblM);
	
	JScrollPane scrollt6 = new JScrollPane();
	scrollt6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollt6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollt6.setBounds(30, 30, 200, 30);
	
	
	model6 = new ModPagam(ElencoModPagDAO.elencomodp());
	table6 = new JTable(model6);
	table6.setRowHeight(20);
	table6.setRowHeight(3, 50);
	table6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	table6.setCellSelectionEnabled(true);
	table6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	Dimension di = table6.getPreferredSize();
	table6.setPreferredSize(di);
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =1;
	gbc.gridy= 16;
		
	
	scrollt6.setPreferredSize(di);
	scrollt6.setViewportView(table6);
	tabellaPnl6.add(scrollt6);
	
	bottoniPnl5 = new JPanel();
	
	JButton btnNewButton9 = new JButton("Inserisci modalità di pagamento");
	btnNewButton9.setMnemonic('m');
	btnNewButton9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciModPag();
				
		}
	});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =0;
	gbc.gridy =17;
	gbc.gridwidth = 2;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl5.add(btnNewButton9,gbc);
	
	
	JButton btnNewButton14 = new JButton("Modifica modalità di pagamento ");
	btnNewButton14.setMnemonic('n');
	btnNewButton14.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table6.getSelectedRow()!=-1)
			{
				new FrameModificaModPag((String) FrameGestione.table6.getValueAt(FrameGestione.table6.getSelectedRow(), 0));
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona una modalità dall'elenco","Errore modalità",JOptionPane.WARNING_MESSAGE);
		}
	});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridwidth = 2;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =1;
	gbc.gridy =17;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl5.add(btnNewButton14,gbc);
	
	JButton btnNewButton15 = new JButton("Elimina modalità di pagamento");
	btnNewButton15.setMnemonic('o');
	btnNewButton15.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table6.getSelectedRow()!=-1)
			{
				EliminaModPagDAO.eliminamodpagam((String) FrameGestione.table6.getValueAt(FrameGestione.table6.getSelectedRow(), 0));	
				
				
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona una modalità dall'elenco","Errore modalità",JOptionPane.WARNING_MESSAGE);
		}
	});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =2;
	gbc.gridy =17;
	gbc.gridwidth = 2;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl5.add(btnNewButton15,gbc);
	Dimension bi = bottoniPnl5.getPreferredSize();
	bottoniPnl5.setPreferredSize(bi);
		
	
	
	
	tabellaPnl6.add(bottoniPnl5,gbc);
	Dimension u =tabellaPnl6.getPreferredSize();
	tabellaPnl6.setPreferredSize(u);
	tabel.addTab("Gestione modalità di pagamento", tabellaPnl6);
	
	tabellaPnl7 = new JPanel();
	tabellaPnl7.setLayout(new GridLayout(4 , 1));
	
	
	
	
	JLabel lblT = new JLabel("Elenco delle testimonianze");
	lblT.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblT.setForeground(Color.BLACK);
	Dimension it = lblM.getPreferredSize();
	lblT.setPreferredSize(it);
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 18;
	tabellaPnl7.add(lblT);
	
	JScrollPane scrollt7 = new JScrollPane();
	scrollt7.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollt7.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollt7.setBounds(30, 30, 200, 30);
	
	
	model7 = new ModElTestResp(ElencoTestRespDao.elencotest());
	table7 = new JTable(model7);
	table7.setRowHeight(20);
	table7.setRowHeight(3, 50);
	table7.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	table7.setCellSelectionEnabled(true);
	table7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	Dimension dix = table7.getPreferredSize();
	table7.setPreferredSize(dix);
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =1;
	gbc.gridy= 19;
		
	
	scrollt7.setPreferredSize(dix);
	scrollt7.setViewportView(table7);
	tabellaPnl7.add(scrollt7);
	
	bottoniPnl6 = new JPanel();
	
	JButton btnNewButton16 = new JButton("Cancella Testimonianza");
	btnNewButton16.setMnemonic('q');
	btnNewButton16.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table7.getSelectedRow()!=-1)
			{
				EliminaTestimonianzaDAO.eliminatest(((String) FrameGestione.table7.getValueAt(FrameGestione.table7.getSelectedRow(), 0)),((String) FrameGestione.table7.getValueAt(FrameGestione.table7.getSelectedRow(), 1)));		
				
			}
			else
				JOptionPane.showMessageDialog(null, "Seleziona una modalità dall'elenco","Errore modalità",JOptionPane.WARNING_MESSAGE);
		}
				
		
	});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =1;
	gbc.gridy =20;
	gbc.gridwidth = 2;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl6.add(btnNewButton16,gbc);
	
	
	
	
	Dimension bim = bottoniPnl6.getPreferredSize();
	bottoniPnl6.setPreferredSize(bim);
		
	
	
	
	tabellaPnl7.add(bottoniPnl6,gbc);
	Dimension uy =tabellaPnl7.getPreferredSize();
	tabellaPnl7.setPreferredSize(uy);
	tabel.addTab("Gestione testimonianze",tabellaPnl7);
	
	
	
	
	
	contentPane.add(tabel,gbc);

}
	
	
}
