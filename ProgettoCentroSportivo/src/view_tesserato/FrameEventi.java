package view_tesserato;


import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JButton;

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
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import ClassiDaoTesserato.ElencoEventiTessDAO;

import java.awt.ComponentOrientation;
import java.awt.Dimension;


import ModelliTabelle_Tesserato.ModElEventiTes;
import VisteUtenteGenerico.DetDisciplina;

import VisteUtenteGenerico.FrameIniziale;



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
	
	public JPanel contentPane,tabellaPnl;
	public static JTable table;
    private ModElEventiTes model;
	public static JTable table_1;
	

	/**
	 * Create the frame.
	 */
	public FrameEventi() {
		frame = new JFrame();
		
		frame.setTitle("Frame Eventi");
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
		mntmNewMenuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
		new FrameIniziale();
				
			}
			
			
		});
		
		


		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		JLabel lblEventi = new JLabel("Elenco dei tuoi eventi");
		lblEventi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEventi.setForeground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 2;
		contentPane.add(lblEventi, gbc);
		
		
		table = new JTable();
		model = new ModElEventiTes(ElencoEventiTessDAO.elencoiniziale());
		table.setRowHeight(20);
		table.setRowHeight(3, 50);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		
		Dimension d = table.getPreferredSize();
		table.setPreferredSize(d);
		gbc.insets= new Insets(0,0,5,5);
		gbc.gridx =2;
		gbc.gridy =3;
		tabellaPnl = new JPanel();
		tabellaPnl.setLayout(new GridLayout(2, 1));
		tabellaPnl.add(table.getTableHeader());
		tabellaPnl.add(table);
		contentPane.add(tabellaPnl, gbc);
		
		
		
	table_1 = new JTable();
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome Evento","Descrizione","TipoEvento","Fascia oraria","Giorno della settimana","Posti disponibili","Nome istruttore","Cognome istruttore"
			}
		){
			
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class,	String.class, String.class, Integer.class,	String.class, String.class
					
				};
			
				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				
			
		});
		
	
		table_1.setAutoCreateRowSorter(true);
		
		
		JScrollPane pane = new JScrollPane(table_1);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 5;
		gbc.gridy = 2;
		contentPane.add(pane, gbc);
		 
		JButton btnNewButton = new JButton("Dettagli Evento");
		btnNewButton.setMnemonic('d');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				new DetDisciplina();
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 5;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		contentPane.add(btnNewButton,gbc);
		
		
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			   @Override
			   public void windowClosing(java.awt.event.WindowEvent windowEvent) 
			    {
				   FrameTesserato.frame.setVisible(true);
			    
			    }
			});
		
}
	

}
