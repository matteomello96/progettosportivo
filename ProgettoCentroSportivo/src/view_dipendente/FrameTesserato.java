package view_dipendente;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


import ClassiDaoTesserato.ElencoAttivitaDAO;
import Listener.Listen;
import ModelliTabelle.disc_tabella;
import VisteUtenteGenerico.FrameCambia;
import view_dipendente.FrameTurno;


public class FrameTesserato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public static JTable table_1;
	public static JFrame frame;
	private JPanel contentPane;
	 private disc_tabella model;
	 public static float totale;
	 public static JButton svuotacarrello;
	 public static JButton Aggiungi;
	 public static JButton rimuovi;
	 public static JButton invia;
	

	/**
	 * Create the panel.
	 */
	public FrameTesserato() {
		
		
		frame = new JFrame("Tesserato");
		frame.setTitle("Frame Tesserato");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1334, 700);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		
	
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	
		
		JMenu mnNewMenu = new JMenu("home");
		menuBar.add(mnNewMenu);
		
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
		
		
		JMenuItem scelta_orario= new JMenuItem("Scegli turno");
		scelta_orario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameTurno();
				frame.setEnabled(false);
			}
		});
		mnNewMenu.add(scelta_orario);
		//scelta_orario.addActionListener(new Listen(this));
		//scelta_orario.setActionCommand("turn");
		
		JMenuItem test= new JMenuItem("Testimonianze");
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameTestimonianze();
				frame.setEnabled(false);
			}
		});
		mnNewMenu.add(test);
		//test.addActionListener(new Listen(this));
		//test.setActionCommand("testimon");
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(240, 240, 240));
		
		
		
		final JLabel totord = new JLabel("TOTALE ORDINE:");
		totord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totord.setBounds(101, 101, 131, 101);
		contentPane.add(totord);
		
		
		table = new JTable();
		model = new disc_tabella(ElencoAttivitaDAO.elencoiniziale());
		
	
		
		table.setCellSelectionEnabled(true);
		table.setModel(model);
		contentPane.add(table);
		
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
		contentPane.add(table_1);
		

		Aggiungi = new JButton("Aggiungi");
		contentPane.add(Aggiungi);
		Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
				Object[] dati = new Object[3];

				dati[0]=table.getValueAt(table.getSelectedRow(), 0);
				dati[1]=table.getValueAt(table.getSelectedRow(), 1);				
				dati[2]=table.getValueAt(table.getSelectedRow(), 2);
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				
				int c=0;
				boolean u=true;
				

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
						modello.addRow(dati);						
					}
				
					else{
				
					JOptionPane.showMessageDialog(null, "Non è possibile Aggiungere la stessa disciplina",null,JOptionPane.WARNING_MESSAGE);
					
					}
					
				
				
				
				
				
				
				
				
				
				
				
				
				}
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		rimuovi = new JButton("rimuovi");
		
		contentPane.add(rimuovi);
		rimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modello = (DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRow()!=-1){
				modello.removeRow(table_1.getSelectedRow());
				}
			}
		});
		
		
		
	    svuotacarrello = new JButton("svuotacarrello");
	    
		contentPane.add(svuotacarrello);
		
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
		contentPane.add(invia);
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
			
				totord.setText("TOTALE ORDINE: "+df.format(totale)+" EUR  ");
				
				if(table_1.getModel().getRowCount()>0)
					invia.setEnabled(true);
				else table_1.setEnabled(false);
				if(table_1.getModel().getRowCount()<1)
					invia.setEnabled(false);	
				
				
				
				
					
					
		}}
		);
	
	}

}


     





