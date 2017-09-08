package visteadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassiDAOIstruttore.ElencoEventiDAO;

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



import java.awt.ComponentOrientation;

import Model.Utente;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.setupTableWidths;
import classiDAOResponsabile.ElencoUtentiDAO;
import classiDAOResponsabile.credenzialidao;
import listener.Listen;
import modelliTabelleIstruttore.ModElEventiIstr;
import modelliTabelleRespo.ModElUtenti;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FrameElencoUtenti extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static JFrame frame;
	
	public JPanel GPane1,GPane2,GPane3,GPane4,contentPane,BotPnl1,BotPnl2,BotPnl3,BotPnl4;
	public JTable table,table2,table3,table4,tablemod,tablemod2,tablemod3,tablemod4;
    private ModElUtenti model,model2,model3,model4;

    private JTabbedPane tabed = new JTabbedPane();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameElencoUtenti() {
		frame = new JFrame("Pagina Iscritti");
		
		frame.setTitle("Elenco degli utenti");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		tabed = new JTabbedPane();
	
		JMenu mnNewMenu = new JMenu("Pannello di controllo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna al pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("iniresp");
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		 
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		
		
		
		
	    GPane1 = new JPanel();
		GPane1.setBackground(new Color (235,193,20));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		JLabel lblUtenti = new JLabel("Elenco degli utenti attivi");
		lblUtenti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtenti.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		GPane1.add(lblUtenti,BorderLayout.NORTH);
		
		table = new JTable();
		model = new ModElUtenti(ElencoUtentiDAO.elencoattivi());
		table.setRowHeight(50);
		table.setRowHeight(3, 50);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		// .
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		Font font2 = new Font("Comic Sans", Font.PLAIN, 25);
		table.setFont(font2);
		tablemod = setupTableWidths.setupTableWidths(table);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt1 = new JScrollPane();

		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBackground(new Color(255, 193, 20));
		scrollt1.setViewportView(tablemod);

		GPane1.add(scrollt1, BorderLayout.CENTER);

		
		
		
		
		BotPnl1 = new JPanel();
		BotPnl1.setBackground(new Color (235,193,20));
		BotPnl1.setLayout(new GridBagLayout());
		
		
		JButton bottone= new JButton("Elimina Iscritto");
		bottone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		BotPnl1.add(bottone,gbc);
		bottone.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table.getValueAt(table.getSelectedRow(), 0);
		
			credenzialidao.eliminaiscr(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	
		});
		
		
		JButton bottone2= new JButton("Blocca Iscritto");
		bottone2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone2.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 4;
		gbc.gridy = 1;
		BotPnl1.add(bottone2,gbc);
		bottone2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table.getValueAt(table.getSelectedRow(), 0);
		
			credenzialidao.blocca(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	
		});
		
		GPane1.add(BotPnl1,BorderLayout.SOUTH);
		
		tabed.add("Utenti Attivi",GPane1);
		
		
		
		GPane2 = new JPanel();
		GPane2.setBackground(new Color (235,193,20));
		GPane2.setLayout(new BorderLayout());
		
		
		
		
		JLabel lblUtentiS = new JLabel("Elenco delle richieste di iscrizione");
		lblUtentiS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtentiS.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		GPane2.add(lblUtentiS,BorderLayout.NORTH);
		
		table2 = new JTable();
		model2 = new ModElUtenti(ElencoUtentiDAO.elencorichiesteiscr());
		table2.setRowHeight(50);
		table2.setRowHeight(3, 50);
		table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table2.setCellSelectionEnabled(true);
		// .
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setModel(model2);
		
		table2.setFont(font2);
		tablemod2 = setupTableWidths.setupTableWidths(table2);

		tablemod2.setForeground(new Color(255, 255, 255));
		tablemod2.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt2 = new JScrollPane();

		scrollt2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt2.setBackground(new Color(255, 193, 20));
		scrollt2.setViewportView(tablemod2);

		GPane2.add(scrollt2, BorderLayout.CENTER);

		
		
		
		
		BotPnl2 = new JPanel();
		BotPnl2.setBackground(new Color (235,193,20));
		BotPnl2.setLayout(new GridBagLayout());
		
		
		JButton bottone3= new JButton("Accetta Iscrizione");
		bottone3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone3.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		BotPnl2.add(bottone3,gbc);
		bottone3.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table2.getValueAt(table2.getSelectedRow(), 0);
		
			credenzialidao.attiva(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	
		});
		
		
		JButton bottone4= new JButton("Elimina Richiesta di Iscrizione");
		bottone4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone4.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 4;
		gbc.gridy = 1;
		BotPnl2.add(bottone4,gbc);
		bottone4.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table2.getValueAt(table2.getSelectedRow(), 0);
		
			credenzialidao.eliminaiscr(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	
		});
		
		GPane2.add(BotPnl2,BorderLayout.SOUTH);
		
		tabed.add("Richieste di iscrizione",GPane2);
		
		
		GPane3 = new JPanel();
		GPane3.setBackground(new Color (235,193,20));
		GPane3.setLayout(new BorderLayout());
		
		
		
		
		JLabel lblUtentiM = new JLabel("Elenco delle richieste di modifica");
		lblUtentiM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtentiM.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		GPane3.add(lblUtentiM,BorderLayout.NORTH);
		
		table3 = new JTable();
		model3 = new ModElUtenti(ElencoUtentiDAO.elencorichiestemod());
		table3.setRowHeight(50);
		table3.setRowHeight(3, 50);
		table3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table3.setCellSelectionEnabled(true);
		// .
		table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table3.setModel(model3);
		
		table3.setFont(font2);
		tablemod3 = setupTableWidths.setupTableWidths(table3);

		tablemod3.setForeground(new Color(255, 255, 255));
		tablemod3.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt3 = new JScrollPane();

		scrollt3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt3.setBackground(new Color(255, 193, 20));
		scrollt3.setViewportView(tablemod3);

		GPane3.add(scrollt3, BorderLayout.CENTER);

		
		
		
		
		BotPnl3 = new JPanel();
		BotPnl3.setBackground(new Color (235,193,20));
		BotPnl3.setLayout(new GridBagLayout());
		
		
		JButton bottone5= new JButton("Accetta Modifica");
		bottone5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone5.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		BotPnl3.add(bottone5,gbc);
		bottone5.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table3.getValueAt(table3.getSelectedRow(), 0);
		
			credenzialidao.accmod(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	
		});
		
		
		
		
		GPane3.add(BotPnl3,BorderLayout.SOUTH);
		
		tabed.add("Richieste di modifica",GPane3);
		
		
		
		GPane4 = new JPanel();
		GPane4.setBackground(new Color (235,193,20));
		GPane4.setLayout(new BorderLayout());
		
		
		
		
		JLabel lblUtentiB = new JLabel("Elenco degli utenti bloccati");
		lblUtentiB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtentiB.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		GPane4.add(lblUtentiB,BorderLayout.NORTH);
		
		table4 = new JTable();
		model4 = new ModElUtenti(ElencoUtentiDAO.elencobloccati());
		table4.setRowHeight(50);
		table4.setRowHeight(3, 50);
		table4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table4.setCellSelectionEnabled(true);
		// .
		table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table4.setModel(model4);
		table4.setFont(font2);
		tablemod4 = setupTableWidths.setupTableWidths(table4);

		tablemod4.setForeground(new Color(255, 255, 255));
		tablemod4.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt4 = new JScrollPane();

		scrollt4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt4.setBackground(new Color(255, 193, 20));
		scrollt4.setViewportView(tablemod4);

		GPane4.add(scrollt4, BorderLayout.CENTER);

		
		
		
		
		BotPnl4 = new JPanel();
		BotPnl4.setBackground(new Color (235,193,20));
		BotPnl4.setLayout(new GridBagLayout());
		
		
		JButton bottone6= new JButton("Sblocca Utente");
		bottone6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone6.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		BotPnl4.add(bottone6,gbc);
		bottone6.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int b;
			
				b= (int) table4.getValueAt(table4.getSelectedRow(), 0);
		
			credenzialidao.sblocca(b);
			frame.dispose();
			new FrameElencoUtenti();
			
		}	
		});
		
		
		
		
		GPane4.add(BotPnl4,BorderLayout.SOUTH);
		
		tabed.add("Utenti Bloccati",GPane4);
		
		
		
		
		
		
		contentPane.add(tabed,gbc);
	}
	

}
