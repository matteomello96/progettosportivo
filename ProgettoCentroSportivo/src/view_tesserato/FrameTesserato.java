package view_tesserato;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import ClassiDao.GetInfoDB;
import ClassiDaoTesserato.ElencoAttivitaDAO;
import Listener.Listen;
import Model.Utente;
import ModelliTabelle_Tesserato.disc_tabella;
import VisteUtenteGenerico.FrameCambia;


public class FrameTesserato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public static JTable table_1;
	public static JFrame frame;
	public JPanel contentPane;
	 private disc_tabella model;
	 public static float totale;
	 public static JButton svuotacarrello;
	 public static JButton Aggiungi;
	 public static JButton rimuovi;
	 public static JButton invia;
	 public String a;
	

	/**
	 * Create the panel.
	 */
	public FrameTesserato() {
		


		
		
		frame = new JFrame("Tesserato");
		String username=""+Utente.getUsername()+"";
		frame.setTitle("Benvenuto tesserato "+username+"");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1334, 700);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,36,0));
		contentPane.setLayout(new GridBagLayout());
		

	
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
		
		JMenu mnNewMenu = new JMenu("home");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("visualizza");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("ini");
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CambiaPassword");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameCambia();
				frame.setEnabled(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Visualizza eventi");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameEventi();
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Stato Iscrizione");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameDiscAttive();
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		
		
		
		JMenuItem scelta_orario= new JMenuItem("Scegli turno");
		scelta_orario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				a="null";
				new FrameTurno(a,null,null,null);
				
				
			}
		});
		mnNewMenu.add(scelta_orario);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tue testimonianze");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameVisTest();
				//frame.setEnabled(false);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
	
		
		JMenuItem test= new JMenuItem("Testimonianze");
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameTestimonianze(null,null,null);
				frame.setEnabled(false);
							
			}
		});
		mnNewMenu.add(test);
		
		
		
		
		;
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		
		JLabel totord = new JLabel("TOTALE ISCRIZIONI:");
		totord.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 0;
		contentPane.add(totord, gbc_lblNewLabel);
		
		
		table = new JTable();
		model = new disc_tabella(ElencoAttivitaDAO.elencoiniziale());
		table.setCellSelectionEnabled(true);
		table.setModel(model);
		
		
		
		JScrollPane pane2 = new JScrollPane(table);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 2;
		contentPane.add(pane2, gbc);
		
		
		table_1 = new JTable();
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Disciplina", "Livello", "CostoMensile"
			}
		){
			
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class,Integer.class
					
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
		
		

		Aggiungi = new JButton("Aggiungi");
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 4;
		contentPane.add(Aggiungi,gbc);
		
		
		
		Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
				Object[] dati = new Object[3];

				dati[0]=table.getValueAt(table.getSelectedRow(), 0);
				dati[1]=table.getValueAt(table.getSelectedRow(), 1);				
				dati[2]=table.getValueAt(table.getSelectedRow(), 2);
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				
				int c=0;
				int q;
				int ris=0;
				boolean u=true;
				
				
				new FrameDiscAttive();
				FrameDiscAttive.frame.dispose();
				for(q=0;q<FrameDiscAttive.table_1.getRowCount();q++){
					
				
					if(GetInfoDB.getcombinazionelivdis(FrameDiscAttive.table_1.getValueAt(q,0).toString(), FrameDiscAttive.table_1.getValueAt(q,1).toString()) == GetInfoDB.getcombinazionelivdis(table.getValueAt(table.getSelectedRow() , 1).toString(),table.getValueAt(table.getSelectedRow() , 0).toString())){
					
						ris=1;
					}
					else{
						
						
					}
					
					
				}

				for(c=0;c<table_1.getRowCount();c++)
				{
				if(table_1.getRowCount()>=1){
						if(table.getValueAt(table.getSelectedRow(), 0).equals(table_1.getValueAt(c, 0))&&
								table.getValueAt(table.getSelectedRow(), 1).equals(table_1.getValueAt(c, 1)))
						{
							u=false;
							break;
						}

					}

				}
				
				
				
					if(u)
					{
						
						if(ris==1){
							JOptionPane.showMessageDialog(FrameTesserato.frame, "Hai già un iscrizione in stato di avanzamento",null,JOptionPane.WARNING_MESSAGE);
							
						}
						else{
						modello.addRow(dati);
						}
					}
				
					else{
				
					JOptionPane.showMessageDialog(FrameTesserato.frame, "Non è possibile Aggiungere la stessa disciplina",null,JOptionPane.WARNING_MESSAGE);
					
					}
					
				
				
				
				
				
				
				
				
				
				
				
				
				}
				
			
	
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		rimuovi = new JButton("rimuovi");
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 3;
		gbc.gridy = 5;
		contentPane.add(rimuovi, gbc);
		
		
		
		rimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRow()!=-1){
				modello.removeRow(table_1.getSelectedRow());
				}
			}
		});
		
		
		
	    svuotacarrello = new JButton("svuotacarrello");
	   
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 4;
		gbc.gridy = 4;
		contentPane.add(svuotacarrello, gbc);
		
		
		svuotacarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				for(int x=modello.getRowCount()-1;x>=0;x--)
				{
					modello.removeRow(x);
				}
			}
		});
		
	     invia = new JButton("invia");

			gbc.anchor = GridBagConstraints.WEST;
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.gridx = 5;
			gbc.gridy = 4;
			contentPane.add(invia, gbc);
		
		invia.addActionListener(new Listen(this));
		invia.setActionCommand("conf");
		invia.setEnabled(false);
		
		
		
		
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		table_1.getModel().addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e) {
			
				
			
				
				
				
				totale=0;
				int c=0;
				for (c=0;c<table_1.getModel().getRowCount();c++){
		
				totale=totale+((Integer)(table_1.getModel().getValueAt(c, 2)));
				
				}
			
				totord.setText("TOTALE ISCRIZIONI: "+df.format(totale)+" EUR  ");
				
				if(table_1.getModel().getRowCount()>0)
					invia.setEnabled(true);
				else table_1.setEnabled(false);
				if(table_1.getModel().getRowCount()<1)
					invia.setEnabled(false);	
				
				
				
				
					
					
		}}
		);
	
	}

}


     





