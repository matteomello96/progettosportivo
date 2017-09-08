package visteadmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.ScrollPaneConstants;

import ClassiDao.GetInfoDB;
import VisteUtenteGenerico.setupTableWidths;
import classiDAOResponsabile.GestioneDetIscrizioniDAO;
import classiDAOResponsabile.Uccidi_iscrizione;
import classiDAOResponsabile.dettagliiscrizionedao;
import classiDAOResponsabile.modificaordinedao;
import listener.Listen;
import modelliTabelleRespo.modellidettagli;

public class framedettagli extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JFrame frame;
	
	public static JTable table_2,tablemod2;
	private modellidettagli model;
	public JPanel contentPane;
	public JButton bottone;
	public JButton bottone1;
	
	
	public framedettagli(int cod) {
		frame = new JFrame("FrameDettagli");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setTitle("Dettagli dell'ordine numero "+cod+"");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		frame.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
	
		JMenu mnNewMenu = new JMenu("Pannello Ordini");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Torna agli ordini");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("ord");
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new GridBagLayout());
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		
		
	
		
		table_2 = new JTable();
		model = new modellidettagli(dettagliiscrizionedao.elencoiniziale(cod));
		table_2.setCellSelectionEnabled(true);
		table_2.setModel(model);
		
		tablemod2 = setupTableWidths.setupTableWidths(table_2);

		tablemod2.setForeground(new Color(255, 255, 255));
		tablemod2.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt2 = new JScrollPane();

		scrollt2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt2.setBackground(new Color(255, 193, 20));
		scrollt2.setViewportView(tablemod2);
		contentPane.add(scrollt2,gbc);
		
        bottone= new JButton("Conferma Parte dell'Ordine");
        bottone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bottone.setForeground(Color.BLACK);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 3;
		gbc.gridx = 2;
		gbc.gridy = 3;
		contentPane.add(bottone,gbc);
		
		bottone.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int iddet,tesserato,codiceturno;
			String disciplina,livello,giorno,orario;
			
			        disciplina= (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
					livello=(String) table_2.getValueAt(table_2.getSelectedRow(), 1);
					tesserato=(int) FrameOrdini2.table2.getValueAt(FrameOrdini2.table2.getSelectedRow(), 2);
		
			giorno=(String) table_2.getValueAt(table_2.getSelectedRow(), 5);
			orario=(String) table_2.getValueAt(table_2.getSelectedRow(), 6);
			iddet= GetInfoDB.getiddet(disciplina,livello,tesserato);
			codiceturno= GetInfoDB.getcodiceturno(disciplina, livello, giorno, orario);
			    GestioneDetIscrizioniDAO.ConfermaDetIscrizione(iddet,tesserato,codiceturno);
				frame.dispose();
				new framedettagli(cod);
			
		}
				
				}
	
			);		
				
				
				
		 bottone1= new JButton("Annulla conferma");
	        bottone1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bottone1.setForeground(Color.BLACK);
			gbc.anchor = GridBagConstraints.LINE_END;
			gbc.gridwidth = 3;
			gbc.gridx = 0;
			gbc.gridy = 3;
			contentPane.add(bottone1,gbc);

	bottone1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int iddet,tesserato,codiceturno,conf;
			String disciplina,livello,giorno,orario;
			
			disciplina= (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
			livello=(String) table_2.getValueAt(table_2.getSelectedRow(), 1);
			tesserato=(int) FrameOrdini2.table2.getValueAt(FrameOrdini2.table2.getSelectedRow(), 2);
		    
			giorno=(String) table_2.getValueAt(table_2.getSelectedRow(), 5);
			orario=(String) table_2.getValueAt(table_2.getSelectedRow(), 6);
			iddet= GetInfoDB.getiddet(disciplina,livello,tesserato);
			codiceturno= GetInfoDB.getcodiceturno(disciplina, livello, giorno, orario);
			
			
			
		
				GestioneDetIscrizioniDAO.AnnullaDetIsc(iddet,tesserato,codiceturno);
				
				frame.dispose();
				new framedettagli(cod);
		
		}
	}
			);	
	
	
	
		
		

	

	}
}
