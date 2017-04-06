package InterfacciaUtentegenerico;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import DBInterfaccia.DbConnection;
import DatiGenerali.DisciplineDAO;
import InterfacciaUtentegenerico.*;
import it.progetto.listeners.Listen;
import it.progetto.listeners.ListenTab;
import it.progetto.listeners.TreeListener;
import it.progetto.model.Utente;

import it.progetto.view.LoginFrame;

import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrameUtente {

	public static JFrame frame;
	public static JTable tabella;
	public JLabel trovati;
	
	public static JButton confermab;
	
	@SuppressWarnings("unused")
	private JTextField textField;
	
	
	private JTextField ric;
	public static JLabel elems;
	public static ComboDisc ComboD;
	

	public FrameUtente(){
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setTitle("  connesso come utente generico");
		frame.setBounds(100, 100, 1334, 700);
		frame.setMinimumSize(new Dimension(500, 300));
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		frame.setAutoRequestFocus(true);
		
		
		
		
		
		ImageIcon imga = new ImageIcon(FrameUtente.class.getResource("/resources/icona.png"));
		

		frame.setIconImage(imga.getImage());
	
		frame.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{247, 571, 415, 0};
		gridBagLayout.rowHeights = new int[]{69, 0, 537, 38, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		frame.setVisible(true);
		
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		frame.getContentPane().add(panel_5, gbc_panel_5);
		
	
				//JComboBox comboMag = new JComboBox();
					ComboD = new ComboDisc();
//					comboM.setLocation(0, 0);
//					comboM.setSize(152, 25);
					//ComboM.setBounds(5,28,232, 26);
					
					
					//comboMag=MagazziniDAO.prendiMag();
				
					
					
					
					//comboMag2=MagazziniDAO.prendiMag();
					
					
				
					//panel_5.add(comboMag);
					
	
		
		panel_5.add(ComboD);
		
		JLabel lblNewLabel = new JLabel("Filtra per disciplina:");
		lblNewLabel.setBounds(5, 6, 122, 16);
		panel_5.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		
		textField = new JTextField();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		panel.add(layeredPane);
		
		final JLabel labcerca = new JLabel("Ricerca istantanea discipline per ordine...");
		labcerca.setForeground(Color.GRAY);
		labcerca.setBounds(7, 33, 270, 14);
		labcerca.setIcon(new ImageIcon(ConfOrd.class.getResource("/resources/search.png")));
		layeredPane.add(labcerca,2,0);
		
		 
	

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 0;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrameUtente.class.getResource("/resources/cart.png")));
		lblNewLabel_2.setBounds(0, -24, 1000, 700);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(110, 0, 138, 23);
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Filtra per livello:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 1;
		frame.getContentPane().add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{356, 60, 161, 0};
		gbl_panel_8.rowHeights = new int[]{20, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblElencoArticoliPer = new JLabel("Elenco discipline del catalogo:     ");
		GridBagConstraints gbc_lblElencoArticoliPer = new GridBagConstraints();
		gbc_lblElencoArticoliPer.anchor = GridBagConstraints.WEST;
		gbc_lblElencoArticoliPer.insets = new Insets(0, 0, 0, 5);
		gbc_lblElencoArticoliPer.gridx = 0;
		gbc_lblElencoArticoliPer.gridy = 0;
		panel_8.add(lblElencoArticoliPer, gbc_lblElencoArticoliPer);
		lblElencoArticoliPer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblOrdinaPer = new JLabel("Ordina per:  ");
		GridBagConstraints gbc_lblOrdinaPer = new GridBagConstraints();
		gbc_lblOrdinaPer.anchor = GridBagConstraints.WEST;
		gbc_lblOrdinaPer.insets = new Insets(0, 0, 0, 5);
		gbc_lblOrdinaPer.gridx = 1;
		gbc_lblOrdinaPer.gridy = 0;
		panel_8.add(lblOrdinaPer, gbc_lblOrdinaPer);

		GridBagConstraints gbc_ordina = new GridBagConstraints();
		gbc_ordina.fill = GridBagConstraints.HORIZONTAL;
		gbc_ordina.gridx = 2;
		gbc_ordina.gridy = 0;
		
		
		
		
		
		
		ImageIcon imageIcon = new ImageIcon(FrameUtente.class.getResource("/resources/boxm.png"));
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(imageIcon);
		tree_categ.setCellRenderer(renderer);
		
		
		final JComboBox<Object> ordina = new JComboBox<Object>();
		ordina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TreeListener.setOrdina(ordina.getSelectedItem().toString());
//				tree_categ.setSelectionRow(0);
//		    	tree_categ.setSelectionRow(1);
//		    	tree_categ.setSelectionRow(0);
		    	int tempob =tree_categ.getLeadSelectionRow();
		    	tree_categ.setSelectionRow(tempob);
		    	tree_categ.setSelectionRow(0);
		    	tree_categ.setSelectionRow(1);
		    	tree_categ.setSelectionRow(tempob);
				
			}
		});
		ordina.setModel(new DefaultComboBoxModel<Object>(new String[] {"Disciplina", "Livello", "Prezzo", "Fornitore", "Magazzino"}));
		ordina.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_8.add(ordina, gbc_ordina);
	
		
		ric = new JTextField();
		
		ric.setBounds(0, 28, 380, 25);
		layeredPane.add(ric);
		ric.setColumns(10);
		
		ric.addKeyListener(new KeyAdapter() {
											
			@Override
			public void keyReleased(KeyEvent arg0) {
				String ricercan=ric.getText().toString();	    			    	
		    	TreeListener.setRicerca(ricercan);
		    	
				
		    	int tempob =tree_categ.getLeadSelectionRow();
		    	tree_categ.setSelectionRow(tempob);
		    	tree_categ.setSelectionRow(0);
		    	tree_categ.setSelectionRow(1);
		    	tree_categ.setSelectionRow(tempob);
		    	if(tabella.getModel().getRowCount()==0)
		    	ric.setBackground(new Color(255, 138, 138));
		    	else ric.setBackground(Color.WHITE);
		    	
			}
		});
		ric.addFocusListener(new FocusAdapter() {
		public void focusGained(FocusEvent arg0) {
			labcerca.setBounds(0, 0, 0, 0);

		}
		
		public void focusLost(FocusEvent arg0) {
			if(ric.getText().isEmpty())
				labcerca.setBounds(7, 33, 270, 14);

		}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 2;
		frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		tabella = new JTable();
		tabella.setShowGrid(false);
		tabella.setFillsViewportHeight(true);
		tabella.setBackground(Color.WHITE);
		tabella.getTableHeader().setReorderingAllowed(false);
		tabella.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella.setRowHeight(20);
		tabella.setAutoCreateRowSorter(true);
		
		
		
		
//		@SuppressWarnings("rawtypes")
//		TableRowSorter myModel = new TableRowSorter();
//		
//		tabella.setRowSorter(myModel);
//		
//		
//		tabella.setAutoCreateRowSorter(true);
		
		
		
		DefaultTableModel modtab = (DefaultTableModel) tabella.getModel();
		
		
		
		modtab.fireTableDataChanged();
		
		modtab.addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e) {
				
		}}
		);
		
		
		
		
	
		scrollPane_1.setViewportView(tabella);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 2;
		gbc_panel_10.gridy = 2;
		frame.getContentPane().add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_10.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		final JLabel totord = new JLabel("TOTALE ARTICOLI:");
		totord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_11.add(totord);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_10.add(scrollPane_2);
		
	
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 3, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 3;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{151, 433, 0};
		gbl_panel_2.rowHeights = new int[]{35, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_2.add(panel_6, gbc_panel_6);
		panel_6.setLayout(null);
		elems = new JLabel("Elementi");
		elems.setBounds(0, 0, 139, 14);
		panel_6.add(elems);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.anchor = GridBagConstraints.WEST;
		gbc_panel_12.fill = GridBagConstraints.VERTICAL;
		gbc_panel_12.gridx = 1;
		gbc_panel_12.gridy = 0;
		panel_2.add(panel_12, gbc_panel_12);
		panel_12.setLayout(new GridLayout(1, 1, 4, 0));
		
		
		JButton btnNewButton = new JButton("Dettagli articolo");
		btnNewButton.setMnemonic('d');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabella.getSelectedRow()!=-1)
				new DetArt();
			}
		});
		btnNewButton.setIcon(new ImageIcon(FrameUtente.class.getResource("/resources/details.png")));
		panel_12.add(btnNewButton);
		
		final JButton aggel = new JButton(" Aggiungi al carrello >");
		aggel.setMnemonic('a');
		aggel.setIcon(new ImageIcon(FrameUtente.class.getResource("/resources/maggcarr.png")));
		panel_12.add(aggel);
		aggel.setBackground(new Color(200, 255, 215));
		aggel.setPreferredSize(new Dimension(300,40));
		aggel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabella.getSelectedRow()!=-1){
				Object[] dati = new Object[6];

				dati[0]=tabella.getValueAt(tabella.getSelectedRow(), 0);
				dati[1]=tabella.getValueAt(tabella.getSelectedRow(), 1);				
				dati[2]=(Integer)1;
				dati[3]=tabella.getValueAt(tabella.getSelectedRow(), 3);
				dati[4]=(String)"";
				dati[5]=tabella.getValueAt(tabella.getSelectedRow(), 6);
				DefaultTableModel modello = (DefaultTableModel) carrello.getModel();

				
					int c=0;
					boolean u=true;
					

					for(c=0;c<carrello.getRowCount();c++)
					{
						if(carrello.getRowCount()>=1){
							if(tabella.getValueAt(tabella.getSelectedRow(), 0).equals(carrello.getValueAt(c, 0))&&
									tabella.getValueAt(tabella.getSelectedRow(), 6).equals(carrello.getValueAt(c, 5)))
							{
								u=false;
								break;
							}

						}


					}


					if(!(tabella.getValueAt(tabella.getSelectedRow(),2).equals((Integer)0)))
					{
						if(u)
						{
							modello.addRow(dati);						
						}
						else
						{
							int eord = (Integer)carrello.getValueAt(c,2);
							int edisp = (Integer) tabella.getValueAt(tabella.getSelectedRow(),2);

							if(eord<edisp){
								int agg=(Integer) carrello.getValueAt(c, 2);
								carrello.setValueAt(agg+1, c, 2);
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Non è possibile ordinare più pezzi di quelli disponibili nel magazzino selezionato",null,JOptionPane.WARNING_MESSAGE);
							}

						}
					}
					else JOptionPane.showMessageDialog(null, "Articolo attualmente non disponibile");

				}
			}
		
		});
	
		
		
		
		tabella.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		            aggel.doClick();
		        }
		    }
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.insets = new Insets(0, 0, 3, 2);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 3;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		
		
		
		rimuovi.setBackground(new Color(255, 170, 160));
		rimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modello = (DefaultTableModel) carrello.getModel();
				if(carrello.getSelectedRow()!=-1){
				modello.removeRow(carrello.getSelectedRow());
				}
			}
		});
		
		
		panel_1.setLayout(new GridLayout(0, 3, 4, 0));
		panel_1.add(rimuovi);
		panel_1.add(btnRimuoviTutto);
		
		panel_1.add(confermab);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.BLACK);
		frame.setJMenuBar(menuBar);
		
		JMenu menuUtente = new JMenu("Utente");
		menuBar.add(menuUtente);
		
		JMenuItem mntmCambiaPassword = new JMenuItem("Cambia password...");
		mntmCambiaPassword.setIcon(new ImageIcon(FrameUtente.class.getResource("/resources/lockm.png")));
		mntmCambiaPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CambiaPassword();
				frame.setEnabled(false);
			}
		});
		menuUtente.add(mntmCambiaPassword);
		
		JMenuItem mntmRiconnetti = new JMenuItem("Riconnetti");
		mntmRiconnetti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DbConnection.getInstance();
			}
		});
		menuUtente.add(mntmRiconnetti);
		
		JMenuItem menuLogout = new JMenuItem("Logout");
		menuLogout.setIcon(new ImageIcon(FrameUtente.class.getResource("/resources/mlogout.png")));
		menuUtente.add(menuLogout);
		menuLogout.addActionListener(new Listen(this));
		menuLogout.setActionCommand("TORNA_LOGIN");
		
		JMenu mnOrdini = new JMenu("Visualizza");
		mnOrdini.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnOrdini);
		
		JMenuItem mcronord = new JMenuItem("Cronologia ordini...");
		mcronord.setIcon(new ImageIcon(FrameUtente.class.getResource("/resources/his.png")));
		mcronord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Attesa();
				new Thread(new Runnable() 
			    { 
			      public void run() 
			      { 
			        	  new CronOrd();
				        					
			          Attesa.frame.dispose();
			      } 
			    }).start(); 
				
				
			}
		});
		
		JMenuItem mntmListaProduttori = new JMenuItem("Lista produttori...");
		mntmListaProduttori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new it.progetto.view.interfacciaMagaz.ListaProduttori();
			}
		});
		mnOrdini.add(mntmListaProduttori);
		
		JMenuItem mntmListaFornitori = new JMenuItem("Lista fornitori...");
		mntmListaFornitori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new it.progetto.view.interfacciaMagaz.ListaFornitori();
			}
		});
		mnOrdini.add(mntmListaFornitori);
		mnOrdini.add(mcronord);
		
		
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    { 
		    	if(carrello.getRowCount()!=0){
		        String ObjButtons[] = {"        Sì        ","      No      "};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Gli ordini non confermati andranno persi. Sei sicuro di voler uscire? ","Logout",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	frame.setVisible(false);
			    	frame.dispose();
			    	java.awt.Window win[] = java.awt.Window.getWindows(); 
			    	for(int i=0;i<win.length;i++){ 
			    	win[i].dispose(); 
			    	} 
			    	new LoginFrame();
			    	LoginFrame.frame.setVisible(true);
			    	GetInfoDB.setUserStatus(false);
			    	
		        }
		  
		    }
		    	else  {
		    		
			    	frame.setVisible(false);
			    	frame.dispose();
			    	java.awt.Window win[] = java.awt.Window.getWindows(); 
			    	for(int i=0;i<win.length;i++){ 
			    	win[i].dispose(); 
			    	} 
			    	new LoginFrame();
			    	LoginFrame.frame.setVisible(true);
			    	GetInfoDB.setUserStatus(false);
		    	}
		    		}
		});

		
		tease();
		
	    new Thread(new Runnable() 
	    { 
	      public void run() 
	      { 
	        while(true) 
	        { 
	          DbConnection.getInstance();
	          GetInfoDB.nullQuery();
	          //System.out.println("REFRESH");
	          
	          try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        } 
	      } 
	    }).start(); 
	}
	public static int getextraMagdist()
	{
		int nmagdist=0;
		for(int c=0;c<ComboM.getItemCount();c++)
		{
			Object i=ComboM.getItemAt(c);
			for(int x=0;x<carrello.getRowCount();x++)
			{
				Object r=carrello.getValueAt(x,5);
				
				if(i.equals(r)&&!i.equals(GetInfoDB.getnomeMagdelDip(Utente.getUsername())))
				{
					nmagdist++;
					break;
				}
					
				
			}
		}
		
		return nmagdist;
	}
	
	public static int isdefMag()
	{
		int predefmag=0;
		boolean br=false;
		for(int c=0;c<=ComboM.getItemCount();c++)
		{
			ComboM.getItemAt(c);
			for(int x=0;x<carrello.getRowCount();x++)
			{
				Object r=carrello.getValueAt(x,5);
				
				if(r.equals(GetInfoDB.getnomeMagdelDip(Utente.getUsername())))
				{
					predefmag=1;
					br=true;
					break;
				}
				
				
				
				
			}
			if(br)
				break;
		}
		
		return predefmag;
	}
	public static void tease(){
		
		tabella.setModel(ArticoliDAO.prendiElementi("SELECT DISTINCT articolo.idarticolo,articolo.Nomearticolo,articolo.Prezzo,articolo.descrizione,magazzino_articolo.quantita,fornitore.nomefornitore,magazzino.nomemagazzino "
    			+ "FROM articolo,prodotto,magazzino,magazzino_articolo,fornitore "
    			+ "WHERE articolo.idarticolo=magazzino_articolo.idarticolo "
    			+ "AND magazzino.idmagazzino=magazzino_articolo.idmagazzino AND fornitore.idfornitore=articolo.idfornitore ORDER BY articolo.idarticolo ASC" /*GROUP BY articolo.idarticolo*/));
		tabella.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabella.getColumnModel().getColumn(2).setPreferredWidth(55);
		tabella.getColumnModel().getColumn(3).setPreferredWidth(28);
		int conta=tabella.getModel().getRowCount();
		elems.setText(conta+" elementi");
		
		//ComboM.setSelectedIndex(0);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tabella.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tabella.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tabella.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		DefaultTableCellRenderer lead1 = new DefaultTableCellRenderer();
		lead1.setHorizontalAlignment( JLabel.LEADING);
		tabella.getColumnModel().getColumn(0).setCellRenderer(lead1);
		
		}
}
