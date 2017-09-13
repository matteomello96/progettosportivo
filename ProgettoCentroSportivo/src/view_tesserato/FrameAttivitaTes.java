package view_tesserato;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.ComponentOrientation;
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
import ClassiDaoTesserato.elencoattivitaattivedao;
import Model.Utente;
import ModelliTabelle_Tesserato.disc_attive;
import ModelliTabelle_Tesserato.disc_tabella;
import VisteUtenteGenerico.FrameCambia;
import VisteUtenteGenerico.setupTableWidths;
import listener.Listen;


public class FrameAttivitaTes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table,tablemod1;
	public static JTable table_1;
	public static JTable table_2;
	public static JFrame frame;
	public JPanel contentPane;
	private disc_tabella model;
	private disc_attive model1;
	 public static float totale;
	 public static JButton svuotacarrello;
	 public static JButton Aggiungi;
	 public static JButton rimuovi;
	 public static JButton invia;
	 public String a;
	

	/**
	 * Create the panel.
	 */
	public FrameAttivitaTes() {
		


		
		
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
	
		
		JMenu mnNewMenu = new JMenu("Torna al Pannello di Controllo");
		menuBar.add(mnNewMenu);
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pannello di controllo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new Listen(this));
		mntmNewMenuItem.setActionCommand("pantes");
		
		
		
		
		
		
		
		
		/*JMenuItem scelta_orario= new JMenuItem("Scegli turno");
		scelta_orario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				a="null";
				new FrameTurno(a,null,null,null);
				
				
			}
		});
		mnNewMenu.add(scelta_orario);*/

		
	
		
		
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(50, 30, 300, 50);			
	    frame.getContentPane().add(scroll);
		
		
		
		JLabel totord = new JLabel("Elenco delle discipline disponibili per l'iscrizione");
		totord.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(totord, gbc_lblNewLabel);
		
		
		table = new JTable();
		model = new disc_tabella(ElencoAttivitaDAO.elencoiniziale());
		table.setRowHeight(250);
		table.setRowHeight(3, 50);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setCellSelectionEnabled(true);
		table.setCellSelectionEnabled(true);
		table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		Font font2 = new Font("Comic Sans", Font.PLAIN, 15);
		table.setFont(font2);
		tablemod1 = setupTableWidths.setupTableWidths(table);

		tablemod1.setForeground(new Color(255, 255, 255));
		tablemod1.setBackground(new Color(240, 220, 130));
		
		
		JScrollPane pane2 = new JScrollPane(table);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// .
	

		
		pane2.setBackground(new Color(255, 193, 20));
		pane2.setViewportView(tablemod1);
		
		
		
		
		
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
					String.class, String.class, Integer.class
					
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
		
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 4;
		contentPane.add(Aggiungi,gbc);
		
		
		
		Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_2 = new JTable();
				model1 = new disc_attive(elencoattivitaattivedao.elencoiniziale());
				table_2.setModel(model1);
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
				
				
				//new FrameDiscAttive();
			//FrameDiscAttive.frame.dispose();
				for(q=0;q<table_2.getRowCount();q++){
					
				
					if(GetInfoDB.getcombinazionelivdis(table_2.getValueAt(q,0).toString(), table_2.getValueAt(q,1).toString()) == GetInfoDB.getcomb(table_2.getValueAt(q , 1).toString(),table_2.getValueAt(q , 0).toString(),GetInfoDB.getidTess(Utente.getUsername())))
					{
					
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
							JOptionPane.showMessageDialog(FrameAttivitaTes.frame, "Hai già un iscrizione con la disciplina da te selezionata",null,JOptionPane.WARNING_MESSAGE);
							
						}
						else{
						modello.addRow(dati);
						}
					}
				
					else{
				
					JOptionPane.showMessageDialog(FrameAttivitaTes.frame, "Non è possibile Aggiungere la stessa disciplina",null,JOptionPane.WARNING_MESSAGE);
					
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


     





