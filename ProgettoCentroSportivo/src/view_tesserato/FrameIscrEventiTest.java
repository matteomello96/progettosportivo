package view_tesserato;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;


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
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		 
		GridBagConstraints gbc = new GridBagConstraints();
 
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		int tes= GetInfoDB.getidTess(Utente.getUsername());
		
		
		
	    GPane1 = new JPanel();
		GPane1.setBackground(new Color (235,193,20));
		GPane1.setLayout(new BorderLayout());
		
		
		
		
		JLabel lblUtenti = new JLabel("Elenco delle tue richieste confermate");
		lblUtenti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtenti.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		GPane1.add(lblUtenti,BorderLayout.NORTH);
		
		table = new JTable();
		model = new modeven(ElencoeventidaoTess.elencoevenconf(tes));
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
		
		
		
		
		JButton btnNewButton_1 = new JButton("Visualizza Certificato ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setForeground(Color.BLACK);

		
		gbc.gridx = 2;
		gbc.gridy = 1;
		BotPnl1.add(btnNewButton_1, gbc);
        btnNewButton_1.addActionListener(new ActionListener() {
			

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
        

		
		JButton bottone2= new JButton("Elimina Ordine");
		bottone2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone2.setForeground(Color.BLACK);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		BotPnl1.add(bottone2,gbc);
		bottone2.addActionListener(new ActionListener() {
		
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
		GPane2.setBackground(new Color (235,193,20));
		GPane2.setLayout(new BorderLayout());
		
		
		
		
		JLabel lblUtentiS = new JLabel("Elenco delle richieste  da accettare");
		lblUtentiS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUtentiS.setForeground(Color.WHITE);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		GPane2.add(lblUtentiS,BorderLayout.NORTH);
		
		table2 = new JTable();
		model2 = new modeven(ElencoeventidaoTess.elencoevendaconf(tes));
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
		
		JButton bottone24= new JButton("Elimina Ordine");
		bottone24.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone24.setForeground(Color.BLACK);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		BotPnl2.add(bottone24,gbc);
		bottone24.addActionListener(new ActionListener() {
		
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
		
		
		
		
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("Visualizza Certificato ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setForeground(Color.BLACK);

		
		gbc.gridx = 2;
		gbc.gridy = 1;
		BotPnl2.add(btnNewButton_2, gbc);
        btnNewButton_2.addActionListener(new ActionListener() {
			

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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		contentPane.add(tabed,gbc);
	}
	

}
