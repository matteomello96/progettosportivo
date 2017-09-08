package visteIstruttore;

import java.awt.BorderLayout;

import javax.swing.border.Border;

import ClassiDAOIstruttore.ElencoEventiDAO;
import ClassiDAOIstruttore.EliminaEventoDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.BorderFactory;


import javax.swing.JButton;

import javax.swing.JMenuBar;                                   
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;


import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;

import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import ClassiDao.GetInfoDB;

import java.awt.ComponentOrientation;
import java.awt.Container;

import Model.Utente;

import javax.swing.JScrollPane;
import VisteUtenteGenerico.setupTableWidths;
import listener.Listen;
import modelliTabelleIstruttore.ModElEventiIstr;

public class FrameEventiIstr extends JFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	public static JFrame frame;

	public JPanel contentPane, tabellaPnl, panelImage, panelCenter, PanelBottom;
	public static JTable table, tablemod;
	private ModElEventiIstr model;
	BufferedImage img;
	int cordx;
	int cordy;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 */
	public FrameEventiIstr() {
		String username=""+Utente.getUsername()+"";
		FrameEventiIstr.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Pagina iniziale");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 705, 491);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);

		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent ev) {
				cordx = ev.getX();
				cordy = ev.getY();
			}
		});

		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen() - cordx;
				int y = evt.getYOnScreen() - cordy;
				// System.out.println(x+","+y+" "+xi+","+yi);
				frame.setLocation(x, y);

			}
		});

		Container c = this.getContentPane();
		c.setBackground(new Color(255, 193, 20));
		c.setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna al panello di controllo");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_pan");

		

		JScrollPane scroll = new JScrollPane(c);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(100, 100, 605, 391);
		frame.getContentPane().add(scroll);

		// panelImage = new JPanel();
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBackground(new Color(255, 193, 20));
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel lblEventi = new JLabel("Elenco dei tuoi eventi");
		Font font = new Font("Comic Sans", Font.PLAIN, 25);
		lblEventi.setFont(font);
		lblEventi.setForeground(new Color(0, 123, 167));
		lblEventi.setBackground(new Color(0, 133, 217));
		Border b = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblEventi.setBorder(b);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		lblEventi.setHorizontalAlignment(SwingConstants.CENTER);

		panelCenter.add(lblEventi, gbc);

		

		c.add(panelCenter, BorderLayout.NORTH);

		
		int matricola = GetInfoDB.getidIstr(username);
		table = new JTable();
		model = new ModElEventiIstr(ElencoEventiDAO.elencoiniziale(matricola));
		table.setRowHeight(250);
		table.setRowHeight(3, 250);
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

		c.add(scrollt1, BorderLayout.CENTER);

		PanelBottom = new JPanel();
		PanelBottom.setLayout(new GridBagLayout());
		PanelBottom.setBackground(new Color(255, 193, 20));

		
		JButton btnNewButton7 = new JButton("Inserisci Evento");
		btnNewButton7.setMnemonic('e');
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameEventiIstr.frame.dispose();
				new FrameInserisciEv();
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 6;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		PanelBottom.add(btnNewButton7,gbc);
		
		
		
		
		JButton btnNewButton = new JButton("Dettagli Evento");
		btnNewButton.setMnemonic('c');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				new DetEv((String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0));
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 7;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		PanelBottom.add(btnNewButton,gbc);
		
		
		JButton btnNewButton3 = new JButton("Modifica Evento");
		btnNewButton3.setMnemonic('d');
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				{
			    frame.dispose();
				new FrameModificaEv((String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0));	
				}
				
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 8;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		PanelBottom.add(btnNewButton3,gbc);
		
		JButton btnNewButton4 = new JButton("Elimina Evento");
		btnNewButton4.setMnemonic('e');
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				{
				
				boolean bool=EliminaEventoDAO.eliminaevento((String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0));
				if(bool)
				{
					 frame.dispose();
					 new FrameEventiIstr();
					 FrameEventiIstr.frame.setVisible(true);
					 FrameEventiIstr.frame.setEnabled(true);
					
				}
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un evento dall'elenco","Errore evento",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 9;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		PanelBottom.add(btnNewButton4,gbc);

		c.add(PanelBottom, BorderLayout.SOUTH);

	}

}
