package visteadmin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


import javax.swing.BorderFactory;
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
		tabellaPnl.setLayout(new BorderLayout());
		
		JLabel lblNull = new JLabel("Nessuna informazione disponibile");
		lblNull.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNull.setBounds(40,40,100,300);
		lblNull.setOpaque(true);
		lblNull.setForeground(new Color (255,255,255));
		lblNull.setBackground(new Color (0,150,17));
		Border b = BorderFactory.createLineBorder(new Color (255,205,255));
		lblNull.setBorder(b);
		
		
		JLabel lblG = new JLabel("Elenco delle discipline");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblG.setForeground(Color.BLACK);
		Dimension g = lblG.getPreferredSize();
		lblG.setPreferredSize(g);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		tabellaPnl.add(lblG,BorderLayout.NORTH);
		
		
			
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
		tablemod1 = setupTableWidths.setupTableWidths(table);

		tablemod1.setForeground(new Color(255, 255, 255));
		tablemod1.setBackground(new Color(240, 220, 130));
		
		if(model.getRowCount()==0)
		{
			scrollt1.setViewportView(lblNull);
		}
		else{
		scrollt1.setViewportView(tablemod1);
		}
		tabellaPnl.add(scrollt1,BorderLayout.CENTER);
		
		
		
		
		bottoniPnl1 = new JPanel();
		bottoniPnl1.setLayout(new GridBagLayout());
		
		JButton btnNewButton = new JButton("Inserisci disciplina");
		btnNewButton.setEnabled(true);
		btnNewButton.setMnemonic('a');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
				frame.dispose();	
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
				if(table.getSelectedRow()!=-1){
				GestioneDAO.eliminadisciplina((String) FrameGestione.table.getValueAt(FrameGestione.table.getSelectedRow(), 0));
				frame.dispose();
				new FrameGestione();}
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
		
		
		
		
		
		
		tabellaPnl.add(bottoniPnl1,BorderLayout.SOUTH);
		
	
		tabel.addTab("Gestione discipline", tabellaPnl);
		
		

		tabellaPnl2 = new JPanel();
		tabellaPnl2.setLayout(new BorderLayout());
		
		
		JLabel lblDisc = new JLabel("Elenco dei livelli");
		lblDisc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisc.setForeground(Color.BLACK);
		Dimension a = lblDisc.getPreferredSize();
		lblDisc.setPreferredSize(a);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx =1;
		gbc.gridy =4;
		tabellaPnl2.add(lblDisc,BorderLayout.NORTH);
		
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
		tablemod2 = setupTableWidths.setupTableWidths(table2);

		tablemod2.setForeground(new Color(255, 255, 255));
		tablemod2.setBackground(new Color(240, 220, 130));
		if(model2.getRowCount()==0)
		{
			scrollt2.setViewportView(lblNull);
		}
		else
		{
		scrollt2.setViewportView(tablemod2);
		}
		tabellaPnl2.add(scrollt2,BorderLayout.CENTER);
		
		
		
		
        bottoniPnl2 = new JPanel();
		bottoniPnl2.setLayout(new GridBagLayout());
		
		JButton btnNewButton3 = new JButton("Inserisci Livello");
		btnNewButton3.setMnemonic('d');
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
					frame.dispose();
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
					GestioneDAO.eliminalivello((String) FrameGestione.table2.getValueAt(FrameGestione.table2.getSelectedRow(), 0));	
					frame.dispose();
					new FrameGestione();
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
	
	
		tabellaPnl2.add(bottoniPnl2,BorderLayout.SOUTH);
		
		tabel.addTab("Gestione livelli",tabellaPnl2);
		
        
	
		tabellaPnl3 = new JPanel();
		tabellaPnl3.setLayout(new BorderLayout());
		
		
		
		JLabel lblDD = new JLabel("Elenco delle discipline disponibili");
		lblDD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDD.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx =1;
		gbc.gridy =7;
		tabellaPnl3.add(lblDD,BorderLayout.NORTH);
		
		
		
		
		model3 = new ModDiscDisp(ElencoDiscDispDAO.elencodiscdisp());
		table3 = new JTable(model3);
		table3.setRowHeight(20);
		table3.setRowHeight(3, 50);
		table3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table3.setCellSelectionEnabled(true);
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablemod3 = setupTableWidths.setupTableWidths(table3);

		tablemod3.setForeground(new Color(255, 255, 255));
		tablemod3.setBackground(new Color(240, 220, 130));
			
		JScrollPane scrollt3 = new JScrollPane();
		scrollt3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt3.setBounds(50, 30, 300, 50);
		if(model3.getRowCount()==0)
		{
			scrollt3.setViewportView(lblNull);
		}
		else
		{
		scrollt3.setViewportView(tablemod3);
		}
		tabellaPnl3.add(scrollt3,BorderLayout.CENTER);
		
		bottoniPnl3 = new JPanel();
		bottoniPnl3.setLayout(new GridBagLayout());
		
		
		JButton btnNewButton10 = new JButton("Inserisci disciplina disponibile");
		btnNewButton10.setMnemonic('g');
		btnNewButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
					frame.dispose();
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
					
					GestioneDAO.eliminadisciplinadisp(((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 0)),((String) FrameGestione.table3.getValueAt(FrameGestione.table3.getSelectedRow(), 1)));	
					frame.dispose();
					new FrameGestione();
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
		
		
		
		
		
	
		
		tabellaPnl3.add(bottoniPnl3,BorderLayout.SOUTH);
		tabel.addTab("Gestione discipline disponibili",tabellaPnl3);
		
		
		
		
		
		

	
	tabellaPnl5 = new JPanel();
	tabellaPnl5.setLayout(new BorderLayout());
	
	
	
	JLabel lblISD = new JLabel("Elenco degli istruttori disponibili");
	lblISD.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblISD.setForeground(Color.BLACK);
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx =1;
	gbc.gridy =12;
	tabellaPnl5.add(lblISD,BorderLayout.NORTH);
	
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
	tablemod5 = setupTableWidths.setupTableWidths(table5);

	tablemod5.setForeground(new Color(255, 255, 255));
	tablemod5.setBackground(new Color(240, 220, 130));
	if(model5.getRowCount()==0)
	{
		scrollt5.setViewportView(lblNull);
	}
	else
	{
	scrollt5.setViewportView(tablemod5);
	}
	tabellaPnl5.add(scrollt5,BorderLayout.CENTER);
	
	
	bottoniPnl4 = new JPanel();
	bottoniPnl4.setLayout(new GridBagLayout());
	
	
	JButton btnNewButton12 = new JButton("Inserisci istruttore  disponibile");
	btnNewButton12.setMnemonic('h');
	btnNewButton12.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciIstrDisp();
				frame.dispose();
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
				GestioneDAO.eliminacombis(((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 0)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 1)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 2)),((String) FrameGestione.table5.getValueAt(FrameGestione.table5.getSelectedRow(), 3)));
				frame.dispose();
				new FrameGestione();
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
	
	
	
	tabellaPnl5.add(bottoniPnl4,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione Istruttori Disponibii",tabellaPnl5);
	
	tabellaPnl6 = new JPanel();
	tabellaPnl6.setLayout(new BorderLayout());
	
	
	
	
	JLabel lblM = new JLabel("Elenco delle modalità di pagamento");
	lblM.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblM.setForeground(Color.BLACK);
	Dimension i = lblM.getPreferredSize();
	lblM.setPreferredSize(i);
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 15;
	tabellaPnl6.add(lblM,BorderLayout.NORTH);
	
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
	tablemod6 = setupTableWidths.setupTableWidths(table6);

	tablemod6.setForeground(new Color(255, 255, 255));
	tablemod6.setBackground(new Color(240, 220, 130));
	if(model6.getRowCount()==0)
	{
		scrollt6.setViewportView(lblNull);
	}
	else
	{
	scrollt6.setViewportView(tablemod6);
	}
	tabellaPnl6.add(scrollt6,BorderLayout.CENTER);
	
	bottoniPnl5 = new JPanel();
	bottoniPnl5.setLayout(new GridBagLayout());
	
	JButton btnNewButton9 = new JButton("Inserisci modalità di pagamento");
	btnNewButton9.setMnemonic('m');
	btnNewButton9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciModPag();
				frame.dispose();
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
				frame.dispose();
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
				GestioneDAO.eliminamodpagam((String) FrameGestione.table6.getValueAt(FrameGestione.table6.getSelectedRow(), 0));	
				frame.dispose();
				new FrameGestione();
				
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
	
		
	
	
	
	tabellaPnl6.add(bottoniPnl5,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione modalità di pagamento", tabellaPnl6);
	
	tabellaPnl7 = new JPanel();
	tabellaPnl7.setLayout(new BorderLayout());
	
	
	
	
	JLabel lblT = new JLabel("Elenco delle testimonianze");
	lblT.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblT.setForeground(Color.BLACK);
	Dimension it = lblM.getPreferredSize();
	lblT.setPreferredSize(it);
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 18;
	tabellaPnl7.add(lblT,BorderLayout.NORTH);
	
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
	tablemod7 = setupTableWidths.setupTableWidths(table7);

	tablemod7.setForeground(new Color(255, 255, 255));
	tablemod7.setBackground(new Color(240, 220, 130));
	if(model7.getRowCount()==0)
	{
		scrollt7.setViewportView(lblNull);
	}
	else
	{
	scrollt7.setViewportView(tablemod7);
	}
	tabellaPnl7.add(scrollt7,BorderLayout.CENTER);
	
	bottoniPnl6 = new JPanel();
	bottoniPnl6.setLayout(new GridBagLayout());
	
	JButton btnNewButton16 = new JButton("Cancella Testimonianza");
	btnNewButton16.setMnemonic('q');
	btnNewButton16.addActionListener(new ActionListener() {
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
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =1;
	gbc.gridy =20;
	gbc.gridwidth = 2;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl6.add(btnNewButton16,gbc);
	
	
	
	

		
	
	
	
	tabellaPnl7.add(bottoniPnl6,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione testimonianze",tabellaPnl7);
	
	
	tabellaPnl8 = new JPanel();
	tabellaPnl8.setLayout(new BorderLayout());
	
	
	
	
	JLabel lblC = new JLabel("Elenco dei Calendari");
	lblC.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblC.setForeground(Color.BLACK);
	Dimension itz = lblC.getPreferredSize();
	lblC.setPreferredSize(itz);
	gbc.insets = new Insets(0, 0, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 18;
	tabellaPnl8.add(lblC,BorderLayout.NORTH);
	
	JScrollPane scrollt8 = new JScrollPane();
	scrollt8.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollt8.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollt8.setBounds(30, 30, 200, 30);
	
	
	model8 = new ModCal(ElencoCalDAO.elencocal());
	table8 = new JTable(model8);
	table8.setRowHeight(20);
	table8.setRowHeight(3, 50);
	table8.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	table8.setCellSelectionEnabled(true);
	table8.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tablemod8 = setupTableWidths.setupTableWidths(table8);

	tablemod8.setForeground(new Color(255, 255, 255));
	tablemod8.setBackground(new Color(240, 220, 130));
	if(model8.getRowCount()==0)
	{
		scrollt8.setViewportView(lblNull);
	}
	else
	{
	scrollt8.setViewportView(tablemod8);
	}
	tabellaPnl8.add(scrollt8,BorderLayout.CENTER);
	
	bottoniPnl7 = new JPanel();
	bottoniPnl7.setLayout(new GridBagLayout());
	JButton btnNewButton17 = new JButton("Inserisci calendario");
	btnNewButton17.setMnemonic('m');
	btnNewButton17.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FrameInserisciCal();
				frame.dispose();
		}
	});	
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =0;
	gbc.gridy =20;
	gbc.gridwidth = 2;
	
	//String[] columnNames = new String[]{"nome", "email", "newsletter"}
	bottoniPnl7.add(btnNewButton17,gbc);
	
	
	JButton btnNewButton18 = new JButton("Modifica calendario ");
	btnNewButton18.setMnemonic('n');
	btnNewButton18.addActionListener(new ActionListener() {
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
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridwidth = 2;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =1;
	gbc.gridy =20;
	bottoniPnl7.add(btnNewButton18,gbc);
	
	JButton btnNewButton19 = new JButton("Cancella Calendario");
	btnNewButton19.setMnemonic('q');
	btnNewButton19.addActionListener(new ActionListener() {
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
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridwidth = 2;
	gbc.insets= new Insets(0,0,5,5);
	gbc.gridx =2;
	gbc.gridy =20;
	bottoniPnl7.add(btnNewButton19,gbc);
	

	
	
	
	tabellaPnl8.add(bottoniPnl7,BorderLayout.SOUTH);
	
	tabel.addTab("Gestione calendario",tabellaPnl8);
	
	
	contentPane.add(tabel,gbc);

}
	
	
}
