package visteIstruttore;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import VisteUtenteGenerico.FrameIniziale;
import VisteUtenteGenerico.setupTableWidths;
import listener.Listen;
import modelliTabelleIstruttore.ModDetOrariEv;
import ClassiDao.DettagliIstruttoreDAO;
import ClassiDao.DettagliLivelloDAO;
import ClassiDao.DettagliOrariDAO;
import ClassiDao.DettagliTestimonianzeDAO;
import ClassiDao.ElencoDisciplineDAO;
import ClassiDao.GetInfoDB;
import ModelliTabelle.ModDetIstr;
import ModelliTabelle.ModDetLiv;
import ModelliTabelle.ModDetOrari;
import ModelliTabelle.ModDetTest;
import ModelliTabelle.ModDiscIni;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeSelectionModel;

import ClassiDAOIstruttore.DettagliOrariEvDAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DetEv {

	public static JFrame frame;
	public JPanel contentPane,tabellaPnl,tabellaPnl2,tabellaPnl3,tabellaPnl4,bottoniPnl1;
	public static JTable table1,tablemod;
    private ModDetOrariEv model1; 
    private ModDetIstr model2;
    private ModDetTest model3;
    private ModDetOrari model4;
    
    
	public DetEv(String evento) {
      evento=(String) FrameEventiIstr.table.getValueAt(FrameEventiIstr.table.getSelectedRow(), 0);
		frame = new JFrame();
		frame.setTitle("Dettaglio Evento: "+evento+"");
		frame.setBounds(100, 100, 956, 523);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(true);
		
		frame.setResizable(true);
		
		

		
		

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem MenuRegistra = new JMenuItem("Torna agli eventi");

		menuBar.add(MenuRegistra);
		MenuRegistra.addActionListener(new Listen(this));
		MenuRegistra.setActionCommand("Vai_ev");
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color (255,193,20));
		contentPane.setLayout(new BorderLayout());
		JScrollPane scroll = new JScrollPane(contentPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(100, 100, 605, 391);
		frame.getContentPane().add(scroll);
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel lblTurni = new JLabel("Turni disponibili:");
		lblTurni.setForeground(new Color(0, 123, 167));
		lblTurni.setBackground(new Color(0, 133, 217));
		Border b = BorderFactory.createLineBorder(new Color(255, 205, 255));
		lblTurni.setBorder(b);
		lblTurni.setBounds(29, 38, 353, 14);
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		
		contentPane.add(lblTurni, BorderLayout.NORTH);
		
		table1 = new JTable();
		model1 = new ModDetOrariEv(DettagliOrariEvDAO.elencoorario(evento));
		table1.setRowHeight(20);
		table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table1.setCellSelectionEnabled(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1.setModel(model1);
		
		Font font2 = new Font("Comic Sans", Font.PLAIN, 25);
		table1.setFont(font2);
		tablemod = setupTableWidths.setupTableWidths(table1);

		tablemod.setForeground(new Color(255, 255, 255));
		tablemod.setBackground(new Color(240, 220, 130));

		JScrollPane scrollt1 = new JScrollPane();

		scrollt1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollt1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollt1.setBackground(new Color(255, 193, 20));
		scrollt1.setViewportView(tablemod);
		
		contentPane.add(scrollt1, BorderLayout.CENTER);
		
        bottoniPnl1 = new JPanel();
        bottoniPnl1.setBackground(new Color (255,193,20));
		bottoniPnl1.setLayout(new GridBagLayout());
        
		JButton btnNewButton = new JButton("Dettaglio partecipanti");
		btnNewButton.setMnemonic('c');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table1.getSelectedRow()!=-1)
				{
			   frame.setVisible(false);
			   frame.dispose();
				new DetPartEv((String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 0),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 1),(String) DetEv.table1.getValueAt(DetEv.table1.getSelectedRow(), 2));
				}
				else
					JOptionPane.showMessageDialog(null, "Seleziona un turno dall'elenco","Errore turno",JOptionPane.WARNING_MESSAGE);
			}
		});	
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 2;
		//String[] columnNames = new String[]{"nome", "email", "newsletter"}
		bottoniPnl1.add(btnNewButton,gbc);
		
		
		
		
		JLabel costoatt = new JLabel("Costo mensile dell'evento:");
		costoatt.setForeground(new Color(0, 123, 167));
		costoatt.setBackground(new Color(0, 133, 217));
		costoatt.setBorder(b);
		costoatt.setBounds(29, 38, 353, 14);
		costoatt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 3;
		bottoniPnl1.add(costoatt, gbc);
		
		JLabel costoatt2 = new JLabel("");
		costoatt2.setForeground(new Color(0, 123, 167));
		costoatt2.setBackground(new Color(0, 133, 217));
		costoatt2.setBorder(b);
		costoatt2.setBounds(29, 38, 353, 14);
		costoatt2.setFont(new Font("Tahoma", Font.BOLD, 11));
		costoatt2.setText("'"+GetInfoDB.getcosto(evento)+"'");
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 4;
		bottoniPnl1.add(costoatt2, gbc);
		
		
		 
		contentPane.add(bottoniPnl1, BorderLayout.SOUTH);		
		
		
	}
}
